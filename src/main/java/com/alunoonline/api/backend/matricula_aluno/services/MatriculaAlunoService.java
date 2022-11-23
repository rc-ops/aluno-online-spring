package com.alunoonline.api.backend.matricula_aluno.services;

import com.alunoonline.api.backend.matricula_aluno.dto.MatriculaAlunoDto;
import com.alunoonline.api.backend.matricula_aluno.enums.StatusAluno;
import com.alunoonline.api.backend.matricula_aluno.enums.StatusMatriculaAluno;
import com.alunoonline.api.backend.matricula_aluno.models.MatriculaAluno;
import com.alunoonline.api.backend.matricula_aluno.repositories.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaAlunoService {

    private final double mediaAprovacao = 7;
    @Autowired
    MatriculaAlunoRepository repository;

    public MatriculaAluno novaMatricula(MatriculaAluno matriculaAluno){
        matriculaAluno.setStatusMatriculaAluno(StatusMatriculaAluno.MATRICULADO);
        matriculaAluno.setStatusAluno(StatusAluno.CURSANDO);
        return repository.save(matriculaAluno);
    }

    public void atualizaNota(MatriculaAlunoDto matriculaAlunoDto, Long matriculaAlunoId){
        MatriculaAluno matriculaAlunoAtt = repository.findById(matriculaAlunoId).orElse(null);
        if (Double.valueOf(matriculaAlunoDto.getNota1()) != null){
            matriculaAlunoAtt.setNota1(matriculaAlunoDto.getNota1());
        }

        if (Double.valueOf(matriculaAlunoDto.getNota2()) != null){
            matriculaAlunoAtt.setNota2(matriculaAlunoDto.getNota2());
        }

        repository.save(matriculaAlunoAtt);
        verificaAprovacao(matriculaAlunoId);
    }

    private void verificaAprovacao(Long matriculaAlunoId){
        MatriculaAluno matriculaAlunoAtt = repository.findById(matriculaAlunoId).orElse(null);
        if ((matriculaAlunoAtt.getNota1() + matriculaAlunoAtt.getNota2()) / 2 >= this.mediaAprovacao){
            matriculaAlunoAtt.setStatusAluno(StatusAluno.APROVADO);
        } else if ((matriculaAlunoAtt.getNota1() + matriculaAlunoAtt.getNota2()) / 2 >= 5){
            matriculaAlunoAtt.setStatusAluno(StatusAluno.FINAL);
        } else{
            matriculaAlunoAtt.setStatusAluno(StatusAluno.REPROVADO);
        }
        repository.save(matriculaAlunoAtt);
    }

    public void deletaMatricula(Long id) {
        repository.deleteById(id);
    }
}

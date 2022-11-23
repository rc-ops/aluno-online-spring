package com.alunoonline.api.backend.alunos.services;

import com.alunoonline.api.backend.alunos.enums.StatusMatriculaAluno;
import com.alunoonline.api.backend.alunos.models.MatriculaAluno;
import com.alunoonline.api.backend.alunos.repositories.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaAlunoService {

    @Autowired
    MatriculaAlunoRepository repository;
    public MatriculaAluno novaMatricula(MatriculaAluno matriculaAluno){
        matriculaAluno.setStatusMatriculaAluno(StatusMatriculaAluno.MATRICULADO);
        return repository.save(matriculaAluno);
    }
}

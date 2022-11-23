package com.alunoonline.api.backend.secretaria.services;

import com.alunoonline.api.backend.secretaria.models.Aluno;
import com.alunoonline.api.backend.secretaria.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    AlunoRepository repository;

    public Aluno create(Aluno aluno){
        return repository.save(aluno);
    }

    public List<Aluno> findAll() {
        return repository.findAll();
    }

    public Optional<Aluno> findById(Long id) {
        return repository.findById(id);
    }

//    public Aluno findById(Long id){
//        return repository.findById(id).orElse(null);
//    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Aluno updateAluno(Long id, Aluno aluno){
        Aluno alunoAtual = repository.findById(id).orElse(null);
        alunoAtual.setNome(aluno.getNome());
        alunoAtual.setCurso(aluno.getCurso());
        alunoAtual.setEmail(aluno.getEmail());
        return repository.save(alunoAtual);
    }
}

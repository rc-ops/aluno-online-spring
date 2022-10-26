package com.alunoonline.api.backend.services;

import com.alunoonline.api.backend.models.Disciplina;
import com.alunoonline.api.backend.repositories.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService{
    @Autowired
    DisciplinaRepository repository;

    public Disciplina createDisciplina(Disciplina disciplina){
        return repository.save(disciplina);
    }

    public Disciplina findDisciplina(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Disciplina> findAllDisciplinas(){
        return repository.findAll();
    }
    public void deleteDisciplina(Long id){
        repository.deleteById(id);
    }

    public Disciplina updateDisciplina(Long id, Disciplina disciplina){
        Disciplina disciplinaAtualizada = repository.findById(id).orElse(null);
        disciplinaAtualizada.setNome(disciplina.getNome());
        disciplinaAtualizada.setQuantidadeAlunos(disciplina.getQuantidadeAlunos());
        return repository.save(disciplinaAtualizada);
    }
}

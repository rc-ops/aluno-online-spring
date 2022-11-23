package com.alunoonline.api.backend.secretaria.services;

import com.alunoonline.api.backend.secretaria.models.Professor;
import com.alunoonline.api.backend.secretaria.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository repository;

    public Professor createrProfessor(Professor professor){
        return repository.save(professor);
    }

    public List<Professor> findAllProfessors(){
        return repository.findAll();
    }

    public Professor findProfessor(Long id){
        return repository.findById(id).orElse(null);
    }

    public void deleteProfessor(Long id){
        repository.deleteById(id);
    }

    public Professor updateProfessor(Long id, Professor professor){
        Professor professorAtual = repository.findById(id).orElse(null);
        professorAtual.setNome(professor.getNome());
        professorAtual.setSobrenome(professor.getSobrenome());
        professorAtual.setDisciplinaMinistrada(professor.getDisciplinaMinistrada());
        return repository.save(professorAtual);
    }
}

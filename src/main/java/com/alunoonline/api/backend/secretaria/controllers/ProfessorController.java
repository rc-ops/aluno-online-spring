package com.alunoonline.api.backend.secretaria.controllers;

import com.alunoonline.api.backend.secretaria.models.Professor;
import com.alunoonline.api.backend.secretaria.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorService service;

    @PostMapping("/novo")
    // OU poderia simplesmente não colocar nenhum endereço
    public Professor createProfessor(@RequestBody Professor professor){
        return service.createrProfessor(professor);
    }

    @GetMapping("/all")
    public List<Professor> findAllProfessors(){
        return service.findAllProfessors();
    }

    @GetMapping("/{id}")
    public Professor findProfessor(@PathVariable Long id){
        return service.findProfessor(id);
    }

    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor professor){
        return service.updateProfessor(id, professor);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Long id){
        service.deleteProfessor(id);
    }

}

package com.alunoonline.api.backend.controllers;

import com.alunoonline.api.backend.models.Disciplina;
import com.alunoonline.api.backend.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    DisciplinaService service;

    @PostMapping("/nova")
    public Disciplina createDisciplina(@RequestBody Disciplina disciplina){
        return service.createDisciplina(disciplina);
    }

    @PutMapping("/{id}")
    public Disciplina updateDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplina){
        return service.updateDisciplina(id, disciplina);
    }

    @GetMapping("/all")
    public List<Disciplina> findAllDisciplinas(){
        return service.findAllDisciplinas();
    }

    @GetMapping("/{id}")
    public Disciplina findDisciplina(@PathVariable Long id){
        return service.findDisciplina(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDisciplina(@PathVariable Long id){
        service.deleteDisciplina(id);
    }

}

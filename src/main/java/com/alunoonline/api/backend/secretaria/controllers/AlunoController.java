package com.alunoonline.api.backend.secretaria.controllers;

import com.alunoonline.api.backend.secretaria.models.Aluno;
import com.alunoonline.api.backend.secretaria.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    AlunoService service;

    // C do CRUD = Create; Método POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno) {
        Aluno alunoCreated = service.create(aluno);
        return ResponseEntity.status(201).body(alunoCreated);
    }

    // R do CRUD = Read; Método GET
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> findAll(){
        return service.findAll();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluno> findById(@PathVariable Long id) {
        return service.findById(id);
    }

//    public Aluno findById(@PathVariable Long id){
//        return service.findById(id);
//    }

    // D do CRUD = Delete; Método DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Aluno updateAluno(@PathVariable Long id, @RequestBody Aluno aluno){
        return service.updateAluno(id , aluno);
    }
}

package com.alunoonline.api.backend.alunos.controllers;

import com.alunoonline.api.backend.alunos.services.MatriculaAlunoService;
import com.alunoonline.api.backend.alunos.models.MatriculaAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matricula-aluno")
public class MatriculaAlunoController {

    @Autowired
    MatriculaAlunoService service;

    @PostMapping
    public MatriculaAluno novaMatricula(@RequestBody MatriculaAluno matriculaAluno){
        return service.novaMatricula(matriculaAluno);
    }

}

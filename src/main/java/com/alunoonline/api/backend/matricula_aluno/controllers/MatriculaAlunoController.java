package com.alunoonline.api.backend.matricula_aluno.controllers;

import com.alunoonline.api.backend.matricula_aluno.dto.MatriculaAlunoDto;
import com.alunoonline.api.backend.matricula_aluno.services.MatriculaAlunoService;
import com.alunoonline.api.backend.matricula_aluno.models.MatriculaAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matricula-aluno")
public class MatriculaAlunoController {

    @Autowired
    MatriculaAlunoService service;

    @PostMapping
    public MatriculaAluno novaMatricula(@RequestBody MatriculaAluno matriculaAluno){
        return service.novaMatricula(matriculaAluno);
    }

    @PatchMapping("/{id}")
    public void atualizaNota(@PathVariable Long id, @RequestBody MatriculaAlunoDto matriculaAlunoDto){
        service.atualizaNota(matriculaAlunoDto, id);
    }

    @DeleteMapping("/{id}")
    public void deletaMatricula(@PathVariable Long id){
        service.deletaMatricula(id);
    }

}

package com.alunoonline.api.backend.matricula_aluno.repositories;

import com.alunoonline.api.backend.matricula_aluno.models.MatriculaAluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaAlunoRepository extends JpaRepository<MatriculaAluno, Long> {
}

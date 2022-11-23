package com.alunoonline.api.backend.alunos.repositories;

import com.alunoonline.api.backend.alunos.models.MatriculaAluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaAlunoRepository extends JpaRepository<MatriculaAluno, Long> {
}

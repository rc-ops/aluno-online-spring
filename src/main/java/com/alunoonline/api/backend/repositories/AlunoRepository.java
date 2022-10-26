package com.alunoonline.api.backend.repositories;

import com.alunoonline.api.backend.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}

package com.alunoonline.api.backend.secretaria.repositories;

import com.alunoonline.api.backend.secretaria.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}

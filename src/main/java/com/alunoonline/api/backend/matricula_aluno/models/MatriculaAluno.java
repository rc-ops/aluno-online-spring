package com.alunoonline.api.backend.matricula_aluno.models;

import com.alunoonline.api.backend.matricula_aluno.enums.StatusAluno;
import com.alunoonline.api.backend.matricula_aluno.enums.StatusMatriculaAluno;
import com.alunoonline.api.backend.secretaria.models.Aluno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class MatriculaAluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double nota1;
    private double nota2;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @Enumerated(EnumType.STRING)
    private StatusMatriculaAluno statusMatriculaAluno;

    @Enumerated(EnumType.STRING)
    private StatusAluno statusAluno;
}

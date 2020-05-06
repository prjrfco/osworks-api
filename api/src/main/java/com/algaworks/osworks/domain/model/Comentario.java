package com.algaworks.osworks.domain.model;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private OrdemServico ordemServico;

    private String descricao;

    private OffsetDateTime dataEnvio;
}

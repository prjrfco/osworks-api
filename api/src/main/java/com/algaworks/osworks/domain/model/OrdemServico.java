package com.algaworks.osworks.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "ordem_servico")
@Data
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    private String descricao;

    private BigDecimal preco;

    private OffsetDateTime dataAbertura;

    private OffsetDateTime dataFinalizacao;

    @Enumerated(EnumType.STRING)
    private StatusOrdemServico statusOrdemServico;
}

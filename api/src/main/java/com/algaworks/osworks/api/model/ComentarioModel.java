package com.algaworks.osworks.api.model;

import com.algaworks.osworks.domain.model.OrdemServico;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ComentarioModel {

    private Long id;

    private String descricao;

    private OffsetDateTime dataEnvio;
}

package com.algaworks.osworks.api.model;

import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.model.StatusOrdemServico;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class OrdemServicoModel {

    private Long id;

    private ClienteResumoModel cliente;

    private String descricao;

    private BigDecimal preco;

    private StatusOrdemServico statusOrdemServico;

    private OffsetDateTime dataAbertura;

    private OffsetDateTime dataFinalizacao;

}

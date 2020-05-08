package com.algaworks.osworks.domain.model;

import com.algaworks.osworks.domain.ValidationGroups;
import com.algaworks.osworks.domain.exception.NegocioException;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordem_servico")
@Data
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
//    @Valid
//    @NotNull
    @ManyToOne
    private Cliente cliente;

//    @NotBlank
    private String descricao;

//    @NotNull
    private BigDecimal preco;

//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusOrdemServico statusOrdemServico;

//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataAbertura;

//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataFinalizacao;

    @OneToMany(mappedBy = "ordemServico")
    private List<Comentario> comentarios = new ArrayList<>();

    public boolean podeSerFinalizada(){
        return StatusOrdemServico.ABERTA.equals(getStatusOrdemServico());
    }

    public boolean naoPodeSerFinalizada(){
        return !podeSerFinalizada();
    }

    public void finalizar() {
        if(naoPodeSerFinalizada()){
            throw new NegocioException("Ordem de serviço não pode ser finalizada");
        }
        setStatusOrdemServico(StatusOrdemServico.FINALIZADA);
        setDataFinalizacao(OffsetDateTime.now().withNano(0));
    }

    public void cancelar() {
        if(naoPodeSerFinalizada()){
            throw new NegocioException("Ordem de serviço não pode ser cancelada");
        }
        setStatusOrdemServico(StatusOrdemServico.CANCELADA);
        setDataFinalizacao(OffsetDateTime.now().withNano(0));
    }

}

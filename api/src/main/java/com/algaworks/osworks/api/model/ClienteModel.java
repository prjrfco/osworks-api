package com.algaworks.osworks.api.model;

import lombok.Data;

@Data
public class ClienteModel {

    private Long id;

    private String nome;

    private String email;

    private String telefone;
}

package com.algaworks.osworks.api.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Classe usada para entrada de dados na API
@Data
public class ClienteInput {

    @NotBlank
    @Size(max = 60)
    private String nome;

    @NotBlank
    @Email
    @Size(max = 255)
    private String email;

    @NotNull
    @Size(max = 20)
    private String telefone;
}

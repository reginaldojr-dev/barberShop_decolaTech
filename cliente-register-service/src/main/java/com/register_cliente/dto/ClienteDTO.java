package com.register_cliente.dto;

import lombok.Data;

@Data
public class ClienteDTO {
    private String nome;
    private String email;
    private int idade;
    private String numeroTelefone;
    private String servico;
}

package com.cliente_appointment_service.dto;

import lombok.Data;

@Data
public class ClienteDTO {

    private Long id;
    private String nome;
    private int idade;
    private String email;
    private String numeroTelefone;

}

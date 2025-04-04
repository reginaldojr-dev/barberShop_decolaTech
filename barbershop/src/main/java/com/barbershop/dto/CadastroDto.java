package com.barbershop.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.UUID;

@Data
public class CadastroDto {

    private UUID id;
    private String nome;
    private String data_nascimento;
    private String cpf;
    private String email;
}

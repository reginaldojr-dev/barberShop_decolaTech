package com.barbershop.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "CADASTRO_DB")
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column
    private String nome;

    @Column
    private String data_nascimento;

    @Column
    private String cpf;

    @Column
    private String email;
}

package com.cliente_appointment_service.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos") // Melhor nome pra tabela
@Data
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteId;

    private String servico;

    private LocalDateTime data; // ou "dataHora" se quiser mais semântico

    private String email;

    private String nome;

    private String numeroTelefone; // ou "telefone" se quiser padronizar

}

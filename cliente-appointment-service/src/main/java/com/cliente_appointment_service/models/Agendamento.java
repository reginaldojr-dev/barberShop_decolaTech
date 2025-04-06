package com.cliente_appointment_service.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Table(name = "appointment_db")
@Data
@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clienteId;
    private String servico;
    private LocalDateTime data;
    private String email;
    private String nome;
    private String numeroTelefone;

}

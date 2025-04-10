package com.cliente_appointment_service.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class AgendamentoDTO {

    private String nome;
    private LocalTime hora;        // Corrigido: era LocalDateTime
    private String servico;
    private LocalDateTime data;
    private String email;
}

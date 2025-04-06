package com.cliente_appointment_service.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AgendamentoDTO {

    private String nome;
    private LocalDateTime hora;
    private String servico;
    private LocalDateTime data;
    private String email;

}


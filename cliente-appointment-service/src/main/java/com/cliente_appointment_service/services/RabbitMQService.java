package com.cliente_appointment_service.services;

import com.cliente_appointment_service.dto.AgendamentoDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publicarEventoAppointmentCriado(AgendamentoDTO agendamentoDTO) {
        rabbitTemplate.convertAndSend("appointment_created", agendamentoDTO);
    }

    public void publicarEventoPetInfoRequest(Long petId) {
        rabbitTemplate.convertAndSend("pet.requests", petId);
    }
}

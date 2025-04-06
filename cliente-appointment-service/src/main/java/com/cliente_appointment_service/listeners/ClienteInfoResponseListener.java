package com.cliente_appointment_service.listeners;

import com.cliente_appointment_service.dto.ClienteDTO;
import com.cliente_appointment_service.services.AgendamentoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteInfoResponseListener {

    @Autowired
    private AgendamentoService agendamentoService;

    @RabbitListener(queues = "cliente.responses")
    public void receberEventoPetInfoResponse(ClienteDTO clienteDTO) {
        agendamentoService.processarClienteInfoResponse(clienteDTO);
    }
}

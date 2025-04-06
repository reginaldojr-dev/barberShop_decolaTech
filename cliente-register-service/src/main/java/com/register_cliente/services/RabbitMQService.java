package com.register_cliente.services;

import com.register_cliente.dto.ClienteDTO;
import com.register_cliente.models.Cliente;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Jackson2JsonMessageConverter jsonMessageConverter;

    public void publicarEventoPetCriado(ClienteDTO clienteDTO) {
        rabbitTemplate.setMessageConverter(jsonMessageConverter);
        rabbitTemplate.convertAndSend("cliente_created", clienteDTO);
    }

    public void publicarEventoPetInfoResponse(Cliente cliente) {
        rabbitTemplate.setMessageConverter(jsonMessageConverter);
        rabbitTemplate.convertAndSend("cliente.responses", cliente);
    }

    public void publicarEventoClienteCriado(ClienteDTO clienteDTO) {
    }
}

package com.register_cliente.listeners;

import com.register_cliente.models.Cliente;
import com.register_cliente.repositories.ClienteRepository;
import com.register_cliente.services.RabbitMQService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClienteInfoRequestListener {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RabbitMQService rabbitMQService;

    @RabbitListener(queues = "pet.requests")
    public void receberSolicitacao(Long petId) {

        Optional<Cliente> pet = clienteRepository.findById(petId);
        pet.ifPresent(p -> rabbitMQService.publicarEventoPetInfoResponse(p));
    }
}

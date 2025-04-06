package com.cliente_appointment_service.services;

import com.cliente_appointment_service.clients.ClienteRegisterClient;
import com.cliente_appointment_service.dto.AgendamentoDTO;
import com.cliente_appointment_service.dto.ClienteDTO;
import com.cliente_appointment_service.models.Agendamento;
import com.cliente_appointment_service.repositories.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private RabbitMQService rabbitMQService;

    @Autowired
    private ClienteRegisterClient clienteRegisterClient;


    public AgendamentoDTO criarAgendamentoManual(Long id, String servico, LocalDateTime data) {

        ClienteDTO clienteDTO = clienteRegisterClient.getClienteDTO(id);
        if (clienteDTO == null) {
            rabbitMQService.publicarEventoPetInfoRequest(id);
            throw new RuntimeException("Dados do cliente não encontrados.");
        }

        Agendamento agendamento = new Agendamento();
        agendamento.setClienteId(id);
        agendamento.setServico(servico);
        agendamento.setData(data);
        agendamento.setEmail(clienteDTO.getEmail());


        Agendamento savedAgendamento = agendamentoRepository.save(agendamento);
        AgendamentoDTO agendamentoDTO = toDTO(savedAgendamento);
        rabbitMQService.publicarEventoAppointmentCriado(agendamentoDTO);

        return agendamentoDTO;
    }

    public List<Agendamento> listarAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public Optional<Agendamento> buscarAgendamentoPorId(Long id) {
        return agendamentoRepository.findById(id);
    }

    public AgendamentoDTO atualizarAgendamento(Long id, Agendamento agendamentoAtualizado) {
        return agendamentoRepository.findById(id)
                .map(agendamento -> {
                    agendamento.setServico(agendamentoAtualizado.getServico());
                    agendamento.setData(agendamentoAtualizado.getData());
                    Agendamento savedAgendamento = agendamentoRepository.save(agendamento);
                    AgendamentoDTO agendamentoDTO = toDTO(savedAgendamento);
                    rabbitMQService.publicarEventoAppointmentCriado(agendamentoDTO);

                    return agendamentoDTO;
                })
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado com o ID: " + id));
    }

    public void processarPetInfoResponse(ClienteDTO clienteDTO) {
    }

    public void excluirAgendamento(Long id) {
        agendamentoRepository.deleteById(id);
    }

    private AgendamentoDTO toDTO(Agendamento agendamento) {
        return null;
    }

    public void processarClienteInfoResponse(ClienteDTO clienteDTO) {
    }
}

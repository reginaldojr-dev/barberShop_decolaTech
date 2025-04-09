package com.cliente_appointment_service.services;

import com.cliente_appointment_service.clients.ClienteRegisterClient;
import com.cliente_appointment_service.dto.AgendamentoDTO;
import com.cliente_appointment_service.dto.ClienteDTO;
import com.cliente_appointment_service.models.Agendamento;
import com.cliente_appointment_service.repositories.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final ClienteRegisterClient clienteRegisterClient;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, ClienteRegisterClient clienteRegisterClient) {
        this.agendamentoRepository = agendamentoRepository;
        this.clienteRegisterClient = clienteRegisterClient;
    }

    public AgendamentoDTO criarAgendamentoManual(Long id, String servico, LocalDateTime data) {
        ClienteDTO clienteDTO = clienteRegisterClient.getClienteDTO(id);
        if (clienteDTO == null) {
            throw new RuntimeException("Dados do cliente não encontrados.");
        }

        Agendamento agendamento = new Agendamento();
        agendamento.setClienteId(id);
        agendamento.setServico(servico);
        agendamento.setData(data);
        agendamento.setEmail(clienteDTO.getEmail());

        Agendamento savedAgendamento = agendamentoRepository.save(agendamento);
        return toDTO(savedAgendamento);
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
                    return toDTO(savedAgendamento);
                })
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado com o ID: " + id));
    }

    public void excluirAgendamento(Long id) {
        agendamentoRepository.deleteById(id);
    }

    private AgendamentoDTO toDTO(Agendamento agendamento) {
        AgendamentoDTO dto = new AgendamentoDTO();
        dto.setNome(agendamento.getNome());
        dto.setHora(agendamento.getData().toLocalTime().atDate(agendamento.getData().toLocalDate()));
        dto.setServico(agendamento.getServico());
        dto.setData(agendamento.getData());
        dto.setEmail(agendamento.getEmail());
        return dto;
    }


}

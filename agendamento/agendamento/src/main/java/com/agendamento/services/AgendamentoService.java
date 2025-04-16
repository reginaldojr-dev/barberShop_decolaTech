package com.agendamento.services;

import com.agendamento.clients.CadastroClient;
import com.agendamento.dto.AgendamentoDTO;
import com.agendamento.dto.CadastroDTO;
import com.agendamento.models.Agendamento;
import com.agendamento.repositories.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final CadastroClient cadastroClient;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, CadastroClient cadastroClient) {
        this.agendamentoRepository = agendamentoRepository;
        this.cadastroClient = cadastroClient;
    }

    public AgendamentoDTO criarAgendamentoManual(Long id, String servico, LocalDateTime data) {
        CadastroDTO cadastroDTO = cadastroClient.getCadastroDTO(id);
        if (cadastroDTO == null) {
            throw new IllegalArgumentException("Cadastro com ID " + id + " não encontrado.");
        }

        Agendamento agendamento = new Agendamento();
        agendamento.setId(id); // Alterado de setClienteId para setCadastroId
        agendamento.setServico(servico);
        agendamento.setData(data);
        agendamento.setEmail(cadastroDTO.getEmail());
        agendamento.setNome(cadastroDTO.getNome());
        agendamento.setnumeroTelefone(cadastroDTO.getNumeroTelefone());

        Agendamento savedAgendamento = agendamentoRepository.save(agendamento);
        return toDTO(savedAgendamento);
    }

    public AgendamentoDTO criarAgendamento(AgendamentoDTO dto) {
        CadastroDTO cadastroDTO = cadastroClient.getCadastroByEmail(dto.getEmail());
        if (cadastroDTO == null) {
            throw new IllegalArgumentException("Cadastro com e-mail " + dto.getEmail() + " não encontrado.");
        }

        Agendamento agendamento = new Agendamento();
        agendamento.setId(cadastroDTO.getId());
        agendamento.setServico(dto.getServico());
        agendamento.setData(dto.getData());
        agendamento.setEmail(dto.getEmail());
        agendamento.setNome(dto.getNome());
        agendamento.setnumeroTelefone(cadastroDTO.getNumeroTelefone());

        Agendamento savedAgendamento = agendamentoRepository.save(agendamento);
        return toDTO(savedAgendamento);
    }

    public List<Agendamento> listarAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public Optional<Agendamento> buscarAgendamentoPorId(Long id) {
        return agendamentoRepository.findById(id);
    }

    public AgendamentoDTO atualizarAgendamento(Long id, AgendamentoDTO dto) {
        return agendamentoRepository.findById(id)
                .map(agendamento -> {
                    agendamento.setServico(dto.getServico());
                    agendamento.setData(dto.getData());
                    Agendamento saved = agendamentoRepository.save(agendamento);
                    return toDTO(saved);
                })
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado com o ID: " + id));
    }

    public void excluirAgendamento(Long id) {
        agendamentoRepository.deleteById(id);
    }

    private AgendamentoDTO toDTO(Agendamento agendamento) {
        AgendamentoDTO dto = new AgendamentoDTO();
        dto.setNome(agendamento.getNome());
        dto.setHora(agendamento.getData().toLocalTime());
        dto.setServico(agendamento.getServico());
        dto.setData(agendamento.getData());
        dto.setEmail(agendamento.getEmail());
        return dto;
    }
}

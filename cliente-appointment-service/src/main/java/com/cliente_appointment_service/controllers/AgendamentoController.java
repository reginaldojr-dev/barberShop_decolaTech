package com.cliente_appointment_service.controllers;

import com.cliente_appointment_service.dto.AgendamentoDTO;
import com.cliente_appointment_service.models.Agendamento;
import com.cliente_appointment_service.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping("/manual")
    public AgendamentoDTO criarAgendamentoManual(@RequestParam Long clienteId, @RequestParam String servico, @RequestParam LocalDateTime data) {
        return agendamentoService.criarAgendamentoManual(clienteId, servico, data);
    }

    @GetMapping
    public List<Agendamento> listarAgendamentos() {
        return agendamentoService.listarAgendamentos();
    }

    @GetMapping("/{id}")
    public Optional<Agendamento> buscarAgendamentoPorId(@PathVariable Long id) {
        return agendamentoService.buscarAgendamentoPorId(id);
    }

    @PutMapping("/{id}")
    public AgendamentoDTO atualizarAgendamento(@PathVariable Long id, @RequestBody Agendamento agendamentoAtualizado) {
        return agendamentoService.atualizarAgendamento(id, agendamentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void excluirAgendamento(@PathVariable Long id) {
        agendamentoService.excluirAgendamento(id);
    }
}


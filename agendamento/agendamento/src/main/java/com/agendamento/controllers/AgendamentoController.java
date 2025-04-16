package com.agendamento.controllers;

import com.agendamento.dto.AgendamentoDTO;
import com.agendamento.models.Agendamento;
import com.agendamento.services.AgendamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    public ResponseEntity<AgendamentoDTO> criarAgendamento(@RequestBody AgendamentoDTO dto) {
        AgendamentoDTO novoAgendamento = agendamentoService.criarAgendamento(dto);
        return ResponseEntity.ok(novoAgendamento);
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> listarAgendamentos() {
        return ResponseEntity.ok(agendamentoService.listarAgendamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> buscarAgendamentoPorId(@PathVariable Long id) {
        return agendamentoService.buscarAgendamentoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> atualizarAgendamento(@PathVariable Long id,
                                                               @RequestBody AgendamentoDTO dto) {
        AgendamentoDTO atualizado = agendamentoService.atualizarAgendamento(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAgendamento(@PathVariable Long id) {
        agendamentoService.excluirAgendamento(id);
        return ResponseEntity.noContent().build();
    }
}

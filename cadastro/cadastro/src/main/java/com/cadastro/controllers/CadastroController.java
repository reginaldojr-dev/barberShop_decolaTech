package com.cadastro.controllers;

import com.cadastro.dto.CadastroDTO;
import com.cadastro.models.Cadastro;
import com.cadastro.services.CadastroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {

    private final CadastroService cadastroService;

    public CadastroController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @PostMapping
    public ResponseEntity<CadastroDTO> cadastrar(@Valid @RequestBody CadastroDTO cadastroDTO) {
        Cadastro novoCadastro = cadastroService.cadastrar(cadastroDTO);
        return ResponseEntity.ok(toDTO(novoCadastro));
    }

    @GetMapping
    public ResponseEntity<List<CadastroDTO>> listarTodos() {
        List<CadastroDTO> cadastros = cadastroService.listarTodos()
                .stream().map(this::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(cadastros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CadastroDTO> buscarPorId(@PathVariable Long id) {
        return cadastroService.buscarPorId(id)
                .map(cadastro -> ResponseEntity.ok(toDTO(cadastro)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CadastroDTO> atualizar(@PathVariable Long id, @Valid @RequestBody CadastroDTO cadastroDTO) {
        Cadastro atualizado = cadastroService.atualizar(id, cadastroDTO);
        return ResponseEntity.ok(toDTO(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        cadastroService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    private CadastroDTO toDTO(Cadastro cadastro) {
        CadastroDTO dto = new CadastroDTO();
        dto.setId(cadastro.getId());
        dto.setNome(cadastro.getNome());
        dto.setEmail(cadastro.getEmail());
        dto.setIdade(cadastro.getIdade());
        dto.setNumeroTelefone(cadastro.getNumeroTelefone());
        dto.setServico(cadastro.getServico());
        return dto;
    }
}

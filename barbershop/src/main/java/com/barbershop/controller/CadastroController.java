package com.barbershop.controller;

import com.barbershop.entities.Cadastro;
import com.barbershop.service.CadastroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/clientes")
public class CadastroController {

    private final CadastroService service;

    @PostMapping
    public Cadastro cadastrarCliente(@RequestBody Cadastro cadastro) {
        return service.cadastrarCliente(cadastro);
    }

    @GetMapping
    public List<Cadastro> listarClientes(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cadastro> findById(@PathVariable UUID id){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Optional<Cadastro> atualizarCliente(@PathVariable UUID id, @RequestBody Cadastro cadastro){
        return service.atualizarCliente(id, cadastro);
    }

    @DeleteMapping("{id}")
    public void excluirCliente(@PathVariable UUID id){
        service.excluirCliente(id);
    }
}

package com.agendamento.models;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")

public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cadastro_id")
    private Long cadastroId;

    private String servico;

    private LocalDateTime data;

    private String email;

    private String nome;

    @Column(name = "telefone")
    private String telefone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return cadastroId;
    }

    public void setClienteId(Long clienteId) {
        this.cadastroId = cadastroId;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getnumeroTelefone() {
        return telefone;
    }

    public void setnumeroTelefone(String telefone) {
        this.telefone = telefone;
    }
}


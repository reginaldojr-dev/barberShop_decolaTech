package com.register_cliente.dto;


import lombok.Getter;

@Getter
public class ClienteDTO {

    private String nome;
    private String email;
    private int idade;
    private String numeroTelefone;
    private String servico;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }
}

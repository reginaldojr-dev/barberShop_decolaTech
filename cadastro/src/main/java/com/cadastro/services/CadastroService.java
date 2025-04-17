package com.cadastro.services;

import com.cadastro.dto.CadastroDTO;
import com.cadastro.models.Cadastro;
import com.cadastro.repositories.CadastroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroService {

    private final CadastroRepository cadastroRepository;

    public CadastroService(CadastroRepository cadastroRepository) {
        this.cadastroRepository = cadastroRepository;
    }

    public Cadastro cadastrar(CadastroDTO cadastroDTO) {
        Cadastro cadastro = toEntity(cadastroDTO);
        return cadastroRepository.save(cadastro);
    }

    public List<Cadastro> listarTodos() {
        return cadastroRepository.findAll();
    }

    public Optional<Cadastro> buscarPorId(Long id) {
        return cadastroRepository.findById(id);
    }

    public Cadastro atualizar(Long id, CadastroDTO cadastroDTO) {
        return cadastroRepository.findById(id)
                .map(cadastro -> {
                    cadastro.setNome(cadastroDTO.getNome());
                    cadastro.setEmail(cadastroDTO.getEmail());
                    cadastro.setIdade(cadastroDTO.getIdade());
                    cadastro.setNumeroTelefone(cadastroDTO.getNumeroTelefone());
                    cadastro.setServico(cadastroDTO.getServico());
                    return cadastroRepository.save(cadastro);
                })
                .orElseThrow(() -> new RuntimeException("Cadastro com o ID: " + id + " não encontrado."));
    }

    public void excluir(Long id) {
        if (!cadastroRepository.existsById(id)) {
            throw new RuntimeException("Cadastro com o ID: " + id + " não encontrado.");
        }
        cadastroRepository.deleteById(id);
    }

    public List<Cadastro> filtrarNome(String nome) {
        return cadastroRepository.findByNome(nome);
    }

    public List<Cadastro> filtrarPorServico(String servico) {
        return cadastroRepository.findByServico(servico);
    }

    private Cadastro toEntity(CadastroDTO dto) {
        Cadastro cadastro = new Cadastro();
        cadastro.setNome(dto.getNome());
        cadastro.setEmail(dto.getEmail());
        cadastro.setIdade(dto.getIdade());
        cadastro.setNumeroTelefone(dto.getNumeroTelefone());
        cadastro.setServico(dto.getServico());
        return cadastro;
    }
}

package com.register_cliente.services;

import com.register_cliente.dto.ClienteDTO;
import com.register_cliente.models.Cliente;
import com.register_cliente.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> filtrarNome(String nome) {
        return clienteRepository.findByNome(nome);
    }

    public List<Cliente> filtrarPorServico(String servico) {
        return clienteRepository.findByServico(servico);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public void excluirCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente com o ID: " + id + " não encontrado.");
        }
        clienteRepository.deleteById(id);
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        // Conversão para DTO feita, mas não utilizada aqui. Pode ser útil se for retorná-lo em outra camada.
        toDTO(clienteSalvo);
        return clienteSalvo;
    }

    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setEmail(clienteAtualizado.getEmail());
                    cliente.setIdade(clienteAtualizado.getIdade());
                    cliente.setNumeroTelefone(clienteAtualizado.getNumeroTelefone());
                    cliente.setServico(clienteAtualizado.getServico());
                    return clienteRepository.save(cliente);
                })
                .orElseThrow(() -> new RuntimeException("Cliente com o ID: " + id + " não encontrado."));
    }

    public ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setIdade(cliente.getIdade());
        clienteDTO.setNumeroTelefone(cliente.getNumeroTelefone());
        clienteDTO.setServico(cliente.getServico());
        return clienteDTO;
    }
}

package com.register_cliente.services;

import com.register_cliente.dto.ClienteDTO;
import com.register_cliente.models.Cliente;
import com.register_cliente.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

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
        clienteRepository.deleteById(id);
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        ClienteDTO clienteDTO = toDTO(clienteSalvo);

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
                .orElseThrow(() -> new RuntimeException("Cliente com o ID: " + id + " não encontrado"));
    }


    public ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setIdade(cliente.getIdade());
        clienteDTO.setNumeroTelefone(cliente.getNumeroTelefone());
        return clienteDTO;
    }
}

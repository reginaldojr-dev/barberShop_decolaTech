package com.barbershop.service;

import com.barbershop.dto.CadastroDto;
import com.barbershop.entities.Cadastro;
import com.barbershop.repository.CadastroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@AllArgsConstructor
@Service
public class CadastroService {

    private final CadastroRepository repository;

    public Cadastro cadastrarCliente(Cadastro cadastro) {
        Cadastro clienteSalvo = repository.save(cadastro);
        CadastroDto cadastroDto = toDTO(clienteSalvo);
        return clienteSalvo;
    }

    public Optional<Cadastro> findById(UUID id){
        return repository.findById(id);
    }

    public List<Cadastro> findAll(){
        return repository.findAll();
    }

    public void excluirCliente(UUID id){
        repository.deleteById(id);
    }

    public Optional<Cadastro> atualizarCliente(UUID id, Cadastro cadastroAtualizado){
        return repository.findById(id)
                .map(cadastro -> {
                    cadastro.setNome(cadastroAtualizado.getNome());
                    cadastro.setData_nascimento((cadastroAtualizado.getData_nascimento()));
                    cadastro.setCpf(cadastroAtualizado.getCpf());
                    cadastro.setEmail(cadastroAtualizado.getEmail());
                    return repository.save(cadastro);
                });
    }

    public CadastroDto toDTO(Cadastro cadastro){
        CadastroDto cadastroDto = new CadastroDto();
        cadastroDto.setId(cadastro.getId());
        cadastroDto.setNome(cadastro.getNome());
        cadastroDto.setData_nascimento(cadastro.getData_nascimento());
        cadastroDto.setEmail(cadastro.getEmail());
        cadastroDto.setCpf(cadastro.getCpf());
        return cadastroDto;
    }

}

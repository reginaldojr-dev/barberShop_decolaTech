package com.register_cliente.repositories;

import com.register_cliente.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByServico(String servico);

    List<Cliente> findByNome(String nome);
}

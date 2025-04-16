package com.cadastro.repositories;

import com.cadastro.models.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

    List<Cadastro> findByServico(String servico);

    List<Cadastro> findByNome(String nome);
}

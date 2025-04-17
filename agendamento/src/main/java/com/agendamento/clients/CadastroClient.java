package com.agendamento.clients;

import com.agendamento.dto.CadastroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cadastro", url = "http://localhost:8080")  // Ajuste a URL se necessário
public interface CadastroClient {

    // Busca cadastro por ID
    @GetMapping("/cadastros/{id}")
    CadastroDTO getCadastroDTO(@PathVariable("id") Long id);

    // Busca cadastro por e-mail
    @GetMapping("/cadastros/email")
    CadastroDTO getCadastroByEmail(@RequestParam("email") String email);
}

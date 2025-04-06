# Desafio Microsserviços Java
Este projeto consiste em dois microsserviços que trabalham em conjunto para gerenciar o cadastro de pets e agendamentos de cuidados.
## Índice
- [Tecnologias Utilizadas](##tecnologias-utilizadas)
- [Descrição dos Microsserviços](##descrição-dos-microsserviços)
- [Fluxo de comunicação](##fluxo-de-comunicação)
- [Variáveis de Ambiente](##variáveis-de-ambientes)
- [Criação de Banco de Dados](##criação-de-banco-de-dados)
- [Documentação](##documentação)
    - [Swagger](###swagger)
    - [Postman](###postman)

## Tecnologias Utilizadas:
- **Java 21**: Certifique-se de ter a JDK 21 ou superior.
- **Spring boot**: Framework com abordagem simplificada para construção de aplicações web.
- **Maven**: Ferramenta de gerenciamento de dependências.
- **MySQL**: Sistema de gerenciamento de banco de dados relacional utilizado para armazenar os dados dos microsserviços.
- **RabbitMQ**: Utilizado para comunicação assíncrona entre os microsserviços.

## Descrição dos Microsserviços
1. Pet Register Service (cadastro)
- Funcionalidades:
    - Cadastra novos pets.
    - Lista todos os pets cadastrados.
    - Filtra pets por raças ou espécie.
    - Busca informações de um cliente específico por ID.
    - Atualizar e excluir cadastrados de pets.
- Integração com APIs Externas: Integra com The Cart API e The Dog API para buscar informações sobre raças de gatos e cachorros, como listagem de raças, imagens e IDs de raças.
- Comunicação: Publica eventos do RabbitMQ quando um novo cliente é cadastrado (pet_created) e responde a solicitações de informações sobre pets (cliente.requests e cliente.responses).
2. Pet Appointment Service (agendamento)
- Funcionalidades:
    - Criar agendamentos manuais e automáticos com base da idade do cliente.
    - Listar todos os agendamentos.
    - Buscar um agendamento específico por ID.
    - Atualizar e excluir agendamentos.
- Integração com Pet Register Service: Se comunica com o microsserviço de cadastro para obter informações do cliente como nome, tutor e e-mail, para criar um agendamento.
- Comunicação:
    - Consome eventos do RabbitMQ quando um novo cliente é cadastrado (pet_created) para criar agendamentos automáticos.
    - Publica eventos no RabbitMQ quando um novo agendamento é criado (appointment_created).
    - Envia solicitações para o microsserviço de cadastro quando precisa de informações adicionais sobre um cliente (cliente.request).

## Fluxo de Comunicação:


## Variáveis de ambiente:
O projeto utiliza variáveis de ambiente para configurar credenciais de serviços esternos.
A seguir as varáveis necessárias (O token de acesso pode ser único para as duas varáveos, mas e extritamente necessário ter as duas varáveis configuradas para o bom funcionamento da aplicação):
- thecatapi.apikey
- thedogapi.apikey

## Criação de Banco de Dados:
O projeto utiliza três bancos de dados MySQL, um para cada microsserviço. Abaixo estão os detalhes para criação dos bancos de dados:
- Nomenclaturas:
    - pet_db.
    - appointment_db.


- Comandos SQL para criação dos bancos de dados:
```
CREATE DATABASE pet_db;
CREATE DATABASE appointment_db;
  ```

## Documentação
### Swagger:
- [ ] [Microsserviço de cadastramento de cliente (cliente-register-service)](https://localhost:8080/swagger-ui.html)
- [ ] [Microsserviço de agendamento de cuidados (cliente-register-service)](https://localhost:8081/swagger-ui.html)
- [ ] [Microsserviço de notificação de agendamentos (appointment-notification-service)](https://localhost:8082/swagger-ui.html)
### Postman:
- [ ] [Postman collections](https://localhost:8080/swagger-ui.html)

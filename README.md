# 💈 BarberShop API - DecolaTech

Este projeto é uma aplicação completa desenvolvida durante o programa **DecolaTech**, com o objetivo de gerenciar **cadastros de clientes**, **agendamentos de serviços** e oferecer uma interface moderna e responsiva para **barbearias**.

🔗 **Repositório completo:**  
https://github.com/reginaldojr-dev/barberShop_decolaTech.git

---

## 🧱 Tecnologias Utilizadas

### 🔙 Backend (Spring Boot):
- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- MySQL
- RabbitMQ
- Swagger (Springdoc OpenAPI)
- Lombok

### 🔜 Frontend (Angular):
- Angular 19.2.5
- Angular Material
- Responsividade
- Componentização
- Formulários reativos

---

## 📦 Estrutura do Projeto

### Backend
📁 `cliente_register_service`  
- Responsável pelo **cadastro dos clientes**.
- CRUD completo com persistência no MySQL.

📁 `cliente_appointment_service`  
- Responsável pelos **agendamentos de serviços**.
- Integração via RabbitMQ para troca de dados entre microsserviços.

---

## 📋 Funcionalidades

### ✅ Backend
- Cadastro de clientes (`/clientes`)
- Agendamento de serviços (`/agendamentos`)
- Comunicação entre microsserviços com RabbitMQ
- Documentação automática com Swagger

### ✅ Frontend
- Página inicial responsiva com Angular Material
- Formulário de cadastro de cliente
- Formulário de agendamento de serviço
- Navegação amigável entre componentes

# Acessar a pasta do frontend
cd UI

# Instalar dependências
npm install

# Rodar a aplicação
ng serve

# Acesse no navegador
http://localhost:4200

---

## ⚙️ Como Rodar o Projeto

### 🔧 Requisitos

- Java 21.0.6
- Node.js 22.14.0
- MySQL rodando localmente (porta padrão: `3306`)
- RabbitMQ (utilizado CloudAMQP)

---

### 🧪 Backend

```bash
# Clonar o projeto
git clone https://github.com/reginaldojr-dev/barberShop_decolaTech.git
cd barberShop_decolaTech

# Importar no IntelliJ (ou IDE de sua preferência)

# Verificar o arquivo application.properties (MySQL configurado na porta 3306)

# Executar as aplicações:
- cliente_register_service
- cliente_appointment_service



# ⚙️ ERP LF SOFTWARE & INFRA (Backend API)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)

> Arquitetura backend escalável desenvolvida em Java para gerenciar chamados de assistência técnica, orçamentos e automação das operações da **LF SOFTWARE & INFRA**.

---

## 💻 Sobre o Projeto

O **ERP LF SOFTWARE & INFRA (API)** é o núcleo de processamento do sistema de gestão da empresa. Desenvolvido para substituir processos manuais, a API RESTful expõe endpoints seguros para o registro de clientes, gestão de ativos de TI e acompanhamento de Ordens de Serviço (OS) de manutenção de hardware.

O sistema utiliza uma abordagem de persistência poliglota, aproveitando o melhor de bancos relacionais para dados transacionais estruturados e bancos NoSQL para flexibilidade de documentos.

## 🚀 Tecnologias e Arquitetura

O ecossistema do servidor foi construído utilizando as seguintes ferramentas:

*   **Linguagem & Framework:** Java 17+ com Spring Boot
*   **Bancos de Dados:** PostgreSQL (Relacional) e MongoDB (NoSQL)
*   **Gerenciamento de Dependências:** Maven
*   **Containerização:** Docker
*   **Boas Práticas:** Design Patterns, Injeção de Dependências e Clean Code.

## ⚙️ Principais Funcionalidades

- [x] CRUD completo de Clientes, Equipamentos e Ordens de Serviço.
- [x] Integração e persistência de dados em múltiplos bancos.
- [x] Arquitetura em camadas (Controllers, Services, Repositories).
- [x] Containerização pronta para deploy (Dockerfile configurado).

---

## 🛠️ Como executar o projeto localmente

### Pré-requisitos
*   [Java 17+](https://www.oracle.com/java/technologies/javase-downloads.html)
*   [Maven](https://maven.apache.org/)
*   [Docker](https://www.docker.com/) (Opcional, para rodar os bancos de dados isolados)

### Passos para rodar:

1. **Clone este repositório**
   ```bash
  git clone https://github.com/leonidas-ferreira/erp-lf-suporte-backend.git

# Help Desk Application

Este projeto é um sistema de Help Desk desenvolvido com **Spring Boot** e **Java 21** no backend, e **Angular** no frontend. O objetivo é fornecer uma plataforma para o gerenciamento de chamados, onde há três tipos de usuários principais: **Cliente**, **Técnico** e **Administrador**.

## Funcionalidades

### Cliente
- **Cadastro de Chamados**: O cliente pode abrir novos chamados descrevendo problemas ou solicitações.
- **Consulta de Chamados**: Visualizar a lista de chamados abertos, em andamento ou concluídos.
- **Atualização de Chamados**: Adicionar informações ou comentários nos chamados existentes.

### Técnico
- **Visualização de Chamados**: Acompanhar a lista de chamados designados.
- **Atualização de Status**: Alterar o status de um chamado (e.g., "Aberto", "Em andamento", "Concluído").
- **Resolução de Problemas**: Registrar as soluções aplicadas nos chamados.

### Administrador
- **Gerenciamento de Usuários**: Criar, editar e remover usuários (clientes e técnicos).
- **Atribuição de Chamados**: Designar chamados para técnicos específicos.
- **Relatórios**: Gerar relatórios sobre o desempenho dos técnicos e o tempo médio de resolução.

## Tecnologias Utilizadas

### Backend
- **Java 21**
- **Spring Boot**
  - Spring Data JPA
  - Spring Security
  - Spring Web
- **Banco de Dados**: H2 (em memória para teste) e MySQL (para desenvolvimento)
- **Autenticação**: JWT (JSON Web Tokens)

### Frontend
- **Angular**: Framework para construção da interface do usuário.
- **Angular Material**: Componentes de UI modernos e responsivos.

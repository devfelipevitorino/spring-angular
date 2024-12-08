# 🛠️ Help Desk Application  

Este projeto é um sistema de Help Desk desenvolvido com **Spring Boot** e **Java 21** no backend, e **Angular** no frontend. Ele foi criado para simplificar o gerenciamento de chamados, com funcionalidades adaptadas para três tipos de usuários: **Cliente**, **Técnico** e **Administrador**.  

## 🌟 Funcionalidades  

### 👤 Cliente  
- **📄 Cadastro de Chamados**: Permite abrir novos chamados descrevendo problemas ou solicitações.  
- **🔍 Consulta de Chamados**: Visualize a lista de chamados abertos, em andamento ou concluídos.  
- **✏️ Atualização de Chamados**: Adicione informações ou comentários nos chamados existentes.  

### 👨‍🔧 Técnico  
- **📋 Visualização de Chamados**: Acesse e acompanhe os chamados designados.  
- **🛠️ Atualização de Status**: Altere o status dos chamados para "Aberto", "Em andamento" ou "Concluído".  
- **✅ Registro de Soluções**: Documente as soluções aplicadas em cada chamado.  

### 👑 Administrador  
- **👥 Gerenciamento de Usuários**: Crie, edite e remova usuários (clientes e técnicos).  
- **📌 Atribuição de Chamados**: Direcione chamados para técnicos específicos.  
- **📊 Relatórios**: Gere relatórios sobre desempenho e tempo médio de resolução.  

## 🛠️ Tecnologias Utilizadas  

### Backend  
- **Java 21**  
- **Spring Boot**  
  - Spring Data JPA  
  - Spring Security  
  - Spring Web  
- **Banco de Dados**:  
  - **H2**: Banco em memória para testes.  
  - **MySQL**: Banco relacional para ambiente de desenvolvimento.  
- **🔒 Autenticação**: Implementada com JWT (JSON Web Tokens).  

### Frontend  
- **Angular**: Framework para desenvolvimento da interface.  
- **Angular Material**: Biblioteca de componentes UI modernos e responsivos.  


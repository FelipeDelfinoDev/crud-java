# 🛒 Mercadinho-CRUD

> Um sistema desktop de gerenciamento de estoque para um mercadinho local desenvolvido em Java, utilizando a interface gráfica Java Swing (MVC) e a API JDBC (DAO) para persistência em banco de dados MySQL.

---

## 🚀 Sobre o Projeto

O **Mercadinho-CRUD** é uma aplicação desktop estruturada para gerenciar o inventário de um pequeno comércio. O foco principal deste projeto foi aplicar os conceitos fundamentais de Programação Orientada a Objetos (POO), design de interfaces visuais e consolidar o fluxo de persistência de dados utilizando **JDBC**, realizando consultas SQL nativas de forma segura diretamente da aplicação Java.

### 🛠️ Tecnologias Utilizadas

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

---

## 🎯 Funcionalidades (CRUD via JDBC)

- ➕ **Create (Cadastrar - FInsert):** Interface gráfica para envio de dados que aciona uma query `INSERT` via `PreparedStatement` para registrar novos produtos.
- 🔍 **Read (Listar/Exibir - FDisplay):** Executa uma query `SELECT`, manipulando o `ResultSet` para listar todos os itens na tela em componentes de tabela ou buscar dados específicos.
- 🔄 **Update (Atualizar):** Modifica os registros existentes no banco através de instruções `UPDATE` (útil para alteração de preços ou reposição de estoque).
- ❌ **Delete (Remover):** Executa comandos `DELETE` para remover permanentemente um produto do catálogo do banco de dados a partir da interface.

---

## 🏗️ Estrutura do Projeto (Arquitetura MVC / DAO)

O projeto foi desenvolvido seguindo padrões arquiteturais de mercado para garantir a separação de responsabilidades, facilitando a manutenção e organização do código:

- **`model` (Camada de Negócio / Entidade):** \* `Produto.java`: Mapeia a entidade do banco de dados em Objetos Java (POJO) com encapsulamento (atributos, construtores, getters e setters).
- **`persistence` (Camada de Dados / DAO):** \* `ConnectionFactory.java`: Responsável por gerir e fornecer as conexões com o banco de dados MySQL via JDBC.
  - `JDBCProduto.java`: Implementa o padrão DAO (Data Access Object), isolando todas as queries SQL (`PreparedStatement`) de inserção, consulta, atualização e remoção.
- **`view` (Camada de Interface - Java Swing):** \* Interfaces visuais criadas graficamente. Contém as janelas principais do sistema (`Principal.java`, `FInsert.java`, `FDisplay.java`) junto com os arquivos `.form` gerenciados pela IDE para renderização dos componentes de tela.

---

## ⚙️ Como Executar o Projeto

Para rodar esta aplicação localmente, você precisará ter o [JDK (Java Development Kit) 17 ou superior](https://www.oracle.com/java/technologies/downloads/) instalado e o servidor MySQL ativo em sua máquina.

### 1. Clonar o Repositório

```bash
git clone [https://github.com/FelipeDelfinoDev/mercadinho-crud.git](https://github.com/FelipeDelfinoDev/mercadinho-crud.git)
cd mercadinho-crud
```

### 2. Adicionar o Driver do MySQL (Connector/J)

Como o projeto utiliza JDBC puro, certifique-se de que o arquivo .jar do driver do MySQL está adicionado ao classpath de dependências do seu projeto na sua IDE (VS Code, NetBeans, IntelliJ ou Eclipse) para evitar o erro de ClassNotFoundException.

### 3. Configurar o Banco de Dados

Abra o seu terminal MySQL ou o gerenciador de banco de sua preferência (como o MySQL Workbench) e execute o script abaixo para criar a estrutura:

```bash
CREATE DATABASE mercadinho_db;
USE mercadinho_db;

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,
    preco DECIMAL(10, 2) NOT NULL
);

```

### 4. Configurar as Credenciais no Código

No arquivo ConnectionFactory.java (localizado dentro do pacote persistence), ajuste as propriedades com o seu usuário e senha locais do seu servidor MySQL:

```bash
private static final String URL = "jdbc:mysql://localhost:3306/mercadinho_db";
private static final String USER = "seu_usuario";
private static final String PASSWORD = "sua_senha";
```

### 5. Executar a Aplicação

Abra o projeto em sua IDE de preferência e execute o método main localizado na sua classe de entrada principal

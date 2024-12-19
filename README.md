# Nearby Backend

Este é o backend do projeto [Nearby](https://github.com/Arthurandradens/Nearby), desenvolvido originalmente durante a NLW. Apesar de o backend inicial ter sido feito em Node.js, decidi refazer a API utilizando **Spring Boot** para praticar minhas habilidades com Java.

## Tecnologias Utilizadas
- **Java 17** com Spring Boot
- Banco de dados **PostgreSQL** (escolhido por ser uma solução simples para lidar com UUIDs)
- **Docker** para levantar o ambiente do banco de dados
- **Flyway** para gerenciar as migrations

## Configuração do Projeto
Para utilizar o projeto, siga os passos abaixo:

1. Certifique-se de ter o **Docker** instalado.
2. No terminal, execute o comando:

   ```bash
   docker compose up -d
   ```
3. O banco de dados será iniciado em um container Docker e as tabelas serão criadas automaticamente pelas migrations gerenciadas pelo Flyway.

## Estrutura do Projeto
As principais entidades do projeto são:
- **Category**: Representa categorias de mercados.
- **Market**: Representa um mercado associado a uma categoria e possui regras específicas.
- **Rule**: Define regras para os mercados.

### Principais Rotas
Todas as rotas estão documentadas no **Swagger** e podem ser acessadas através da URL:

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

Aqui estão as principais rotas do projeto:

#### Categoria (`/categories`)
- **POST `/categories`**: Criar uma nova categoria.
  - Exemplo de body:
    ```json
    {
      "name": "Supermercado"
    }
    ```
- **GET `/categories`**: Listar todas as categorias.

#### Mercado (`/markets`)
- **POST `/markets`**: Criar um novo mercado.
  - Exemplo de body:
    ```json
    {
      "name": "Mercado Central",
      "description": "O melhor mercado da região",
      "coupons": 10,
      "address": {
        "longitude": -46.6388,
        "latitude": -23.5489,
        "address": "Rua das Flores, 123",
        "phone": "(11) 99999-9999"
      },
      "cover": "link-da-imagem",
      "categoryId": "uuid-da-categoria"
    }
    ```
- **GET `/markets/{id}`**: Buscar um mercado específico com suas regras.
- **GET `/markets/category/{categoryId}`**: Listar mercados de uma categoria específica.

#### Regra (`/rules`)
- **POST `/rules`**: Criar uma nova regra para um mercado.
  - Exemplo de body:
    ```json
    {
      "description": "Promoção de 10% para compras acima de R$ 100",
      "marketId": "uuid-do-mercado"
    }
    ```

#### Cupom (`/coupons/{marketId}`)
- **PATCH `/coupons/{marketId}`**: Verificar e utilizar um cupom disponível para o mercado selecionado.
  - Parâmetro de URL: `marketId` (UUID do mercado).
  - Resposta: Hash do cupom gerado, caso disponível.

## Esquemas dos Dados
### Entidades Principais
#### `Category`
```json
{
  "id": "uuid",
  "name": "string"
}
```

#### `Market`
```json
{
  "id": "uuid",
  "name": "string",
  "description": "string",
  "coupons": "integer",
  "address": {
    "longitude": "number",
    "latitude": "number",
    "address": "string",
    "phone": "string"
  },
  "cover": "string",
  "category": {
    "id": "uuid",
    "name": "string"
  }
}
```

#### `Rule`
```json
{
  "id": "uuid",
  "description": "string",
  "market": {
    "id": "uuid",
    "name": "string"
  }
}
```

## Melhorias Futuras
- Implementar autenticação com **JWT** para maior segurança.
- Adicionar testes automatizados utilizando **JUnit**.
- Criar uma interface gráfica para gerenciar categorias, mercados e regras.

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

## Licença
Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

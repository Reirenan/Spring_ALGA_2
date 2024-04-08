# O que é uma API?
- Application Programming Interface
- Software consumidor <--> API <--> Software Provedor

## Web services vs APIs
- Software Restaurante <--> API do iFOOD <--> iFood

## REST
- Respresentational State Transfer
- Por que REST
- - Separação entre cliente e servidor
- - Escabilidade
- - Independência de linguagem
- - Mercado

## Constratios (regras)
- Cliente-servidor
- Stateless <sem estato>
- Cache 
- Interface uniforme
- Sistema em camadas
- Código sobre demanda

## Protocolo HTTP
- Cliente       requisição ->       Sevidor
  -             <- reposta

## Composição da requisição

```` markdown

[MÉDOTO] [URI] HTTP/[Versão]        
[Cabeçalho]
[CORPO/PAYLOAD]

````

````markdown

POST /produtos HTTP/1.1 
Content-Type: application/json 
aceept: application/json
{
    "nome": "Nootbook i7",
    "preco": 2100.0 
}

````

## Composição da resposta
````markdown
HTTP/[Versão] [STATUS]
[Cabeçalho]
[CORPO]

````
````markdown
HTTP/1.1 201 Created
Location: /produtos/331
Content/type: application/json

{
    "codigo": 331,
    "nome": "Notebook i7",
    "preco": 2100.0
}
````

## Recursos REST
- Um único produto é um rescuro
- - Singleton Resource
- Coleção de produtos é um recurso
- - Collection Resource

## Identicando um recurso
- URI
- - Uniform Resource Identifier

## URI vs URL
/listarProdutos (coleção de produtos)
http://api.algamarket.com.br/listarProdutos

## boas praticas
http://api.algamarket.com.br/produtos

/produtos/{codigo} (produto unico)
http://api.algamarket.com.br/produtos/331

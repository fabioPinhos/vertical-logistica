<h1 align="center" style="font-weight: bold;">LuizaLabs - Desafio técnico - Vertical Logística 💻</h1>

<p align="center">
    <b>Sistema que receba um arquivo via API REST e processe-o para ser retornado via API REST.</b>
</p>

<h2 id="started">🚀 Iniciando...</h2>

<h3>Prerequisites</h3>


- Rodar o docker-compose que foi enviado juntamente com o projeto, o SGDG escolhido foi o MySQL 5.7.
- Possuir o [github](https://github.com/) devidamente instalado e configurado
- Possuir o [Apache Maven](https://maven.apache.org/download.cgi) devidamente instalado e configurado.
- Possuir instalado Java Development Kit (JDK) - versão 11 [download aqui](https://www.oracle.com/java/technologies/downloads/#java11)
- Possuir uma IDE/editor da sua preferência:
    - [Intellij IDEA](https://www.jetbrains.com/idea/)
    - [Eclipse IDE](https://www.eclipse.org/ide/)
    - [VSCode](https://code.visualstudio.com/download)

## Build
```
mvn clean install
```

## Tests
```
mvn test
```

## Running
```
mvn spring-boot:run
```
<h2 id="routes">📍 API Endpoints</h2>

| route               | description                                          
|----------------------|-----------------------------------------------------
| <kbd>POST /cartoes</kbd>     | Criar novo cartão [response details](#get-auth-detail)
| <kbd>POST /cartoes/{numeroCartao}</kbd>     | Obter saldo do Cartão, onde {numeroCartao} é o número do cartão [request details](#post-auth-detail).
| <kbd>POST /transacoes/</kbd>     | Realizar uma Transação [request details](#post-trans-detail).

<h3 id="get-auth-detail">POST /cartoes</h3>

**RESPONSE**
```json
{
    "numeroCartao": "6549873025634501",
    "senha": "1234"
}
```

<h3 id="post-auth-detail">POST /cartoes/{numeroCartao}</h3>

**REQUEST**
```json
6549873025634501
```

**RESPONSE**
```json
  495.15
```

<h3 id="post-trans-detail">POST /cartoes/{numeroCartao}</h3>

**REQUEST**
```json
{
    "numeroCartao": "6549873025634501",
    "senhaCartao": "1234",
    "valor": 10.00
}
```

**RESPONSE**
```json
  OK
```
<h2 id="technologies">💻 Stack utilizada</h2>

![Java](https://img.shields.io/badge/Java-11-green?style=plastic&logo=java)
![Spring Boot](https://img.shields.io/badge/SpringBoot-2.7.7-green?style=plastic&logo=spring)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-2.7.7-green?style=plastic&logo=spring)
![JUnit](https://img.shields.io/badge/JUnit-5-green?style=plastic&)
![Maven](https://img.shields.io/badge/Maven-green?style=plastic)

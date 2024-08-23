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

| route                               | description                                          
|-------------------------------------|-----------------------------------------------------
| <kbd>POST /v1/api/files/upload</kbd> | Uploda do arquivo [response details](#get-detail)
| <kbd>GET /v1/api/users/{id}</kbd>   | Obter Usuario, onde {id} é o id do usuario [request details](#users-detail).
| <kbd>GET /v1/api/orders/{id}</kbd>  | Obter Usuario, onde {id} é o id do pedido [request details](#orders-id-detail).
| <kbd>GET /v1/api/orders/</kbd>      | Obter todos os pedidos [request details](#orders-detail).

<h3 id="get-detail">POST /cartoes</h3>

**RESPONSE**
<h3 id="get-detail">POST /v1/api/files/upload</h3>

**REQUEST**
```json
[
  {
    "user_id": 1,
    "name": "Sammie Baumbach",
    "orders": [
      {
        "order_id": 7,
        "total": 96.47,
        "date": "2021-05-28T03:00:00.000+00:00",
        "products": [
          {
            "product_id": 2,
            "value": 1578.57
          },
          {
            "product_id": 2,
            "value": 1578.57
          },
          {
            "product_id": 5,
            "value": 1288.77
          }
        ]
      }
  }
]
```

**RESPONSE**
```json
  495.15
```

<h3 id="users-detail">GET /v1/api/users/{id}</h3>

**REQUEST**
```json
{
  "user_id": 55,
  "name": "Kris Lockman"
}
```

**RESPONSE**
```json
  OK
```

<h3 id="orders-id-detail">GET /v1/api/orders/{id}</h3>

**REQUEST**
```json
{
  "order_id": 55,
  "total": 279.44,
  "date": "2024-08-22",
  "products": {
    "product_id": 2,
    "value": 1578.57
  },
  "users": {
    "user_id": 6,
    "name": "Mittie Crona DDS"
  }
}
```

**RESPONSE**
```json
  OK
```

<h3 id="orders-detail">GET /v1/api/orders</h3>

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
  [
  {
    "order_id": 177,
    "total": 770.68,
    "date": "2024-08-22T13:49:00.301+00:00",
    "products": {
      "product_id": 5,
      "value": 1288.77
    },
    "users": {
      "user_id": 17,
      "name": "Ethan Langworth"
    }
  },
  {
    "order_id": 237,
    "total": 436.14,
    "date": "2024-08-22T13:49:00.305+00:00",
    "products": {
      "product_id": 5,
      "value": 1288.77
    },
    "users": {
      "user_id": 22,
      "name": "Rosendo Hartmann"
    }
  },
  {
    "order_id": 163,
    "total": 1174.45,
    "date": "2024-08-22T13:49:00.301+00:00",
    "products": {
      "product_id": 1,
      "value": 673.49
    },
    "users": {
      "user_id": 17,
      "name": "Ethan Langworth"
    }
  },
  {
    "order_id": 227,
    "total": 1481.9,
    "date": "2024-08-22T13:49:00.303+00:00",
    "products": {
      "product_id": 3,
      "value": 1836.74
    },
    "users": {
      "user_id": 21,
      "name": "Alberto Murray"
    }
  },
  {
    "order_id": 165,
    "total": 1441.79,
    "date": "2024-08-22T13:49:00.301+00:00",
    "products": {
      "product_id": 6,
      "value": 961.37
    },
    "users": {
      "user_id": 17,
      "name": "Ethan Langworth"
    }
  }]
```


<h2 id="technologies">💻 Stack utilizada</h2>

![Java](https://img.shields.io/badge/Java-11-green?style=plastic&logo=java)
![Spring Boot](https://img.shields.io/badge/SpringBoot-2.7.7-green?style=plastic&logo=spring)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-2.7.7-green?style=plastic&logo=spring)
![JUnit](https://img.shields.io/badge/JUnit-5-green?style=plastic&)
![Maven](https://img.shields.io/badge/Maven-green?style=plastic)

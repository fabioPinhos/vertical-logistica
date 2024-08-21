CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE pedido (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    produto_id INT,
    FOREIGN KEY(produto_id) REFERENCES produto(id) ON DELETE CASCADE
);
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE products (
    product_id INT PRIMARY KEY,
    value FLOAT NOT NULL
);
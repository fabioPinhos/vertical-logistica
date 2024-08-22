CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    date TIMESTAMP NOT NULL,
    total FLOAT NOT NULL,
    users_id INT,
    FOREIGN KEY(users_id) REFERENCES users(user_id) ON DELETE CASCADE,
    products_id INT,
    FOREIGN KEY(products_id) REFERENCES products(product_id) ON DELETE CASCADE
);
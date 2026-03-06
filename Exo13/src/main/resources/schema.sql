CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    stock INT NOT NULL
);

INSERT INTO product (name, price, stock) VALUES ('iPhone 15', 999.99, 50);
INSERT INTO product (name, price, stock) VALUES ('Samsung Galaxy S24', 899.99, 35);
INSERT INTO product (name, price, stock) VALUES ('MacBook Pro', 1999.99, 20);
INSERT INTO product (name, price, stock) VALUES ('iPad Air', 599.99, 45);
INSERT INTO product (name, price, stock) VALUES ('AirPods Pro', 249.99, 100);


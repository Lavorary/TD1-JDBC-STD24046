CREATE TABLE Product(
    id SERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    creation_datetime TIMESTAMP
);

CREATE TABLE Product_category(
    id SERIAL PRIMARY KEY,
    name VARCHAR(155) NOT NULL,
    product_id INT REFERENCES Product(id) NOT NULL
);
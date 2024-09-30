CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    country VARCHAR(255) NOT NULL
);

INSERT INTO users (first_name, age, country) VALUES ('Alice', 25, 'USA');
INSERT INTO users (first_name, age, country) VALUES ('Alice', 25, 'USA');
INSERT INTO users (first_name, age, country) VALUES ('Bob', 30, 'CANADA');
INSERT INTO users (first_name, age, country) VALUES ('Charlie', 22, 'FRANCE');
INSERT INTO users (first_name, age, country) VALUES ('David', 27, 'GERMANY');
INSERT INTO users (first_name, age, country) VALUES ('Eve', 35, 'JAPAN');

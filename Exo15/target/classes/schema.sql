-- Create users table
CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Create projects table
CREATE TABLE IF NOT EXISTS projects (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(500),
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Insert test users
INSERT INTO users (username, password) VALUES ('alice', 'password123');
INSERT INTO users (username, password) VALUES ('bob', 'password456');

-- Insert test projects for alice
INSERT INTO projects (name, description, user_id) VALUES ('Projet A', 'Premier projet d''Alice', 1);
INSERT INTO projects (name, description, user_id) VALUES ('Projet B', 'Deuxième projet d''Alice', 1);

-- Insert test projects for bob
INSERT INTO projects (name, description, user_id) VALUES ('Projet C', 'Projet de Bob', 2);
INSERT INTO projects (name, description, user_id) VALUES ('Projet D', 'Autre projet de Bob', 2);


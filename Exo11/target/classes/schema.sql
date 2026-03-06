-- Create users table
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create index on email for faster queries
CREATE INDEX IF NOT EXISTS idx_users_email ON users(email);

-- Insert sample data
INSERT INTO users (name, email, active) VALUES
    ('User1', 'user1@example.com', TRUE),
    ('User2', 'user2@example.com', TRUE),
    ('User3', 'user3@example.com', FALSE),
    ('User4', 'user4@example.com', TRUE)
ON CONFLICT (email) DO NOTHING;


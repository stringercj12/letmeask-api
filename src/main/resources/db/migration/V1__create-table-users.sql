CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE users
(
    id        UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name      VARCHAR(30)  NOT NULL,
    email     VARCHAR(30)  NOT NULL,
    password  VARCHAR(20)  NOT NULL,
    imageUrl  VARCHAR(200) NOT NULL,
    createdAt TIMESTAMP    NOT NULL
)
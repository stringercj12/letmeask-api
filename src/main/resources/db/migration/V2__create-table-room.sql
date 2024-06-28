CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE rooms
(
    id        UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name      VARCHAR(30)  NOT NULL,
    email     VARCHAR(30)  NOT NULL,
    password  VARCHAR(20)  NOT NULL,
    imageUrl  VARCHAR(200) NOT NULL,
    createdAt TIMESTAMP    NOT NULL,

    user_id UUID,
    FOREIGN KEY(user_id) REFERENCES users (id) ON DELETE CASCADE
)
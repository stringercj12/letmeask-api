CREATE
EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE comments
(
    id          UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    description VARCHAR(30) NOT NULL,
    isPublic    BOOLEAN     NOT NULL,
    createdAt   TIMESTAMP   NOT NULL,

    user_id     UUID,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,

    room_id     UUID,
    FOREIGN KEY (room_id) REFERENCES rooms (id) ON DELETE CASCADE
)
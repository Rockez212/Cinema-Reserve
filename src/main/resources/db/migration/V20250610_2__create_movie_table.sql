CREATE TABLE movies
(
    id              SERIAL PRIMARY KEY,
    user_id BIGINT references users(id),
    title           varchar(255) not null,
    description     varchar(2000) not null,
    duration_minutes int          not null
);
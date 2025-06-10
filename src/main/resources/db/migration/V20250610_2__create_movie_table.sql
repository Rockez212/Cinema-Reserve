CREATE TABLE movie
(
    id              SERIAL PRIMARY KEY,
    title           varchar(255) not null,
    description     varchar(255) not null,
    durationMinutes int          not null
);
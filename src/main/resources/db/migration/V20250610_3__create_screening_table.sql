CREATE TABLE screening
(
    id        SERIAL PRIMARY KEY,
    movie     BIGINT references movie (id),
    startTime date         not null,
    hallName  varchar(255) not null
);

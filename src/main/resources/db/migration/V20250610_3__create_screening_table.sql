CREATE TABLE screenings
(
    id        SERIAL PRIMARY KEY,
    movie     BIGINT references movies (id),
    start_time timestamp         not null,
    hall_name  varchar(255) not null
);

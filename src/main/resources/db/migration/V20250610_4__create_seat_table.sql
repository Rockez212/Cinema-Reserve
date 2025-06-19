create table seats
(
    id         SERIAL PRIMARY KEY,
    screening_id  BIGINT references screenings (id),
    row        int     not null,
    number     int     not null,
    is_reserved boolean not null
);
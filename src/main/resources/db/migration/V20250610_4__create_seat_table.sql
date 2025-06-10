create table seat
(
    id         SERIAL PRIMARY KEY,
    screening  BIGINT references screening (id),
    row        int     not null,
    number     int     not null,
    isReserved boolean not null
);
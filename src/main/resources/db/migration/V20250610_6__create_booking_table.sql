create table booking
(
    id        SERIAL PRIMARY KEY,
    user_id   BIGINT references users(id),
    seat_id      BIGINT references seat (id)
);
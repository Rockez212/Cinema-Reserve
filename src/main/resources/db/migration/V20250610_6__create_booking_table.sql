create table booking
(
    id        SERIAL PRIMARY KEY,
    user_id   BIGINT references users(id),
    screening BIGINT references screening (id),
    seat      BIGINT references seat (id)
);
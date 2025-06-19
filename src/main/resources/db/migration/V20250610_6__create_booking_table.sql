create table bookings
(
    id        SERIAL PRIMARY KEY,
    user_id   BIGINT references users(id),
    seat_id      BIGINT references seats (id)
);
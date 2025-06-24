CREATE SEQUENCE bookings_id_seq START 1;


create table bookings
(
    id      BIGINT PRIMARY KEY DEFAULT nextval('bookings_id_seq'),
    user_id BIGINT references users (id) ON DELETE CASCADE,
    seat_id BIGINT references seats (id) ON DELETE CASCADE
);
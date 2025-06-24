CREATE SEQUENCE seats_id_seq START 1;


create table seats
(
    id           BIGINT PRIMARY KEY DEFAULT nextval('seats_id_seq'),
    screening_id BIGINT references screenings (id) ON DELETE CASCADE,
    row          int     not null,
    number       int     not null,
    is_reserved  boolean not null
);
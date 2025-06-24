CREATE SEQUENCE screenings_id_seq START 1;

CREATE TABLE screenings
(
    id         BIGINT PRIMARY KEY DEFAULT nextval('screenings_id_seq'),
    movie      BIGINT references movies (id) ON DELETE CASCADE,
    start_time timestamp    not null,
    hall_name  varchar(255) not null
);

CREATE UNIQUE INDEX unique_screening ON screenings (movie, start_time, hall_name);

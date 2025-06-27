CREATE SEQUENCE movies_id_seq START 1;


CREATE TABLE movies
(
    id               BIGINT PRIMARY KEY DEFAULT nextval('movies_id_seq'),
    admin_id         BIGINT references users (id) NOT NULL,
    user_id          BIGINT references users (id) ON DELETE CASCADE,
    title            varchar(255)                 not null,
    description      varchar(2000)                not null,
    duration_minutes int                          not null
);
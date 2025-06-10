CREATE TABLE users
(
    id        SERIAL PRIMARY KEY,
    name      varchar(255) not null,
    email     varchar(255) not null UNIQUE,
    password  varchar(255) not null,
    role      varchar(30)  not null CHECK ( role in ('USER', 'ADMIN')),
    createdAt date         not null default CURRENT_DATE
);
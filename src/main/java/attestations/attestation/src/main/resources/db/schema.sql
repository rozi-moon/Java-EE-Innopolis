create table IF not exists users (
    id bigserial primary key,
    login varchar not null,
    password varchar not null,
    email varchar not null,
    phone_number varchar not null
)

comment on table users is 'Таблица пользователей'

create table IF not exists card (
    id bigserial primary key,
    card_number varchar not null,
    expire_date date not null,
    balance bigint not null,
    user_id bigint references users(id)
)

comment on table card is 'Таблица пользовательских карт'

create table IF not exists operation (
    id bigserial primary key,
    operation_type varchar not null,
    balance_change bigint not null,
    operation_date date not null,
    card_id bigint references card(id)
)

comment on table operation is 'Таблица операций по картам'
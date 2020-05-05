--liquibase formatted sql

--changeset bob:1

create table cliente
(
    id bigserial,
    nome varchar(60) not null,
    email varchar(255) not null,
    telefone varchar(20) not null,
    primary key (id)
);
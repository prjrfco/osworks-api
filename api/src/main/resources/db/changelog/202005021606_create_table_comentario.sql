--liquibase formatted sql

--changeset bob:1

create table comentario
(
    id bigserial,
    ordem_servico_id bigserial REFERENCES ordem_servico (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
    descricao varchar(255) not null,
    data_envio timestamp with time zone not null,
    primary key (id)
);
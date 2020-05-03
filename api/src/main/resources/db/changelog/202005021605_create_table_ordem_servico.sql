--liquibase formatted sql

--changeset bob:1

create table ordem_servico
(
    id bigserial,
    cliente_id bigserial REFERENCES cliente (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
    descricao varchar(256) not null,
    preco decimal(10,2) not null,
    data_abertura timestamp with time zone not null,
    data_finalizacao timestamp with time zone,
    primary key (id)
);
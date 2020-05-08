--liquibase formatted sql

--changeset bob:1

create table comentario
(
    id bigserial,
    ordem_servico_id bigserial REFERENCES ordem_servico (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
    descricao text not null,
    data_envio timestamp with time zone not null,
    primary key (id)
);

--Inserindo informações na tabela comentario
insert into comentario values (default, 1, 'Comentário 1', '2019-05-19');
insert into comentario values (default, 2, 'Comentário 2', '2019-06-21');
insert into comentario values (default, 3, 'Comentário 3', '2019-07-13');
insert into comentario values (default, 4, 'Comentário 4', '2019-08-19');
insert into comentario values (default, 5, 'Comentário 5', '2019-09-24');
insert into comentario values (default, 6, 'Comentário 6', '2019-01-11');
insert into comentario values (default, 7, 'Comentário 7', '2020-02-15');
insert into comentario values (default, 8, 'Comentário 8', '2020-05-02');
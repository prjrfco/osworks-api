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

--Inserindo informações na tabela cliente
insert into cliente values (default, 'Francisco', 'prjr.francisco@gmail.com', '98403-7855');
insert into cliente values (default, 'Frank', 'zoddam@gmail.com', '98215-1346');
insert into cliente values (default, 'Daniel', 'karmodaniel@gmail.com', '98945-3265');
insert into cliente values (default, 'Marilia', 'mahsoares@gmail.com', '98595-1912');
insert into cliente values (default, 'Valter', 'hanzojr@gmail.com', '99192-5654');
insert into cliente values (default, 'Kenedy', 'kanja@gmail.com', '98186-8235');
insert into cliente values (default, 'Ricardo', 'kdinho@gmail.com', '98486-8435');
insert into cliente values (default, 'Hayres', 'morphix@gmail.com', '99154-3455');
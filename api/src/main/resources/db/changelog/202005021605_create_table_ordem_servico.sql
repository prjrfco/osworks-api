--liquibase formatted sql

--changeset bob:1

create table ordem_servico
(
    id bigserial,
    cliente_id bigserial REFERENCES cliente (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
    descricao text not null,
    preco decimal(10,2) not null,
    data_abertura timestamp with time zone not null,
    data_finalizacao timestamp with time zone,
    status_ordem_servico varchar(20),
    primary key (id)
);

--Inserindo informações na tabela ordem_servico
insert into ordem_servico values (default, 1, 'Formatar notebook dell', 100.00, '2019-05-06', '2019-05-19', 'FINALIZADA');
insert into ordem_servico values (default, 2, 'Limpeza de gabinete', 80.00, '2019-06-05', '2019-06-21', 'FINALIZADA');
insert into ordem_servico values (default, 3, 'Remoção de virus', 35.00, '2019-07-04', '2019-07-13', 'FINALIZADA');
insert into ordem_servico values (default, 4, 'Instalação de jogos', 10.50, '2019-08-12', '2019-08-19', 'FINALIZADA');
insert into ordem_servico values (default, 5, 'Reparo da placa mãe', 150.00, '2019-09-13', '2019-09-24', 'FINALIZADA');
insert into ordem_servico values (default, 6, 'Limpeza de notebook', 50.00, '2020-01-02', '2020-01-11', 'FINALIZADA');
insert into ordem_servico values (default, 7, 'Atualização de harwdware', 50.00, '2020-02-07', '2020-02-15', 'FINALIZADA');
insert into ordem_servico values (default, 8, 'Instalação de sistema operacional', 400.00, '2020-05-01', '2020-05-02', 'CANCELADA');
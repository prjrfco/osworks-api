--liquibase formatted sql

--changeset bob:1

--Inserindo informações na tabela cliente
insert into cliente values (default, 'Francisco', 'prjr.francisco@gmail.com', '98403-7855');
insert into cliente values (default, 'Frank', 'zoddam@gmail.com', '98215-1346');
insert into cliente values (default, 'Daniel', 'karmodaniel@gmail.com', '98945-3265');
insert into cliente values (default, 'Marilia', 'mahsoares@gmail.com', '98595-1912');
insert into cliente values (default, 'Valter', 'hanzojr@gmail.com', '99192-5654');
insert into cliente values (default, 'Kenedy', 'kanja@gmail.com', '98186-8235');
insert into cliente values (default, 'Ricardo', 'kdinho@gmail.com', '98486-8435');
insert into cliente values (default, 'Hayres', 'morphix@gmail.com', '99154-3455');


--Inserindo informações na tabela ordem_servico
insert into ordem_servico values (default, 1, 'Formatar notebook dell', 100.00, '2019-05-06', '2019-05-19', 'FECHADA');
insert into ordem_servico values (default, 2, 'Limpeza de gabinete', 80.00, '2019-06-05', '2019-06-21', 'FECHADA');
insert into ordem_servico values (default, 3, 'Remoção de virus', 35.00, '2019-07-04', '2019-07-13', 'FECHADA');
insert into ordem_servico values (default, 4, 'Instalação de jogos', 10.50, '2019-08-12', '2019-08-19', 'FECHADA');
insert into ordem_servico values (default, 5, 'Reparo da placa mãe', 150.00, '2019-09-13', '2019-09-24', 'FECHADA');
insert into ordem_servico values (default, 6, 'Limpeza de notebook', 50.00, '2020-01-02', '2020-01-11', 'FECHADA');
insert into ordem_servico values (default, 7, 'Atualização de harwdware', 50.00, '2020-02-07', '2020-02-15', 'FECHADA');
insert into ordem_servico values (default, 8, 'Instalação de sistema operacional', 400.00, '2020-05-01', '2020-05-02', 'CANCELADA');

--Inserindo informações na tabela comentario
insert into comentario values (default, 1, 'Comentário 1', '2019-05-19');
insert into comentario values (default, 2, 'Comentário 2', '2019-06-21');
insert into comentario values (default, 3, 'Comentário 3', '2019-07-13');
insert into comentario values (default, 4, 'Comentário 4', '2019-08-19');
insert into comentario values (default, 5, 'Comentário 5', '2019-09-24');
insert into comentario values (default, 6, 'Comentário 6', '2019-01-11');
insert into comentario values (default, 7, 'Comentário 7', '2020-02-15');
insert into comentario values (default, 8, 'Comentário 8', '2020-05-02');



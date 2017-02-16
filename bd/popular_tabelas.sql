delete from ca_usuario;
insert into ca_usuario (id_usuario, tx_login, tx_nome_usuario, tx_senha) values (1, 'admin', 'admin', 'admin');

delete from adm_marca;
insert into adm_marca (id_marca, tx_nome) values (1, 'Volkswagen');
insert into adm_marca (id_marca, tx_nome) values (2, 'Fiat');
insert into adm_marca (id_marca, tx_nome) values (3, 'Renault');

delete from adm_modelo;
insert into adm_modelo (id_modelo, tx_nome, id_marca) values (1, 'Gol', 1);
insert into adm_modelo (id_modelo, tx_nome, id_marca) values (2, 'Fusca', 1);
insert into adm_modelo (id_modelo, tx_nome, id_marca) values (3, 'Voyage', 1);
insert into adm_modelo (id_modelo, tx_nome, id_marca) values (4, 'Kombi', 1);

insert into adm_modelo (id_modelo, tx_nome, id_marca) values (5, 'Uno', 2);
insert into adm_modelo (id_modelo, tx_nome, id_marca) values (6, 'Punto', 2);
insert into adm_modelo (id_modelo, tx_nome, id_marca) values (7, 'Strada', 2);

insert into adm_modelo (id_modelo, tx_nome, id_marca) values (8, 'Sandero', 3);
insert into adm_modelo (id_modelo, tx_nome, id_marca) values (9, 'Logan', 3);

delete from adm_veiculo;
insert into adm_veiculo 
  (id_veiculo, tx_descricao, id_modelo, ano_fabricacao, ano_modelo, tx_combustivel, tx_cor, tx_placa)
values
  (1, 'Teste1', 2, 1969, 1969, 'Gasolina', 'Preto', 'AAA-0000');
	
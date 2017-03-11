delete from adm_orcamento;
delete from adm_veiculo;
delete from adm_modelo;
delete from adm_marca;
delete from ca_usuario;
delete from ger_papel;
delete from ger_pessoa;
delete from ger_cargo;
insert into ca_usuario (id_usuario, tx_login, tx_nome_usuario, tx_senha) values (1, 'admin', 'admin', 'admin');

insert into adm_marca (id_marca, tx_nome) values (1, 'Volkswagen');
insert into adm_marca (id_marca, tx_nome) values (2, 'Fiat');
insert into adm_marca (id_marca, tx_nome) values (3, 'Renault');

insert into adm_modelo (id_modelo, tx_nome, id_marca) values (1, 'Gol', 1);
insert into adm_modelo (id_modelo, tx_nome, id_marca) values (2, 'Fusca', 1);
insert into adm_modelo (id_modelo, tx_nome, id_marca) values (3, 'Voyage', 1);
insert into adm_modelo (id_modelo, tx_nome, id_marca) values (4, 'Kombi', 1);

insert into adm_modelo (id_modelo, tx_nome, id_marca) values (5, 'Uno', 2);
insert into adm_modelo (id_modelo, tx_nome, id_marca) values (6, 'Punto', 2);
insert into adm_modelo (id_modelo, tx_nome, id_marca) values (7, 'Strada', 2);

insert into adm_modelo (id_modelo, tx_nome, id_marca) values (8, 'Sandero', 3);
insert into adm_modelo (id_modelo, tx_nome, id_marca) values (9, 'Logan', 3);

insert into adm_veiculo 
  (id_veiculo, tx_descricao, id_modelo, ano_fabricacao, ano_modelo, tx_combustivel, tx_cor, tx_placa)
values
  (1, 'Teste1', 2, 1969, 1969, 'Gasolina', 'Preto', 'AAA-0000');
  
insert into ger_pessoa
  (dtype, id_pessoa, tx_nome, tx_cnpj, tx_cpf)
values
  ('CLIENTE', 1, 'Alberto Roberto', null, '00000000000'); 
  
insert into ger_pessoa
  (dtype, id_pessoa, tx_nome, tx_cnpj, tx_cpf)
values
  ('COLABORADOR', 2, 'Teste ', null, '00000000000'); 
  
insert into ger_cargo (id_cargo, tx_descricao) values (1, 'Mecânico');

--insert into ger_papel (dtype, id_papel, tx_descricao, id_cargo) values ('CLIENTE', 1, 'Papel', 1);   
insert into ger_papel (dtype, id_papel, tx_descricao, id_cargo) values ('COLABORADOR', 1, 'Papel', 1);   
  
insert into adm_orcamento 
  (id_orcamento, dt_chegada, tx_descricao_problema, id_status, id_cliente, id_colaborador) 
values 
  (1, '2017-01-01', 'Teste', 1, 1, 2);
	
	
select usuarioent0_.id_usuario as id_usuar1_20_, usuarioent0_.ds_senha as ds_senha2_20_, usuarioent0_.ds_login as ds_login3_20_ from tb_usuario	

CREATE TABLE tb_usuario (
  id_usuario int(11) PRIMARY KEY,
  ds_login varchar(255),
  ds_senha varchar(255)
);
insert into tb_usuario (id_usuario, ds_login, ds_senha) values (1, 'admin', '123456');
CREATE TABLE `adm_agenda` (
  `id_agenda` int(11) NOT NULL AUTO_INCREMENT,
  `tx_descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_agenda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `adm_agendamento` (
  `id_agendamento` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_agendamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `adm_disponibilidade` (
  `id_disponibilidade` int(11) NOT NULL AUTO_INCREMENT,
  `dt_disponibilidade` datetime DEFAULT NULL,
  PRIMARY KEY (`id_disponibilidade`),
  CONSTRAINT `FKa87jda8e6rf97sa2rednr7i0x` FOREIGN KEY (`id_disponibilidade`) REFERENCES `adm_agenda` (`id_agenda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `adm_marca` (
  `id_marca` int(11) NOT NULL AUTO_INCREMENT,
  `tx_nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_marca`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `adm_modelo` (
  `id_modelo` int(11) NOT NULL AUTO_INCREMENT,
  `tx_nome` varchar(255) DEFAULT NULL,
  `id_marca` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_modelo`),
  KEY `FKch9gmrh86cs5awui26vafgoua` (`id_marca`),
  CONSTRAINT `FKch9gmrh86cs5awui26vafgoua` FOREIGN KEY (`id_marca`) REFERENCES `adm_marca` (`id_marca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `adm_orcamento` (
  `id_orcamento` int(11) NOT NULL AUTO_INCREMENT,
  `tx_descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_orcamento`),
  CONSTRAINT `FKkwt34djuteruce0xym1tsl0v9` FOREIGN KEY (`id_orcamento`) REFERENCES `adm_veiculo` (`id_veiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `adm_veiculo` (
  `id_veiculo` int(11) NOT NULL AUTO_INCREMENT,
  `ano_fabricacao` int(11) DEFAULT NULL,
  `ano_modelo` int(11) DEFAULT NULL,
  `tx_combustivel` varchar(255) DEFAULT NULL,
  `tx_cor` varchar(255) DEFAULT NULL,
  `tx_descricao` varchar(255) DEFAULT NULL,
  `tx_placa` varchar(255) DEFAULT NULL,
  `id_modelo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_veiculo`),
  KEY `FKqdqgeg5nrtnwhbhh3a0vc31tv` (`id_modelo`),
  CONSTRAINT `FKqdqgeg5nrtnwhbhh3a0vc31tv` FOREIGN KEY (`id_modelo`) REFERENCES `adm_modelo` (`id_modelo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ca_autorizacao` (
  `id_autorizacao` int(11) NOT NULL AUTO_INCREMENT,
  `tx_codigo_autorizacao` varchar(255) DEFAULT NULL,
  `tx_nome_autorizacao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_autorizacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ca_perfil` (
  `id_perfil` int(11) NOT NULL AUTO_INCREMENT,
  `tx_nome_perfil` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ca_perfil_autorizacao` (
  `Perfil_id_perfil` int(11) NOT NULL,
  `autorizacoes_id_autorizacao` int(11) NOT NULL,
  KEY `FKpt8gd3lcy65tcuadoqwj7tenp` (`autorizacoes_id_autorizacao`),
  KEY `FK3xjmfb9etmwhrvo4gawlc2aj` (`Perfil_id_perfil`),
  CONSTRAINT `FK3xjmfb9etmwhrvo4gawlc2aj` FOREIGN KEY (`Perfil_id_perfil`) REFERENCES `ca_perfil` (`id_perfil`),
  CONSTRAINT `FKpt8gd3lcy65tcuadoqwj7tenp` FOREIGN KEY (`autorizacoes_id_autorizacao`) REFERENCES `ca_autorizacao` (`id_autorizacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ca_perfil_usuario` (
  `Usuario_id_usuario` int(11) NOT NULL,
  `perfis_id_perfil` int(11) NOT NULL,
  KEY `FKp2ssg5fp5vbtl2hyxaujgn5rm` (`perfis_id_perfil`),
  KEY `FKlat3fh7eesq3rveesrups4h7j` (`Usuario_id_usuario`),
  CONSTRAINT `FKlat3fh7eesq3rveesrups4h7j` FOREIGN KEY (`Usuario_id_usuario`) REFERENCES `ca_usuario` (`id_usuario`),
  CONSTRAINT `FKp2ssg5fp5vbtl2hyxaujgn5rm` FOREIGN KEY (`perfis_id_perfil`) REFERENCES `ca_perfil` (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ca_usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `tx_login` varchar(255) DEFAULT NULL,
  `tx_nome_usuario` varchar(255) DEFAULT NULL,
  `tx_senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ger_cargo` (
  `id_cargo` int(11) NOT NULL AUTO_INCREMENT,
  `tx_descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_cargo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ger_endereco` (
  `id_endereco` int(11) NOT NULL AUTO_INCREMENT,
  `tx_complemento` varchar(255) DEFAULT NULL,
  `tx_logradouro` varchar(255) DEFAULT NULL,
  `vl_numero` int(11) DEFAULT NULL,
  `tx_tipo_contato` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_endereco`),
  CONSTRAINT `FKra7p7elqbapfpygfvcpu69kkj` FOREIGN KEY (`id_endereco`) REFERENCES `ger_pessoa` (`id_pessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ger_papel` (
  `DTYPE` varchar(31) NOT NULL,
  `id_papel` int(11) NOT NULL AUTO_INCREMENT,
  `tx_descricao` varchar(255) DEFAULT NULL,
  `id_cargo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_papel`),
  KEY `FKa87mp7e7khd4amwklg8t4lg86` (`id_cargo`),
  CONSTRAINT `FKa87mp7e7khd4amwklg8t4lg86` FOREIGN KEY (`id_cargo`) REFERENCES `ger_cargo` (`id_cargo`),
  CONSTRAINT `FKftth8ayc13kqam4kqg8u0xmjc` FOREIGN KEY (`id_papel`) REFERENCES `ger_pessoa` (`id_pessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ger_pessoa` (
  `DTYPE` varchar(31) NOT NULL,
  `id_pessoa` int(11) NOT NULL AUTO_INCREMENT,
  `tx_nome` varchar(255) DEFAULT NULL,
  `tx_cpf` varchar(255) DEFAULT NULL,
  `tx_cnpj` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_pessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ger_telefone` (
  `id_telefone` int(11) NOT NULL AUTO_INCREMENT,
  `tx_descricao` varchar(255) DEFAULT NULL,
  `tx_tipo_contato` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_telefone`),
  CONSTRAINT `FKijoxr3kqs4ii3n2fm9rt4b3ye` FOREIGN KEY (`id_telefone`) REFERENCES `ger_pessoa` (`id_pessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `op_categoria` (
  `DTYPE` varchar(31) NOT NULL,
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `op_produto` (
  `DTYPE` varchar(31) NOT NULL,
  `id_produto` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_produto`),
  CONSTRAINT `FKr13bab0pgwmgy3yoiqxy645l4` FOREIGN KEY (`id_produto`) REFERENCES `adm_orcamento` (`id_orcamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tb_pessoa` (
  `id_pessoa` int(11) NOT NULL AUTO_INCREMENT COMMENT 'CÓDIGO DA PESSOA',
  `nm_pessoa` varchar(70) NOT NULL COMMENT 'NOME DA PESSOA',
  `fl_sexo` char(1) NOT NULL COMMENT 'INFORMAR M OU F',
  `dt_cadastro` datetime NOT NULL COMMENT 'DATA DE CADASTRO DO REGISTRO',
  `ds_email` varchar(80) NOT NULL COMMENT 'EMAIL DA PESSOA',
  `ds_endereco` varchar(200) NOT NULL COMMENT 'DESCRIÇÃO DO ENDEREÇO',
  `fl_origemCadastro` char(1) NOT NULL COMMENT 'ORIGEM DO CADASTRO (I) = INPUT OU (X) = XML',
  `id_usuario_cadastro` int(11) NOT NULL COMMENT 'USUÁRIO LOGADO QUE CADASTROU A PESSOA',
  PRIMARY KEY (`id_pessoa`),
  KEY `id_usuario_cadastro` (`id_usuario_cadastro`),
  CONSTRAINT `tb_pessoa_ibfk_1` FOREIGN KEY (`id_usuario_cadastro`) REFERENCES `tb_usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT COMMENT 'CÓDIGO DO USUÁRIO',
  `ds_login` varchar(30) NOT NULL COMMENT 'LOGIN DO USUÁRIO PARA ACESSO AO SISTEMA',
  `ds_senha` varchar(30) NOT NULL COMMENT 'SENHA DO USUÁRIO PARA ACESSO AO SISTEMA',
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

ALTER TABLE `sgo`.`tb_pessoa` ADD FOREIGN KEY (`id_usuario_cadastro`) REFERENCES `sgo`.`tb_usuario`(`id_usuario`);

INSERT INTO `sgo`.`tb_usuario` (`ds_login`,`ds_senha`) VALUES (`admin`, `123456`);

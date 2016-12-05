CREATE TABLE `ca_autorizacao` (
  `id_autorizacao` int(11) NOT NULL AUTO_INCREMENT,
  `tx_nome_autorizacao` varchar(45) NOT NULL,
  `tx_codigo_autorizacao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_autorizacao`),
  UNIQUE KEY `tx_codigo_autorizacao_UNIQUE` (`tx_codigo_autorizacao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `ca_perfil` (
  `id_perfil` int(11) NOT NULL AUTO_INCREMENT,
  `tx_nome_perfil` varchar(45) NOT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `ca_usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `tx_login` varchar(45) NOT NULL,
  `tx_nome_usuario` varchar(45) NOT NULL,
  `tx_senha` varchar(45) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `tx_login_UNIQUE` (`tx_login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `ca_perfil_autorizacao` (
  `id_perfil` int(11) DEFAULT NULL,
  `id_autorizacao` int(11) DEFAULT NULL,
  KEY `fk_id_perfil_idx` (`id_perfil`),
  KEY `fk_id_autorizacao_idx` (`id_autorizacao`),
  CONSTRAINT `fk_pa_id_autorizacao` FOREIGN KEY (`id_autorizacao`) REFERENCES `ca_autorizacao` (`id_autorizacao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pa_id_perfil` FOREIGN KEY (`id_perfil`) REFERENCES `ca_perfil` (`id_perfil`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `ca_perfil_usuario` (
  `id_perfil` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  KEY `fk_id_perfil_idx` (`id_perfil`),
  KEY `fk_id_usuario_idx` (`id_usuario`),
  CONSTRAINT `fk_pu_id_perfil` FOREIGN KEY (`id_perfil`) REFERENCES `ca_perfil` (`id_perfil`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pu_id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `ca_usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

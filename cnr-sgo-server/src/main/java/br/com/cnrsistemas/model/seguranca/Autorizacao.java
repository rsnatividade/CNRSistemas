package br.com.cnrsistemas.model.seguranca;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ca_autorizacao")
public class Autorizacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id_autorizacao")
	private Integer id;
	
	@Column(name="tx_nome_autorizacao")
	private String nome;
	
	@Column(name="tx_codigo_autorizacao")
	private String codigo;
}

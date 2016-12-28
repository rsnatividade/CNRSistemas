package br.com.cnrsistemas.model.gerencial;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ger_endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id_endereco")
	private int id;
	
	@Column(name="tx_tipo_contato")
	private TipoContato tipoContato;
	
	@Column(name="tx_logradouro")
	private String logradouro;
	
	@Column(name="vl_numero")
	private int numero;
	
	@Column(name="tx_complemento")
	private String complemento;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TipoContato getTipoContato() {
		return tipoContato;
	}
	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}

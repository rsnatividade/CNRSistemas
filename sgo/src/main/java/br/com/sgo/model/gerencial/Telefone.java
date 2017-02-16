package br.com.sgo.model.gerencial;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ger_telefone")
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_telefone")
	private int id;
	
	@Column(name="tx_tipo_contato")
	private TipoContato tipoContato;

	@Column(name="tx_descricao")
	private String descricao;
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}

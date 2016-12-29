package br.com.cnrsistemas.model.administrativo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="adm_agenda")
public class Agenda implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_agenda")
	private int id;
	
	@Column(name="tx_descricao")
	private String descricao;
	
	@OneToMany
	@JoinColumn(name="id_disponibilidade")
	private List<Disponibilidade> disponibilidades;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Disponibilidade> getDisponibilidades() {
		return disponibilidades;
	}
	public void setDisponibilidades(List<Disponibilidade> disponibilidades) {
		this.disponibilidades = disponibilidades;
	}
	
}

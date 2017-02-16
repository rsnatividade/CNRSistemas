package br.com.sgo.model.seguranca;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ca_perfil")
public class Perfil implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_perfil")
	private Integer id;
	
	@Column(name="tx_nome_perfil")
	private String nome;
	
	@ManyToMany
	@JoinTable(name="ca_perfil_autorizacao",
			joinColumns={@JoinColumn(referencedColumnName="id_perfil")},
			inverseJoinColumns={@JoinColumn(referencedColumnName="id_autorizacao")})
	private List<Autorizacao> autorizacoes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}

	public void setAutorizacoes(List<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}
	
}

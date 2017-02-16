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
@Table(name="ca_usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Integer id;
	
	@Column(name="tx_login")
	private String login;
	
	@Column(name="tx_nome_usuario")
	private String nome;
	
	@Column(name="tx_senha")
	private String senha;
	
	@ManyToMany
	@JoinTable(name="ca_perfil_usuario",
			joinColumns={@JoinColumn(referencedColumnName="id_usuario")},
			inverseJoinColumns={@JoinColumn(referencedColumnName="id_perfil")})
	private List<Perfil> perfis;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
	
}

package br.com.sgo.model.gerencial;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ger_pessoa")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pessoa")
	private int id;
	
	@Column(name="tx_nome")
	private String nome;
	
	@OneToMany
	@JoinColumn(name="id_endereco")
	private List<Endereco> enderecos;
	
	@OneToMany
	@JoinColumn(name="id_telefone")
	private List<Telefone> telefones;
	
	@OneToMany
	@JoinColumn(name="id_papel")
	private List<Papel> papeis;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public List<Papel> getPapeis() {
		return papeis;
	}
	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}
	
}

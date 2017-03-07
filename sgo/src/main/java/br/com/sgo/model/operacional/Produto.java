package br.com.sgo.model.operacional;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="op_produto")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_produto")
	private int id;
	@Column(name="tx_nome")
	private String nome;
	@Column(name="vl_produto")
	private BigDecimal valor;
	@Transient
	private Boolean kit;

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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Boolean getKit() {
		return kit;
	}

	public void setKit(Boolean kit) {
		this.kit = kit;
	}
	
	public void adicionarItem(Produto item){
		
	}
	
	public void removerItem(Produto item){
		
	}
	
	public Produto getProduto(int index){
		return null;
	}
}

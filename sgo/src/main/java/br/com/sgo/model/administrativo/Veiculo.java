package br.com.sgo.model.administrativo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="adm_veiculo")
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_veiculo")
	private int id;
	
	@Column(name="tx_descricao")
	private String descricao;
	
	@Column(name="tx_placa")
	private String placa;
	
	@Column(name="tx_cor")
	private String cor;
	
	@Column(name="ano_fabricacao")
	private int ano_fabricacao;
	
	@Column(name="ano_modelo")
	private int ano_modelo;
	
	@Column(name="tx_combustivel")
	private String combustivel;
	
	@ManyToOne
	@JoinColumn(name="id_modelo")
	private Modelo modelo;
	
	@OneToMany
	@JoinColumn(name="id_orcamento")
	private List<Orcamento> orcamentos;
	
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
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public List<Orcamento> getOrcamentos() {
		return orcamentos;
	}
	public void setOrcamentos(List<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getAno_fabricacao() {
		return ano_fabricacao;
	}
	public void setAno_fabricacao(int ano_fabricacao) {
		this.ano_fabricacao = ano_fabricacao;
	}
	public int getAno_modelo() {
		return ano_modelo;
	}
	public void setAno_modelo(int ano_modelo) {
		this.ano_modelo = ano_modelo;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	
}

package br.com.sgo.utils;

import br.com.sgo.model.operacional.Kit;
import br.com.sgo.model.operacional.Material;
import br.com.sgo.model.operacional.Produto;
import br.com.sgo.model.operacional.Servico;

public enum TipoProduto {

	SERVICO("Serviço"){
		public Class<Servico> criarProduto(){
			return Servico.class;
		}
	},
	MATERIAL("Material"){
		public Class<Material> criarProduto(){
			return Material.class;
		}
	},
	KIT("Kit"){
		public Class<Kit> criarProduto(){
			return Kit.class;
		}
	};

	private String nome;
	
	public abstract Class<? extends Produto> criarProduto();
	
	private TipoProduto(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}

package br.com.sgo.utils;

import br.com.sgo.model.operacional.Kit;
import br.com.sgo.model.operacional.Material;
import br.com.sgo.model.operacional.Produto;
import br.com.sgo.model.operacional.Servico;

public enum TipoProduto {

	SERVICO{
		public Class<Servico> criarProduto(){
			return Servico.class;
		}
	},
	MATERIAL{
		public Class<Material> criarProduto(){
			return Material.class;
		}
	},
	KIT{
		public Class<Kit> criarProduto(){
			return Kit.class;
		}
	};
	
	public abstract Class<? extends Produto> criarProduto();
}

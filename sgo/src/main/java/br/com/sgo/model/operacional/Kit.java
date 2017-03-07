package br.com.sgo.model.operacional;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value="KIT")
public class Kit extends Produto {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(targetEntity=Produto.class)
	private List<Produto> itens;

	public List<Produto> getItens() {
		return itens;
	}

	public void setItens(List<Produto> itens) {
		this.itens = itens;
	}

	public void adicionarItem(Produto item){
		itens.add(item);
	}
	
	public void removerItem(Produto item){
		itens.remove(item);
	}
	
	public Produto getProduto(int index){
		return itens.get(index);
	}

}

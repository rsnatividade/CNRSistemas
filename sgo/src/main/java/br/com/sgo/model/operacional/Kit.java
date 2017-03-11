package br.com.sgo.model.operacional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="KIT")
public class Kit extends Produto {

	private static final long serialVersionUID = 1L;
	
	@OneToMany
	@JoinColumn(name="itens")
	private List<Produto> itens;

	public List<Produto> getItens() {
		return itens;
	}

	public void setItens(List<Produto> itens) {
		this.itens = itens;
	}

	public void adicionarItem(Produto item){
		if(itens == null){
			itens = new ArrayList<Produto>();
		}
		itens.add(item);
	}
	
	public void removerItem(Produto item){
		if(itens != null){
			itens.remove(item);
		}
	}
	
	public Produto getProduto(int index){
		return itens.get(index);
	}

}

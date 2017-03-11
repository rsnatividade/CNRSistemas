package br.com.sgo.utils.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sgo.model.operacional.Produto;

@FacesConverter("produtoConverter")
public class ProdutoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Produto produto = null;
		if(value != null && !value.isEmpty()){
			produto = (Produto)component.getAttributes().get(value);
		}
		return produto;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		String txtProduto = "";
		if(obj != null){
			Produto produto = (Produto)obj;
			txtProduto = produto.getNome();
			component.getAttributes().put(txtProduto, obj);
		}
		
		return txtProduto;
	}

}

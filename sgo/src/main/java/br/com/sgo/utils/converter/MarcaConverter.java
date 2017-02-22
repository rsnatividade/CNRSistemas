package br.com.sgo.utils.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sgo.model.administrativo.Marca;

@FacesConverter("marcaConverter")
public class MarcaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Marca marca = null;
		if(value != null && !value.isEmpty()){
			marca = (Marca)component.getAttributes().get(value);
		}
		return marca;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		String txtMarca = "";
		if(obj != null){
			Marca marca = (Marca)obj;
			txtMarca = marca.getNome();
			component.getAttributes().put(txtMarca, obj);
		}
		
		return txtMarca;
	}

	
}

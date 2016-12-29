package br.com.cnrsistemas.managedbean.cadastro;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.cnrsistemas.model.administrativo.Marca;

@ManagedBean
@ViewScoped
public class CadastroMarcaMBean {

	
	private List<Marca> marcas;
	
	@PostConstruct
	public void init(){
		
		for(int i = 0; 1 < 20; i++){
			Marca marca = new Marca();
			marca.setId(i);
			marca.setNome("Marca x" + i);
		}
		
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}
	
}

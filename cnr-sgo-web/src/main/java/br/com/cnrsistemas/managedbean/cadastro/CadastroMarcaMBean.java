package br.com.cnrsistemas.managedbean.cadastro;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.cnrsistemas.dao.administrativo.CadastrosBean;
import br.com.cnrsistemas.model.administrativo.Marca;

@ManagedBean
@ViewScoped
public class CadastroMarcaMBean {

	
	private CadastrosBean cadastroBean = new CadastrosBean();
	private List<Marca> marcas;
	
	@PostConstruct
	public void init(){
		marcas = cadastroBean.listarMarcas();
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}
	
}

package br.com.cnrsistemas.managedbean.cadastro;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import br.com.cnrsistemas.dao.administrativo.AdministrativoSessionFacade;
import br.com.cnrsistemas.model.administrativo.Marca;

@ManagedBean
@ViewScoped
public class CadastroMarcaMBean {

	
	private List<Marca> marcas;
	private AdministrativoSessionFacade administrativoSessionFacade;
	private Marca marca;
	
	@PostConstruct
	public void init(){
		administrativoSessionFacade = new AdministrativoSessionFacade();
		marcas = administrativoSessionFacade.listarMarcasAtivas();
		marca = new Marca();
	}

	public void cadastrarMarca(){
		administrativoSessionFacade.salvarMarca(marca);
		marca = new Marca();
	}
	
	public void selecionarMarca(Marca marca){
		this.marca = marca;
	}
	
	public void removerMarca(){
		administrativoSessionFacade.removerMarca(this.marca);
	}
	
	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
}

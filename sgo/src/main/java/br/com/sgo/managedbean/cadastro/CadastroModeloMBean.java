package br.com.sgo.managedbean.cadastro;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sgo.dao.administrativo.AdministrativoSessionFacade;
import br.com.sgo.model.administrativo.Marca;
import br.com.sgo.model.administrativo.Modelo;

@ManagedBean
@ViewScoped
public class CadastroModeloMBean {

	private List<Modelo> modelos;
	private List<Marca> marcas;
	private Modelo modelo;
	private AdministrativoSessionFacade administrativoSessionFacade;
	
	@PostConstruct
	public void init(){
		administrativoSessionFacade = new AdministrativoSessionFacade();
		marcas = administrativoSessionFacade.listarMarcasAtivas();
		modelos = administrativoSessionFacade.listarModelosAtivos();
		modelo = new Modelo();
	}
	
	public void cadastraModelo(){
		administrativoSessionFacade.salvarModelo(modelo);
		modelo = new Modelo();
	}
	
	public void selecionarModelo(Modelo modelo){
		this.modelo = modelo;
	}
	
	public void removerModelo(){
		administrativoSessionFacade.removerModelo(modelo);
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
}

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
	private String titulo_dialog;
	
	@PostConstruct
	public void init(){
		administrativoSessionFacade = new AdministrativoSessionFacade();
		marcas = administrativoSessionFacade.listarMarcasAtivas();
		modelos = administrativoSessionFacade.listarModelosAtivos();
		novoModelo();
	}
	
	public void cadastraModelo(){
		administrativoSessionFacade.salvarModelo(modelo);
		
		// Refresh nas modelos listados
		modelos = administrativoSessionFacade.listarModelosAtivos();
		novoModelo();
	}
	
	public void selecionarModelo(Modelo modelo){
		this.modelo = modelo;
		
		titulo_dialog = new String("Editar Modelo");
	}
	
	public void removerModelo(){
		administrativoSessionFacade.removerModelo(modelo);
		
		// Refresh nas modelos listados
		modelos = administrativoSessionFacade.listarModelosAtivos();
		novoModelo();
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
	
	public void novoModelo() {
		this.modelo = new Modelo();
		
		titulo_dialog = new String("Inclusão de novo Modelo");
	}
	
	public String getTitulo_dialog() {
		return titulo_dialog;
	}
	
}

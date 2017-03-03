package br.com.sgo.managedbean.cadastro;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sgo.dao.administrativo.AdministrativoSessionFacade;
import br.com.sgo.model.administrativo.Marca;
import br.com.sgo.model.administrativo.Modelo;
import br.com.sgo.model.administrativo.Veiculo;

@ManagedBean
@ViewScoped
public class CadastroMarcaMBean {

	
	private List<Marca> marcas;
	private AdministrativoSessionFacade administrativoSessionFacade;
	private Marca marca;
	private String titulo_dialog;
	
	@PostConstruct
	public void init(){
		administrativoSessionFacade = new AdministrativoSessionFacade();
		marcas = administrativoSessionFacade.listarMarcasAtivas();
		novaMarca();
	}

	public void cadastrarMarca(){
		administrativoSessionFacade.salvarMarca(marca);
		
		// Refresh nas marcas listadas
		marcas = administrativoSessionFacade.listarMarcasAtivas();
		novaMarca();
	}
	
	public void selecionarMarca(Marca marca){
		this.marca = marca;
		
		titulo_dialog = new String("Editar Marca");
	}
	
	public void removerMarca(){
		administrativoSessionFacade.removerMarca(this.marca);
		
		// Refresh nas marcas listadas
		marcas = administrativoSessionFacade.listarMarcasAtivas();
		novaMarca();
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
	
	public void novaMarca() {
		this.marca = new Marca();
		
		titulo_dialog = new String("Inclusão de nova Marca");
	}
	
	public String getTitulo_dialog() {
		return titulo_dialog;
	}
}

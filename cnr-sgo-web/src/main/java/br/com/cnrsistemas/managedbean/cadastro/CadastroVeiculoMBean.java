package br.com.cnrsistemas.managedbean.cadastro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.cnrsistemas.dao.administrativo.AdministrativoSessionFacade;
import br.com.cnrsistemas.model.administrativo.Marca;
import br.com.cnrsistemas.model.administrativo.Modelo;
import br.com.cnrsistemas.model.administrativo.Veiculo;

@ManagedBean
@ViewScoped
public class CadastroVeiculoMBean {
	
	private AdministrativoSessionFacade admSession;
	
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	private Veiculo veiculo;
	
	@PostConstruct
	public void init(){		
		admSession = new AdministrativoSessionFacade();
		veiculos = admSession.listarVeiculosAtivos();
		veiculo = new Veiculo();
		
         Marca marca = new Marca();
		
		marca.setId(1);
		marca.setNome("Volkswagen");		
		
		Modelo modelo = new Modelo();
		
		modelo.setId(1);
		modelo.setMarca(marca);
		modelo.setNome("Fuscao");
		
		veiculo.setModelo(modelo);	
	}
	
	public void incluirVeiculo(){
		admSession.salvarVeiculo(veiculo);
	}
	
	public void editarVeiculo(Veiculo veiculo){
		
	}
	
	public void excluirVeiculo(Veiculo veiculo){
		
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setClientes(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

}

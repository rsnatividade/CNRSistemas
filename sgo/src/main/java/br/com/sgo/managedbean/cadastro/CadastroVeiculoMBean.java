package br.com.sgo.managedbean.cadastro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sgo.dao.administrativo.AdministrativoSessionFacade;
import br.com.sgo.model.administrativo.Combustivel;
import br.com.sgo.model.administrativo.Marca;
import br.com.sgo.model.administrativo.Modelo;
import br.com.sgo.model.administrativo.Veiculo;

@ManagedBean
@ViewScoped
public class CadastroVeiculoMBean {
	
	private AdministrativoSessionFacade admSession;
	
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	private Veiculo veiculo;
	private List<Combustivel> combustiveis;

	
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
		veiculo.setAno_fabricacao(Calendar.getInstance().get(Calendar.YEAR));
		veiculo.setAno_modelo(Calendar.getInstance().get(Calendar.YEAR));
		
		combustiveis = Arrays.asList(Combustivel.values());				
	}
	
	public List<Combustivel> getCombustiveis() {
		return combustiveis;
	}

	public void setCombustiveis(List<Combustivel> combustiveis) {
		this.combustiveis = combustiveis;
	}

	public void incluirVeiculo(){
		admSession.salvarVeiculo(veiculo);
	}
	
	public void selecionarVeiculo(Veiculo veiculo){
		this.veiculo = veiculo;
	}
	
	public void excluirVeiculo(){
		admSession.removerVeiculo(this.veiculo);
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

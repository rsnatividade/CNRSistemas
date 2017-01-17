package br.com.cnrsistemas.managedbean.cadastro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.cnrsistemas.model.administrativo.Marca;
import br.com.cnrsistemas.model.administrativo.Modelo;
import br.com.cnrsistemas.model.administrativo.Veiculo;

@ManagedBean
@ViewScoped
public class CadastroVeiculoMBean {
	
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	@PostConstruct
	public void init(){
		Marca marca = new Marca();
		
		marca.setId(1);
		marca.setNome("Volkswagen");		
		
		Modelo modelo = new Modelo();
		
		modelo.setId(1);
		modelo.setMarca(marca);
		modelo.setNome("Fusca");				
		
		Veiculo veiculo = new Veiculo();
		
		veiculo.setId(1);
		veiculo.setModelo(modelo);
		veiculo.setPlaca("ABC-1234");
		veiculo.setCor("Preto");
		veiculo.setCombustivel("Gasolina");
		veiculo.setAno_modelo(69);
		veiculo.setAno_fabricacao(69);
		veiculo.setDescricao("Fumaceando");		
		
		veiculos.add(veiculo);
	}
	
	public void incluirVeiculo(){
		
	}
	
	public void editarVeiculo(Veiculo veiculo){
		
	}
	
	public void excluirVeiculo(Veiculo veiculo){
		
	}
	
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setClientes(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

}

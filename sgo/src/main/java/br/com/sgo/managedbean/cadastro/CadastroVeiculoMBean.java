package br.com.sgo.managedbean.cadastro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

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
	private String titulo_dialog;

	public String getTitulo_dialog() {
		return titulo_dialog;
	}

	@PostConstruct
	public void init() {
		admSession = new AdministrativoSessionFacade();
		veiculos = admSession.listarVeiculosAtivos();				

		combustiveis = Arrays.asList(Combustivel.values());
		novoVeiculo();
	}

	public List<Combustivel> getCombustiveis() {
		return combustiveis;
	}

	public void setCombustiveis(List<Combustivel> combustiveis) {
		this.combustiveis = combustiveis;
	}

	public void incluirVeiculo() {
		admSession.salvarVeiculo(veiculo);
	}

	public void selecionarVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
		titulo_dialog = new String("Editar Veículo");
	}

	public void excluirVeiculo() {
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

	public void buscarModelo() {
		Map<String, Object> opcoes = new HashMap<String, Object>();
		opcoes.put("resizable", false);
		opcoes.put("draggable", true);
		opcoes.put("modal", true);
		opcoes.put("position", "center center");

		RequestContext.getCurrentInstance().openDialog("buscarModelo", opcoes, null);
	}

	public void retBuscarModelo(SelectEvent evt) {
		Modelo modelo = (Modelo) evt.getObject();

		veiculo.setModelo(modelo);
	}
	public void novoVeiculo() {
		Marca marca = new Marca();
		Modelo modelo = new Modelo();
		modelo.setMarca(marca);		
		
		veiculo = new Veiculo();
		veiculo.setModelo(modelo);
		veiculo.setAno_fabricacao(Calendar.getInstance().get(Calendar.YEAR));
		veiculo.setAno_modelo(Calendar.getInstance().get(Calendar.YEAR));
		
		titulo_dialog = new String("Inclusão de novo Veículo");
	}

}

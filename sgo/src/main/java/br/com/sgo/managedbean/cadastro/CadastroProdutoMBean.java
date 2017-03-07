package br.com.sgo.managedbean.cadastro;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FlowEvent;

import br.com.sgo.dao.administrativo.AdministrativoSessionFacade;
import br.com.sgo.model.operacional.Produto;
import br.com.sgo.utils.TipoProduto;

@ManagedBean
@ViewScoped
public class CadastroProdutoMBean {

	
	private AdministrativoSessionFacade administrativoSessionFacade;
	private List<Produto> produtos;
	private Produto produto;
	private List<TipoProduto> tiposProduto;
	private TipoProduto tipoProdutoSelecionado;
	
	@PostConstruct
	public void init(){
		administrativoSessionFacade = new AdministrativoSessionFacade();
		produtos = administrativoSessionFacade.listarProdutos();
		tiposProduto.addAll(Arrays.asList(TipoProduto.values()));
	}

	public String onFlowProcess(FlowEvent event){
		try{
			switch (tipoProdutoSelecionado) {
			case SERVICO:
				produto = TipoProduto.SERVICO.criarProduto().newInstance();
				break;
			case MATERIAL:
				produto = TipoProduto.MATERIAL.criarProduto().newInstance();
				break;
			case KIT:
				produto = TipoProduto.KIT.criarProduto().newInstance();
				break;
				
			default:
				break;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return event.getNewStep();
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<TipoProduto> getTiposProduto() {
		return tiposProduto;
	}

	public void setTiposProduto(List<TipoProduto> tiposProduto) {
		this.tiposProduto = tiposProduto;
	}

	public TipoProduto getTipoProdutoSelecionado() {
		return tipoProdutoSelecionado;
	}

	public void setTipoProdutoSelecionado(TipoProduto tipoProdutoSelecionado) {
		this.tipoProdutoSelecionado = tipoProdutoSelecionado;
	}
	
}

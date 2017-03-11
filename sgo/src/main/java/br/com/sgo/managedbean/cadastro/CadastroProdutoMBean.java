package br.com.sgo.managedbean.cadastro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FlowEvent;
import org.primefaces.model.DualListModel;

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
	private List<Produto> itensSource;
	private List<Produto> itensTarget;
	private DualListModel<Produto> produtoDualListModel;
	
	@PostConstruct
	public void init(){
		administrativoSessionFacade = new AdministrativoSessionFacade();
		produtos = administrativoSessionFacade.listarProdutos();
		tiposProduto = Arrays.asList(TipoProduto.values());
		itensSource = administrativoSessionFacade.listarProdutos();
		itensTarget = new ArrayList<Produto>();
		produtoDualListModel = new DualListModel<Produto>(itensSource, itensTarget);
	}

	public String onFlowProcess(FlowEvent event){
		if(event.getOldStep().equalsIgnoreCase("tipoProduto")){
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
		}
		
		return event.getNewStep();
	}
	
	public void salvarProduto(){
		for(Produto p : produtoDualListModel.getTarget()){
			produto.adicionarItem(p);
		}
		administrativoSessionFacade.salvarProduto(produto);
		
		produto = null;
		init();
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

	public List<Produto> getItensSource() {
		return itensSource;
	}

	public void setItensSource(List<Produto> itensSource) {
		this.itensSource = itensSource;
	}

	public List<Produto> getItensTarget() {
		return itensTarget;
	}

	public void setItensTarget(List<Produto> itensTarget) {
		this.itensTarget = itensTarget;
	}

	public DualListModel<Produto> getProdutoDualListModel() {
		return produtoDualListModel;
	}

	public void setProdutoDualListModel(DualListModel<Produto> produtoDualListModel) {
		this.produtoDualListModel = produtoDualListModel;
	}

}

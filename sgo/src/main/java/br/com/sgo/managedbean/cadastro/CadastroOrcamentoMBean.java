package br.com.sgo.managedbean.cadastro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sgo.dao.administrativo.AdministrativoSessionFacade;
import br.com.sgo.model.administrativo.Orcamento;

@ManagedBean
@ViewScoped
public class CadastroOrcamentoMBean {

	private AdministrativoSessionFacade admSession;

	private List<Orcamento> orcamentos = new ArrayList<Orcamento>();
	private Orcamento orcamento;
	private String titulo_dialog;

	public String getTitulo_dialog() {
		return titulo_dialog;
	}

	@PostConstruct
	public void init() {
		admSession = new AdministrativoSessionFacade();
		orcamentos = admSession.listarOrcamentosAbertos();

		novoOrcamento();
	}

	public void novoOrcamento() {
		orcamento = new Orcamento();
		titulo_dialog = new String("Novo Orçamento");
	}

	public List<Orcamento> getOrcamentos() {
		return orcamentos;
	}

	public void setOrcamentos(List<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;

	}

	public void selecionarOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
		titulo_dialog = new String("Editar Orçamento");
	}

	public void incluirOrcamento() {
		admSession.salvarOrcamento(orcamento);

		// Refresh nos orçamentos listados
		orcamentos = admSession.listarOrcamentosAbertos();
		novoOrcamento();
	}

	public void excluirOrcamento() {
		admSession.removerOrcamento(orcamento);

		// Refresh nos orçamentos listados
		orcamentos = admSession.listarOrcamentosAbertos();
		novoOrcamento();
	}

}

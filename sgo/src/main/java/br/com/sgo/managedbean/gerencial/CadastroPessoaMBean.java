package br.com.sgo.managedbean.gerencial;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sgo.dao.gerencial.GerencialSessionFacade;
import br.com.sgo.model.gerencial.Pessoa;

@ManagedBean
@ViewScoped
public class CadastroPessoaMBean {

	private List<Pessoa> pessoas;
	private GerencialSessionFacade gerencialSessionFacade;
	private Pessoa pessoa;
	
	/***
	 * CARREGA AS PESSOAS NA INICIALIZAÇÃO 
	 */
	@PostConstruct
	public void init(){
		gerencialSessionFacade = new GerencialSessionFacade();
		pessoas = gerencialSessionFacade.listarPessoasCadastradas();
		pessoa = new Pessoa();
	}
	
	public void cadastrarPessoa(){
		gerencialSessionFacade.salvarPessoa(pessoa);
		pessoa = new Pessoa();
	}
	
	public void selecionarPessoa(Pessoa pessoa){
		this.pessoa = pessoa;
	}
	
	public void removerPessoa(){
		gerencialSessionFacade.removerPessoa(this.pessoa);
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}

package br.com.sgo.dao.gerencial;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sgo.model.gerencial.Pessoa;

public class GerencialSessionFacade {

	private EntityManager em;
	
	public GerencialSessionFacade(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sgo-pu");
		em = emf.createEntityManager();
	}
	
	public List<Pessoa> listarPessoasCadastradas(){
		PessoaDao pessoaDao = new PessoaDao(em);
		return pessoaDao.listarPessoasCadastradas();
	}
	
	public void salvarPessoa(Pessoa pessoa){
		PessoaDao pessoaDao = new PessoaDao(em);
		pessoaDao.salvar(pessoa);
	}
	
	public void removerPessoa(Pessoa pessoa){
		PessoaDao pessoaDao = new PessoaDao(em);
		pessoaDao.excluir(pessoa);
	}
}

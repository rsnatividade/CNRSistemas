package br.com.sgo.dao.gerencial;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sgo.dao.ObjectDao;
import br.com.sgo.model.gerencial.Pessoa;

public class PessoaDao extends ObjectDao {

	private EntityManager em;
	
	public PessoaDao(EntityManager em){
		super(em);
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> listarPessoasCadastradas(){
		StringBuffer sb = new StringBuffer();
		sb.append("from Pessoa p");
		Query qry = em.createQuery(sb.toString());
		List<Pessoa> pessoas = qry.getResultList();
		return pessoas;
	}
}

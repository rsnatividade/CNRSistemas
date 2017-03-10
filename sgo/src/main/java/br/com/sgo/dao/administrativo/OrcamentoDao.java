package br.com.sgo.dao.administrativo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sgo.dao.ObjectDao;
import br.com.sgo.model.administrativo.Orcamento;

public class OrcamentoDao extends ObjectDao {

	private EntityManager em;

	public OrcamentoDao(EntityManager em) {
		super(em);
		this.em = em;
	}
	
	public List<Orcamento> listarOrcamentosAbertos() {
		StringBuffer sb = new StringBuffer();
		sb.append("from Orcamento o");
		Query qry = em.createQuery(sb.toString());
		List<Orcamento> orcamentos = qry.getResultList();
		return orcamentos;
	}

}

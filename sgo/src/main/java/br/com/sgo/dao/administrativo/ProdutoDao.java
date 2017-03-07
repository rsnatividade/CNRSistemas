package br.com.sgo.dao.administrativo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sgo.dao.ObjectDao;
import br.com.sgo.model.operacional.Produto;

public class ProdutoDao extends ObjectDao {

	private EntityManager em;
	
	public ProdutoDao(EntityManager em) {
		super(em);
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<Produto> listarProdutosAtivos(){
		StringBuffer sb = new StringBuffer();
		sb.append("from Produto m");
		Query qry = em.createQuery(sb.toString());
		List<Produto> produtos = qry.getResultList();
		return produtos;
	}

}

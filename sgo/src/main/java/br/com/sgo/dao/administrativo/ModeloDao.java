package br.com.sgo.dao.administrativo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sgo.dao.ObjectDao;
import br.com.sgo.model.administrativo.Modelo;

public class ModeloDao extends ObjectDao {
	
	private EntityManager em;

	public ModeloDao(EntityManager em) {
		super(em);
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<Modelo> listarModelosAtivos(){
		String sql = "from Modelo m";
		Query qry = em.createQuery(sql);
		return qry.getResultList();
	}
}

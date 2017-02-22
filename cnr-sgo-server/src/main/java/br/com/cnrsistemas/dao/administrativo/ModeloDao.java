package br.com.cnrsistemas.dao.administrativo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.cnrsistemas.dao.ObjectDao;
import br.com.cnrsistemas.model.administrativo.Modelo;

public class ModeloDao extends ObjectDao {
	
    private EntityManager em;
	
	public ModeloDao(EntityManager em) {
		super(em);
		this.em = em;
	}
	
    public List<Modelo> listarModelosAtivos() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("from Modelo m");
		Query qry = em.createQuery(sb.toString());
		List<Modelo> modelos = qry.getResultList(); 
		return modelos;		
	}

}

package br.com.cnrsistemas.dao.administrativo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.cnrsistemas.dao.ObjectDao;
import br.com.cnrsistemas.model.administrativo.Marca;

public class MarcaDao extends ObjectDao {

	private EntityManager em;
	
	public MarcaDao(EntityManager em){
		super(em);
		this.em = em;
	}
	
	public List<Marca> listarMarcasAtivas(){
		StringBuffer sb = new StringBuffer();
		sb.append("from Marca m");
		Query qry = em.createQuery(sb.toString());
		List<Marca> marcas = qry.getResultList();
		return marcas;
	}
}

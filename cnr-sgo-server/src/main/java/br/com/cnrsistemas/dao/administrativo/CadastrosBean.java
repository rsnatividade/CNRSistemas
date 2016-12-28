package br.com.cnrsistemas.dao.administrativo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.cnrsistemas.model.administrativo.Marca;
import br.com.cnrsistemas.remote.administrativo.CadastrosBeanRemote;

public class CadastrosBean implements CadastrosBeanRemote {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Marca> listarMarcas() {
		try{
			Query qry = em.createQuery("from Marca");
			return qry.getResultList();
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	
}

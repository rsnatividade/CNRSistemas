package br.com.sgo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

public class ObjectDao {

	private EntityManager em;
	
	public ObjectDao(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public <T> T salvar(T object){
		try{
			em.getTransaction().begin();
			em.persist(object);
			em.getTransaction().commit();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return object;
	}

	public <T> void excluir(T object){
		try{
			em.getTransaction().begin();
			em.remove(object);
			em.getTransaction().commit();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public <T> T procurar(Class<T> classe, int id){
		return em.find(classe, id);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> listar(Class<T> classe){
		Query qry = em.createQuery("from " + classe);
		List<T> resultado = new ArrayList<T>();
		resultado.addAll(qry.getResultList());
		return resultado;
	}

}

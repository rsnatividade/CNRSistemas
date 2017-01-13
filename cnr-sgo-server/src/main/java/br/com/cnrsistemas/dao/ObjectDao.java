package br.com.cnrsistemas.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ObjectDao {

	private EntityManager em;
	
	public ObjectDao(EntityManager em) {
		this.em = em;
	}
	
	public <T> T salvar(T object){
		em.persist(object);
		return object;
	}

	public <T> void excluir(T object){
		em.remove(object);
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

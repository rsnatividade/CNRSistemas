package br.com.cnrsistemas.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilConexao {

	public static EntityManager getEntityManager(){
		EntityManager em;
		
		try{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sgo-pu");
			em = factory.createEntityManager();
		}catch(Exception ex){
			ex.printStackTrace();
			em = null;
		}
		
		return em;
	}
}

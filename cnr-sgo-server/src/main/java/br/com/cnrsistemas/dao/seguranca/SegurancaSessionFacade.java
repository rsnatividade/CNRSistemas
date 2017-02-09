package br.com.cnrsistemas.dao.seguranca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.cnrsistemas.model.seguranca.Usuario;

public class SegurancaSessionFacade {

	private EntityManager em;
	
	public SegurancaSessionFacade() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sgo-pu");
		em = emf.createEntityManager();
	}
	
	public Usuario retornarUsuarioPorLogin(String login){
		UsuarioDao usuarioDao = new UsuarioDao(em);
		return usuarioDao.retornarUsuarioPorLogin(login);
	}

}

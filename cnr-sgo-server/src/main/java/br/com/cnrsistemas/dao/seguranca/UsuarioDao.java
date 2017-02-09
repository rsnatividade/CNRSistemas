package br.com.cnrsistemas.dao.seguranca;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.cnrsistemas.dao.ObjectDao;
import br.com.cnrsistemas.model.seguranca.Usuario;

public class UsuarioDao extends ObjectDao {

	private EntityManager em;
	
	public UsuarioDao(EntityManager em) {
		super(em);
		this.em = em;
	}

	public Usuario retornarUsuarioPorLogin(String login){
		String sql = "from Usuario where login = ?";
		Query qry = em.createQuery(sql);
		qry.setParameter(1, login);
		
		List<Usuario> usuarios = qry.getResultList();
		
		return usuarios != null && !usuarios.isEmpty() ? usuarios.get(0) : null;
	}
}

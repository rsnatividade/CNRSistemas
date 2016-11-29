package br.com.cnrsistemas.dao.seguranca;

import javax.ejb.Stateless;

import br.com.cnrsistemas.model.seguranca.Usuario;
import br.com.cnrsistemas.remote.seguranca.UsuarioBeanRemote;

@Stateless
public class UsuarioBean implements UsuarioBeanRemote {

	@Override
	public Usuario recuperarUsuarioPorId(Integer id) {
		return null;
	}

	@Override
	public Usuario recuperarUsuarioPorNome(String nome) {
		return null;
	}

	@Override
	public Usuario recuperarUsuarioPorLogin(String login) {
		return null;
	}

}

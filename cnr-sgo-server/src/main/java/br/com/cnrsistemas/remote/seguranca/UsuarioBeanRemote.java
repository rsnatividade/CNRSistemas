package br.com.cnrsistemas.remote.seguranca;

import javax.ejb.Remote;

import br.com.cnrsistemas.model.seguranca.Usuario;

@Remote
public interface UsuarioBeanRemote {

	public Usuario recuperarUsuarioPorId(Integer id);
	public Usuario recuperarUsuarioPorNome(String nome);
	public Usuario recuperarUsuarioPorLogin(String login);
}

package br.com.cnrsistemas.seguranca;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.cnrsistemas.dao.seguranca.SegurancaSessionFacade;
import br.com.cnrsistemas.model.seguranca.Usuario;

public class ApplicationSecurityProvider implements AuthenticationProvider {

	private SegurancaSessionFacade segurancaSessionFacade;
	
	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		
		segurancaSessionFacade = new SegurancaSessionFacade();
		Usuario usuario = segurancaSessionFacade.retornarUsuarioPorLogin(auth.getName());
		
		if(usuario == null || !usuario.getSenha().equals(auth.getCredentials().toString())){
			throw new AuthenticationServiceException("Usuário/Senha incorretos");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		return new UsernamePasswordAuthenticationToken(usuario.getNome(), usuario.getSenha(), authorities);
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}

package br.com.cnrsistemas.seguranca;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class ApplicationSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

	public ApplicationSecurityInitializer() {
		super(ApplicationSecurityConfig.class);
	}
}

package br.com.cnrsistemas.seguranca;

import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Inject
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(new ApplicationSecurityProvider());
	}
	
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login.xhtml").permitAll()
		.and()
		.httpBasic();
	   http.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(
	            XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN));
	}
}

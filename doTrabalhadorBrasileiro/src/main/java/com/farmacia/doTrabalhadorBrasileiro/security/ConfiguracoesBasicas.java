package com.farmacia.doTrabalhadorBrasileiro.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class ConfiguracoesBasicas extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioImplementado servico;
	
	@Bean
	public PasswordEncoder criptografaSenha() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/farmaciadotrabalhador/v1/users/save").permitAll()
								.antMatchers(HttpMethod.PUT,"/farmaciadotrabalhador/v1/users/login").permitAll().anyRequest()
								.authenticated()
								.and().httpBasic()
								.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
								.and().cors()
								.and().csrf().disable();
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(servico);
	}
}

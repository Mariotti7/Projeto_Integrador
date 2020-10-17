package com.api.projetoIntegrador.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SegurancaBasicaConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsServices userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/usuario/logar").permitAll()
		.antMatchers("/usuario/cadastrar").permitAll()
		.anyRequest().authenticated()
		.and().httpBasic()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().cors()
		.and().csrf().disable();
	}
	
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.userDetailsService(userDetailsService);
//	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception{
////		http.authorizeRequests()
//		.antMatchers("usuario/logar").permitAll()
//		.antMatchers("usuario/cadastrar").permitAll()
//		.anyRequest().authenticated()
//		.and().httpBasic()
//		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		.and().cors()
//		.and().csrf().disable();
		
//		http.csrf().disable().authorizeRequests()
//		.antMatchers(HttpMethod.GET, "/").hasRole("administrador")
//		.antMatchers(HttpMethod.GET, "/formCad").hasRole("administrador")
//		.antMatchers(HttpMethod.POST, "/categoria").hasRole("administrador")
//		.antMatchers(HttpMethod.POST, "/formCad").hasRole("administrador")
//		.antMatchers(HttpMethod.GET, "/cadastrarCurso").hasRole("administrador")
//		.anyRequest().authenticated()
//		.and().formLogin().permitAll()
//		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
//	}
//	
//	@Bean
//	public static NoOpPasswordEncoder passwordEncorder() {
//		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("Mariotti").password("mariotti").roles("administrador");
//	}
		

}

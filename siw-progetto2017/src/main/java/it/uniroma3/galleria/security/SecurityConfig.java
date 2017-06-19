package it.uniroma3.galleria.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("SELECT username,password,enabled FROM users WHERE username=?")
			.authoritiesByUsernameQuery("SELECT username,authority FROM users u JOIN authorities a ON u.id=a.utente_id WHERE username=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.csrf().disable()
		.authorizeRequests()
			.antMatchers("modifica", "inserimento", "amministrazione", "/removeOpera", "/removeAutore", "/removeStanza", "/updateStanza")
			.hasAuthority("ROLE_ADMIN")
			.anyRequest().permitAll()
			.and()
		.formLogin()
			.loginPage("/login").permitAll()
			.and()
		.logout()
			.permitAll();
	}

}

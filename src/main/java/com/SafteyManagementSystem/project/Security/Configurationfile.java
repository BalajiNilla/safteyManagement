package com.SafteyManagementSystem.project.Security;

import org.springframework.context.annotation.Bean;



import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class Configurationfile extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Team1").password("Team1").roles("ADMIN","USER").and().withUser("Ramcharan").password("Ramcharan").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/api/injurycentre/**","/api/incidentcentre/**","/api/rfa/**","/api/action/**").hasRole("ADMIN").
		antMatchers("/api/injurycentre/**","/api/incidentcentre/**","/api/rfa/**").hasRole("USER").
		anyRequest().authenticated().
		and().csrf().disable();
	 
}
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder(){
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
}
}


package com.JeevanJyotiHospital.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	UserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
		security.csrf(customizer -> customizer.disable());
		security.authorizeHttpRequests(request -> request.requestMatchers("/private/**").authenticated());
		security.authorizeHttpRequests(request -> request.anyRequest().permitAll());
		security.formLogin(Customizer.withDefaults()); // for browser
	//	security.formLogin(formLogin -> formLogin.loginPage("/logins").loginProcessingUrl("/logging").defaultSuccessUrl("/").permitAll()); // for browser
		security.httpBasic(Customizer.withDefaults()); // for postman
		// security.sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		 
		return security.build(); 

	}	

	/*
	 * 
	 * @Bean public UserDetailsService userDetailsService() {
	 * 
	 * @SuppressWarnings("deprecation") UserDetails user =
	 * User.withDefaultPasswordEncoder() .username("dheeraj") .password("password")
	 * .roles("USER") .build();
	 * 
	 * 
	 * return new InMemoryUserDetailsManager(user);
	 * 
	 * }
	 * 
	 */

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoauth = new DaoAuthenticationProvider();
		daoauth.setPasswordEncoder(new BCryptPasswordEncoder(12));
		daoauth.setUserDetailsService(userDetailsService);
		
		return daoauth;

	}

}

package com.abautista.appsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	/**
	 * Configuracion básica 
	 * @param http
	 * @return
	 * @throws Exception
	 */
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(auth -> 
//		auth.anyRequest().authenticated()) // Cualquier request que sea mandado debe tener autenticación
//		.formLogin(Customizer.withDefaults()) // Configuración por default para el login
//		.httpBasic(Customizer.withDefaults()); // El metodo de autenticación es básico, solo usuario y contraseña
//		return http.build();
//	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> 
		auth.requestMatchers("/loans","/balance", "accounts", "/cards").authenticated()
		.anyRequest().permitAll()) // Cualquier otro request que no sea el de la linea anterior, no necesitan autenticación
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		return http.build();
	}

}

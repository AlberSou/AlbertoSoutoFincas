package com.dawes.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.dawes.serviciosimpl.ServicioUsuarioImpl;

@Configuration
@EnableWebSecurity
public class MiSeguridad {
	@Autowired
	ServicioUsuarioImpl su;


	@Bean
	public BCryptPasswordEncoder encripta() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filtroCompleto(HttpSecurity http) throws Exception {

		// autentificamos
		http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(su)
				.passwordEncoder(encripta());

		// autorizamos a user acceso a la carpeta user

		http.authorizeHttpRequests().requestMatchers("/fincas/fincasmostrar","/fincas/fincaplano","/fincas/plano/**","/variedades/variedadesmostrar","/fincas/fincaarboles").hasAnyRole("USER", "ADMIN").and().exceptionHandling()
				.accessDeniedPage("/403");

		;

		// autorizamos a user admin acceso a la carpeta admin

		http.authorizeHttpRequests().requestMatchers("/fincas/**").hasRole("ADMIN").and().exceptionHandling()
				.accessDeniedPage("/403");

		;

		// el raiz , index, login, 403 no requieren autentificación
		http.authorizeHttpRequests().requestMatchers("/", "/fincas/fincasmostrar", "/login", "/403").permitAll().anyRequest()
				.authenticated();

		// para autenticarse utiliza el formulario de login personalizado

		http.formLogin().loginPage("/login").permitAll();

		// programamos el logout
		http.logout().logoutUrl("/logout").permitAll();

		return http.build();
	}
}

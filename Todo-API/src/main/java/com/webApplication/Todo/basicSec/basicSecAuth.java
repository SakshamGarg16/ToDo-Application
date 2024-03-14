package com.webApplication.Todo.basicSec;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

//@Controller
public class basicSecAuth {
	
	@Bean
	public SecurityFilterChain filterChai(HttpSecurity http) throws Exception {
		
		return
		http.authorizeHttpRequests(
				auth -> auth
							.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
							.anyRequest().authenticated()
				)
			.httpBasic(Customizer.withDefaults())
			.sessionManagement(
					session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.csrf().disable()
			.build();
	}

}

package br.com.usp.mac0472.cartografiapaulistana.config;

import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private SecurityFilter securityFilter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers("/error").permitAll()
						.requestMatchers(GET, "api/arquitetos/**").permitAll()
						.requestMatchers(PUT, "api/arquitetos/**").hasRole("ADMIN")
						.requestMatchers(DELETE, "api/arquitetos/**").hasRole("ADMIN")
						.requestMatchers(GET, "api/obras/**").permitAll()
						.requestMatchers(PUT, "api/obras/**").hasRole("ADMIN")
						.requestMatchers(DELETE, "api/obras/**").hasRole("ADMIN")
						.requestMatchers(GET, "api/construtoras/**").permitAll()
						.requestMatchers(PUT, "api/construtoras/**").hasRole("ADMIN")
						.requestMatchers(DELETE, "api/construtoras/**").hasRole("ADMIN")
						.requestMatchers(POST, "api/auth/login").permitAll()
						.requestMatchers(POST, "api/auth/cadastro").hasRole("ADMIN")
						.anyRequest().authenticated())
				.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
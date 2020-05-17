package com.codelabs.vignesh.authServer.authenticationManager;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@EnableWebSecurity
public class AuthManager extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(AuthenticationManagerBuilder authBuilder) throws Exception {

		authBuilder.inMemoryAuthentication()
		   		.passwordEncoder(passwordEncoder())
		   		.withUser("admin")
				.password("$2a$04$XX40OCtQY7kU0YqXuhBgSONjsjXRQDvimJfCaroOsV2twGq.Bx7fC")
				.roles("ADMIN")
				.and()
				
				.withUser("admin1")
				.password("$2a$04$XX40OCtQY7kU0YqXuhBgSONjsjXRQDvimJfCaroOsV2twGq.Bx7fC")
				.roles("ADMIN");
	}
	


	@Bean 
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

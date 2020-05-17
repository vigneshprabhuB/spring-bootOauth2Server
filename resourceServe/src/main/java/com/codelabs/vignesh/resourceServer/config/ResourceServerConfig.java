package com.codelabs.vignesh.resourceServer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;


@Configuration

@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
   
	  @Override
	    public void configure(HttpSecurity http) throws Exception {
	         http.authorizeRequests()
	         .antMatchers("/api/**").authenticated();

	    }
	
	  @Bean
	  public ResourceServerTokenServices createResourceServerTokenServices() {
	      RemoteTokenServices tokenServices = new RemoteTokenServices();
	      tokenServices.setCheckTokenEndpointUrl("http://localhost:8081/oauth/check_token");
	      tokenServices.setClientId("client1");
	      tokenServices.setClientSecret("secret1"); //cannot be null
	      return tokenServices;
	  } 

}

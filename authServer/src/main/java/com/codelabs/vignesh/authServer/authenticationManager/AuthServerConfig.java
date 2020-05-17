package com.codelabs.vignesh.authServer.authenticationManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

   @Autowired
	AuthenticationManager authenticationManager;
   


	@Override
	 public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	   clients.inMemory()
	   .withClient("client1").secret("{noop}secret1")
	   .authorizedGrantTypes("password").scopes("READ")
	   .and()
	   .withClient("client2").secret("{noop}secret2")
	   .authorizedGrantTypes("authorization_code").scopes("READ");
	
			   
	} 
	
	 @Override
	    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
	        endpoints.authenticationManager(authenticationManager);
	        endpoints.tokenEnhancer(accessTokenConverter());
	        
	    }
	 
	 
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}
	 @Bean
	 public JwtAccessTokenConverter accessTokenConverter() {
	     JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	     converter.setSigningKey("123");
	     return converter;
	 }
	 

}

package com.codelabs.vignesh.authServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value="api/device")

public class AuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}
	
	@GetMapping(value= {"/v1.0/{id}","/v2.0"},produces="application/json")
	public ResponseEntity<String> Hello() {
		return new ResponseEntity("{\"version\":v1.0}",HttpStatus.OK);
	//	return new ResponseEntity("{\"version\":v1.0}",HttpStatus.OK);
	}

}

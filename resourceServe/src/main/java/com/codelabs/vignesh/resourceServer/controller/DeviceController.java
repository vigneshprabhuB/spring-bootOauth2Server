package com.codelabs.vignesh.resourceServer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/device")
public class DeviceController {

@GetMapping(value= {"/v1.0"})	
public String getInfo() {
	return "v1.0";
}
}

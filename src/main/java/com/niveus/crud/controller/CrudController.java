package com.niveus.crud.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudController {
	
	@PostMapping(value= "/getDetails")
	public String getDetails()
	{
		return "Welcome to niveus solutions";
	}

}

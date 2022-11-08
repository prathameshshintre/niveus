package com.niveus.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niveus.crud.entity.EmpEntity;
import com.niveus.crud.entity.EmpEntityReponse;
import com.niveus.crud.repository.EmpRepository;

@RestController
@RequestMapping(value= "/crud")
public class CrudController {
	
	@Autowired
	EmpRepository repo;
	@PostMapping(value= "/insert")
	public ResponseEntity<EmpEntityReponse> enterData(@RequestBody EmpEntity request)
	{
		EmpEntityReponse response=new EmpEntityReponse();
		System.out.println(request.getEmpName()+ request.getEmpDesignation()+ request.getEmpDepartment() + request.getEmpEmailId());
		this.repo.save(request);
		response.setMessage("Record inserted");
		
		return new ResponseEntity<EmpEntityReponse>(response,HttpStatus.OK);
		
	}

}

package com.niveus.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niveus.crud.entity.EmpEntity;
import com.niveus.crud.entity.EmpEntityReponse;
import com.niveus.crud.entity.EmpEntityRequest;
import com.niveus.crud.repository.EmpRepository;

@RestController
@RequestMapping(value= "/crud")
public class CrudController {
	
	private static final Logger log=LoggerFactory.getLogger(CrudController.class);
	@Autowired
	EmpRepository repo;
	
	@PostMapping(value= "/insert")
	public ResponseEntity<EmpEntityReponse> enterData(@RequestBody EmpEntityRequest request)
	{
		EmpEntityReponse response=new EmpEntityReponse();
		EmpEntity savedEntity=new EmpEntity();
		savedEntity.setEmpName(request.getEmpName());
		savedEntity.setEmpDesignation(request.getEmpDesignation());
		savedEntity.setEmpDepartment(request.getEmpDepartment());
		savedEntity.setEmpEmailId(request.getEmpEmailId());
		 savedEntity=this.repo.save(savedEntity);
		ArrayList<EmpEntity> li=new ArrayList<>();
		li.add(savedEntity);
		response.setList(li);
		response.setMessage("Record inserted");
		
		return new ResponseEntity<EmpEntityReponse>(response,HttpStatus.CREATED);
		
	}
	
	@GetMapping(value="/select/{id}")
	public ResponseEntity<EmpEntityReponse> getData(@PathVariable(value ="id")int empId)  
	{
		EmpEntityReponse response=new EmpEntityReponse();
		log.info("empId:{}",empId);
		EmpEntity finalList=this.repo.findById(empId).orElse(null);
		ArrayList<EmpEntity> li=new ArrayList<>();
		li.add(finalList);
		response.setList(li);
		response.setMessage("");
		
		return new ResponseEntity<EmpEntityReponse>(response,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/selectAll")
	public ResponseEntity<EmpEntityReponse> getAllData()  
	{
		List<EmpEntity> li=new ArrayList();
		EmpEntityReponse response=new EmpEntityReponse();
		 li=this.repo.findAll();
		response.setList(li);
		response.setMessage("");
		
		return new ResponseEntity<EmpEntityReponse>(response,HttpStatus.OK);
	}
	
	@PutMapping(value= "/update")
	public ResponseEntity<EmpEntityReponse> updateData(@RequestBody EmpEntityRequest request)
	{
		ArrayList<EmpEntity> li=new ArrayList<>();
		ArrayList<EmpEntity> newList=new ArrayList<>();
		EmpEntityReponse response=new EmpEntityReponse();
		EmpEntity savedEntity=new EmpEntity();
		int empId=request.getEmpId();
		EmpEntity finalList=this.repo.findById(empId).orElse(null);
		
		if(finalList!=null) {
			savedEntity.setEmpId(request.getEmpId());
			savedEntity.setEmpDesignation(request.getEmpDesignation());
			savedEntity.setEmpDepartment(request.getEmpDepartment());
			savedEntity.setEmpEmailId(request.getEmpEmailId());
			savedEntity.setEmpName(request.getEmpName());
		}
		else
		{
			response.setMessage("Record NotFound");
			return new ResponseEntity<EmpEntityReponse>(response,HttpStatus.OK);
		}
		savedEntity=this.repo.save(savedEntity);
		newList.add(savedEntity);
		response.setList(newList);
		response.setMessage("Record Updated");
		return new ResponseEntity<EmpEntityReponse>(response,HttpStatus.OK);
		
	}
	
	@DeleteMapping(value= "/delete")
	public ResponseEntity<EmpEntityReponse> deleteData(@RequestBody EmpEntityRequest request)
	{
		List<EmpEntity> newList=new ArrayList();
		EmpEntityReponse response=new EmpEntityReponse();
		int empId=request.getEmpId();
			this.repo.deleteById(empId);
			 newList=this.repo.findAll();
			response.setList(newList);
		response.setMessage("Record Deleted");
		return new ResponseEntity<EmpEntityReponse>(response,HttpStatus.OK);
		
	}
}

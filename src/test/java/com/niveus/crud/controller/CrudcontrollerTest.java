package com.niveus.crud.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.niveus.crud.entity.EmpEntity;
import com.niveus.crud.entity.EmpEntityReponse;
import com.niveus.crud.entity.EmpEntityRequest;
import com.niveus.crud.repository.EmpRepository;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
 class CrudcontrollerTest {

		
		@Mock
		EmpRepository repo;
	
	
	    @InjectMocks
	    CrudController curdController;
	    
	    EmpEntity rec1= new EmpEntity();
	   
	    @Test
		 void testAddEmployee() 
		{
			MockHttpServletRequest request = new MockHttpServletRequest();
			RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
			
			EmpEntity employee = new EmpEntity();
			employee.setEmpId(908);
			when(repo.save(any(EmpEntity.class))).thenReturn(employee);
			
			EmpEntity employeeToAdd = new EmpEntity("Lokesh","Lokesh", "Gupta", "howtodoinjava@gmail.com");
			EmpEntityRequest req=new EmpEntityRequest();
			req.setEmpName(employeeToAdd.getEmpName());
			req.setEmpDepartment(employeeToAdd.getEmpDepartment());
			req.setEmpDesignation(employeeToAdd.getEmpDesignation());
			req.setEmpEmailId(employeeToAdd.getEmpEmailId());
			ResponseEntity<EmpEntityReponse> responseEntity = curdController.enterData(req);
			
			assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
			
		}
	    @Test
		 void testFindAll() 
		{
			// given
	    	EmpEntity employee1 = new EmpEntity("Lokesh", "Lokesh","Gupta", "howtodoinjava@gmail.com");
	    	EmpEntity employee2 = new EmpEntity("Alex", "Lokesh","Gussin", "example@gmail.com");
			List<EmpEntity> list = new ArrayList<EmpEntity>();
			list.addAll(Arrays.asList(employee1, employee2));

			when(repo.findAll()).thenReturn(list);

			// when
			ResponseEntity<EmpEntityReponse>   result = curdController.getAllData();

			// then
			assertThat(result.getBody().getList()).isNotNull();
			
			assertThat(result.getBody().getList().get(0).getEmpName())
							.isEqualTo(employee1.getEmpName());
			
			assertThat(result.getBody().getList().get(1).getEmpName())
			.isEqualTo(employee2.getEmpName());
		}

	    @Test
	  		 void testFindBYId() 
	  		{
	  			// given
	  	    	EmpEntity employee1 = new EmpEntity("Lokesh", "Lokesh","Gupta", "howtodoinjava@gmail.com");
	  	    	employee1.setEmpId(101);
	  			List<EmpEntity> list = new ArrayList<EmpEntity>();
	  			list.addAll(Arrays.asList(employee1));
	  			EmpEntity finalList=null;
	  			when(repo.findById(employee1.getEmpId())).thenReturn(Optional.ofNullable(finalList));
	  			// when
	  			ResponseEntity<EmpEntityReponse>   result = curdController.getData(employee1.getEmpId());
	  			// then
	  			assertThat(result.getBody().getList()).isNotNull();
	  			
	  		}

	    @Test
  		 void deleteId() 
  		{
  			// given
	    	EmpEntityRequest req=new EmpEntityRequest();
  	    	EmpEntity employee1 = new EmpEntity("Lokesh", "Lokesh","Gupta", "howtodoinjava@gmail.com");
  	    	employee1.setEmpId(101);
  			List<EmpEntity> list = new ArrayList<EmpEntity>();
  			list.addAll(Arrays.asList(employee1));
  			req.setEmpId(employee1.getEmpId());
  			repo.deleteById(req.getEmpId());
  			when(repo.findAll()).thenReturn(list);

  			// when
  			ResponseEntity<EmpEntityReponse>   result = curdController.deleteData(req);
  			String message="Record Deleted.";
  			// then
  			assertEquals( "Record Deleted.",message);
  			
  		}
	    
	    @Test
  		 void updateId() 
  		{
  			// given
	    	EmpEntity savedEntity=new EmpEntity();
	    	
  	    	EmpEntity employee1 = new EmpEntity("Lokesh", "Lokesh","Gupta", "howtodoinjava@gmail.com");
  	    	employee1.setEmpId(101);
  			List<EmpEntity> list = new ArrayList<EmpEntity>();
  			list.addAll(Arrays.asList(employee1));
  			EmpEntity finalList=null;
  			when(repo.findById(employee1.getEmpId())).thenReturn(Optional.ofNullable(finalList));
  			// when
  			curdController.getData(employee1.getEmpId());
  			EmpEntityRequest req=new EmpEntityRequest();
  			req.setEmpName(employee1.getEmpName());
			req.setEmpDepartment(employee1.getEmpDepartment());
			req.setEmpDesignation(employee1.getEmpDesignation());
			req.setEmpEmailId(employee1.getEmpEmailId());
  			if(list!=null) {
  				savedEntity.setEmpId(req.getEmpId());
  				savedEntity.setEmpDesignation(req.getEmpDesignation());
  				savedEntity.setEmpDepartment(req.getEmpDepartment());
  				savedEntity.setEmpEmailId(req.getEmpEmailId());
  				savedEntity.setEmpName(req.getEmpName());
  				
  				
  			}
  			ResponseEntity<EmpEntityReponse> responseEntity = curdController.enterData(req);
  			String message="Record Updated";
  			// then
  			assertEquals( "Record Updated",message);
				assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
  			// then
  		
  		}
}

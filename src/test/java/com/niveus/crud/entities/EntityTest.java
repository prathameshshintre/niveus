package com.niveus.crud.entities;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;

import com.niveus.crud.entity.EmpEntity;
import com.niveus.crud.entity.EmpEntityReponse;
import com.niveus.crud.entity.EmpEntityRequest;

 class EntityTest {
	@Test
	 void testEmpEntity() {
		assertThat(EmpEntity.class, hasValidGettersAndSetters());
	}
	
	@Test
	 void testEmpEntityReponse() {
		assertThat(EmpEntityReponse.class, hasValidGettersAndSetters());
	}
	
	@Test
	 void testEmpEntityRequest() {
		assertThat(EmpEntityRequest.class, hasValidGettersAndSetters());
	}
	@Test
	 void testEmpEntity1() {
		assertThat(EmpEntity.class, hasValidBeanConstructor());
	}
}

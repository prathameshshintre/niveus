package com.niveus.crud.entities;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

import com.niveus.crud.entity.EmpEntity;
import com.niveus.crud.entity.EmpEntityReponse;
import com.niveus.crud.entity.EmpEntityRequest;

public class EntityTest {
	@Test
	public void testEmpEntity() {
		assertThat(EmpEntity.class, hasValidGettersAndSetters());
	}
	
	@Test
	public void testEmpEntityReponse() {
		assertThat(EmpEntityReponse.class, hasValidGettersAndSetters());
	}
	
	@Test
	public void testEmpEntityRequest() {
		assertThat(EmpEntityRequest.class, hasValidGettersAndSetters());
	}
}

package com.niveus.crud;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrudApplicationTests {

	@Test
	void contextLoads() {
		
		assertNotNull(getClass());
	}

}

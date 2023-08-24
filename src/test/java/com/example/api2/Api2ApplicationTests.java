package com.example.api2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import voll.example.api2.Api2Application;

@SpringBootTest(classes = Api2Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Api2ApplicationTests {

	@Test
	void contextLoads() {
	}

}

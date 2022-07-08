package com.example.superheroes.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.example.superheroes.services.SuperHeroeService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class SuperHeroeControllerTest {
	
	@MockBean
    SuperHeroeService superHeroeServiceMock = Mockito.mock(SuperHeroeService.class);
    
    @Autowired
    SuperHeroeController superHeroeController = new SuperHeroeController();

	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAllSuperHeroes() {
	}

//	@Test
//	void testGetSuperHeroeById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCreateSuperHeroe() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateSuperHeroe() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testKillSuperHeroe() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testReviveSuperHeroe() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteSuperHeroe() {
//		fail("Not yet implemented");
//	}

}

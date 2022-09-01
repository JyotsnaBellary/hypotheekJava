package com.wipro.velocity.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.wipro.velocity.hypotheek.controller.AdminController;
import com.wipro.velocity.hypotheek.model.Admin;
import com.wipro.velocity.hypotheek.repository.AdminRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
class AdminControllerTest {

	@InjectMocks
	AdminController adminController;

	@Mock
	AdminRepository arepo;
	
	private Admin admin;
	
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testSaveAdmin() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Admin admin = new Admin("admin","admin@hypotheek.com","admin");

		when(arepo.save(any(Admin.class))).thenReturn(admin);
		
		String response = adminController.saveBook(admin);
        
		assertEquals("Added Successfully", response);
		
	}
	
	@Test
	public void testDeleteAdmin() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		String response1 = adminController.deleteAdmin("62cfef7bb5eb361d694595c7");
        
		
		assertEquals("Deleted Successfully", response1);
		
	}
	@Test
	public void testGetAdmin() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		List<Admin> res = adminController.getAdmin();
        
	}
	@Test
	public void testGetFindByIdAdmin() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		Optional<Admin> res1 = adminController.findAdmin(null);
	
	
	}
}
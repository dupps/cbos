package de.cbos.controller.admin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import de.cbos.controller.admin.AdminController;

public class AdminControllerTest {
	
	private AdminController admincontroller;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assert(admincontroller.adminPage() instanceof ModelAndView);
	}

}

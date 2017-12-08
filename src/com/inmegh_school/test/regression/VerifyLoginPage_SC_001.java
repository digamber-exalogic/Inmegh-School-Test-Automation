package com.inmegh_school.test.regression;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.inmegh_school.ui.LoginPage;
import com.inmegh_school.utils.project_spec.CreateBrowserDriver;

public class VerifyLoginPage_SC_001 {

	WebDriver driver;
	LoginPage login;
	
	@BeforeTest
	public void getDriver() throws RuntimeException{
		
		driver = CreateBrowserDriver.createDriver("Firefox", 
				"http://inmegh-local.herokuapp.com/users/sign_in");
	
	}
	

	@Test
	public void testValidLogin_TC_001() 
	{
		
				login = PageFactory.initElements(driver, LoginPage.class);
				login.login_inmegh("admin@demo.in", "12345678");
					
	}
	
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
	}

	
}

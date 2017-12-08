package com.inmegh_school.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	@FindBy(how=How.ID, using = "user_login")
	@CacheLookup
	public WebElement username;
	
	@FindBy(how=How.ID, using = "user_password")
	@CacheLookup
	public WebElement password;
	
	@FindBy(how=How.ID, using = "login")
	@CacheLookup
	public WebElement login_btn;
	
	@FindBy(how=How.XPATH, using = "//a[text()='Admission Form']")
	@CacheLookup
	public WebElement addm_btn;
	
	@FindBy(how=How.XPATH, using = "//img[@title='inMegh Logo' AND @alt='inmegh']")
	@CacheLookup
	public WebElement inmegh_img;
	
	@FindBy(how=How.XPATH, using = "//button[@type='button']")
	@CacheLookup
	public WebElement invalidCloseFlashMsg_btn;
	
	public void login_inmegh(String uid, String pid)
	{
				
				try {
					
					username.sendKeys(uid);
					password.sendKeys(pid);
				    login_btn.click();
				} catch (Exception e) {
			
					System.out.println("Error------------"+e.getCause());

				}
				
				
	}
	
}

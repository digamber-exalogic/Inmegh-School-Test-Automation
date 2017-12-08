/**This java program will create all the different browser drivers like: Chrome,
 * Firefox, Internet Explorer etc.
 * 
 */
package com.inmegh_school.utils.project_spec;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author digamber
 *
 */
public class CreateBrowserDriver {

	public static WebDriver createDriver(String browserName, String url) throws RuntimeException{
		
		WebDriver driver = null;
		
		if(browserName.equalsIgnoreCase("Firefox"))
		{
			try {
				System.setProperty("webdriver.gecko.driver", "/home/exalogic/Documents/selenium_videos/geckodriver");
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			} catch (Exception e) {
				System.out.println("DriverNotFound Exception Handled");
				e.getMessage();
			}
		}
		else if(browserName.equalsIgnoreCase("Chrome"))
		{
			try {
				System.setProperty("webdriver.chrome.driver", 
						"/home/exalogic/Documents/selenium_videos/chromedriver");
				driver = new ChromeDriver();
			} catch (Exception e) {
				System.out.println("DriverNotFound Exception Handled");
				e.getMessage();
			}
		}
		else
		{
			System.out.println("Invalid Browser Name");
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
			
		if(url == "http://inmegh-local.herokuapp.com/users/sign_in")
		{
			driver.get(url);
		}
		else
			System.out.println("Entered Wrong URL");
		
			
		return driver;
	}
	
}

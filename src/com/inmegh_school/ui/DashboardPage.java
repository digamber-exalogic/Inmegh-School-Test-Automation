package com.inmegh_school.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public DashboardPage(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH, using = "//a[@class='dropdown-toggle fw600 p15' and @href='#']")
	@CacheLookup
	public WebElement adminDropDown;
	
	@FindBy(how=How.XPATH, using = "//a[@class='dropdown-toggle' and @href='#']")
	@CacheLookup
	public WebElement notification_btn;
	
	@FindBy(how=How.XPATH, using = "//a[contains(@class,'topbar-menu-toggle') and contains(@href,'#')]")
	@CacheLookup
	public WebElement magicWand_btn;
	
	@FindBy(how=How.ID, using = "toggle_sidemenu_l")
	@CacheLookup
	public WebElement sideToggle_btn;
	
	@FindBy(how=How.XPATH, using = ".//*[@id='toggle_sidemenu_r']/a/i")
	@CacheLookup
	public WebElement rightToggle_btn;
	
	@FindBy(how=How.XPATH, using = ".//*[@id='skin-toolbox']/div/div[1]/span[1]")
	@CacheLookup
	public WebElement setting_btn;
	
	@FindBy(how=How.ID, using = "select2-month-container")
	@CacheLookup
	public WebElement attendanceStatusDropdown_btn;
	
	@FindBy(how=How.ID, using = "select2-finance_month-container")
	@CacheLookup
	public WebElement financeStatusDropdown_btn;
	
	@FindBy(how=How.ID, using = "1")
	@CacheLookup
	public WebElement libraryStatistics_link;
	
	@FindBy(how=How.XPATH, using = "//a[@href='/users/sign_out']")
	@CacheLookup
	public WebElement signOut;
	
	public void adminDropDownClick() {
		wait = new WebDriverWait(driver, 20000);
		adminDropDown = wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.xpath("//a[@class='dropdown-toggle fw600 p15' and @href='#']")));
		adminDropDown.click();
	}
	
	public void notificationClick() {
		wait = new WebDriverWait(driver, 20000);
		notification_btn = wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.xpath("//a[@class='dropdown-toggle' and @href='#']")));
		notification_btn.click();
	}
	
	public void sideToggleClick() {
		wait = new WebDriverWait(driver, 20000);
		sideToggle_btn = wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.id("toggle_sidemenu_l")));
		sideToggle_btn.click();
	}
	
	public void magicWandClick() {
		wait = new WebDriverWait(driver, 20000);
		magicWand_btn = wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.xpath("//a[contains(@class, 'topbar-menu-toggle') and contains(@href, '#')]")));
		magicWand_btn.click();
	}
	
	public void rightToggleClick() {
		wait = new WebDriverWait(driver, 20000);
		rightToggle_btn = wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.xpath(".//*[@id='toggle_sidemenu_r']/a/i")));
		rightToggle_btn.click();
	}
	
	public void settingClick() {
		wait = new WebDriverWait(driver, 200000);
		rightToggle_btn = wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.xpath(".//*[@id='skin-toolbox']/div/div[1]/span[1]")));
		setting_btn.click();
	}
	
	public void attendanceStatusClick() {
		wait = new WebDriverWait(driver, 20000);
		attendanceStatusDropdown_btn = wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.id("select2-month-container")));
		attendanceStatusDropdown_btn.click();
	}
	
	public void financeStatusClick() {
		wait = new WebDriverWait(driver, 20000);
		financeStatusDropdown_btn = wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.id("select2-finance_month-container")));
		financeStatusDropdown_btn.click();
	}
	
	public void signOutClick() {
		wait = new WebDriverWait(driver, 2000);
		signOut = wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.xpath("//a[@href='/users/sign_out']")));
		signOut.click();
	}
	
}

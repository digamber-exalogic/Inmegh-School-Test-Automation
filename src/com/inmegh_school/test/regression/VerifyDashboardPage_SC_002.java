package com.inmegh_school.test.regression;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inmegh_school.ui.DashboardPage;
import com.inmegh_school.ui.LoginPage;
import com.inmegh_school.utils.generic.CommonUtils;


public class VerifyDashboardPage_SC_002 extends CommonUtils{

	LoginPage login;
	DashboardPage dashPage;
	public static ExtentReports reports;
	public static ExtentTest testInfo;
	public static ExtentHtmlReporter htmlReporter;
	public static DateFormat df = new SimpleDateFormat("");
	public static Date dateObj = new Date();

	
	public VerifyDashboardPage_SC_002() {
		dashPage = new DashboardPage(_driver);
	}
	
	public static String screenShotFilePath = "/home/exalogic/Documents/Eclipse/workspace/Inmegh-school/Screen_shots" + df.format(dateObj) + ".png";
	
	@BeforeSuite
	public void beforeSuite() {
//		extentReportSetup();
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/AutomationReports.html"));
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
		reports = new ExtentReports();
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("Test Author", "Digamber Singh");
		reports.setSystemInfo("Operating System", "Ubuntu-16.04");
		htmlReporter.config().setDocumentTitle("Inmegh-School Test Report");
		htmlReporter.config().setReportName("Dashboard Page Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		reports.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	public void getDriver() {
		login("admin@demo.in","adminmegh");
	}
	
	@BeforeMethod
	public void register(Method method) {
		String testName = method.getName();
		testInfo = reports.createTest(testName);
	}
	
	@AfterMethod
	public void captureStatus(ITestResult result) throws IOException {
//		captureStatusReport(result);
		if(result.getStatus() == ITestResult.SUCCESS) {
			testInfo.pass("TESTCASE PASSED");
			testInfo.log(Status.PASS, "The method name as : "+result.getName()+" is passed");
		} else if(result.getStatus() == ITestResult.FAILURE) {
//			EventFiringWebDriver  eDriver = new EventFiringWebDriver(_driver);
			File src = ((TakesScreenshot)_driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(src, new File(screenShotFilePath));
			testInfo.fail("TESTCASE FAILED").addScreenCaptureFromPath(screenShotFilePath);
			testInfo.log(Status.FAIL, "The method name as : "+result.getName()+" is failed");
			testInfo.log(Status.FAIL, "Test failure : "+result.getThrowable());
		} else if(result.getStatus() == ITestResult.SKIP) {
			testInfo.skip("TESTCASE SKIPPED");
			testInfo.log(Status.SKIP, "The method name as : "+result.getName()+" is skipped");
			
		}
	}
	
	@Test(priority=2)
	public void adminDropdownVerify_TC_002() {
//		Assert.assertTrue(true);
		testInfo.log(Status.INFO, "Checking Admin profile drop-down click functionality");
		dashPage.adminDropDownClick();
	}
	
	@Test(priority=3)
	public void notificationVerify_TC_003() {
//		Assert.assertTrue(false);
		testInfo.log(Status.INFO, "Checking Notification button click functionality");
		dashPage.notificationClick();
	}
	
	@Test(priority=8)
	public void sideToggleVerify_TC_008() {
//		Assert.assertTrue(false);
		testInfo.log(Status.INFO, "Checking Side Toggle button click functionality");
		dashPage.sideToggleClick();
	}
	
	@Test(priority=1)
	public void magicWandVerify_TC_001() {
		testInfo.log(Status.INFO, "Checking Magic-Wand button click functionality");
		testInfo.log(Status.INFO, "Expected Result : All the Tiles should appear when Magic-Wand button is clicked");
		dashPage.magicWandClick();
		dashPage.notificationClick();
	}
	
	@Test(priority=4)
	public void rightToggleVerify_TC_004() {
		testInfo.log(Status.INFO, "Checking Right-Toggle button click functionality");
		dashPage.rightToggleClick();
	}
	
	@Test(priority=5)
	public void settingVerify_TC_005() {
		testInfo.log(Status.INFO, "Checking Setting button click functionality");
		dashPage.settingClick();
	}
	
	@Test(priority=6)
	public void attendanceStatusVerify_TC_006() {
		testInfo.log(Status.INFO, "Checking Attendance-Status button click functionality");
		dashPage.attendanceStatusClick();
	}
	
	@Test(priority=7)
	public void financeStatusVerify_TC_007() {
		testInfo.log(Status.INFO, "Checking Finance-Status button click functionality");
		dashPage.financeStatusClick();
	}
	
	@Test(priority=9)
	public void signOutVerify_TC_009() {
		Assert.assertTrue(false);
		testInfo.log(Status.INFO, "Checking Sign-Out button click functionality");
		dashPage.adminDropDownClick();
		dashPage.signOutClick();
	}
	
	@AfterTest
	public void tearDown() {
		_driver.quit();
	}
	
	@AfterSuite
	public void afterSuite() {
		reports.flush();
	}
	
	
}

package com.hrm.employee;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManagernopcommerce;
import enviromentConfig.Enviroment;
import pageObject.hrm.AddEmployeePO;
import pageObject.hrm.DasrBoardPageObject;
import pageObject.hrm.EmployeeListPO;
import pageObject.hrm.LoginPageObject;
import pageObject.hrm.PageGenerator;
import pageObject.hrm.MyInfoPO;
import pageObject.nopCommerce.admin.AdminDashBoardPageObject;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountPageObject;
import pageObjects.nopCommerce.user.UserOdersPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardpointsPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_21_Multiple_Enviroment1 extends BaseTest {
	Enviroment enviroment;

	private WebDriver driver;
	

	@Parameters({"browser", "envName", "severName", "osName", "ipAddress", "portNumber", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("firefox")String browserName, String osName,@Optional("dev") String severName, @Optional("localhost")String ipAddress,@Optional("4444") String portNumber, String envName, String osVersion) {

		log.info("pre-condition - Step 01: open browser  " + browserName);
		driver = getBrowserDriver(browserName, enviroment.applicationUrl(), envName, ipAddress, portNumber, osName, osVersion);
		
		System.out.println(enviroment.osName());
		System.out.println(driver.getCurrentUrl());
			}

	@Test
	public void Employee_01_Add_New_Eployee() {}

	@Test
	public void Employee_02_Upload_Avatar() {}

	
	public void Employee_03_Edit_Personal_Detail() {}

	public void Employee_04_Contact_Personal_Detail() {}

	
	public void Employee_05_Emergency_Personal_Detail() {

	}

	
	

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("post-conditon : close browser");
		driver.quit();
		cleanDriverInstance();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}

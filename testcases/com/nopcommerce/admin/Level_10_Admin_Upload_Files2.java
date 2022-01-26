package com.nopcommerce.admin;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManagernopcommerce;
import pageObject.jQuery.uploadfile.HomePageObject;
import pageObject.jQuery.uploadfile.PageGeneratorManagerjQuery;
import pageObject.nopCommerce.admin.AdminDashBoardPageObject;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObject.nopCommerce.admin.AdminProductDetailsPageObject;
import pageObject.nopCommerce.admin.AdminProductSearchPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountPageObject;
import pageObjects.nopCommerce.user.UserOdersPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardpointsPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_10_Admin_Upload_Files2 extends BaseTest {
	String rubyFileName = "ruby.jpg";
	String pythonFileName = "python.jpg";
	String seleniumFileName = "selenium.jpg";

	
	String[] multipleFileName = {seleniumFileName, pythonFileName, rubyFileName};

	private WebDriver driver;
	private HomePageObject homePage;
	
	private String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManagerjQuery.getHomePage(driver);

		
	}

	

	@Test
	public void Admin_01_One_Files() {
		homePage.uploadMultipleFiles(driver, seleniumFileName);
		
		Assert.assertTrue(homePage.isFileLinkLoadedByName(seleniumFileName));
		//homePage.clickToStartButton();
		
		homePage.clickToStartButton2();
		
		Assert.assertTrue(homePage.isFileLoadedSuccess(seleniumFileName));

		
	}
	
	
	@Test
    public void Admin_02_Multiple_Files() {
		homePage.uploadMultipleFiles(driver, multipleFileName);

		Assert.assertTrue(homePage.isFileLinkLoadedByName(multipleFileName));
		//homePage.clickToStartButton();
		homePage.clickToStartButton2();

		Assert.assertTrue(homePage.isFileLoadedSuccess(multipleFileName));

	
	}
		
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

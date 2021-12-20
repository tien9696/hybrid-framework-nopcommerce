package com.facebook.register;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManagernopcommerce;
import pageObject.nopCommerce.admin.AdminDashBoardPageObject;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObject.nopCommerce.admin.AdminProductDetailsPageObject;
import pageObject.nopCommerce.admin.AdminProductSearchPageObject;
import pageObjectFacebook.PageGeneratorManager;
import pageObjectFacebook.RegisterPageObject;
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

public class Level_11_Register_Login_Element_Undisplayed extends BaseTest {

	private WebDriver driver;
	RegisterPageObject registerPage;
	private String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
	}

	@Test
	public void Register_01_Element_Displayed() {
		Assert.assertTrue(registerPage.isEmailTextboxDisplayed());
		registerPage.enterToEmailTextbox("cam@gmail.com");
		Assert.assertTrue(registerPage.isConfirmEmailTextboxDisplayed());
		
	}

	@Test
	public void Register_02_Element_Undisplayed_In_DOM() {
		registerPage.enterToEmailTextbox("");
		registerPage.sleepInsecond(3);
		Assert.assertFalse(registerPage.isConfirmEmailTextboxDisplayed());
		
		Assert.assertTrue(registerPage.isConfirmEmailTextboxUnDisplayed());

	}

	@Test
	public void Register_03_Element_Undispayed_Not_In_DOM() {
		Assert.assertFalse(registerPage.isButtonLoginDisplayed());

	}

	@Test
	public void Register_04_Element_Undispayed_Not_In_DOM() {
		Assert.assertTrue(registerPage.isButtonLoginUnDisplayed());

	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

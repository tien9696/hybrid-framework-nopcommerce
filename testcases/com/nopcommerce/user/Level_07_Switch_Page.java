package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountPageObject;
import pageObjects.nopCommerce.user.UserOdersPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardpointsPage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_07_Switch_Page extends BaseTest {
	private String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new UserHomePageObject(driver);

		firstName = "Automation";
		lastName = "Fc";
		validPassword = "123456";
		existingEmail = "afc" + generateFakeNumber() + "@gmail.com";

	}

	@Test
	public void User_01_Register() {
		
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLasttnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.clickToLoginLink();
		//loginPage.clickToLoginButton();
		
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);

		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		
		
		
		
	}

	@Test
	public void User_03_My_Account() {
		myAccountPage = homePage.clickToMyAccountLink();

		

	}

	@Test
	public void User_04_Switch_Page() {

		addressPage = myAccountPage.openAddressPage(driver);
		
		odersPage = addressPage.openOdersPage(driver);
		addressPage = odersPage.openAddressPage(driver);
		
		rewardpointsPage = addressPage.openRewardpointsPage(driver);
		odersPage = rewardpointsPage.openOdersPage(driver);
		rewardpointsPage = odersPage.openRewardpointsPage(driver);
	}

	
	@Test
	public void User_05_Switch_Role() {

		//Role user => Role admin
		//Role admin => Role user
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private UserMyAccountPageObject myAccountPage;
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validPassword, incorrectPassword;
	// declare + init;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
private UserAddressPageObject addressPage;
	private UserLoginPageObject loginPage;
	private UserOdersPageObject odersPage;
	private UserRewardpointsPage rewardpointsPage;


	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}

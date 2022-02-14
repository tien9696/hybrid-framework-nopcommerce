package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class Level_17_Denpendence_Test {
	// BasePage: Class
	// basePage: Object

	// declare
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	// declare + init;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private String projectPath = System.getProperty("user.dir");

	

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

		// basePage = new BasePage();

		// che dấu việc khởi tạo của 1 đối tương
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://demo.nopcommerce.com/");
		// mở Url lên nó qua trang HomePage
		homePage = new UserHomePageObject(driver);
		firstName = "Automation";
		lastName = "Fc";
		password = "123456";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
	
		homePage.clickToRegisterLink();
		// click register link > nhảy qua trang register
		registerPage = new UserRegisterPageObject(driver);

	}
	
	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01 - Steps: 01 click to register link");
		
		System.out.println("Register_01 - Steps: 02 click to register link");
		registerPage.clickToRegisterButton();

		System.out.println("Register_01 - Steps: 03 Verify error message displayed");

		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLasttnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		System.out.println("Register_02- Steps: 01 click to register link");
		homePage.clickToRegisterLink();
		// click register link > nhảy qua trang register
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_02 - Steps: 02 Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLasttnameTextbox(lastName);
		registerPage.inputToEmailTextbox("12.17.net");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_02 - Steps: 03 click to register link");
		registerPage.clickToRegisterButton();

		System.out.println("Register_02 - Steps: 04 Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Register_03_Success() {
		System.out.println("Register_03 - Steps: 01 click to register link");
		homePage.clickToRegisterLink();
		// click register link > nhảy qua trang register
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_03 - Steps: 02 Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLasttnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_03 - Steps: 03 click to register link");
		registerPage.clickToRegisterButton();

		System.out.println("Register_03 - Steps: 04 Verify success message diplayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Register_03 - Steps: 05 click logout link");
		registerPage.clickToLogoutLink();

	}

	@Test
	public void Register_04_Existing_Email() {
		System.out.println("Register_04 - Steps: 01 click to register link");
		homePage.clickToRegisterLink();
		// click register link > nhảy qua trang register
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_04 - Steps: 02 Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLasttnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_04 - Steps: 03 click to register link");
		registerPage.clickToRegisterButton();

		System.out.println("Register_04 - Steps: 04 Verify error existing email message displayed");

		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
		System.out.println("Register_05 - Steps: 01 click to register link");
		homePage.clickToRegisterLink();
		// click register link > nhảy qua trang register
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_05 - Steps: 02 Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLasttnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("13");
		registerPage.inputToConfirmPasswordTextbox("13");

		System.out.println("Register_05 - Steps: 03 click to register link");
		registerPage.clickToRegisterButton();

		System.out.println("Register_05 - Steps: 04 Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
		System.out.println("Register_06 - Steps: 01 click to register link");
		homePage.clickToRegisterLink();
		// click register link > nhảy qua trang register
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_06 - Steps: 02 Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLasttnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(emailAddress);

		System.out.println("Register_06 - Steps: 03 click to register link");
		registerPage.clickToRegisterButton();

		System.out.println("Register_06 - Steps: 04 Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}

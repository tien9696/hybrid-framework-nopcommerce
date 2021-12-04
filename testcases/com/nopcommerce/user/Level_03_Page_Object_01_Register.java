package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Page_Object_01_Register {
	// BasePage: Class
	// basePage: Object

	// declare
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	// declare + init;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();

		// basePage = new BasePage();

		// che dấu việc khởi tạo của 1 đối tương
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://demo.nopcommerce.com/");
		// mở Url lên nó qua trang HomePage
		homePage = new HomePageObject(driver);
		firstName = "Automation";
		lastName = "Fc";
		password = "123456";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
	}

	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01 - Steps: 01 click to register link");
		homePage.clickToRegisterLink();
		// click register link > nhảy qua trang register
		registerPage = new RegisterPageObject(driver);

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
		registerPage = new RegisterPageObject(driver);

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
		registerPage = new RegisterPageObject(driver);

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
		registerPage = new RegisterPageObject(driver);

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
		registerPage = new RegisterPageObject(driver);

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
		registerPage = new RegisterPageObject(driver);

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

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}

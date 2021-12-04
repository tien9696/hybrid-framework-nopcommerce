package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Page_Object_02_Login {
	// BasePage: Class
	// basePage: Object

	// declare
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validPassword, incorrectPassword;
	// declare + init;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	private LoginPageObject loginPage;
	private String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();

		// basePage = new BasePage();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);

		firstName = "Automation";
		lastName = "Fc";
		invalidEmail = "afc.@.co.emil";
		// biến cho email chưa đăng kí
		incorrectPassword = "7894";
		notFoundEmail = "afc" + generateFakeNumber() + "@gmail.vn";

		validPassword = "123456";
		// biến cho email đăng kí thành công
		existingEmail = "afc" + generateFakeNumber() + "@gmail.com";

		System.out.println("Pre-condition - Steps: 01 click to register link");
		homePage.clickToRegisterLink();
		// click register link > nhảy qua trang register
		registerPage = new RegisterPageObject(driver);

		System.out.println("Pre-condition - Steps: 02 Input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLasttnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		System.out.println("Pre-condition - Steps: 03 click to register link");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-condition - Steps: 04 Verify success message diplayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Pre-condition - Steps: 05 click logout link");
		registerPage.clickToLogoutLink();

		// click logout thì business sẽ quay về trang home
		homePage = new HomePageObject(driver);

	}

	@Test
	public void Login_01_Empty_Data() {

		homePage.clickToLoginLink();
		// từ trang home > click LoginLink > qua trang login
		loginPage = new LoginPageObject(driver);
		loginPage.clickToLoginButton();

		// nên cho vao Assert trước khi create để code tạo sẵn String
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong emaill");

	}

	@Test
	public void Login_03_Email_Not_Found() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(notFoundEmail);

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_04_Existing_Email_Empty_Paswsword() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Existing_Email_Invalid_Password() {

		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_Success_Valid_Email_And_Pasword() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);

		loginPage.clickToLoginButton();
		// login thành công sẽ qua trang homePage;
		homePage = new HomePageObject(driver);

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
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

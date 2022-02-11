package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManagernopcommerce;
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
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_15_Register_Login_Pattern_Object extends BaseTest {
	private String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		log.info("pre-condition - Step 01: open browser  " + browserName);
		driver = getBrowserDriver(browserName);

		log.info("pre-condition - Step 02: Verify Home page is displayed");
		userHomePage = PageGeneratorManagernopcommerce.getUserHomePageObject(driver);

		firstName = "Automation";
		lastName = "Fc";
		validPassword = "123456";
		existingEmail = "afc" + generateFakeNumber() + "@gmail.com";

		emailAdmin = "admin@yourstore.com";
		passwordAdmin = "admin";
		date = "23";
		month = "October";
		year = "2000";

		// Assert.assertTrue(false);
	}

	@Test
	public void User_01_Register() {

		log.info("User_01_Register - Step 03: click to Register link ");
		userHomePage.openHeaderPageByName(driver, "Register");
		userRegisterPage = PageGeneratorManagernopcommerce.getUserRegisterPage(driver);
		// pattern object
		//có thể đổi thành by text để phù hợp với các page khác
		userRegisterPage.clickToRadioButtonByID(driver, "gender-female");

		userRegisterPage.enterToTextboxByID(driver, "FirstName", firstName);
		userRegisterPage.enterToTextboxByID(driver, "LastName", lastName);
		userRegisterPage.enterToTextboxByID(driver, "Email", existingEmail);
		userRegisterPage.enterToTextboxByID(driver, "Password", validPassword);
		userRegisterPage.enterToTextboxByID(driver, "ConfirmPassword", validPassword);

		userRegisterPage.selectDropdownByName(driver, "DateOfBirthDay", date);
		userRegisterPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
		userRegisterPage.selectDropdownByName(driver, "DateOfBirthYear", year);

		log.info("User_01_Register - Step 09: click to Register button ");
		userRegisterPage.clickToButtonByText(driver, "Register");
		userHomePage = PageGeneratorManagernopcommerce.getUserHomePageObject(driver);

		log.info("User_01_Register - Step 10: Verify Success Message ");
		verifyEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("User_01_Register - Step 11: click to Logout Link ");
		userHomePage.openHeaderPageByName(driver, "Log out");
		userHomePage = PageGeneratorManagernopcommerce.getUserHomePageObject(driver);

	}

	@Test
	public void User_02_Login_User() {
		log.info("User_02_Login_User - Step 12: click to Login link ");
		userHomePage.openHeaderPageByName(driver, "Log in");
		userLoginPage = PageGeneratorManagernopcommerce.getUserLoginPage(driver);

		// login as user role
		userLoginPage.enterToTextboxByID(driver, "Email", existingEmail);
		userLoginPage.enterToTextboxByID(driver, "Password", validPassword);
		userLoginPage.clickToButtonByText(driver, "Log in");
		userHomePage = PageGeneratorManagernopcommerce.getUserHomePageObject(driver);

//		log.info("User_02_Login_User - Step 13: Verify Login page is displayed " + existingEmail +validPassword );
//       userHomePage = userLoginPage.LoginAsUser(existingEmail, validPassword);
//       
//		log.info("User_02_Login_User - Step 14: Verify My account link is displayed " );
		verifyTrue(userHomePage.isMyAccountLinkDisplayed());

		userHomePage.openHeaderPageByName(driver, "Log out");
		userHomePage = PageGeneratorManagernopcommerce.getUserHomePageObject(driver);

	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("post-conditon : close browser");
		driver.quit();
		cleanDriverInstance();
	}

	private UserMyAccountPageObject myAccountPage;
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, emailAdmin, passwordAdmin, existingEmail,
			validPassword, incorrectPassword, date, month, year;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserAddressPageObject userAddressPage;
	private UserLoginPageObject userLoginPage;
	private UserOdersPageObject userOdersPage;
	private UserRewardpointsPage userRewardpointsPage;

	private AdminLoginPageObject adminLoginPage;
	private AdminDashBoardPageObject myDashBoardPage;

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}

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

public class Level_08_Switch_Role extends BaseTest {
	private String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManagernopcommerce.getUserHomePageObject(driver);

		firstName = "Automation";
		lastName = "Fc";
		validPassword = "123456";
		existingEmail = "afc" + generateFakeNumber() + "@gmail.com";

		emailAdmin = "admin@yourstore.com";
		passwordAdmin = "admin";
	}

	@Test
	public void User_01_Register() {

		userRegisterPage = userHomePage.clickToRegisterLink();
		userRegisterPage.inputToFirstnameTextbox(firstName);
		userRegisterPage.inputToLasttnameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(existingEmail);
		userRegisterPage.inputToPasswordTextbox(validPassword);
		userRegisterPage.inputToConfirmPasswordTextbox(validPassword);

		userRegisterPage.clickToRegisterButton();

		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

		userHomePage = userRegisterPage.clickToLogoutLink();

	}

	@Test
	public void User_02_Login_User() {
		userLoginPage = userHomePage.clickToLoginLink();

		// login as user role
		userHomePage = userLoginPage.LoginAsUser(existingEmail, validPassword);

		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		userHomePage = userHomePage.clickToLogoutLinkAtUserPage(driver);
		
	}
	@Test
	public void User_03_Login_Admin() {
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManagernopcommerce.getAdminLoginPageObject(driver);

		//login at Admin role
		myDashBoardPage = adminLoginPage.LoginAsAdmin(emailAdmin, passwordAdmin);

		Assert.assertTrue(myDashBoardPage.isDashBoardHeaderDisplayed());
		
		adminLoginPage = myDashBoardPage.clickToLogoutLinkAtAdminPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private UserMyAccountPageObject myAccountPage;
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, emailAdmin, passwordAdmin, existingEmail, validPassword, incorrectPassword;
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

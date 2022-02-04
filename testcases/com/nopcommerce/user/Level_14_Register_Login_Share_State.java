package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.commons.Common_01_Login;

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

public class Level_14_Register_Login_Share_State extends BaseTest {
	private String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		
		log.info("pre-condition - Step 01: open browser  " + browserName  );
		driver = getBrowserDriver(browserName);
		
		log.info("pre-condition - Step 02: Verify Home page is displayed" );
        userHomePage = PageGeneratorManagernopcommerce.getUserHomePageObject(driver);

		firstName = "Automation";
		lastName = "Fc";
		validPassword = "123456";
		existingEmail = "afc" + generateFakeNumber() + "@gmail.com";

		emailAdmin = "admin@yourstore.com";
		passwordAdmin = "admin";
		//Assert.assertTrue(false);
	}


	@Test
	public void User_01_Login_User() {
		log.info("User_02_Login_User - Step 12: click to Login link " );
        userLoginPage = userHomePage.clickToLoginLink();

		log.info("User_02_Login_User - Step 12: Set login page cookie " );
		userLoginPage.setAllCookies(driver, Common_01_Login.loginPageCookie);
		userLoginPage.sleepInsecond(5);
		userLoginPage.refreshCurrentPage(driver);

		log.info("User_02_Login_User - Step 12: click to homePage img " );
        userHomePage = userLoginPage.openHomePage();
		
		log.info("User_02_Login_User - Step 14: Verify My account link is displayed " );
		verifyTrue(userHomePage.isMyAccountLinkDisplayed());
        
		
	}

	@Test
	public void User_02_Create_New_Account() {
		
	}
	@Test
	public void User_03_Login_User() {
		
	}

	@Parameters({"browser"})
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("post-conditon : close browser");
		driver.quit();
		cleanDriverInstance();
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

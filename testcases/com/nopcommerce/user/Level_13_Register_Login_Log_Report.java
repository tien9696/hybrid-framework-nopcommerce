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

public class Level_13_Register_Login_Log_Report extends BaseTest {
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
	}

	@Test
	public void User_01_Register() {

		log.info("User_01_Register - Step 03: click to Register link " );
        userRegisterPage = userHomePage.clickToRegisterLink();
        
		log.info("User_01_Register - Step 04: enter to firstName texbox  "+firstName  );
        userRegisterPage.inputToFirstnameTextbox(firstName);
		
        log.info("User_01_Register - Step 05: enter to LastName texbox  "+lastName  );
        userRegisterPage.inputToLasttnameTextbox(lastName);
		
        log.info("User_01_Register - Step 06: enter to email texbox  "+existingEmail  );
        userRegisterPage.inputToEmailTextbox(existingEmail);
	
         log.info("User_01_Register - Step 07: enter to password texbox  "+validPassword  );
         userRegisterPage.inputToPasswordTextbox(validPassword);	
		
         log.info("User_01_Register - Step 08: enter to confirm password texbox  "+validPassword  );
         userRegisterPage.inputToConfirmPasswordTextbox(validPassword);
		
		log.info("User_01_Register - Step 09: click to Register button " );
        userRegisterPage.clickToRegisterButton();

		log.info("User_01_Register - Step 10: Verify Success Message " );
        verifyEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("User_01_Register - Step 11: click to Logout Link " );
        userHomePage = userRegisterPage.clickToLogoutLink();

	}

	@Test
	public void User_02_Login_User() {
		log.info("User_02_Login_User - Step 12: click to Login link " );
        userLoginPage = userHomePage.clickToLoginLink();

		// login as user role
		log.info("User_02_Login_User - Step 13: Verify Login page is displayed " + existingEmail +validPassword );
       userHomePage = userLoginPage.LoginAsUser(existingEmail, validPassword);
       
		log.info("User_02_Login_User - Step 14: Verify My account link is displayed " );
        verifyTrue(userHomePage.isMyAccountLinkDisplayed());
        
		log.info("User_02_Login_User - Step 15: click to Logout at userpage " );
       userHomePage = userHomePage.clickToLogoutLinkAtUserPage(driver);
		
	}
	

	@AfterClass
	public void afterClass() {
		log.info("post-conditon : close browser");
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

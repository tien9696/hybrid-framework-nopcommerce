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
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

@Listeners(commons.MethodListener.class)
public class Level_12_Register_Login_Assert_Verify extends BaseTest {

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
		// fail lần 1
		verifyFalse(registerPage.isEmailTextboxDisplayed());
		registerPage.enterToEmailTextbox("cam@gmail.com");
		verifyTrue(registerPage.isConfirmEmailTextboxDisplayed());

		registerPage.enterToEmailTextbox("");
		registerPage.sleepInsecond(3);

		// fail lần 2
		verifyTrue(registerPage.isConfirmEmailTextboxDisplayed());

		verifyTrue(registerPage.isConfirmEmailTextboxUnDisplayed());

		// fail lần 3
		verifyTrue(registerPage.isButtonLoginDisplayed());

		verifyTrue(registerPage.isButtonLoginUnDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

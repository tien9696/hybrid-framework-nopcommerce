package com.saucelab.sort;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManagernopcommerce;
import pageObject.Saucelab.InventoryPO;
import pageObject.Saucelab.LoginPO;
import pageObject.Saucelab.PageGenerator;
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

public class Level_18_Sort extends BaseTest {

	InventoryPO inventoryPage;
	
	LoginPO loginPage;
	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
           driver = getBrowserDriver(browserName);
           loginPage = PageGenerator.getLoginPage(driver);
           loginPage.loginToSystem("problem_user", "secret_sauce");
           inventoryPage =  loginPage.clickToLoginButton();
	}

	@Test
	public void Sort_01_Name() {
		inventoryPage.selectItemInSortDropdown("Name (A to Z)");
        inventoryPage.sleepInsecond(4);

		verifyTrue(inventoryPage.isProductNameSortAsceding());
		
		
		
		inventoryPage.selectItemInSortDropdown("Name (Z to A)");
        inventoryPage.sleepInsecond(4);

		verifyTrue(inventoryPage.isProductNameSortDescending());

		
		
	}

	@Test
	public void Sort_02_Price() {
         inventoryPage.selectItemInSortDropdown("Price (low to high)");
         inventoryPage.sleepInsecond(4);
 		verifyTrue(inventoryPage.isProductPriceSortAsceding());

		
		inventoryPage.selectItemInSortDropdown("Price (high to low)");
        inventoryPage.sleepInsecond(4);

 		verifyTrue(inventoryPage.isProductPriceSortDesceding());

	}

	@Parameters({"browser", "url"})
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("post-conditon : close browser");
		driver.quit();
		cleanDriverInstance();
	}

	private WebDriver driver;
	

}



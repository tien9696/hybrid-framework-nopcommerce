package com.jQuery;

import org.testng.annotations.Test;

import com.sun.tools.javac.comp.Enter;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManagernopcommerce;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.PageGeneratorManagerjQuery;
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

public class Level_10_DatabaseTable extends BaseTest {
	private String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");

		homePage = PageGeneratorManagerjQuery.getHomePage(driver);
	}

	// @Test
	public void Table_01_Paging() {

		homePage.openPageByNumber("15");
		Assert.assertTrue(homePage.isPageActiveByNumber("15"));

		homePage.openPageByNumber("20");
		Assert.assertTrue(homePage.isPageActiveByNumber("20"));

		homePage.openPageByNumber("10");
		Assert.assertTrue(homePage.isPageActiveByNumber("10"));

	}

	// @Test
	public void Table_02_Actions() {

		homePage.inputToSearchTextbox("Females", "56746000");
		homePage.sleepInsecond(3);
		homePage.refreshCurrentPage(driver);

		homePage.inputToSearchTextbox("Country", "World");
		homePage.sleepInsecond(3);
		homePage.refreshCurrentPage(driver);

		homePage.inputToSearchTextbox("Males", "60681000 ");
		homePage.sleepInsecond(3);
		homePage.refreshCurrentPage(driver);

	}

	// @Test
	public void Table_03_Click_To_Icon() {

		homePage.clickToIconByCountryName("Afghanistan", "remove");
		homePage.sleepInsecond(3);

		homePage.clickToIconByCountryName("Albania", "edit");
		homePage.sleepInsecond(3);
		homePage.refreshCurrentPage(driver);

		homePage.clickToIconByCountryName("AFRICA", "remove");
		homePage.sleepInsecond(3);
		homePage.refreshCurrentPage(driver);

		homePage.inputToSearchTextbox("Males", "60681000 ");

	}

	// @Test
	public void Table_04_() {
		// cách 1
		homePage.inputToTextboxByRowNumber("Contact Person", "3", "jonh Deep");
		homePage.sleepInsecond(3);

		homePage.inputToTextboxByRowNumber("Order Placed", "2", " Deep");
		homePage.sleepInsecond(3);

		homePage.inputToTextboxByRowNumber("Company", "1", "jonh");
		homePage.sleepInsecond(3);

		// cách 2
		homePage.inputToTextbox("name", "1", "hihi");
		homePage.sleepInsecond(3);

		homePage.inputToTextbox("company", "1", "hehe");
		homePage.sleepInsecond(3);

		homePage.inputToTextbox("orderPlaced", "2", "hoho");
		homePage.sleepInsecond(3);

		// homePage.inputToTextbox( "country", "2", "hoho");
		// homePage.sleepInsecond(3);
	}

	@Test
	public void Table_05_Click_To_Icon_At_Row() {

		homePage.clickToIconByRowName("2", "Move Up");
		homePage.sleepInsecond(3);

		homePage.clickToIconByRowName("3", "Remove Current Row");
		homePage.sleepInsecond(3);

		homePage.clickToIconByRowName("2", "Remove Current Row");
		homePage.sleepInsecond(3);

		homePage.clickToIconByRowName("1", "Remove Current Row");
		homePage.sleepInsecond(3);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private HomePageObject homePage;

}

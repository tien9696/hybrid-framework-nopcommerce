package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_02_Apply_BasePage_II {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	BasePage basePage;
	// BasePage: Class
	// basePage: Object

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDriver\\geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	
		//driver = new FirefoxDriver();

		//basePage = new BasePage();

		//che dấu việc khởi tạo của 1 đối tương
		basePage = BasePage.getBasePageObject();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
	}

	public void TC_01_Register_Empty_Data() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getWebElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(basePage.getWebElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");

		Assert.assertEquals(basePage.getWebElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(basePage.getWebElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(basePage.getWebElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");

	}

	public void TC_02_Register_Invalid_Email() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.sendToElement(driver, "//input[@id='LastName']", "Fc");
		basePage.sendToElement(driver, "//input[@id='Email']", "123@12;.net");
		basePage.sendToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		basePage.waitForElementVisible(driver, "//span[@id='Email-error']");
		Assert.assertEquals(basePage.getWebElementText(driver, "//span[@id='Email-error']"), "Wrong email");

	}

	@Test
	public void TC_03_Register_Success() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.sendToElement(driver, "//input[@id='LastName']", "Fc");
		basePage.sendToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getWebElementText(driver, "//div[@class='result']"), "Your registration completed");

		basePage.waitForElementClickable(driver, "//a[@class='ico-logout']");

		basePage.clickToElement(driver, "//a[@class='ico-logout']");
	}

	@Test
	public void TC_04_Register_Existing_Email() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.sendToElement(driver, "//input[@id='LastName']", "Fc");
		basePage.sendToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getWebElementText(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");
	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.sendToElement(driver, "//input[@id='LastName']", "Fc");
		basePage.sendToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendToElement(driver, "//input[@id='Password']", "123");
		basePage.sendToElement(driver, "//input[@id='ConfirmPassword']", "123");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getWebElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Email() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.sendToElement(driver, "//input[@id='LastName']", "Fc");
		basePage.sendToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendToElement(driver, "//input[@id='ConfirmPassword']", "123");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getWebElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
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

package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_02_Apply_BasePage_III extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	// BasePage: Class
	// basePage: Object

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();

		//basePage = new BasePage();

		//che dấu việc khởi tạo của 1 đối tương
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
	}

	public void TC_01_Register_Empty_Data() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getWebElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(getWebElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");

		Assert.assertEquals(getWebElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getWebElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getWebElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");

	}

	public void TC_02_Register_Invalid_Email() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendToElement(driver, "//input[@id='FirstName']", "Automation");
		sendToElement(driver, "//input[@id='LastName']", "Fc");
		sendToElement(driver, "//input[@id='Email']", "123@12;.net");
		sendToElement(driver, "//input[@id='Password']", "123456");
		sendToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		waitForElementVisible(driver, "//span[@id='Email-error']");
		Assert.assertEquals(getWebElementText(driver, "//span[@id='Email-error']"), "Wrong email");

	}

	@Test
	public void TC_03_Register_Success() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendToElement(driver, "//input[@id='FirstName']", "Automation");
		sendToElement(driver, "//input[@id='LastName']", "Fc");
		sendToElement(driver, "//input[@id='Email']", emailAddress);
		sendToElement(driver, "//input[@id='Password']", "123456");
		sendToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getWebElementText(driver, "//div[@class='result']"), "Your registration completed");

		waitForElementClickable(driver, "//a[@class='ico-logout']");

		clickToElement(driver, "//a[@class='ico-logout']");
	}

	@Test
	public void TC_04_Register_Existing_Email() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendToElement(driver, "//input[@id='FirstName']", "Automation");
		sendToElement(driver, "//input[@id='LastName']", "Fc");
		sendToElement(driver, "//input[@id='Email']", emailAddress);
		sendToElement(driver, "//input[@id='Password']", "123456");
		sendToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getWebElementText(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");
	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendToElement(driver, "//input[@id='FirstName']", "Automation");
		sendToElement(driver, "//input[@id='LastName']", "Fc");
		sendToElement(driver, "//input[@id='Email']", emailAddress);
		sendToElement(driver, "//input[@id='Password']", "123");
		sendToElement(driver, "//input[@id='ConfirmPassword']", "123");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getWebElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Email() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendToElement(driver, "//input[@id='FirstName']", "Automation");
		sendToElement(driver, "//input[@id='LastName']", "Fc");
		sendToElement(driver, "//input[@id='Email']", emailAddress);
		sendToElement(driver, "//input[@id='Password']", "123456");
		sendToElement(driver, "//input[@id='ConfirmPassword']", "123");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getWebElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
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

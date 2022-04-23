package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGenerator;
import commons.commonsPageObject;
import pageObjectFacebook.PageGeneratorManager;

public class Register_Bank extends BaseTest {

	private WebDriver driver;
	commonsPageObject bankPO;
	private String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		bankPO = PageGenerator.getHomePageObject(driver);
		
	}
	//a[text()='Manager']
	
	
	
}

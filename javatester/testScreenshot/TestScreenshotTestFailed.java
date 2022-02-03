package testScreenshot;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectFacebook.PageGeneratorManager;
import pageObjectFacebook.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


@Listeners(TestListener.class)
public class TestScreenshotTestFailed extends BaseTest {

	private WebDriver driver;
	RegisterPageObject registerPage;
	private String projectPath = System.getProperty("user.dir") + "//screenshotImg//";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		//driver.get("https://demo.nopcommerce.com/register");

		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		
	}

	

	@Test
	public void Register_01_Element_Displayed() {
		Assert.assertTrue(registerPage.isEmailTextboxDisplayed());
		registerPage.enterToEmailTextbox("cam@gmail.com");
		Assert.assertTrue(registerPage.isConfirmEmailTextboxDisplayed());
		
	}

	@Test
	public void Register_02_Element_Undisplayed_In_DOM() {
		registerPage.enterToEmailTextbox("hihi@gmail.com");
		registerPage.sleepInsecond(3);
		//fail
		Assert.assertTrue(registerPage.isConfirmEmailTextboxDisplayed());
		
		Assert.assertFalse(registerPage.isConfirmEmailTextboxUnDisplayed());

	}

	//@Test
	public void Register_03_Element_Undispayed_Not_In_DOM() {
		Assert.assertFalse(registerPage.isButtonLoginDisplayed());

	}

	//@Test
	public void Register_04_Element_Undispayed_Not_In_DOM() {
		Assert.assertTrue(registerPage.isButtonLoginUnDisplayed());

	}
	
	public WebDriver getWebDriver() {
		return this.driver;
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
}

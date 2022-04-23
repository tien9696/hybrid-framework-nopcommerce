package javaPractice;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManagernopcommerce;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.liveguru.DashBoardPageObjectLiveguru;
import pageObjects.liveguru.HomePageObjectLiveguru;
import pageObjects.liveguru.LoginPageObjectLiveguru;
import pageObjects.liveguru.PageGeneratorManagerLiveguru;
import pageObjects.liveguru.RegisterPageObjectLiveguru;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class switchCase  {
	// BasePage: Class
	// basePage: Object

	// declare
	private String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
			homePage = PageGeneratorManagerLiveguru.getHomePageObjectLiveguru(driver);

		firstName = "Automation";
		lastName = "Fc";
		existingEmail = "afc" + generateFakeNumber() + "@gmail.com";

		// biến cho email chưa đăng kí
		validPassword = "123456";

	}

	@Test
	public void User_01_Register_To_System() {

		homePage.clickToAccountLink();
		
		loginPage = homePage.clickToLoginLink();
		
		registerPage = loginPage.clickToCreateAnAccount();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailAddressTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToPasswordConfirmTextbox(validPassword);

		homePage = registerPage.clickToRegisterButton();
	}

	@Test
	public void User_02_Login_To_System() {
		homePage.clickToAccountLink();
		homePage.clickToLogoutLink();

		homePage.clickToAccountLink();
		
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailAddressTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);
       mydashBoardPage =  loginPage.clickToLoginButtton();
	}

	private WebDriver driver;
	private String firstName, lastName, existingEmail, validPassword ;
	private HomePageObjectLiveguru homePage;
	private RegisterPageObjectLiveguru registerPage;
	private DashBoardPageObjectLiveguru mydashBoardPage;
	private LoginPageObjectLiveguru loginPage;

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}

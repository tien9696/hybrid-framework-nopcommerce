package testng;

import org.testng.annotations.Test;

import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Close_Browser extends BaseTest {
	WebDriver driver;
	
	@BeforeClass //pre-condition
	  public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		//init browser/ driver
		//init page class
		//init data test
		//create flow for bellow tc
		
	  }

	
  @Test
  public void TC_01() {
	  
	  
  }
  
  @Test
  public void TC_02() {
	  
	  
  }
  
 

  @AfterClass(alwaysRun = true)
  public void afterClass() {
	  driver.quit();
	  cleanDriverInstance();
  }

}

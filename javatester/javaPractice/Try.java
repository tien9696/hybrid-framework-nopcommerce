package javaPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Try {
	WebDriver driver;

	
	public Try() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
	}
	@Test
	public void TC_01() {
		
	
	driver.get("https://cati.edu.vn/user/bookings");
	driver.quit();
	}
}

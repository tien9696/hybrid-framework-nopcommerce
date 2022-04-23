package javaBasic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class For_Get_Link {
	WebDriver driver; // interface
	String projectPath = System.getProperty("user.dir");
	WebDriverWait expliciWait; // class
	JavascriptExecutor jsExecutor; // interface

	@BeforeClass
	public void beforeClass() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

		expliciWait = new WebDriverWait(driver, 15);

		jsExecutor = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void forGetLink() {
		driver.get("https://www.facebook.com/");

		List<WebElement> Links = driver.findElements(By.xpath("//li//a"));
		for (WebElement webElement : Links) {
			if (webElement.getText().equals("Services")) {
				webElement.click();
			}
			System.out.println(webElement);
		}

		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Facebook's service directory']")).isDisplayed());
		
		
	}

	@AfterClass
	public void afterclass() {
		driver.quit();
	}
}

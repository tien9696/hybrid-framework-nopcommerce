package javaBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;






public class Topic_06_If_else_if_else {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	
	

	@Parameters("browser")
	@Test
	public void TC_01_If_Else_If_Else(String browserName){
		if(browserName.equalsIgnoreCase("Chrome")) {
		
			System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\BrowserDriver\\msedgedriver.exe");
			driver = new EdgeDriver();
			 
		}else {
			throw new RuntimeException ("Please input correct the browser name");
		}
	System.out.println(browserName);
	System.out.println(driver.toString());
	
	driver.quit();
	}
	
	@Test
	public void TC_02_If_Else_If_Else(){
		String pageName = "Login";
		if(pageName.equals("login")) {
			
		}else if (pageName.equals("Register")) {
						
		}else if(pageName.equals("New Customer")) {
			
		}else {
			//return homepage
		}
		

	
	int age = 17;
	String access = (age < 18) ? "you can not access" :"welcome to our system" ;
	 
	if (age <18) {
		access = "you can not access";
	}else {
		access = "welcome to our system";
	}
	System.out.println(access);
}
}

	
	
	


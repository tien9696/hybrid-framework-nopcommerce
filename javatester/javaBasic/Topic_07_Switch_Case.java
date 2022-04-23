package javaBasic;

import java.util.Scanner;
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






public class Topic_07_Switch_Case {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);

	
	

	//@Parameters("browser")
	//@Test
	public void TC_01_If_Else_If_Else(String browserName){
		driver = getBrowserDriver (browserName);
		
	switch (browserName) {
	case "chrome":
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		break;
	case "firefox":
		System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		break;
	case "edge":
		System.setProperty("webdriver.edge.driver", projectPath + "\\BrowserDriver\\msedgedriver.exe");
		driver = new EdgeDriver();
		
		break;
	default:
		 new RuntimeException ("Please input correct the browser name");

		break;
	}	
	
	System.out.println(browserName);
	System.out.println(driver.toString());
	
	driver.quit();
	}
	
	
	
	
	public WebDriver getBrowserDriver(String browserName){
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\BrowserDriver\\msedgedriver.exe");
			driver = new EdgeDriver();
			
			break;
		default:
			 new RuntimeException ("Please input correct the browser name");

			break;
		}
		return driver;
}

	
	
		public void TC_07() {
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
  
			System.out.println("Thang nay co 31 ngay");
			break;
		case 2:
 
			System.out.println("Thang nay co 28 ngay");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Thang nay co 30 ngay");

			break;

		default:
			System.out.println("Thang nhap sai dinh dang");
			break;
		}
	}	
			
		
		public void TC_08() {
			int month = scanner.nextInt();

			switch (month) {
			case 1:
				System.out.println("One");
				break;
			case 2:
				System.out.println("Two");
				break;

			case 3:
				System.out.println("Three");
				break;
			case 4:
				System.out.println("Four");
				break;
			case 5:
				System.out.println("Five");
				break;
			case 6:
				System.out.println("Six");
				break;
			case 7:
				System.out.println("Sven");
				break;
			case 8:
				System.out.println("Eight");
				break;
			case 9:
				System.out.println("Nine");
			case 10:
				System.out.println("Ten");
			break;
			default :
				System.out.println("Nhap sai dinh dang");
			
			}
	
			
			
			
		}
		
		@Test
		public void TC_06() {

			int firstNumber  =  scanner.nextInt();
			int secondNumber  =  scanner.nextInt();
			String operator = scanner.next();

			// ex: 4 5 * or 3 4  +
			switch (operator) {
			case "+":
				System.out.println("A + B = " + (firstNumber + secondNumber) );
				break;
			case "-":
				System.out.println("A - B = " + (firstNumber - secondNumber) );
				break;
			case "*":
				System.out.println("A x B = " + (firstNumber * secondNumber) );
				break;
			case "/":
				System.out.println("A / B = " + (firstNumber / secondNumber) );
				break;
			case "%":
				System.out.println("A % B = " + (firstNumber % secondNumber) );
				break;
			default:
				break;
			}
			
		}	
			
			
			
			
	
		
}


	


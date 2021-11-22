 package javaBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Topic_06_Conditions_Statement {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	//@Test
	public void TC_01_If() {
		boolean status = 5 <3;
		System.out.println(status);
		
		//ham if se nhan vao 1 dk dung
		//kt duy nhat 1 dk
		//neu dk nay dung thi se action (xxx) trong phan than
		if(status) {
			// dung thi vao phan than cua if
			//sai thi bo qua
			System.out.println("go for it");
			
		}
		//gan (Assign)
				int studentNumber = 10;
				//so sanh
				status = (studentNumber == 10);
				System.out.println(status);
		
		WebDriver driver = new FirefoxDriver();
		//Element luon luon co trong DOM du popup co hien thi hay ko
		WebElement  salePopup = driver.findElement(By.id(""));
		if (salePopup.isDisplayed()) {
			
		}
		//Element ko co trong DOM khi Popup ko hien thi 
		List<WebElement> salePopups = driver.findElements(By.id(""));
		
		if (salePopups.size()>0 && salePopups.get(0).isDisplayed()) {
		}
		//Uncheck to checkbox
		WebElement  languagesCheckbox = driver.findElement(By.id(""));
		if (!languagesCheckbox.isSelected()) {
			languagesCheckbox.click();
		}
		if (languagesCheckbox.isSelected()) {
			languagesCheckbox.click();
		}
	}

	@Test
	public void TC_02_If_Else() {
		//co 2 dk, dung thi vao if/sai thi vao else
		
		//neu driver start vs browser nhu Chrome/Firefox/Edge/ Safari thi dung click thong thuong
		//neu la IE thi dung JavascripExecutor
		
		System.setProperty("webdriver.ie.driver", projectPath + "\\BrowserDriver\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
		System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		
		
		System.out.println(driver.toString());
		
		
		if(driver.toString().contains("internet explorer ")) {
			System.out.println("click by JavascripExecutor");
		}else {
			System.out.println("click by selenium WebElement");

		}
		
	}
	
	

}
  


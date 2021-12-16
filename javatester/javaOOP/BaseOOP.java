package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class BaseOOP {

	public long shortTimeout = 15;
	protected long longTimeout = 45;
	private WebDriver driver;
	
	public void setImplicitWait() {
		
		//local
		long shortTimeout = 16;
		//biến ở class cha
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
	
	}
	
}

package javaBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import javaOOP.BaseOOP;

public class Topic_05_This_Super extends BaseOOP {
	private WebDriver driver;

	public long shortTimeout = 15;
	protected long longTimeout = 45;
	

	public void setImplicitWait() {
		
		//local
		long shortTimeout = 16;
		//biến ở class cha
		driver.manage().timeouts().implicitlyWait(super.longTimeout, TimeUnit.SECONDS);
		
		//biên ở local
		driver.manage().timeouts().implicitlyWait(shortTimeout, TimeUnit.SECONDS);

		// biến ở global
		driver.manage().timeouts().implicitlyWait(this.shortTimeout, TimeUnit.SECONDS);

	}
	public void  clickToElement() {
		
		setImplicitWait();
		
	}
	
}

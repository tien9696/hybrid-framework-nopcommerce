package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class MyAccountPageObject extends BasePage {
	private WebDriver driver;

	//ham khoi tao
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;

	}

	

	public MyAccountPageObject clickToNewletterCheckbox() {
		waitForElementClickable(driver, HomePageUI.NEWLETTER_LINK);
		clickToElement(driver, HomePageUI.NEWLETTER_LINK);
        		return PageGeneratorManager.getMyAccountPage(driver);
			
	}
	

}

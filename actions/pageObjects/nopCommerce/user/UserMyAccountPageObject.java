package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagernopcommerce;
import pageUIs.nopcommerce.User.HomePageUI;

public class UserMyAccountPageObject extends BasePage {
	private WebDriver driver;

	//ham khoi tao
	public UserMyAccountPageObject(WebDriver driver) {
		this.driver = driver;

	}

	

	public UserMyAccountPageObject clickToNewletterCheckbox() {
		waitForElementClickable(driver, HomePageUI.NEWLETTER_LINK);
		clickToElement(driver, HomePageUI.NEWLETTER_LINK);
        		return PageGeneratorManagernopcommerce.getUserMyAccountPage(driver);
			
	}
	

}

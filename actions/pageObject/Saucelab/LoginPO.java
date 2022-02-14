package pageObject.Saucelab;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.Saucelab.LoginPageUI;

public class LoginPO extends BasePage {
	WebDriver driver;

	public LoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void loginToSystem(String userName, String password) {

		waitForElementVisible(driver, LoginPageUI.USER_NAME);
		sendToElement(driver, LoginPageUI.USER_NAME, userName);
		waitForElementVisible(driver, LoginPageUI.PASSWORD);
		sendToElement(driver, LoginPageUI.PASSWORD, userName);

	}

	public InventoryPO clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGenerator.getInventoryPage(driver);
	}

}

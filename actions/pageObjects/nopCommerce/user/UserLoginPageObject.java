package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagernopcommerce;
import pageUIs.nopcommerce.User.LoginPageUI;

public class UserLoginPageObject extends BasePage {

	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManagernopcommerce.getUserHomePageObject(driver);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getWebElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextbox(String invalidEmail) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendToElement(driver, LoginPageUI.EMAIL_TEXTBOX, invalidEmail);
	}

	public String getErrorMessageUnsuccessfull() {
		waitForElementVisible(driver, LoginPageUI.UNSUCCESSFULL_ERROR_MESSAGE);
		return getWebElementText(driver, LoginPageUI.UNSUCCESSFULL_ERROR_MESSAGE);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);

	}

	public UserHomePageObject LoginAsUser(String existingEmail, String validPassword) {
		inputToEmailTextbox(existingEmail);
		inputToPasswordTextbox(validPassword);
		return clickToLoginButton();
	}

	public UserHomePageObject openHomePage() {
		waitForElementClickable(driver, LoginPageUI.HOMEPAGE);
		clickToElement(driver, LoginPageUI.HOMEPAGE);
		
		return PageGeneratorManagernopcommerce.getUserHomePageObject(driver);
	}

}

package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.PageGeneratorManagernopcommerce;
import pageUIs.liveguru.LoginPageUI;
import pageUIs.nopcommerce.RegisterPageUI;

public class LoginPageObjectLiveguru extends BasePage {
	private WebDriver driver;

	public LoginPageObjectLiveguru(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObjectLiveguru clickToCreateAnAccount() {
		waitForElementClickable(driver, LoginPageUI.CREATE_AN_ACCOUNT_LINK);
		clickToElement(driver, LoginPageUI.CREATE_AN_ACCOUNT_LINK);
		return PageGeneratorManagerLiveguru.getRegisterPageObjectLiveguru(driver) ;
	}

	

	public void inputToEmailAddressTextbox(String existingEmail) {

		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, existingEmail);

	
	}

	public void inputToPasswordTextbox(String validPassword) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, validPassword);

	}

	public DashBoardPageObjectLiveguru clickToLoginButtton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON );
		clickToElement(driver,  LoginPageUI.LOGIN_BUTTON);
		// cachs 2
		//return new HomePageObject(driver);
        //3
		return PageGeneratorManagerLiveguru.getDashBoardPageObjectLiveguru(driver);
	}


	
}

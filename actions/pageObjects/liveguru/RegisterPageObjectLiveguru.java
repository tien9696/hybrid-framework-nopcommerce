package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.User.RegisterPageUI;
    
public class RegisterPageObjectLiveguru extends BasePage {
    private WebDriver driver;

	public RegisterPageObjectLiveguru(WebDriver driver) {
		this.driver = driver;

	}

	

	public void inputToFirstnameTextbox(String firstName) {
		waitForElementVisible(driver, pageUIs.liveguru.RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendToElement(driver, pageUIs.liveguru.RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
		
	}

	


	public void inputToLastnameTextbox(String lastName) {
		waitForElementVisible(driver, pageUIs.liveguru.RegisterPageUI.LAST_NAME_TEXTBOX);
		sendToElement(driver, pageUIs.liveguru.RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
			
	}

	public void inputToEmailAddressTextbox(String existingEmail) {
		waitForElementVisible(driver, pageUIs.liveguru.RegisterPageUI.EMAIL_TEXTBOX);
		sendToElement(driver, pageUIs.liveguru.RegisterPageUI.EMAIL_TEXTBOX, existingEmail);
				
	}

	public void inputToPasswordTextbox(String validPassword) {
		waitForElementVisible(driver, pageUIs.liveguru.RegisterPageUI.PASSWORD_TEXTBOX);
		sendToElement(driver, pageUIs.liveguru.RegisterPageUI.PASSWORD_TEXTBOX, validPassword);
			
	}

	public void inputToPasswordConfirmTextbox(String validPassword) {
		waitForElementVisible(driver, pageUIs.liveguru.RegisterPageUI.PASSWORD_CONFIRM_TEXTBOX);
		sendToElement(driver, pageUIs.liveguru.RegisterPageUI.PASSWORD_CONFIRM_TEXTBOX, validPassword);
				
	}



	public HomePageObjectLiveguru clickToRegisterButton() {
		waitForElementClickable(driver, pageUIs.liveguru.RegisterPageUI.CREATE_AN_ACCOUNT_BUTTON );
		clickToElement(driver, pageUIs.liveguru.RegisterPageUI.CREATE_AN_ACCOUNT_BUTTON );
		// cachs 2
		//return new HomePageObject(driver);
        //3
		return PageGeneratorManagerLiveguru.getHomePageObjectLiveguru(driver);
	}

}

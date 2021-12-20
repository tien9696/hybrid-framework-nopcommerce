package pageObjectFacebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIFacebook.RegisterPageUI;

public class RegisterPageObject extends BasePage {
WebDriver driver;

public RegisterPageObject(WebDriver driver) {
	this.driver = driver;
}

public void enterToEmailTextbox(String email) {

	waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	sendToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
}

public boolean isEmailTextboxDisplayed() {

	waitForElementClickable(driver, RegisterPageUI.EMAIL_TEXTBOX);
	clickToElement(driver, RegisterPageUI.EMAIL_TEXTBOX);
	return true;
}

public boolean isConfirmEmailTextboxDisplayed() {
	return isElementDisplayed(driver, RegisterPageUI.CONFIRM_EMAIL_TEXTBOX);
}

public boolean isButtonLoginDisplayed() {
	// TODO Auto-generated method stub
	return isElementDisplayed(driver, RegisterPageUI.LOGIN_BUTTON);
}

public boolean isButtonLoginUnDisplayed() {
 //waitForElementInvisible(driver, RegisterPageUI.LOGIN_BUTTON);
 
	return isElementUnDisplayed(driver, RegisterPageUI.LOGIN_BUTTON);
}

public boolean isConfirmEmailTextboxUnDisplayed() {
	// TODO Auto-generated method stub
	return isElementUnDisplayed(driver, RegisterPageUI.LOGIN_BUTTON);
}


}

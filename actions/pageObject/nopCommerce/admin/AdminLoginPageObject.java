package pageObject.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagernopcommerce;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageUIs.nopcommerce.Admin.AdminLoginPageUIs;
import pageUIs.nopcommerce.User.HomePageUI;

public class AdminLoginPageObject extends BasePage {

	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUsernameTextbox(String existingEmail) {

		waitForAllElementVisible(driver, AdminLoginPageUIs.EMAIL_TEXTBOX);
		sendToElement(driver, AdminLoginPageUIs.EMAIL_TEXTBOX, existingEmail);
	}

	public void inputToPasswordTextbox(String validPassword) {

		waitForAllElementVisible(driver, AdminLoginPageUIs.PASSWORD_TEXTBOX);
		sendToElement(driver, AdminLoginPageUIs.PASSWORD_TEXTBOX, validPassword);
	
	}

	public AdminDashBoardPageObject clickToLoginButtonTextbox() {
		waitForAllElementVisible(driver, AdminLoginPageUIs.LOGINBUTON_TEXTBOX);
		clickToElement(driver, AdminLoginPageUIs.LOGINBUTON_TEXTBOX);
		return PageGeneratorManagernopcommerce.getMyDashBoardPage(driver);

	}

	public AdminDashBoardPageObject LoginAsAdmin(String emailAdmin, String passwordAdmin) {
		inputToUsernameTextbox(emailAdmin);
		inputToPasswordTextbox(passwordAdmin);
		
		return clickToLoginButtonTextbox();
	}
	
	
	
}

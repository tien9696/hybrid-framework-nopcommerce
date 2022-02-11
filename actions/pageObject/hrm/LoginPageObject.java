package pageObject.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.hrm.LoginPageUI;

public class LoginPageObject extends BasePage{
      WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver =  driver;
	}
	public DasrBoardPageObject loginToSystem(String userName, String password) {
       waitForElementVisible(driver, LoginPageUI.USER_NAME_TEXTBOX, userName);
		sendToElement(driver, LoginPageUI.USER_NAME_TEXTBOX, userName);
		 waitForElementVisible(driver, LoginPageUI.PASSWORDTEXTBOX, password);
			sendToElement(driver, LoginPageUI.PASSWORDTEXTBOX, password);
		
			waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
			clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGenerator.getDashBoardPage(driver);
	}

	
	
	
}

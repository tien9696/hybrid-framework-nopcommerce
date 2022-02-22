package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage;
import commons.PageGeneratorManagernopcommerce;
import pageUIs.nopcommerce.User.HomePageUI;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;

	//ham khoi tao
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;

	}
	//	clickToElement(driver, HomePageUI.REGISTER_LINK);
	
	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		// nếu hàm click của JS ko work thi d có thể dùng hàm href
		if(driver.toString().contains("internet explorer")) {
			openPageUrl(driver, getElementAttribute(driver, HomePageUI.REGISTER_LINK, "href"));
			sleepInsecond(3);
		}
		return PageGeneratorManagernopcommerce.getUserRegisterPage(driver);
	}


	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		if(driver.toString().contains("internet explorer")) {
			sleepInsecond(3);
		}
        return PageGeneratorManagernopcommerce.getUserLoginPage(driver);
	}
	

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}


	public UserMyAccountPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		if(driver.toString().contains("internet explorer")) {
			sleepInsecond(3);
		}
        		return PageGeneratorManagernopcommerce.getUserMyAccountPage(driver);
	}


	


	
}

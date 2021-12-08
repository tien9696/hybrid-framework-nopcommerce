package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagernopcommerce;
import pageUIs.liveguru.LoginPageUI;
import pageUIs.nopcommerce.User.HomePageUI;
import pageUIs.nopcommerce.User.RegisterPageUI;
public class HomePageObjectLiveguru extends BasePage {
	
	
	   private WebDriver driver;

	public HomePageObjectLiveguru(WebDriver driver) {
		this.driver = driver;

	}
//nopcommere
//	public RegisterPageObjectLiveguru clickToLoginLink() {
//		waitForElementClickable(driver, pageUIs.liveguru.HomePageUI.LOGIN_LINK);
//		clickToElement(driver, pageUIs.liveguru.HomePageUI.LOGIN_LINK);
//        return PageGeneratorManagerLiveguru(driver);
//	}

	public void clickToAccountLink() {
		waitForElementClickable(driver, pageUIs.liveguru.HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, pageUIs.liveguru.HomePageUI.MY_ACCOUNT_LINK);

	}

	

	public void clickToLogoutLink() {
		waitForElementClickable(driver, pageUIs.liveguru.HomePageUI.LOGOUT_LINK);
		clickToElement(driver, pageUIs.liveguru.HomePageUI.LOGOUT_LINK);

			
	}

	public RegisterPageObjectLiveguru clickToCreateAnAccount() {
		waitForElementClickable(driver, pageUIs.liveguru.HomePageUI.CREATE_AN_ACCOUNT_LINK );
		clickToElement(driver, pageUIs.liveguru.HomePageUI.CREATE_AN_ACCOUNT_LINK);
		// cachs 2
		//return new HomePageObject(driver);
        //3
		return PageGeneratorManagerLiveguru.getRegisterPageObjectLiveguru(driver);
	}

	

	public LoginPageObjectLiveguru clickToLoginLink() {
		waitForElementClickable(driver, pageUIs.liveguru.HomePageUI.LOGIN_LINK);
		clickToElement(driver,  pageUIs.liveguru.HomePageUI.LOGIN_LINK);
		// cachs 2
		//return new HomePageObject(driver);
        //3
		return PageGeneratorManagerLiveguru.getLoginPageObjectLiveguru(driver);
	}

	

	

	
	
	
	
//	}
//	public void clickToAccountLink() {
//		// TODO Auto-generated method stub
//		
//	}
//	public void clickToLoginLink() {
//		// TODO Auto-generated method stub
//		
//	}
}

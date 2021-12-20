package pageObjectFacebook;

import org.openqa.selenium.WebDriver;

import pageObject.nopCommerce.admin.AdminDashBoardPageObject;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObject.nopCommerce.admin.AdminProductDetailsPageObject;
import pageObject.nopCommerce.admin.AdminProductSearchPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountPageObject;
import pageObjects.nopCommerce.user.UserOdersPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardpointsPage;
import pageUIs.nopcommerce.User.HomePageUI;


public class PageGeneratorManager {
	
		
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
			return new RegisterPageObject(driver);
		}
	}
	


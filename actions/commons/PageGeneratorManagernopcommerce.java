package commons;

import org.openqa.selenium.WebDriver;

import pageObject.nopCommerce.admin.AdminDashBoardPageObject;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountPageObject;
import pageObjects.nopCommerce.user.UserOdersPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardpointsPage;
import pageUIs.nopcommerce.User.HomePageUI;


public class PageGeneratorManagernopcommerce {

	
	
	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	public static UserMyAccountPageObject getUserMyAccountPage(WebDriver driver) {
		return new UserMyAccountPageObject(driver);
	}
	public static UserRewardpointsPage getUserRewardpointsPage(WebDriver driver) {
		return new UserRewardpointsPage(driver);
	}

	public static UserAddressPageObject getUserMyAdressPage(WebDriver driver) {
		return new UserAddressPageObject(driver);
	}

	public static UserOdersPageObject getUserodersPage(WebDriver driver) {
		return new UserOdersPageObject(driver);
	}

	

	public static AdminDashBoardPageObject getMyDashBoardPage(WebDriver driver) {
		return new AdminDashBoardPageObject(driver);
	}

	public static UserHomePageObject getUserHomePageObject(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPageObject(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	


	

	
	
	
}

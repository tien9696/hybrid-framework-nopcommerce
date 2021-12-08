package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManagernopcommerce {

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}
	public static RewardpointsPage getRewardpointsPage(WebDriver driver) {
		return new RewardpointsPage(driver);
	}

	public static AddressPageObject getMyAdressPage(WebDriver driver) {
		return new AddressPageObject(driver);
	}

	public static OdersPageObject getOdersPage(WebDriver driver) {
		return new OdersPageObject(driver);
	}

	
	
	
}

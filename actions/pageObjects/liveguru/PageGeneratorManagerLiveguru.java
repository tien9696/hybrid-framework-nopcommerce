package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class PageGeneratorManagerLiveguru {

	

	public static HomePageObjectLiveguru getHomePageObjectLiveguru(WebDriver driver) {
		return new HomePageObjectLiveguru(driver);
	}
	 
	public static LoginPageObjectLiveguru getLoginPageObjectLiveguru(WebDriver driver) {
		return new LoginPageObjectLiveguru(driver);
	}
	 
	public static RegisterPageObjectLiveguru getRegisterPageObjectLiveguru(WebDriver driver) {
		return new RegisterPageObjectLiveguru(driver);
	}


	public static DashBoardPageObjectLiveguru getDashBoardPageObjectLiveguru(WebDriver driver) {
		// TODO Auto-generated method stub
		return new DashBoardPageObjectLiveguru(driver);
	}
	 
//	public static HomePageObject getHomePage(WebDriver driver) {
//		return new HomePageObject(driver);
//	}
//	
//	public static LoginPageObject getLoginPage(WebDriver driver) {
//		return new LoginPageObject(driver);
//	}
//	
//	public static RegisterPageObject getRegisterPage(WebDriver driver) {
//		return new RegisterPageObject(driver);
//	}
//	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
//		return new MyAccountPageObject(driver);
//	}

	
	
	

}

package pageObject.jQuery.datatable;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.user.UserLoginPageObject;

public class PageGeneratorManagerjQuery {

	private static HomePageObject homePage;
	
	private PageGeneratorManagerjQuery() {
		
	}
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
		
	}
}

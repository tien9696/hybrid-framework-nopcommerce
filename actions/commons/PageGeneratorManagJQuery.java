package commons;

import org.openqa.selenium.WebDriver;

import pageObject.jQuery.uploadfile.HomePageObject;


public class PageGeneratorManagJQuery {

	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	

	
	
	
}

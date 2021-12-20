package pageObject.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.Admin.AdminDashBoardPageUI;

public class AdminDashBoardPageObject extends BasePage {

	private WebDriver driver;

	public AdminDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashBoardHeaderDisplayed() {
		waitForElementVisible(driver, AdminDashBoardPageUI.HEADER_DASHBOARD);
		return isElementDisplayed(driver, AdminDashBoardPageUI.HEADER_DASHBOARD);
	}

	
	
	
}

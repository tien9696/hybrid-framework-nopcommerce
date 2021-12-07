package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveguru.DashBoardUI;
import pageUIs.nopcommerce.RegisterPageUI;

public class DashBoardPageObjectLiveguru extends BasePage {

	  private WebDriver driver;

		public DashBoardPageObjectLiveguru(WebDriver driver) {
			this.driver = driver;

		}


	public void clickToAccountLink() {
		waitForElementClickable(driver, DashBoardUI.MY_ACCOUNT_LINK);
		clickToElement(driver, DashBoardUI.MY_ACCOUNT_LINK);
				
	}

//	public HomePageObjectLiveguru clickToLogoutLink() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}

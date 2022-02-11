package pageObject.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.hrm.BasePageUI;
import pageUI.hrm.MyInfoPageUI;

public class MyInfoPO extends BasePage {
	WebDriver driver;

	public MyInfoPO(WebDriver driver) {
		this.driver = driver;
	}

	

	public void clickToChangeToPhotoImage() {
		waitForElementClickable(driver, MyInfoPageUI.AVATAR_IMG);
		clickToElement(driver, MyInfoPageUI.AVATAR_IMG);
	}

	public boolean isNewAvatarImageDisplayed() {
		waitForElementVisible(driver, MyInfoPageUI.AVATAR_IMG);
		int imgwwidth = Integer.parseInt(getElementAttribute(driver, MyInfoPageUI.AVATAR_IMG, "width"));
		int imgwheight = Integer.parseInt(getElementAttribute(driver, MyInfoPageUI.AVATAR_IMG, "height"));

		return (imgwwidth != 200) || (imgwheight != 200);
	}

	public void openTabAtSidebarByName(String tagName) {
		waitForElementClickable(driver, MyInfoPageUI.TAB_LINK_AT_SIDEBAR, tagName);
		clickToElement(driver, MyInfoPageUI.TAB_LINK_AT_SIDEBAR, tagName);
	}
	
}

package pageObject.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagernopcommerce;
import pageUIs.nopcommerce.Admin.AdminDashBoardPageUI;
import pageUIs.nopcommerce.Admin.AdminProductSearchPageUI;

public class AdminProductSearchPageObject extends BasePage {

	private WebDriver driver;

	public AdminProductSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToProductNameTextbox(String string) {
		waitForElementVisible(driver, AdminProductSearchPageUI.PRODUCT_SEARCH_TEXTBOX);
		sendToElement(driver, AdminProductSearchPageUI.PRODUCT_SEARCH_TEXTBOX, string);
	}

	public void clickToSeachButton() {
		waitForElementVisible(driver, AdminProductSearchPageUI.PRODUCT_SEARCH_BUTTON);
		clickToElement(driver, AdminProductSearchPageUI.PRODUCT_SEARCH_BUTTON);
		}

	public AdminProductDetailsPageObject clickToEditButtonByProductName(String productName) {
		waitForElementVisible(driver, AdminProductSearchPageUI.PRODUCT_EDIT_BUTTON, productName);
		clickToElement(driver, AdminProductSearchPageUI.PRODUCT_EDIT_BUTTON, productName);
		
		return PageGeneratorManagernopcommerce.getAdminProductDetailsPageObject(driver);
	}

	public boolean isSuccessMessageDisplayed(String messageName) {
		waitForElementVisible(driver, AdminProductSearchPageUI.SUCCESS_MESSAGE, messageName);
		return isElementDisplayed(driver, AdminProductSearchPageUI.SUCCESS_MESSAGE, messageName);
	}

	public boolean isPictureImageUpdated(String productImageName, String productName) {
		productImageName = productImageName.replace(" ", "-").toLowerCase();

		waitForElementVisible(driver, AdminProductSearchPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME,productName, productImageName);
		return isElementDisplayed(driver, AdminProductSearchPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME,productName, productImageName);
	}

}

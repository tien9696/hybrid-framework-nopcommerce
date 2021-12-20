package pageObject.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagernopcommerce;
import pageUIs.nopcommerce.Admin.AdminBasePageUI;
import pageUIs.nopcommerce.Admin.AdminDashBoardPageUI;
import pageUIs.nopcommerce.Admin.AdminProductDetailPageUI;

public class AdminProductDetailsPageObject extends BasePage {

	private WebDriver driver;

	public AdminProductDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToExpanPanelByName(String panelName) {

		waitForElementVisible(driver, AdminProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		String toogleIconStatus = getElementAttribute(driver, AdminProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, "class", panelName);
		if (toogleIconStatus.contains("fa-plus")) {
			waitForElementClickable(driver, AdminProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
			clickToElement(driver, AdminProductDetailPageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		}

	}

	public boolean isPictureUploadSuccessByFilename( String fileName) {
		fileName = fileName.split("\\.")[0];
		waitForElementVisible(driver, AdminProductDetailPageUI.PICTURE_IMAGE_ADD_NEW_BY_FILENAME, fileName);
		return isElementDisplayed(driver, AdminProductDetailPageUI.PICTURE_IMAGE_ADD_NEW_BY_FILENAME, fileName);

	}

	public void enterToAltTextbox( String productImageAlt) {

		waitForElementVisible(driver, AdminProductDetailPageUI.ALT_TEXTBOX_ADD_NEW);
		sendToElement(driver, AdminProductDetailPageUI.ALT_TEXTBOX_ADD_NEW, productImageAlt);
	}

	public void enterToTitleTextbox(String productImageTitle) {
		waitForElementVisible(driver, AdminProductDetailPageUI.TITLE_TEXTBOX_ADD_NEW);
		sendToElement(driver, AdminProductDetailPageUI.TITLE_TEXTBOX_ADD_NEW, productImageTitle);

	}

	public void enterToDisplayedOderTextbox(String selectValue) {
		waitForElementClickable(driver, AdminProductDetailPageUI.DISPLAY_ODER_TEXTBOX, selectValue);
		clickToElement(driver, AdminProductDetailPageUI.DISPLAY_ODER_TEXTBOX, selectValue);

	}

	public void clickToAddProductPictureButton() {
		waitForElementClickable(driver, AdminProductDetailPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		clickToElement(driver, AdminProductDetailPageUI.ADD_PRODUCT_PICTURE_BUTTON);
	}

	public boolean isPictureImageDisplayed( String imageName, String imageOder, String imageAlt, String imageTitle) {
		imageName = imageName.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver, AdminProductDetailPageUI.PICTURE_TABLE_BY_NAME_ALT_ODER_TITLE, imageName, imageOder, imageAlt, imageTitle);
		return isElementDisplayed(driver, AdminProductDetailPageUI.PICTURE_TABLE_BY_NAME_ALT_ODER_TITLE, imageName, imageOder, imageAlt, imageTitle);
	}

	public AdminProductSearchPageObject clickToSaveButton() {
		waitForElementClickable(driver, AdminProductDetailPageUI.SAVE_BUTTON);
		clickToElement(driver, AdminProductDetailPageUI.SAVE_BUTTON);
		return PageGeneratorManagernopcommerce.getAdminProductSearchPageObject(driver);
	}

	public void clickToDeleteButtonAtPictureName( String productTitle) {
		waitForElementClickable(driver, AdminProductDetailPageUI.DELETE_BUTTON_BY_IMAGE_TITLE, productTitle);
		clickToElement(driver, AdminProductDetailPageUI.DELETE_BUTTON_BY_IMAGE_TITLE, productTitle);
		acceptAlert(driver);
	}

	public boolean isMesageDisplayedInEmptyTable(WebDriver driver, String tableName) {
		waitForElementVisible(driver, AdminBasePageUI.NO_DATA_MESSGE_BY_TABLE_NAME, tableName);
		return isElementDisplayed(driver, AdminBasePageUI.NO_DATA_MESSGE_BY_TABLE_NAME, tableName);
	}

}

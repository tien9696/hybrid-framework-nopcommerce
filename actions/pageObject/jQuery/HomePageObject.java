package pageObject.jQuery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
      waitForElementClickable(driver, HomePageUI.PAGE_BY_NUMBER, pageNumber);
      clickToElement(driver,HomePageUI.PAGE_BY_NUMBER, pageNumber);
      
      
      
	}

	public boolean isPageActiveByNumber(String pageNumber) {
	      waitForElementVisible(driver, HomePageUI.PAGE_BY_NUMBER_ATIVE, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGE_BY_NUMBER_ATIVE, pageNumber);
		
	}

	public void inputToSearchTextbox(String headerName, String value) {
	      waitForElementVisible(driver, HomePageUI.SEARCH_TEXTBOX, headerName );
	      sendToElement(driver, HomePageUI.SEARCH_TEXTBOX, value , headerName);
	      
		
	}

	public void clickToIconByCountryName(String countryName, String iconAction) {
waitForElementClickable(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconAction);
clickToElement(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconAction);
	}

	public void inputToTextboxByRowNumber(String headerName, String rowIndex, String value) {

		int columIndex = getElementSize(driver, HomePageUI.HEADER_NAME_INDEX, headerName) + 1;
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUM_ROW_INDEX, rowIndex, String.valueOf(columIndex));
		sendToElement(driver, HomePageUI.TEXTBOX_BY_COLUM_ROW_INDEX, value, rowIndex, String.valueOf(columIndex));
	}

	public void inputToTextbox(String string, String string2, String value) {
		waitForElementClickable(driver, HomePageUI.TEXTBOX_BY_COLUM_ROW, string, string2);
	      sendToElement(driver, HomePageUI.TEXTBOX_BY_COLUM_ROW, value , string, string2);
	}

	public void clickToIconByRowName(String rowIndex, String iconAction) {
		waitForElementClickable(driver, HomePageUI.BUTTON_ACTION_BY_ROW_INDEX, rowIndex, iconAction);
		clickToElement(driver, HomePageUI.BUTTON_ACTION_BY_ROW_INDEX, rowIndex, iconAction);
		
	}

	

	



	

	
	
}

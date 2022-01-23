package pageObject.jQuery;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	      pressKeyToElement(driver,  HomePageUI.SEARCH_TEXTBOX, Keys.ENTER, headerName);
		
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

	public List<String> getValueEachRowAllPage() {

		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total size = " + totalPage);
		
		List<String> allRowValueAllPage = new ArrayList<String>();
		
		Set<String> allRowValuesUniqueAllPage = new HashSet<String>();
		
		//duyệt qua tất cả các Page number
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.TOTAL_PAGINATION, String.valueOf(index));
		sleepInsecond(3);
		
		// get text cua all row mỗi page đưa vào array lít
		List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
		for (WebElement eachRow : allRowElementEachPage) {
			allRowValueAllPage.add(eachRow.getText());
		}
		
		}
		//in all giá trị row ra - tất cả các page
		for (String value : allRowValueAllPage) {
			System.out.println(value);
		}
		return allRowValueAllPage;
	}

	public void enterToTexxtBoxAtRowNumberByColumnName(String columName, String rowNumber, String value) {
		//lấy ra column index dựa vào tên cột
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columName) + 1;
         //sendkey vào dòng nào
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,  String.valueOf(columnIndex));
		sendToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber,  String.valueOf(columnIndex));
		
	}

	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToSelect) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementClickable(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,  String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToSelect, rowNumber,  String.valueOf(columnIndex));
		
	
	}

	public void clickToLoadButton() {

		waitForElementClickable(driver, HomePageUI.LOAD_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_BUTTON);
		
		
		
	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,  String.valueOf(columnIndex));
		checkToDefaultCheckboxRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,  String.valueOf(columnIndex));
	}

	public void unCheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,  String.valueOf(columnIndex));
        uncheckToDefaultCheckbox(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,  String.valueOf(columnIndex));
	}

	public void clickToByRowNumber(String rowIndex, String iconAction) {
		waitForElementClickable(driver, HomePageUI.BUTTON_ACTION_BY_ROW_INDEX, rowIndex, iconAction);
		clickToElement(driver, HomePageUI.BUTTON_ACTION_BY_ROW_INDEX, rowIndex, iconAction);
		
	}
	
	

	



	

	
	
}

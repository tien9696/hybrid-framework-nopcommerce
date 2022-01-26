package pageObject.jQuery.uploadfile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.uploadFile.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLinkLoadedByName(String... javaFileName) {

		waitForElementVisible(driver, HomePageUI.FILE_NAME_LOADED, javaFileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_LOADED, javaFileName);
	}

	public boolean isFileImageUpLoadedByImg(String... javaFileName) {

		waitForElementVisible(driver, HomePageUI.FILE_LOAED_SUCCESS_IMAGE, javaFileName);
		return isImageLoaded(driver, HomePageUI.FILE_LOAED_SUCCESS_IMAGE, javaFileName);
	}

	public void clickToStartButton() {
		waitForElementVisible(driver, HomePageUI.START_BUTTON);
		clickToElement(driver, HomePageUI.START_BUTTON);
	}

	public void clickToStartButton2() {

		List<WebElement> startButtons = getListWebElement(driver, HomePageUI.START_BUTTON2);
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInsecond(3);
		}
	}

	public boolean isFileLoadedSuccess(String... fileName) {

		waitForAllElementVisible(driver, HomePageUI.FILE_LOAED_SUCCESS, fileName);

		return isElementDisplayed(driver, HomePageUI.FILE_LOAED_SUCCESS, fileName);
	}

}

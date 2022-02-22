package commons;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.hrm.LoginPageObject;
import pageObject.hrm.PageGenerator;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObject.nopCommerce.admin.AdminProductSearchPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserOdersPageObject;
import pageObjects.nopCommerce.user.UserRewardpointsPage;
import pageUI.hrm.BasePageUI;
import pageUI.hrm.DashBoardPageUI;
import pageUIs.nopcommerce.User.UserBasePageUIs;
import pageUIs.jQuery.uploadFile.HomePageUI;
import pageUIs.nopcommerce.Admin.AdminBasePageUI;
import pageUIs.nopcommerce.User.LoginPageUI;
import pageUIs.nopcommerce.User.RegisterPageUI;

import org.openqa.selenium.Keys;

public class BasePage {

	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	// Mở ra 1 Url bất kì
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}

	public void setAllCookies(WebDriver driver, Set<Cookie> allCookies) {
		for (Cookie cookie : allCookies) {
			driver.manage().addCookie(cookie);
		}
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();

	}

	public void sendKeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	public void switchToWindowByID(WebDriver driver, String Window) {
		Set<String> allWindownIDs = driver.getWindowHandles();
		for (String id : allWindownIDs) {
			if (!id.equals(Window)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String TabTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(TabTitle)) {
				break;
			}
		}
	}

	public void closeAllTabWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWinDowIDs = driver.getWindowHandles();
		for (String id : allWinDowIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
	}

	// locator Type: id=/ css=/ xpath=/ name=/ class=/
	// locator Type: ID=/ CSS=/ XPATH=/ NAME=/ CLASS=/
	// locator Type: Id=/ Css=/ Xpath=/ Name=/ Class=/

	public By getByLocator(String locatorType) {
		By by = null;
		//System.out.println("Locator type = " + locatorType);
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=")
				|| locatorType.startsWith("Xpath=")) {
			by = By.xpath(locatorType.substring(6));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=")
				|| locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=")
				|| locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type is not supported");
		}
		return by;

	}

	public String getDynamicLocator(String locatorType, String... dynamicValues) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			locatorType = String.format(locatorType, (Object[]) dynamicValues);
		}
		return locatorType;

	}

	public WebElement getElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	public WebElement getElement(WebDriver driver, String locatorType, String... dynamicValues) {
		return driver.findElement(getByLocator(getDynamicLocator(locatorType, dynamicValues)));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));

	}

	public void clickToElement(WebDriver driver, String locatorType) {
		highlightElement(driver, locatorType);
		if(driver.toString().contains("internet explorer")) {
			clickToElementByJS(driver, locatorType);
			sleepInsecond(3);
		}else {
		getElement(driver, locatorType).click();
		}
	}

	public void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		highlightElement(driver, locatorType, dynamicValues);
		if(driver.toString().contains("internet explorer")) {
			clickToElementByJS(driver, getDynamicLocator(locatorType, dynamicValues));
			sleepInsecond(3);
		}else {
			getElement(driver, getDynamicLocator(locatorType, dynamicValues)).click();
		}
	}

	public void sendToElement(WebDriver driver, String locatorType, String textValue) {
		WebElement element = getElement(driver, locatorType); 
		highlightElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}

	public void sendToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValues) {
		highlightElement(driver, locatorType, dynamicValues);
		WebElement element = getElement(driver, getDynamicLocator(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(textValue);
	}

	public String getElementText(WebDriver driver, String locatorType) {
		return getElement(driver, locatorType).getText().trim();
	}

	public String getElementText(WebDriver driver, String locatorType, String... dynamicValues) {
		return getElement(driver, getDynamicLocator(locatorType, dynamicValues)).getText().trim();
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getElement(driver, locatorType));
		select.selectByVisibleText(textItem);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem,
			String... dynamicValues) {
		Select select = new Select(getElement(driver, getDynamicLocator(locatorType, dynamicValues)));
		select.selectByVisibleText(textItem);
	}

	public String getSelectedItemDefaultDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(getElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();

	}

	public String getSelectedItemDefaultDropdown(WebDriver driver, String locatorType, String... dynamicValues) {
		Select select = new Select(getElement(driver, getDynamicLocator(locatorType, dynamicValues)));
		return select.getFirstSelectedOption().getText();

	}

	public boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getElement(driver, locatorType));
		return select.isMultiple();
	}

	public void selectItemIncustomDropdown(WebDriver driver, String parentXpath, String childxpath,
			String expectedTextItem) {

		getElement(driver, parentXpath).click();
		sleepInsecond(3);

		WebDriverWait explicitWait = new WebDriverWait(driver, longtimeout);

		List<WebElement> allItem = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childxpath)));
		System.out.println("Item size = " + allItem.size());

		for (WebElement item : allItem) {
			if (item.getText().trim().equals(expectedTextItem)) {
				System.out.println(item.getText());

				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInsecond(3);

				item.click();
				break;
			}
		}

	}

	public void sleepInsecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {
		return getElement(driver, locatorType).getAttribute(attributeName);
	}

	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName,
			String... dynamicValues) {
		return getElement(driver, getDynamicLocator(locatorType, dynamicValues)).getAttribute(attributeName);
	}

	public String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getElement(driver, locatorType).getCssValue(propertyName);

	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();

	}

	public int getElementSize(WebDriver driver, String locatorType) {
		return getListWebElement(driver, locatorType).size();

	}

	public int getElementSize(WebDriver driver, String locatorType, String... dynamicValues) {
		return getListWebElement(driver, getDynamicLocator(locatorType, dynamicValues)).size();

	}

	public String getWebElementText(WebDriver driver, String locatorType) {
		return getElement(driver, locatorType).getText();

	}

	public void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
		highlightElement(driver, locatorType);
		WebElement element = getElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType, String... dynamicValues) {
		highlightElement(driver, locatorType, dynamicValues);
		WebElement element = getElement(driver, getDynamicLocator(locatorType, dynamicValues));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckbox(WebDriver driver, String locatorType) {
		highlightElement(driver, locatorType);
		WebElement element = getElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckbox(WebDriver driver, String locatorType, String... dynamicValues) {
		highlightElement(driver, locatorType, dynamicValues);
		WebElement element = getElement(driver, getDynamicLocator(locatorType, dynamicValues));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType) {

		try {
			// displayed : Visible on UI + in DOM
			// undisplayed : invisible on UI + in DOM
			return getElement(driver, locatorType).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			// undisplayed : invisible on UI + not in DOM

			return false;
		}
	}

	public boolean isElementUnDisplayed(WebDriver driver, String locatorType) {
		System.out.println("Start title = " + new Date().toString());

		overrideGlobalTimeout(driver, shorttimeout);
		List<WebElement> elements = getListWebElement(driver, locatorType);
		overrideGlobalTimeout(driver, longtimeout);

		if (elements.size() == 0) {
			System.out.println("Element not in DOM and not visible on UI");
			System.out.println("End title = " + new Date().toString());
			return true;
		} else if (elements.size() > 0 && elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM and not visible on UI");
			System.out.println("End title = " + new Date().toString());

			return true;
		} else {
			System.out.println("Element in DOM and visible on UI");

			return false;
		}

	}

	public void overrideGlobalTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
		return getElement(driver, getDynamicLocator(locatorType, dynamicValues)).isDisplayed();
	}

	public boolean isElementEnabled(WebDriver driver, String locatorType) {
		return getElement(driver, locatorType).isEnabled();
	}

	public boolean isElementEnabled(WebDriver driver, String locatorType, String... dynamicValues) {
		return getElement(driver, getDynamicLocator(locatorType, dynamicValues)).isEnabled();
	}
	public boolean isElementSelected(WebDriver driver, String locatorType) {
		return getElement(driver, locatorType).isSelected();
	}
	public boolean isElementSelected(WebDriver driver, String locatorType, String... dynamicValues) {
		return getElement(driver, getDynamicLocator(locatorType, dynamicValues)).isSelected();
	}
	public void switchToFrameIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getElement(driver, locatorType));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver, locatorType)).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver, getDynamicLocator(locatorType, dynamicValues))).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(driver, locatorType), key).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(driver, getDynamicLocator(locatorType, dynamicValues)), key).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");

		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}
	
	
	public void highlightElement(WebDriver driver, String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, getDynamicLocator(locatorType, dynamicValues));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");

		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}
	
	
	
	
	

	public void clickToElementByJS(WebDriver driver, String locatorType) {
		highlightElement(driver, locatorType);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locatorType));
	}

	public void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locatorType));
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getElement(driver, locatorType));
	}

	public boolean isJQueryAjaxLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtimeout);

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) ((JavascriptExecutor) driver)
						.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};
		return explicitWait.until(jQueryLoad);
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getElement(driver, locatorType));
		return status;

	}

	public boolean isImageLoaded(WebDriver driver, String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getElement(driver, getDynamicLocator(locatorType, dynamicValues)));
		return status;

	}

	public void waitForElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtimeout);
		explicitWait.until(
				ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locatorType, dynamicValues))));
	}

	public void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtimeout);
		explicitWait.until(ExpectedConditions
				.visibilityOfElementLocated(getByLocator(getDynamicLocator(locatorType, dynamicValues))));
	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));

	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtimeout);
		explicitWait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicLocator(locatorType, dynamicValues))));

	}

	public void waitForElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForAllElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longtimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, locatorType)));

	}

	// User - nopcommerce
	public UserAddressPageObject openAddressPage(WebDriver driver) {
		waitForElementClickable(driver, UserBasePageUIs.ADDRESS_LINK);
		clickToElement(driver, UserBasePageUIs.ADDRESS_LINK);
		return PageGeneratorManagernopcommerce.getUserMyAdressPage(driver);
	}

	public UserOdersPageObject openOdersPage(WebDriver driver) {
		waitForElementClickable(driver, UserBasePageUIs.ODERS_LINK);
		clickToElement(driver, UserBasePageUIs.ODERS_LINK);
		return PageGeneratorManagernopcommerce.getUserodersPage(driver);
	}

	public UserRewardpointsPage openRewardpointsPage(WebDriver driver) {
		waitForElementClickable(driver, UserBasePageUIs.REWARD_POINTS_LINK);
		clickToElement(driver, UserBasePageUIs.REWARD_POINTS_LINK);
		return PageGeneratorManagernopcommerce.getUserRewardpointsPage(driver);
	}

	public UserHomePageObject clickToLogoutLinkAtUserPage(WebDriver driver) {
		waitForElementClickable(driver, UserBasePageUIs.LOGOUT_LINK_AT_USER);
		clickToElement(driver, UserBasePageUIs.LOGOUT_LINK_AT_USER);
		return PageGeneratorManagernopcommerce.getUserHomePageObject(driver);
	}

	public AdminLoginPageObject clickToLogoutLinkAtAdminPage(WebDriver driver) {
		waitForElementClickable(driver, UserBasePageUIs.LOGOUT_LINK_AT_ADMIN);
		clickToElement(driver, UserBasePageUIs.LOGOUT_LINK_AT_ADMIN);
		return PageGeneratorManagernopcommerce.getAdminLoginPageObject(driver);
	}

	public BasePage openPageAtMyAccountByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, UserBasePageUIs.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, UserBasePageUIs.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		switch (pageName) {
		case "Addresses":
			return PageGeneratorManagernopcommerce.getUserMyAdressPage(driver);
		case "Orders":
			return PageGeneratorManagernopcommerce.getUserodersPage(driver);
		case "Reward points":
			return PageGeneratorManagernopcommerce.getUserRewardpointsPage(driver);
		default:
			throw new RuntimeException("Invalid page name at My Account area");
		}
	}

	public void openPageAtMyAccountPageName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, UserBasePageUIs.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, UserBasePageUIs.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
	}

	// Admin - nopcommerce
	public void openSubMenuPageByName(WebDriver driver, String menuPageName, String subMenuPageName) {
		waitForElementClickable(driver, AdminBasePageUI.MENU_LINK_BY_NAME, menuPageName);
		clickToElement(driver, AdminBasePageUI.MENU_LINK_BY_NAME, menuPageName);

		waitForElementClickable(driver, AdminBasePageUI.SUB_MENU_LINK_BY_NAME, subMenuPageName);
		clickToElement(driver, AdminBasePageUI.SUB_MENU_LINK_BY_NAME, subMenuPageName);

	}

	public void upLoadFileAtCardName(WebDriver driver, String cardName, String... fileNames) {
		String filePath = GlobalConstants.UPLOAD_FOLDER_PATH;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getElement(driver, AdminBasePageUI.UPLOAD_FILE_BY_CARD_NAME, cardName).sendKeys(fullFileName);

	}

	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		// đưỡng dẫn của thư mục upload file(win, mac, linux)
		String filePath2 = GlobalConstants.UPLOAD_FOLDER_PATH;
		String fullName2 = "";
		for (String file : fileNames) {
			fullName2 = fullName2 + filePath2 + file + "\n";

		}
		fullName2 = fullName2.trim();
		getElement(driver, HomePageUI.UPLOAD_FILE).sendKeys(fullName2);

	}

	public void enterToTextboxByID(WebDriver driver, String textboxbyID, String value) {
		waitForElementVisible(driver, UserBasePageUIs.DYNAMIC_TEXTBOX_BY_ID, textboxbyID);
		sendToElement(driver, UserBasePageUIs.DYNAMIC_TEXTBOX_BY_ID, value, textboxbyID);

	}

	public void openHeaderPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, UserBasePageUIs.DYNAMIC_PAGE_HEADER, pageName);
		clickToElement(driver, UserBasePageUIs.DYNAMIC_PAGE_HEADER, pageName);
	}

	public void clickToRadioButtonByID(WebDriver driver, String radioButtonID) {
		waitForElementClickable(driver, UserBasePageUIs.RADIO_BUTTON, radioButtonID);
		clickToElement(driver, UserBasePageUIs.RADIO_BUTTON, radioButtonID);
	}

	public void selectDropdownByName(WebDriver driver, String dropDownname, String textItem) {
		selectItemInDefaultDropdown(driver, UserBasePageUIs.DYNAMIC_DROPDOWN_BY_NAME, textItem, dropDownname);
	}

	public void clickToButtonByText(WebDriver driver, String buttonText) {
		waitForElementClickable(driver, UserBasePageUIs.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToElement(driver, UserBasePageUIs.DYNAMIC_BUTTON_BY_TEXT, buttonText);
	}

	// HRM - Menu/ SubMenu/ ChildSubMenu
	public void openMenuPage(WebDriver driver, String menuPageName) {

		waitForElementVisible(driver, BasePageUI.DYNAMIC_MENU_PAGE_BY_NAME, menuPageName);
		clickToElement(driver, BasePageUI.DYNAMIC_MENU_PAGE_BY_NAME, menuPageName);
		isJQueryAjaxLoadedSuccess(driver);
	}

	public void openSubMenuPage(WebDriver driver, String menuPageName, String subMenuPageName) {

		waitForElementVisible(driver, BasePageUI.DYNAMIC_MENU_PAGE_BY_NAME, menuPageName);
		clickToElement(driver, BasePageUI.DYNAMIC_MENU_PAGE_BY_NAME, menuPageName);
		waitForElementVisible(driver, BasePageUI.DYNAMIC_MENU_PAGE_BY_NAME, subMenuPageName);
		clickToElement(driver, BasePageUI.DYNAMIC_MENU_PAGE_BY_NAME, subMenuPageName);

		isJQueryAjaxLoadedSuccess(driver);
	}

	public void openChildSubMenuPage(WebDriver driver, String menuPageName, String subMenuPageName,
			String childSubMenuPageName) {

		waitForElementVisible(driver, BasePageUI.DYNAMIC_MENU_PAGE_BY_NAME, menuPageName);
		clickToElement(driver, BasePageUI.DYNAMIC_MENU_PAGE_BY_NAME, menuPageName);

		waitForElementVisible(driver, BasePageUI.DYNAMIC_MENU_PAGE_BY_NAME, subMenuPageName);
		hoverMouseToElement(driver, BasePageUI.DYNAMIC_MENU_PAGE_BY_NAME, subMenuPageName);

		waitForElementVisible(driver, BasePageUI.DYNAMIC_MENU_PAGE_BY_NAME, childSubMenuPageName);
		clickToElement(driver, BasePageUI.DYNAMIC_MENU_PAGE_BY_NAME, childSubMenuPageName);
		isJQueryAjaxLoadedSuccess(driver);
	}

	public void clickToButtonByid(WebDriver driver, String buttonName) {
		waitForElementVisible(driver, BasePageUI.BUTTON_BY_ID, buttonName);
		clickToElement(driver, BasePageUI.BUTTON_BY_ID, buttonName);

	}

	public void enterToTextboxByIDHrm(WebDriver driver, String textboxIDName, String value) {
		waitForElementVisible(driver, BasePageUI.TEXTBOX_BY_ID, textboxIDName);
		sendToElement(driver, BasePageUI.TEXTBOX_BY_ID, value, textboxIDName);

	}

	/**
	 * Get textbox value by textboxID
	 * 
	 * @author Administrator
	 * @param driver
	 * @param textboxIDName
	 * @return attribute value
	 */
	public String getTextboxValueByID(WebDriver driver, String textboxIDName) {
		waitForElementVisible(driver, BasePageUI.TEXTBOX_BY_ID, textboxIDName);
		return getElementAttribute(driver, BasePageUI.TEXTBOX_BY_ID, "value", textboxIDName);

	}

	/**
	 * Select item in dropdown by ID
	 * 
	 * @param driver
	 * @param dropdownID
	 * @param valueItem
	 */
	public void selectItemInDropdownByID(WebDriver driver, String dropdownID, String valueItem) {
		waitForElementClickable(driver, BasePageUI.DROPDOWN_BY_ID, dropdownID);
		selectItemInDefaultDropdown(driver, BasePageUI.DROPDOWN_BY_ID, valueItem, dropdownID);
	}

	// get dropdown value
	/**
	 * Get selected text item in dropdown
	 * 
	 * @param driver
	 * @param dropdownID
	 * @param valueItem
	 * @return selected text in dropdown
	 */
	public String getSelectValueInDropdownByID(WebDriver driver, String dropdownID) {
		waitForElementVisible(driver, BasePageUI.DROPDOWN_BY_ID, dropdownID);
		return getSelectedItemDefaultDropdown(driver, BasePageUI.DROPDOWN_BY_ID, dropdownID);
	}

	public void clickToCheckboxByLabel(WebDriver driver, String checkboxByLabelName) {
		waitForElementClickable(driver, BasePageUI.CHECK_BOX_BY_LABEL, checkboxByLabelName);
		checkToDefaultCheckboxRadio(driver, BasePageUI.CHECK_BOX_BY_LABEL, checkboxByLabelName);

	}

	public void clickToRadioByLabel(WebDriver driver, String radioByLabelName) {
		waitForElementClickable(driver, BasePageUI.RADIO_BY_LABEL, radioByLabelName);
		checkToDefaultCheckboxRadio(driver, BasePageUI.RADIO_BY_LABEL, radioByLabelName);

	}

	public boolean isRadioSelected(WebDriver driver, String labelName) {
		waitForElementVisible(driver, BasePageUI.RADIO_BY_LABEL, labelName);
		
		
		return isElementSelected(driver, BasePageUI.RADIO_BY_LABEL, labelName);
		
	}
	
	public String getValueInTableIDAtColumnNameAndRowIndex(WebDriver driver, String tableID, String headerName,
			String rowIndex) {
		int columnIndex = getElementSize(driver, BasePageUI.TABLE_HEADER_BY_ID_AND_NAME, tableID, headerName) + 1;
		waitForElementVisible(driver, BasePageUI.TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX, tableID, rowIndex,
				String.valueOf(columnIndex));
		return getElementText(driver, BasePageUI.TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX, tableID, rowIndex,
				String.valueOf(columnIndex));
	}

	public LoginPageObject logoutToSystem(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.WELCOM_USER_LINK);
		clickToElement(driver, BasePageUI.WELCOM_USER_LINK);
		
		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK);
		clickToElement(driver, BasePageUI.LOGOUT_LINK);
		return PageGenerator.getLoginPage(driver);

	}
	
	//dung getgElement vì ko dung sendkey trực tiếp được
	public void upLoadImage(WebDriver driver, String filePath) {
		getElement(driver, BasePageUI.UPLOAD_FILE_IMG).sendKeys(filePath);

	}
	public boolean isSuccessMessageDisplayed (WebDriver driver, String messageValue ) {
		waitForElementVisible(driver, BasePageUI.SUCCESS_MESSAGE, messageValue);
		return isElementDisplayed(driver, BasePageUI.SUCCESS_MESSAGE, messageValue);
	}
	
	public boolean isFieldEnableByName(WebDriver driver, String fieldID ) {
		waitForElementVisible(driver, BasePageUI.ANY_FIELD_BY_ID, fieldID);
		return isElementEnabled(driver, BasePageUI.ANY_FIELD_BY_ID, fieldID);

	}
	
	private long longtimeout = 30;
	private long shorttimeout = 7;

}

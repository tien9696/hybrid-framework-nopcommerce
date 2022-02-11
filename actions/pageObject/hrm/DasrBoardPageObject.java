package pageObject.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.hrm.DashBoardPageUI;

public class DasrBoardPageObject extends BasePage{
      WebDriver driver;
	public DasrBoardPageObject(WebDriver driver) {
		this.driver =  driver;
	}
	public EmployeeListPO openEmployeeListPage() {

		waitForElementVisible(driver, DashBoardPageUI.GIP);
		clickToElement(driver, DashBoardPageUI.GIP);
		
		waitForElementVisible(driver, DashBoardPageUI.EMPLOYEE_LIST_LINK);
		clickToElement(driver, DashBoardPageUI.EMPLOYEE_LIST_LINK);
		
		
		return PageGenerator.getEmployeeListPage(driver);
	}

	
	
	
}

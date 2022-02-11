package pageObject.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.hrm.DashBoardPageUI;

public class EmployeeListPO extends BasePage{
      WebDriver driver;
	public EmployeeListPO(WebDriver driver) {
		this.driver =  driver;
	}
	public AddEmployeePO clickToAddbutton() {
		waitForElementVisible(driver, DashBoardPageUI.ADD_BUTTON);
		clickToElement(driver, DashBoardPageUI.ADD_BUTTON);
		return new AddEmployeePO(driver);
			
	}
	public void enterToEmployeeNameTextbox(String string) {
		// TODO Auto-generated method stub
		
	}
	public void clickToSearchButton() {
		// TODO Auto-generated method stub
		
	}
	public boolean isEmployeeInfoDisplayedAtTable(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}

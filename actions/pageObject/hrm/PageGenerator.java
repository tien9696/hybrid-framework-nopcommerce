package pageObject.hrm;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
	WebDriver driver;
    
	public static LoginPageObject getLoginPage(WebDriver driver) {
	return new LoginPageObject(driver);
}
	
	public static DasrBoardPageObject getDashBoardPage(WebDriver driver) {
		return new DasrBoardPageObject(driver);
	}
	public static AddEmployeePO getAddEmployeePage(WebDriver driver) {
		return new AddEmployeePO(driver);
	}
	public static EmployeeListPO getEmployeeListPage(WebDriver driver) {
		return new EmployeeListPO(driver);
	}
	public static MyInfoPO getMyInfoPage(WebDriver driver) {
		return new MyInfoPO(driver);
	}
		
	
}

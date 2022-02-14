package com.hrm.employee;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManagernopcommerce;
import pageObject.hrm.AddEmployeePO;
import pageObject.hrm.DasrBoardPageObject;
import pageObject.hrm.EmployeeListPO;
import pageObject.hrm.LoginPageObject;
import pageObject.hrm.PageGenerator;
import pageObject.hrm.MyInfoPO;
import pageObject.nopCommerce.admin.AdminDashBoardPageObject;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountPageObject;
import pageObjects.nopCommerce.user.UserOdersPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardpointsPage;
import ubilities.DataUtil;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_20_Data_Test_II_TestNG_XML extends BaseTest {

	private WebDriver driver;
	LoginPageObject loginPage;
	DasrBoardPageObject dashBoardPage;
	AddEmployeePO addEmployeePage;
	EmployeeListPO employeeListPage;
	MyInfoPO myInfoPage;
	
	String employeeID;
	String avatarFilePath = GlobalConstants.UPLOAD_FOLDER_PATH + "2.png";

	private String projectPath = System.getProperty("user.dir");

	@Parameters({"browser", "adminusername", "adminpassword" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUserName, String adminPassword ) {

		log.info("pre-condition - Step 01: open browser  " + browserName);
		driver = getBrowserDriver(browserName);
		loginPage = PageGenerator.getLoginPage(driver);

	
		log.info("Add_New_01 - step 02: Login With Admin role ");
		dashBoardPage = loginPage.loginToSystem(adminUserName, adminPassword);

	}
	//chỉ dung trong 1 TC
	@Parameters({"firstname", "lastname","username", "Password","statusValue"  ,"fullname" })

	@Test
	public void Employee_01_Add_New_Eployee(String firstName, String lastName, String userName, String Password, String statusValue, String fullName ) {

		log.info("Add_New_01 - step 01: Open Employee list page ");
		dashBoardPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage = PageGenerator.getEmployeeListPage(driver);

		log.info("Add_New_01 - step 02: Click to 'Add' button ");
		employeeListPage.clickToButtonByid(driver, "btnAdd");
		addEmployeePage = PageGenerator.getAddEmployeePage(driver);

		log.info("Add_New_01 - step 03: Enter valid info to 'First Name' Textbox ");
		addEmployeePage.enterToTextboxByIDHrm(driver, "firstName", firstName);

		log.info("Add_New_01 - step 04: Enter valid info to 'Last Name' Text box ");
		addEmployeePage.enterToTextboxByIDHrm(driver, "lastName", lastName);

		log.info("Add_New_01 - step 05: Get value of 'Employee ID'");
		employeeID = addEmployeePage.getTextboxValueByID(driver, "employeeId");

		log.info("Add_New_01 - step 06: Click To 'Create Login Details' checkbox ");
		addEmployeePage.clickToCheckboxByLabel(driver, "Create Login Details");

		log.info("Add_New_01 - step 07: Enter valid info to 'User Name' Text box ");
		addEmployeePage.enterToTextboxByIDHrm(driver, "user_name", userName);

		log.info("Add_New_01 - step 08: Enter valid info to  'Password' Text box ");
		addEmployeePage.enterToTextboxByIDHrm(driver, "user_password", Password);

		log.info("Add_New_01 - step 09: Enter valid info to 'Confirm Password' Text box ");
		addEmployeePage.enterToTextboxByIDHrm(driver, "re_password", Password);

		log.info("Add_New_01 - step 10: Select '" + statusValue + "' value in 'status' dropdown ");
		addEmployeePage.selectValueInStatusDropdown(statusValue);

		log.info("Add_New_01 - step 11: Click To 'Save' button ");
		addEmployeePage.clickToButtonByid(driver, "btnSave");
		myInfoPage = PageGenerator.getMyInfoPage(driver);

		log.info("Add_New_01 - step 12: Open Employee list page ");
		myInfoPage.openSubMenuPage(driver, "Employee List", "PIM");
		employeeListPage = PageGenerator.getEmployeeListPage(driver);
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));

		log.info("Add_New_01 - step 13: Enter valid info to 'Employee Name' Text box ");
		employeeListPage.enterToTextboxByIDHrm(driver, "empsearch_employee_name_empName", fullName);
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));

		log.info("Add_New_01 - step 14: Click To 'Search' button ");
		employeeListPage.clickToButtonByid(driver, "searchBtn");
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		log.info("Add_New_01 - step 15: Verify Employee Infomation display at 'Result Table'");

		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Last Name", "1"),
				lastName);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Id", "1"),
				employeeID);

	}
	@Parameters({"username", "Password"})

	@Test
	public void Employee_02_Upload_Avatar( String userName, String Password) {

		loginPage = employeeListPage.logoutToSystem(driver);
		log.info("Upload_Avatar_01 - step 01: Login  ");

		dashBoardPage = loginPage.loginToSystem(userName, Password);
		log.info("Upload_Avatar_01 - step 02: open Personal Details page  ");

		dashBoardPage.openMenuPage(driver, "My Info");
		myInfoPage = PageGenerator.getMyInfoPage(driver);
		log.info("Upload_Avatar_01 - step 03: click To change photo Image  ");
		myInfoPage.clickToChangeToPhotoImage();

		log.info("Upload_Avatar_01 - step 04: upload new avatar Image  ");
		myInfoPage.upLoadImage(driver, avatarFilePath);

		log.info("Upload_Avatar_01 - step 05: click To upload button ");
		myInfoPage.clickToButtonByid(driver, "btnSave");

		log.info("Upload_Avatar_01 - step 06: Success message is displayed  ");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Uploaded"));

		log.info("Upload_Avatar_01 - step 07: verify new avatar image is displayed  ");
		verifyTrue(myInfoPage.isNewAvatarImageDisplayed());

	}
	@Parameters({ "editfirstname", "editlastname", "editgender", "editstatus", "editnational" })

	@Test
	public void Employee_03_Edit_Personal_Detail( String editEmployeeFirstName, String editEmployeeLastName, String editEmployeeGender, String editEmpMaritalStatus, String editNationality) {
		log.info("Edit_Personal_Detail_03 - step 01: open personal details at sidebar");
		myInfoPage.openTabAtSidebarByName("Personal Details");

		log.info("Edit_Personal_Detail_03 - step 02: verify all field at personal tab at Sidebar disable ");
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_txtEmpFirstName"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_txtEmpLastName"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_txtEmployeeId"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_txtLicenNo"));
		
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_txtOtherID"));

		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_optGender_1"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_optGender_2"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_cmbMarital"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_cmbNation"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_DOB"));

		log.info("Edit_Personal_Detail_03 - step 03: click to 'edit' button at 'personal details' form");
		myInfoPage.clickToButtonByid(driver, "btnSave");

		log.info("Edit_Personal_Detail_03 - step 04: verify 'Employee Id' textbox is disable ");
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_txtEmployeeId"));

		log.info("Edit_Personal_Detail_03 - step 05: verify ' Driver' textbox is disable ");
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_txtLicenNo"));

		log.info("Edit_Personal_Detail_03 - step 06: verify 'SSN' textbox is disable ");
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_txtNICNo"));

		log.info("Edit_Personal_Detail_03 - step 07: verify 'SIN' textbox is disable ");
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_txtSINNo"));

		log.info("Edit_Personal_Detail_03 - step 08: verify 'Date of Birth' textbox is disable ");
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_DOB"));

		log.info("Edit_Personal_Detail_03 - step 09: enter new value to 'First name ' textbox ");
		myInfoPage.enterToTextboxByID(driver, "personal_txtEmpFirstName", editEmployeeFirstName);

		log.info("Edit_Personal_Detail_03 - step 10: enter new value to 'Last name ' textbox ");
		myInfoPage.enterToTextboxByID(driver, "personal_txtEmpLastName", editEmployeeLastName);

		log.info("Edit_Personal_Detail_03 - step 11: select new value to ' Gender ' radio button ");
		myInfoPage.clickToRadioByLabel(driver, editEmployeeGender);
		log.info("Edit_Personal_Detail_03 - step 12: select new value to 'Marital status ' dropdown ");
		myInfoPage.selectItemInDropdownByID(driver, "personal_cmbMarital", editEmpMaritalStatus);

		log.info("Edit_Personal_Detail_03 - step 13: select new value to 'Nationality' dropdown ");
		myInfoPage.selectItemInDropdownByID(driver, "personal_cmbNation", editNationality);

		log.info("Edit_Personal_Detail_03 - step 14: click 'Save' button at 'Personal Details' ");
		myInfoPage.clickToButtonByid(driver, "btnSave");

		log.info("Edit_Personal_Detail_03 - step 15: verify message success displayed ");
		
		//verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Saved"));

		log.info("Edit_Personal_Detail_03 - step 16: verify 'First name' textbox is upfated success ");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "personal_txtEmpFirstName"), editEmployeeFirstName);

		log.info("Edit_Personal_Detail_03 - step 17: verify 'Last name' textbox is upfated success ");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "personal_txtEmpLastName"), editEmployeeLastName);

		log.info("Edit_Personal_Detail_03 - step 18: verify 'Gender' radio button  is upfated success ");
		verifyTrue(myInfoPage.isRadioSelected(driver, editEmployeeGender));

		log.info("Edit_Personal_Detail_03 - step 19: verify 'Marital status' dropdown is upfated success ");
		verifyEquals(myInfoPage.getSelectValueInDropdownByID(driver, "personal_cmbMarital"), editEmpMaritalStatus);

		log.info("Edit_Personal_Detail_03 - step 20: verify 'Nationality' dropdown is upfated success ");
		verifyEquals(myInfoPage.getSelectValueInDropdownByID(driver, "personal_cmbNation"), editNationality);

		log.info("Edit_Personal_Detail_03 - step 21: verify 'Employee id' is correct ");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "personal_txtEmployeeId"), employeeID);

	}
	
	public void Employee_04_Contact_Personal_Detail() {
		log.info("Edit_Personal_Detail_03 - step 01: open personal details at sidebar");
		myInfoPage.openTabAtSidebarByName("Contact Details");

		log.info("Edit_Personal_Detail_03 - step 02: verify all field at personal tab at Sidebar disable ");
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "contact_street1"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "contact_street2"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "contact_city"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "contact_province"));
		
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "contact_country"));
		//verifyFalse(myInfoPage.isFieldEnableByName(driver, "personal_txtSINNo"));

		verifyFalse(myInfoPage.isFieldEnableByName(driver, "contact_emp_hm_telephone"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "contact_emp_mobile"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "contact_emp_work_telephone"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "contact_emp_work_email"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver, "contact_emp_oth_email"));

		log.info("Edit_Personal_Detail_03 - step 03: click to 'edit' button at 'contact personal details' form");
		myInfoPage.clickToButtonByid(driver, "btnSave");
		
		
		
		
		log.info("Edit_Personal_Detail_03 - step 09: enter new value to 'contact_street1' textbox ");
		myInfoPage.enterToTextboxByID(driver, "contact_street1", "Duy Thu");

		log.info("Edit_Personal_Detail_03 - step 10: enter new value to 'contact_street2' textbox ");
		myInfoPage.enterToTextboxByID(driver, "contact_street2", "Phu Da");
		
		log.info("Edit_Personal_Detail_03 - step 09: enter new value to 'contact_city' textbox ");
		myInfoPage.enterToTextboxByID(driver, "contact_city", "Quang");

		log.info("Edit_Personal_Detail_03 - step 10: enter new value to 'contact_province' textbox ");
		myInfoPage.enterToTextboxByID(driver, "contact_province", "Da Nang");
		
		log.info("Edit_Personal_Detail_03 - step 09: enter new value to 'contact_emp_hm_telephone' textbox ");
		myInfoPage.enterToTextboxByID(driver, "contact_emp_hm_telephone", "0121463381");

		log.info("Edit_Personal_Detail_03 - step 10: enter new value to 'contact_emp_mobile' textbox ");
		myInfoPage.enterToTextboxByID(driver, "contact_emp_mobile", "0956432123");
		
		log.info("Edit_Personal_Detail_03 - step 09: enter new value to 'contact_emp_work_telephone' textbox ");
		myInfoPage.enterToTextboxByID(driver, "contact_emp_work_telephone", "05113212121");

		log.info("Edit_Personal_Detail_03 - step 10: enter new value to 'contact_emp_work_email' textbox ");
		myInfoPage.enterToTextboxByID(driver, "contact_emp_work_email", "Sisi@gmail.com");
		
		log.info("Edit_Personal_Detail_03 - step 10: enter new value to 'contact_emp_oth_email' textbox ");
		myInfoPage.enterToTextboxByID(driver, "contact_emp_oth_email", "Susi@gmail.com");
		
		
		log.info("Edit_Personal_Detail_03 - step 13: select new value to 'contact_country' dropdown ");
		myInfoPage.selectItemInDropdownByID(driver, "contact_country", "Albania");

		log.info("Edit_Personal_Detail_03 - step 14: click 'Save' button at 'contact personal Details' ");
		myInfoPage.clickToButtonByid(driver, "btnSave");

	}

	@Test
	public void Employee_05_Emergency_Personal_Detail() {

	}

	@Test
	public void Employee_06_Assigned_Dependents() {

	}

	@Test
	public void Employee_07_Edit_View_Job() {

	}

	@Test
	public void Employee_08_Edit_View_Salary() {

	}

	@Test
	public void Employee_09_Edit_View_Tax() {

	}

	@Test
	public void Employee_10_Qualification() {

	}

	@Test
	public void Employee_11_Search_Employee() {

	}

	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("post-conditon : close browser");
		driver.quit();
		cleanDriverInstance();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}

package pageUI.hrm;

public class BasePageUI {
	public static final String DYNAMIC_MENU_PAGE_BY_NAME = "xpath=//div[@id='mainMenu']//a[string()='%s']";
	public static final String BUTTON_BY_ID = "xpath=//input[@id='%s']";
	public static final String TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DROPDOWN_BY_ID = "xpath=//select[@id='%s']";
	public static final String CHECK_BOX_BY_LABEL = "xpath=//label[text()='%s']//following-sibling::input";
	public static final String RADIO_BY_LABEL = "xpath=//label[text()='%s']//preceding-sibling::input";
	public static final String TABLE_HEADER_BY_ID_AND_NAME = "xpath=//table[@id='%s']//th[string()='%s']/preceding-sibling::th";
	public static final String TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//table[@id='%s']/tbody/tr[%s]/td[%s]";
	public static final String WELCOM_USER_LINK = "xpath=//a[@id='welcome']";
	// a[text()='Logout']
	public static final String UPLOAD_FILE_IMG = "xpath=//input[@type='file']";

	public static final String LOGOUT_LINK = "xpath=//a[text()='Logout']";
	// div[contains(text(),'Successfully Uploaded')]

	public static final String SUCCESS_MESSAGE = "xpath=//div[contains(text(),'%s')]";
	public static final String ANY_FIELD_BY_ID = "xpath=//*[@id='%s']";

}

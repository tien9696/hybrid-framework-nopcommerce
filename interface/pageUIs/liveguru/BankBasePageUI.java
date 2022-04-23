package pageUIs.liveguru;

public class BankBasePageUI {
	//Textbox
	public static final String DYNAMIC_TEXTBOX = "xpath=//input[@name='$s']";
	
	//textarea
	public static final String DYNAMIC_TEXTAREA = "xpath=//textarea[@name='$s']";
	
	//Radiobutton
	public static final String DYNAMIC_RADIOBUTTON = "xpath=//input[@type='radio' and @value= '%s']";
	
	//MenuLink
	public static final String DYNAMIC_LINK = "xpath=//a[text()='%s']";
	
	//Button
	public static final String DYNAMIC_BUTTON = "xpath=//input[@value='%s']";
	
	//Message
	public static final String DYNAMIC_MESSAGE = "xpath=//p[@class='heading3' and text()='%s']";
	
	//Column value
	public static final String DYNAMIC_VALUE_BY_COLUMN_NAME = "xpath=//td[contains(text(),'%s')]//following-sibling::td";

}

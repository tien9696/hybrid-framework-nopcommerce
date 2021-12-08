package pageFactory.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.nopcommerce.User.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}	
	@FindBy(id="FirstName")
	private WebElement firtnameTextbox;
   
	@FindBy(id="LastName")
	private WebElement lastnameTextbox;
   
	@FindBy(id="Email")
	private WebElement emailTextbox;
   
	@FindBy(id="Password")
	private WebElement passwordTextbox;
   
	@FindBy(id="ConfirmPassword")
	private WebElement confirmPasswordTextbox;
   
	@FindBy(xpath="//button[@id='register-button']")
	private WebElement registerButton;
   
	@FindBy(xpath="//span[@id='FirstName-error']")
	private WebElement firstnameErrorMessage;
   
	@FindBy(xpath="//span[@id='LastName-error']")
	private WebElement lastnameErrorMessage;
   
	@FindBy(xpath="//span[@id='Email-error']")
	private WebElement emailErrorMessage;
   
	@FindBy(xpath="//span[@id='Password-error']")
	private WebElement passwordErrorMessage;
   
	@FindBy(xpath="//span[@id='ConfirmPassword-error']")
	private WebElement confirmpasswordErrorMessage;
   
	@FindBy(xpath="//div[@class='result']")
	private WebElement registerSuccessMessage;
   
	@FindBy(xpath="//a[@class='ico-logout']")
	private WebElement logoutLink;
   
	@FindBy(xpath="//div[contains(@class,'message-error')]//li")
	private WebElement existingEmailErrorMessage;
   
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);

	}
        public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, firstnameErrorMessage);
		return getWebElementText(driver, firstnameErrorMessage);
	}

	public String getErrorMessageAtLasttnameTextbox() {
		waitForElementVisible(driver, lastnameErrorMessage);
		return getWebElementText(driver, lastnameErrorMessage);
			
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getWebElementText(driver, emailErrorMessage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getWebElementText(driver, passwordErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmpasswordErrorMessage);
		return getWebElementText(driver, confirmpasswordErrorMessage);
	}

	public void inputToFirstnameTextbox(String firstName) {

		waitForElementVisible(driver, firtnameTextbox);
		sendToElement(driver, firtnameTextbox, firstName);

	}

	public void inputToLasttnameTextbox(String lastName) {
		waitForElementVisible(driver, lastnameTextbox);
		sendToElement(driver, lastnameTextbox, lastName);

	}

	public void inputToConfirmPasswordTextbox(String ConfirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendToElement(driver, confirmPasswordTextbox, ConfirmPassword);

	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		sendToElement(driver, emailTextbox, emailAddress);

	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendToElement(driver, passwordTextbox, password);

	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getWebElementText(driver, registerSuccessMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);

	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, existingEmailErrorMessage);
		return getWebElementText(driver, existingEmailErrorMessage);
	}

	
	
	
}

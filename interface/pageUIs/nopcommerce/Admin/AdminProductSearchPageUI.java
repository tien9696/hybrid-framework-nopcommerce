package pageUIs.nopcommerce.Admin;

public class AdminProductSearchPageUI {

	public static final String PRODUCT_SEARCH_TEXTBOX = "xpath=//input[@id='SearchProductName']";
	public static final String PRODUCT_SEARCH_BUTTON = "xpath=//button[@id='search-products']";
	public static final String PRODUCT_EDIT_BUTTON = "xpath=//td[text()='%s']//following-sibling::td//a";
	public static final String SUCCESS_MESSAGE = "xpath=//div[contains(@class,'alert alert') and contains(string(),'%s')]";

	public static final String PRODUCT_IMAGE_BY_PRODUCT_NAME = "xpath=//td[text()='%s']//preceding-sibling::td//img[contains(@src,'%s')]";




}

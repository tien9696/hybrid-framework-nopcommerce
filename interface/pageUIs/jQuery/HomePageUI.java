package pageUIs.jQuery;

public class HomePageUI {

	public static final String PAGE_BY_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link' and text() = '%s']";
	public static final String PAGE_BY_NUMBER_ATIVE = "xpath=//a[@class='qgrd-pagination-page-link active' and text() = '%s']";
    public static final String SEARCH_TEXTBOX = "xpath=//div[@class='qgrd-header-text-wrap']//div[text()='%s']//parent::div//following-sibling::input";
    public static final String ICON_BY_COUNTRY_NAME = "xpath=//td[@data-key='country' and text()='%s']//preceding-sibling::td//button[@class='qgrd-%s-row-btn']";
 
    public static final String TEXTBOX_BY_COLUM_ROW = "xpath=//input[@id='tblAppendGrid_%s_%s']";
	public static final String HEADER_NAME_INDEX = "xpath=//th[text()='%s']//preceding-sibling::th";


    public static final String TEXTBOX_BY_COLUM_ROW_INDEX = "xpath=//tr[%s]/td[%s]/input";
   
    public static final String BUTTON_ACTION_BY_ROW_INDEX = "xpath=//tr[@id][%s]//button[@title='%s']";

}

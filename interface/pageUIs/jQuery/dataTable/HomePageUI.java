package pageUIs.jQuery.dataTable;

public class HomePageUI {

	public static final String PAGE_BY_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link' and text() = '%s']";
	public static final String PAGE_BY_NUMBER_ATIVE = "xpath=//a[@class='qgrd-pagination-page-link active' and text() = '%s']";
	public static final String SEARCH_TEXTBOX = "xpath=//div[@class='qgrd-header-text-wrap']//div[text()='%s']//parent::div//following-sibling::input";
	public static final String ICON_BY_COUNTRY_NAME = "xpath=//td[@data-key='country' and text()='%s']//preceding-sibling::td//button[@class='qgrd-%s-row-btn']";

	public static final String TEXTBOX_BY_COLUM_ROW = "xpath=//input[@id='tblAppendGrid_%s_%s']";
	public static final String HEADER_NAME_INDEX = "xpath=//th[text()='%s']//preceding-sibling::th";

	public static final String TEXTBOX_BY_COLUM_ROW_INDEX = "xpath=//tr[%s]/td[%s]/input";

	public static final String BUTTON_ACTION_BY_ROW_INDEX = "xpath=//tr[@id][%s]//button[@title='%s']";
	public static final String TOTAL_PAGINATION = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page']";
	public static final String PAGINATION_PAGE_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody//tr";
	public static final String ALL_ROW_COUNTRY_EACH_PAGE = "xpath=//tbody//td[@data-key='country']";

	
	
	
	//index của cái cột mà mình cần enter vào
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/td[text()='%s']//preceding-sibling::td";

		public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
		public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input[@type='checkbox']";

			public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/select";
			public static final String LOAD_BUTTON = "xpath=//button[@id='btnLoad']";

}

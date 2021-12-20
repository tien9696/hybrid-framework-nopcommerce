package pageUIs.nopcommerce.Admin;

public class AdminBasePageUI {
	//ul[@role='menu']//a[@class='nav-link active']//p[contains(text(),'Catalog')]
	
	public static final String MENU_LINK_BY_NAME = "xpath=//ul[@role='menu']//li//a//p[contains(text(),'%s')]";

	public static final String SUB_MENU_LINK_BY_NAME = "xpath=//ul[@class='nav nav-treeview' and @style]//p[contains(text(),'%s')]";

	public static final String UPLOAD_FILE_BY_CARD_NAME = "xpath=//div[@id='product-%s']//input[@type='file']";
	public static final String NO_DATA_MESSGE_BY_TABLE_NAME = "xpath=//table[@id='%s-grid']//td[@class='dataTables_empty' and text()='No data available in table']";

}

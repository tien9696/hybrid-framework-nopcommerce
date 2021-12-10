package javaBasic;

public class Topic_14_String_Format {
	public static  String ADDRESS_LINK = "//div[@class='listbox']//a[text()='Addresses']";
	public static  String ODERS_LINK = "//div[@class='listbox']//a[text()='Orders']";
	public static  String REWARD_POINTS_LINK = "//div[@class='listbox']//a[text()='Reward points']";
	
	
	public static String DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME = "//div[@class='listbox']//a[text()='%s']";
	
	public static String DYNAMIC_LINK_BY_PAGE_NAME = "//div[@class='%s']//a[text()='%s']";

	public static void main (String [] args) {
		clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Addresses" );
		clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Orders" );
		clickToLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Reward points" );

		
		
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "listbox", "Orders" );
	}
	
	public static void clickToLink(String locator) {
		System.out.println("click to: " + locator);
	}
	//1 tham so dong
	public static void clickToLink(String dynamicLocator, String pageName) {
		String locator = String.format(dynamicLocator, pageName);
		System.out.println("click to: " + locator);
	}
	//2 tham so dong
	public static void clickToLink(String dynamicLocator, String areaName, String pageName) {
		String locator = String.format(dynamicLocator, areaName, pageName);
		System.out.println("click to: " + locator);

	}
	//n tham so dong
	public static void clickToLink(String dynamicLocator, String... params) {
		String locator = String.format(dynamicLocator, (Object[]) params );
		System.out.println("click to: " + locator);

	}
}

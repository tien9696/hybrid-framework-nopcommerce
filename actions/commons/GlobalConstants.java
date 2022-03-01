package commons;

import java.io.File;

public class GlobalConstants {

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "upLoadFiles" + File.separator ;
	public static final String DOWNLOAD_FOLDER_PATH =  PROJECT_PATH + File.separator + "downLoadFiles";

			
	public static final String POTAL_PAGE_URL = "https://demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
	public static final String REGISTER_FACEBOOK = "https://www.facebook.com/reg/";
public static final String UPLOAD_FILE = "https://blueimp.github.io/jQuery-File-Upload/";
public static final String HRM = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";

	public static final String SAUCELAB = "https://www.saucedemo.com/";
	public static final String BANK_GURU = "http://demo.guru99.com/v4/";

	
	public static final String BROWSER_USERNAME = "cmtin_5iy16h";
	public static final String BROWSER_AUTOMATE_KEY = "RWcsaxzK99x8rsL3xoij";
	public static final String BROWSER_STACK_URL = "https://" + BROWSER_USERNAME + ":" + BROWSER_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	   //  "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	
	public static final String SAUCELABS_USERNAME = "oauth-tiencam9696-d5474";
	public static final String SAUCESlAB_AUTOMATE_KEY = "537e4596-f5d3-48f5-ba3a-94c7a2896e53";
	public static final String SAUCESLABS_URL = "https://" + BROWSER_USERNAME + ":" + BROWSER_AUTOMATE_KEY + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	
	
}

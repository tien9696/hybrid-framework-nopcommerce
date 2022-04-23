package commons;

import java.io.File;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GlobalConstants {
	private static GlobalConstants gLobaLInstance;

	private GlobalConstants() {

	}

	public static synchronized GlobalConstants getGlobalConstants() {
		if (gLobaLInstance == null) {
			gLobaLInstance = new GlobalConstants();
		}
		return gLobaLInstance;
	}

	private final String projectPath = System.getProperty("user.dir");
	private final String uploadFolderPath = projectPath + File.separator + "upLoadFiles" + File.separator;
	private final String DOWNLOAD_FOLDER_PATH = projectPath + File.separator + "downLoadFiles";

	private final String potalPageUrl = "https://demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
	private final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
	private final String REGISTER_FACEBOOK = "https://www.facebook.com/reg/";
	private final String UPLOAD_FILE = "https://blueimp.github.io/jQuery-File-Upload/";
	private final String hrm = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";

	private final String SAUCELAB = "https://www.saucedemo.com/";
	private final String BANK_GURU = "http://demo.guru99.com/v4/";

	
	//
	private final String browserUserName = "cmtin_5iy16h";
	private final String browserAutomationKey = "RWcsaxzK99x8rsL3xoij";
	private final String BROWSER_STACK_URL = "https://" + browserUserName + ":" + browserAutomationKey
			+ "@hub-cloud.browserstack.com/wd/hub";
	// "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY +
	// "@hub-cloud.browserstack.com/wd/hub";

	private final String SAUCELABS_USERNAME = "oauth-tiencam9696-d5474";
	private final String SAUCESlAB_AUTOMATE_KEY = "537e4596-f5d3-48f5-ba3a-94c7a2896e53";
	private final String SAUCESLABS_URL = "https://" + browserUserName + ":" + browserAutomationKey
			+ "@ondemand.us-west-1.saucelabs.com:443/wd/hub";

}

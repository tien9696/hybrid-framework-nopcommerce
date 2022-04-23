package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager implements browserFactory {

	@Override
	public WebDriver getBrowserDriver() {

		WebDriverManager.firefoxdriver().setup();
		// browser tiếng viet
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("intl.accept_languages", "vi,en-us,en");
		// ko show warning
//		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
//		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
//				GlobalConstants.PROJECT_PATH + File.separator + "browserLogs" + File.separator + "Firefox.log" );
//			driver = new FirefoxDriver();

			return new FirefoxDriver(options);
	}

}

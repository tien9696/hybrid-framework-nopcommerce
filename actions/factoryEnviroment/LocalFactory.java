package factoryEnviroment;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalFactory {
	private WebDriver driver;
	private String browserName;

	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}
	
	public WebDriver createDriver() {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		if (browserList == BrowserList.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			// browser tiếng viet
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("intl.accept_languages", "vi,en-us,en");
			driver = new FirefoxDriver(options);
			// ko show warning
//			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
//			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
//					GlobalConstants.PROJECT_PATH + File.separator + "browserLogs" + File.separator + "Firefox.log" );
//				driver = new FirefoxDriver();

		} else if (browserList == BrowserList.CHROME) {
//			WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--lang=vi");
//			driver = new ChromeDriver(options);
//		

			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addExtensions(new File(GlobalConstants.PROJECT_PATH + "\\browserExtensions\\Ultrasurf_1_6_6_0.crx"));

			driver = new ChromeDriver(options);

		} else if (browserList == BrowserList.IE) {
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();

		} else if (browserList == BrowserList.EDGE) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browserList == BrowserList.COCCOC) {
			WebDriverManager.chromedriver().driverVersion("97.0.4692.71").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");

			driver = new ChromeDriver(options);

		} else if (browserList == BrowserList.SAFARI) {
			driver = new SafariDriver();

		} else {
			throw new RuntimeException("Browser name invalid");
		}
		return driver;

	}
}

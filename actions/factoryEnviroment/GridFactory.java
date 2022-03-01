package factoryEnviroment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GridFactory {
	private WebDriver driver;
	private String browserName;
	private String ipAddress;
	private String portNumber;

	public GridFactory(String browserName, String ipAddress, String portNumber) {
		this.browserName = browserName;
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;

	}
public WebDriver createDriver() {
	BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
	DesiredCapabilities capability = null;

	if (browserList == BrowserList.FIREFOX) {
		WebDriverManager.firefoxdriver().setup();
		capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.WINDOWS);
		FirefoxOptions options = new FirefoxOptions();
		options.merge(capability);

	} else if (browserList == BrowserList.CHROME) {
		WebDriverManager.chromedriver().setup();
		capability = DesiredCapabilities.chrome();
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WINDOWS);
		ChromeOptions options = new ChromeOptions();
		options.merge(capability);
	} else if (browserList == BrowserList.EDGE) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

	} else {
		throw new RuntimeException("Browser name invalid");
	}

	try {
		driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)),
				capability);
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}

	return driver;
	
}
}

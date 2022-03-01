package factoryEnviroment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class saucelabsFactory {
	private WebDriver driver;
	private String browserName;
	private String osName;
	public saucelabsFactory(String browserName, String osName) {
		
		this.osName = osName;
		this.browserName = browserName;

	}
	public WebDriver createDriver() {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platformName", osName);
		capability.setCapability("browserName", browserName);
		capability.setCapability("browserVersion", "latest");

		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("screenResolution", "1920x1440");

		capability.setCapability("sauce:options", sauceOptions);

		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.SAUCESLABS_URL), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return driver;
	}

}

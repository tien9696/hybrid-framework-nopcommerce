package factoryEnviroment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class browserStackFactory {
	private WebDriver driver;

	private String browserName;
	private String osName;
	private String osVersion;
	public browserStackFactory(String browserName, String osName, String osVersion) {
	
		this.browserName = browserName;
		this.osName = osName;
		this.osVersion = osVersion;
	}

	
	public WebDriver createDriver() {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("os", osName);
		capability.setCapability("os_version", browserName);
		capability.setCapability("browser_version", "latest");
		capability.setCapability("browserctack.debug", "true");
		capability.setCapability("project", "Hrm");
		capability.setCapability("resolution", "1920x1080");

		capability.setCapability("name", "Run on" + osName + " | " + osVersion + " | " + browserName);

		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_STACK_URL), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		
		return driver;
	}
}

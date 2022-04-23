package factoryBrowser;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager implements browserFactory {

	@Override
	public WebDriver getBrowserDriver() {

//		WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--lang=vi");
//		driver = new ChromeDriver(options);
//	

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-infobars");
		options.addExtensions(new File(GlobalConstants.getGlobalConstants().getProjectPath() + "\\browserExtensions\\Ultrasurf_1_6_6_0.crx"));


	
		return new ChromeDriver(options);
	}

}

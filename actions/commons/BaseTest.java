package commons;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import factoryEnviroment.BrowserList;
import factoryEnviroment.GridFactory;
import factoryEnviroment.LocalFactory;
import factoryEnviroment.browserStackFactory;
import factoryEnviroment.saucelabsFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public enum ENVIROMENT {
		DEV, TEST, STATGING, PRODUCT
	}

	private WebDriver driverBaseTest;

	protected final Log log;

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	protected WebDriver getBrowserDriver(String browserName, String severName, String envName, String ipAddress, String portNumber, String osName, String osVersion) {
		switch (envName) {
		case "local":
			driverBaseTest = new LocalFactory(browserName).createDriver();
			break;
		case "grid":
			driverBaseTest = new GridFactory(browserName, ipAddress, portNumber).createDriver();

			break;
		case "browserStack":
			driverBaseTest = new browserStackFactory(browserName, osName, osVersion).createDriver();

			break;
		case "saucelabs":
			driverBaseTest = new saucelabsFactory(browserName, osName).createDriver();

			break;

		default:
			driverBaseTest = new LocalFactory(browserName).createDriver();

			break;
		}
		driverBaseTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driverBaseTest.get(getEnviromentValuee(severName));
		

		
		return driverBaseTest;
	}
	
	
	
	protected WebDriver getBrowserDriver(String browserName, String severName, String envName, String osName, String osVersion) {
		switch (envName) {
		case "local":
			driverBaseTest = new LocalFactory(browserName).createDriver();
			break;
		
		case "browserStack":
			driverBaseTest = new browserStackFactory(browserName, osName, osVersion).createDriver();

			break;
		case "saucelabs":
			driverBaseTest = new saucelabsFactory(browserName, osName).createDriver();

			break;

		default:
			driverBaseTest = new LocalFactory(browserName).createDriver();

			break;
		}
		driverBaseTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driverBaseTest.get(getEnviromentValuee(severName));
		

		
		return driverBaseTest;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String severName, String envName, String osName) {
		switch (envName) {
		case "local":
			driverBaseTest = new LocalFactory(browserName).createDriver();
			break;
		
		
		case "saucelabs":
			driverBaseTest = new saucelabsFactory(browserName, osName).createDriver();

			break;

		default:
			driverBaseTest = new LocalFactory(browserName).createDriver();

			break;
		}
		driverBaseTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driverBaseTest.get(getEnviromentValuee(severName));
		

		
		return driverBaseTest;
	}
	
	private String projectPath = System.getProperty("user.dir");


	public WebDriver getBrowserDriver(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		if (browserList == BrowserList.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driverBaseTest = new FirefoxDriver();
		} else if (browserList == BrowserList.CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			// options.addExtensions(new File(projectPath +
			// "\\browserExtensions\\Ultrasurf_1_6_6_0.crx"));
			driverBaseTest = new ChromeDriver(options);
		} else if (browserList == BrowserList.EDGE) {
			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();

		} else {
			throw new RuntimeException("Browser name invalid");
		}
		driverBaseTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driverBaseTest.get(GlobalConstants.getGlobalConstants().getPotalPageUrl());
		
		return driverBaseTest;
	}


	


	private String getEnviromentValue(String severName) {
		String envURL = null;
		ENVIROMENT enviroment = ENVIROMENT.valueOf(severName.toUpperCase());
		if (enviroment == ENVIROMENT.DEV) {
			envURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		} else if (enviroment == ENVIROMENT.TEST) {
			envURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		} else if (severName.equalsIgnoreCase("staging")) {
			envURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		} else if (severName.equalsIgnoreCase("production")) {
			envURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		}

		return envURL;
	}

	// c2
	private String getEnviromentValuee(String enviromentName) {
		String enrURL = null;
		if (enviromentName.equalsIgnoreCase("dev")) {
			enrURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		} else if (enviromentName.equalsIgnoreCase("test")) {
			enrURL = "http://demo.guru99.com/v2/";

		} else if (enviromentName.equalsIgnoreCase("staging")) {
			enrURL = "http://demo.guru99.com/v3/";

		}
		return enrURL;

	}

	public WebDriver getWebDriver() {
		return this.driverBaseTest;
	}

	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				System.out.println(" -------------------------- PASSED -------------------------- ");
			} else {
				System.out.println(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				System.out.println(" -------------------------- PASSED -------------------------- ");
			} else {
				System.out.println(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	@BeforeTest
	public void deleteAllFilesInReportNGScreenshot() {
		System.out.println("---------- START delete file in folder ----------");
		try {
			String workingDir = System.getProperty("user.dir");
			String pathFolderDownload = workingDir + "//screenshotReportNG//";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println(listOfFiles[i].getName());
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		System.out.println("---------- END delete file in folder ----------");

	}

	protected void cleanDriverInstance() {
		String cmd = "";
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driverBaseTest.toString().toLowerCase();
			log.info("Driver instance name = " + osName);

			if (driverInstanceName.contains("chrome")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				} else {
					cmd = "pkill chromedriver";
				}
			} else if (driverInstanceName.contains("internetexplorer")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driverInstanceName.contains("firefox")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				} else {
					cmd = "pkill geckodriver";
				}
			} else if (driverInstanceName.contains("edge")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				} else {
					cmd = "pkill msedgedriver";
				}
			} else if (driverInstanceName.contains("opera")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
				} else {
					cmd = "pkill operadriver";
				}
			} else if (driverInstanceName.contains("safari")) {
				if (osName.contains("mac")) {
					cmd = "pkill safaridriver";
				}
			}

			if (driverBaseTest != null) {
				driverBaseTest.manage().deleteAllCookies();
				driverBaseTest.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected void showBrowserConcoleLogs(WebDriver driver) {
		if (driverBaseTest.toString().contains("chrome")) {
			LogEntries logs = driver.manage().logs().get("browser");
			List<LogEntry> logList = logs.getAll();
			for (LogEntry logging : logList) {
				System.out
						.println("--------" + logging.getLevel().toString() + "------------\n" + logging.getMessage());
			}
		}

	}
}

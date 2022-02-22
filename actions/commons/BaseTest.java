package commons;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import javaOOP.BrowserList;

public class BaseTest {
	public enum ENVIROMENT {
		DEV, TEST, STATGING, PRODUCT
	}
	private WebDriver driverBaseTest;

	protected final Log log;

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	private String projectPath = System.getProperty("user.dir");

	public WebDriver getBrowserDriver(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		if (browserList == BrowserList.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			// browser tiếng viet
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("intl.accept_languages", "vi,en-us,en");
			driverBaseTest = new FirefoxDriver(options);
			// ko show warning
//			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
//			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
//					GlobalConstants.PROJECT_PATH + File.separator + "browserLogs" + File.separator + "Firefox.log" );
//				driverBaseTest = new FirefoxDriver();

		} else if (browserList == BrowserList.CHROME) {
//			WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--lang=vi");
//			driverBaseTest = new ChromeDriver(options);
//		

			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addExtensions(new File(projectPath + "\\browserExtensions\\Ultrasurf_1_6_6_0.crx"));

			driverBaseTest = new ChromeDriver(options);

		} else if (browserList == BrowserList.IE) {
			WebDriverManager.iedriver().arch32().setup();
			driverBaseTest = new InternetExplorerDriver();

		} else if (browserList == BrowserList.EDGE) {
			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();

		} else if (browserList == BrowserList.COCCOC) {
			WebDriverManager.chromedriver().driverVersion("97.0.4692.71").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");

			driverBaseTest = new ChromeDriver(options);

		} else if (browserList == BrowserList.SAFARI) {
			driverBaseTest = new SafariDriver();

		} else {
			throw new RuntimeException("Browser name invalid");
		}
		driverBaseTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driverBaseTest.get("http://demo.guru99.com/v4/");

       //driverBaseTest.get(GlobalConstants.BANK_GURU);

		return driverBaseTest;
	}

	public WebDriver getBrowserDriver(String browserName, String appUrl) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		if (browserList == BrowserList.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driverBaseTest = new FirefoxDriver();
		} else if (browserList == BrowserList.CHROME) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			//options.addExtensions(new File(projectPath + "\\browserExtensions\\Ultrasurf_1_6_6_0.crx"));
			driverBaseTest = new ChromeDriver(options);
		} else if (browserList == BrowserList.EDGE) {
			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();

		} else {
			throw new RuntimeException("Browser name invalid");
		}
		driverBaseTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driverBaseTest.get(getEnviromentValuee(appUrl));
		driverBaseTest.get(appUrl);

		return driverBaseTest;
	}

	private String getEnviromentValue(String enviromentName) {
		String envURL = null;
		ENVIROMENT enviroment = ENVIROMENT.valueOf(enviromentName.toUpperCase());
		if(enviroment== ENVIROMENT.DEV){
			envURL = "http://demo.guru99.com/v1/";
		}else if(enviroment== ENVIROMENT.TEST){
			envURL = "http://demo.guru99.com/v2/";
		}else if(enviromentName.equalsIgnoreCase("staging")){
			envURL = "http://demo.guru99.com/v3/";
		}else if(enviromentName.equalsIgnoreCase("production")){
			envURL = "http://demo.guru99.com/v4/";
		}
		
		return envURL;
	}
	
	//c2
	private String getEnviromentValuee(String enviromentName) {
		String enrURL = null;
		if(enviromentName.equalsIgnoreCase("dev")) {
			enrURL = "http://demo.guru99.com/v1/";
		}else if (enviromentName.equalsIgnoreCase("test")){
			enrURL = "http://demo.guru99.com/v2/";

		}else if (enviromentName.equalsIgnoreCase("staging")){
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

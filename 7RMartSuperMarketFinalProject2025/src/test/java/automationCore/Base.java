package automationCore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class Base {
	public WebDriver driver;
	Properties prop;
	FileInputStream fs;
	WaitUtility wait = new WaitUtility();

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception {
		prop = new Properties();
		fs = new FileInputStream(Constants.CONFIGFILE);
		prop.load(fs);
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();

		} else {
			throw new Exception("Invalid Browser");
		}
		driver.get(prop.getProperty("url"));
		wait.implicitWait(driver);
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	public void driverQuit(ITestResult itestresult) throws IOException {// ITestResult interface manage all the test
																		// results
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility screenShot = new ScreenshotUtility();
			screenShot.getScreenshot(driver, itestresult.getName());
		}
		//driver.quit();
	}
}

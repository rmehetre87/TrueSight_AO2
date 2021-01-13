package com.w2a.Testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			//"C:\\Users\\patiln1\\Eclipse_TS\\Truesight_E2E_Patrol\\Truesight_E2E_Patrol\\src\\test\\resources\\excel\\TruesightData.xlsx");
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\TruesightData.xlsx");
	
	@BeforeSuite
	public void pageSetup() throws FileNotFoundException {

		if (driver == null) {
			System.out.println(System.getProperty("user.dir"));

			//
			config = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(config.getProperty("Browser"));

			//
			OR = new Properties();
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(OR.getProperty("blmbtn_CSS"));

		}

		//
		if (config.getProperty("Browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					//"C:\\Users\\patiln1\\Eclipse_WS\\Truesight_E2E_Patrol\\Truesight_E2E_Patrol\\src\\test\\resources\\excutable\\chromedriver.exe");
			System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome is launched");

		} else if (config.getProperty("Browser").equals("ie")) {
			System.setProperty("webdriver.ie.driver",
					//"C:\\Users\\patiln1\\Eclipse_WS\\Truesight_E2E_Patrol\\Truesight_E2E_Patrol\\src\\test\\resources\\excutable\\IEDriverServer.exe");
			System.getProperty("user.dir") + "\\src\\test\\resources\\excutable\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			System.out.println("ie is launched");

		}

		//driver.get(config.getProperty("testsiteurl"));
		driver.get(config.getProperty("testsiteurl_AO2"));
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		// driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);

	}// end of setup method

	// Assertion method
	public boolean isElementPresent(By by) {

		try {
			driver.findElement(by);

			return true;

		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static void verifytext(String expected, String actual) throws IOException {
		try {
			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {
			TestUtil.captureScreenShot();
		}

	}

	public static boolean verifyfieldvalue(String locator, String actualvalue) throws IOException {
		boolean result = false;
		if (driver.findElement(By.xpath(OR.getProperty(locator))).getText().equalsIgnoreCase(actualvalue)) {
			result = true;
		}
		return result;
	}

	public void click(String locator) {
		if (locator.endsWith("_xpath")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();

		}
	}

	public void type(String locator, String value) {
		if (locator.endsWith("_css")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_xpath")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_id")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);

		}
	}

	//---------------Clear method -----------//
	public void clear(String locator) {
		if (locator.endsWith("_css")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).clear();
		} else if (locator.endsWith("_xpath")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).clear();
		} else if (locator.endsWith("_id")) {
			driver.findElement(By.id(OR.getProperty(locator))).clear();

		}
	}

		
			
	

	@AfterSuite
	public void tearDown() {
		System.out.println("Closing the browser");
		 driver.quit();
	}

}

package com.w2a.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.w2a.Testbase.TestBase;
import com.w2a.utilities.TestUtil;

public class Trial extends TestBase {

	public WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\patiln1\\Eclipse_WS\\TS_test\\TS_test\\chromedriver.exe");

		//OR.properties 
		System.out.println(System.getProperty("user.dir"));
		  
		  Properties config = new Properties(); FileInputStream fis = new
		  FileInputStream( System.getProperty("user.dir") +
		  "\\src\\test\\resources\\properties\\config.properties"); config.load(fis);
		  
		  System.out.println(config.getProperty("Browser"));
		  
		  Properties OR = new Properties(); fis = new
		  FileInputStream(System.getProperty("user.dir") +
		  "\\src\\test\\resources\\properties\\OR.properties"); OR.load(fis);
		  System.out.println(OR.getProperty("blmbtn_CSS"));
		  
		
		WebDriver driver = new ChromeDriver();
//Window maximise 	
		driver.manage().window().maximize();
        /*driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/

		String url = "https://cn-tsps-test.uk.pri.o2.com:8443/";
// Screenshot
		//TestUtil.captureScreenShot(driver);
//Capture logs
		log.debug("Truesight_LoginPage Started!!!");
		log.debug("Truesight_LoginPage End!!!");
		
		String expectedTitle = "Software Testing Material - A site for Software Testers";
		String actualTitle = null;

		driver.get(url);
		actualTitle = driver.getTitle();

		Thread.sleep(20000);
//Truesight Login  
		
		driver.findElement(By.xpath(OR.getProperty("detailbtn_xpath"))).click();
		driver.findElement(By.xpath(OR.getProperty("proceedlinkbtn_xpath"))).click();
		driver.findElement(By.xpath(OR.getProperty("Doaminfld_xpath"))).sendKeys("SMIP");
		driver.findElement(By.xpath(OR.getProperty("mspForm_xpath"))).click();
		driver.findElement(By.xpath(OR.getProperty("detailbtn_xpath"))).click();
		driver.findElement(By.xpath(OR.getProperty("proceedlinkbtn_xpath"))).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(OR.getProperty("loginuserfld_xpath"))).sendKeys(OR.getProperty("Username"));
		driver.findElement(By.xpath(OR.getProperty("loginpwdfld_xpath"))).sendKeys(OR.getProperty("password"));
		driver.findElement(By.xpath(OR.getProperty("loginbtn_xpath"))).click();
		Thread.sleep(30000);
		
//Configuration Page-Search server and generate alert
		driver.findElement(By.xpath(OR.getProperty("headermenutogglebtn_xpath"))).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath(OR.getProperty("Configurationbtn_xpath"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("Configurationserverbtn_xpath"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("monitoringAdminSearchBtn_xpath"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("searchintialbtn_xpath"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("searchintialbtn_xpath"))).sendKeys(OR.getProperty("servername"));
		driver.findElement(By.xpath(OR.getProperty("monitoringAdminSearchBtnfilter_xpath"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("eventGrpTreeGridMenuBtn_xpath"))).click();
		Thread.sleep(10000);

		//driver.switchTo().window("//*[@id=\'mainBody\']/title");
		
		String winHandleBefore = driver.getWindowHandle();
		driver.findElement(By.xpath(OR.getProperty("event_action_queryPatrolAgent_xpath"))).click();
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {

			driver.switchTo().window(winHandle);
			System.out.println("Winhandle before close " + winHandle );
			
		}
		Thread.sleep(30000);
		driver.findElement(By.xpath(OR.getProperty("aqtCommandInputfld_xpath"))).click();
		driver.findElement(By.xpath(OR.getProperty("aqtCommandInputfld_xpath"))).sendKeys(OR.getProperty("PSLQuery"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("aqtSubmitBtn_xpath"))).click();
		Thread.sleep(20000);
		
		 
		driver.close();
		
		driver.switchTo().window(winHandleBefore);
		System.out.println("Winhandle after close " + winHandleBefore );
		Thread.sleep(20000);
		
//Monitoring Event-Search Alert
						
		driver.findElement(By.xpath(OR.getProperty("monitoringbtn_xpath"))).click();
		driver.findElement(By.xpath(OR.getProperty("monitoring-events_xpath"))).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(OR.getProperty("eventSearchBth_xpath"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("txtSearchInpfld_xpath"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("txtSearchInpfld_xpath"))).sendKeys(OR.getProperty("servername"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("eventSearchActionBtn_xpath"))).click();
		Thread.sleep(2000);
		
//Change filter to BMCPatrol and export alert to CSV
		driver.findElement(By.xpath(OR.getProperty("extend-tb-link_xpath"))).click();
		driver.findElement(By.xpath(OR.getProperty("change_table_view_id_xpath"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(OR.getProperty("Extendbtn_xpath"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("selectedRemoteCell_xpath"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("eventMenuButton0_xpath"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("BMCPatrolfilter_xpath"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("CSV_xpath"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("AllSlots_xpath"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("Exportbtn_xpath"))).click();
		Thread.sleep(3000);
		
		 driver.close();

	}
}

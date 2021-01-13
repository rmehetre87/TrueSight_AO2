package com.w2a.testcases;

import java.io.IOException;
import java.util.Hashtable;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.Testbase.TestBase;
import com.w2a.utilities.TestUtil;


public class Truesight_configurationPage extends TestBase {
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void truesight_configurationPage(Hashtable<String, String> data) throws InterruptedException, IOException {

		System.out.println("Conf  page start");
		log.debug("Truesight_configurationPage Started !!!");
		
		click("Configurationserverbtn_xpath");
		Thread.sleep(6000);
		click("monitoringAdminSearchBtn_xpath");
		Thread.sleep(2000);
		click("searchintialbtn_xpath");
		clear("searchintialbtn_xpath");
		Thread.sleep(5000);
		type("searchintialbtn_xpath", data.get("servername"));
		click("monitoringAdminSearchBtnfilter_xpath");
		Thread.sleep(5000);
		click("eventGrpTreeGridMenuBtn_xpath");
		Thread.sleep(5000);

		String winHandleBefore = driver.getWindowHandle();
		click("event_action_queryPatrolAgent_xpath");
		Thread.sleep(5000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			System.out.println("Winhandle before close " + winHandle);
		}

		// Reset alert
		Thread.sleep(5000);
		click("aqtCommandInputfld_xpath");
		type("aqtCommandInputfld_xpath", data.get("PSLQuery"));
		Thread.sleep(2000);
		click("aqtSubmitBtn_xpath");
		Thread.sleep(5000);
		// Generate alert		
		click("aqtCommandInputfld_xpath");
		clear("aqtCommandInputfld_xpath");
		type("aqtCommandInputfld_xpath", data.get("PSLQuery1"));
		Thread.sleep(2000);
		click("aqtSubmitBtn_xpath");
		Thread.sleep(5000);
		log.debug("Alert generated for server: " + data.get("servername") + " " + "Alert Key: " + data.get("AlertKey"));

		//Close Execute PSLQuery window
		driver.close();
		driver.switchTo().window(winHandleBefore);
		System.out.println("Winhandle after close " + winHandleBefore);
		Thread.sleep(10000);

		//Clear Server search on managed devices page
		clear("searchintialbtn_xpath");
		click("monitoringAdminSearchBtnfilter_xpath");
		Thread.sleep(2000);

		log.debug("Truesight_configurationPage End !!!");

		//Monitoring events
		System.out.println("Monitoring  page start");
		log.debug("Truesight_MonitoringPage Started !!!");
		Thread.sleep(3000);
		click("monitoringbtn_xpath");
		Thread.sleep(3000);
		click("monitoring-events_xpath");
		Thread.sleep(5000);
		click("eventSearchBth_xpath");
		Thread.sleep(3000);
		click("txtSearchInpfld_xpath");
		Thread.sleep(3000);
		type("txtSearchInpfld_xpath", data.get("servername"));
		Thread.sleep(1000);
		click("eventSearchActionBtn_xpath");
		Thread.sleep(8000);
		
		// Capture Screenshot
		TestUtil.captureScreenShot();

		//Export alert to CSV
	    click("eventMenuButton0_xpath");
		Thread.sleep(2000);
		click("Exportlink_xpath");
		Thread.sleep(1000);
		click("CSV_xpath");
		Thread.sleep(500);
		click("AllSlots_xpath");
		Thread.sleep(500);
		click("Exportbtn_xpath");
		Thread.sleep(1000);
		log.debug("Alert data captured for server: " + data.get("servername") + " " + "Alert Key: " + data.get("AlertKey"));

		//Minimize Monitoring tab and Reset events search filter
		click("monitoringbtn_xpath");
		Thread.sleep(4000);
		clear("txtSearchInpfld_xpath");
		click("eventSearchActionBtn_xpath");
		Thread.sleep(4000);
		log.debug("Truesight_MonitoringPage End !!!");
		
	}
	
}

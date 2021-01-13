package com.w2a.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.w2a.Testbase.TestBase;
import com.w2a.utilities.TestUtil;

public class Truesight_LoginPage extends TestBase {

	@Test
	public void truesight_LoginPage() throws InterruptedException, IOException {

		log.debug("Truesight_LoginPage Started!!!");
		System.out.println("Login page Start");

		click("detailbtn_xpath");
		
		click("proceedlinkbtn_xpath");
		type("Doaminfld_xpath", "SMIP");
		click("mspForm_xpath");
		click("detailbtn_xpath");
		click("proceedlinkbtn_xpath");
		Thread.sleep(10000);
		type("loginuserfld_xpath", OR.getProperty("Username"));
		type("loginpwdfld_xpath", OR.getProperty("password"));
		click("loginbtn_xpath");
		Thread.sleep(30000);
		
		// Config page code
		click("headermenutogglebtn_xpath");
		Thread.sleep(7000);
		click("Configurationbtn_xpath");
		Thread.sleep(2000);
		
		// Apply BMC Patrol filter
		System.out.println("Apply BMC Patrol filter Start");
		click("monitoringbtn_xpath");
		Thread.sleep(8000);
		click("monitoring-events_xpath");
		Thread.sleep(25000);
		click("extend-tb-link_xpath");
		Thread.sleep(2000);
		click("change_table_view_id_xpath");
		Thread.sleep(1000);
		click("arrow1btn_xpath");
		Thread.sleep(1000);
		click("tableViewRadio4BMCFilter_xpath");
		Thread.sleep(1000);
		click("selectedRemoteCell_xpath");
		Thread.sleep(10000);
		
		click("monitoringbtn_xpath");
		System.out.println("Apply BMC Patrol filter End");

		// Capture Screenshot
		TestUtil.captureScreenShot();

		log.debug("Truesight_LoginPage End!!!");
		System.out.println("Login page done");
	}

}

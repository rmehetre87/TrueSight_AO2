package com.w2a.testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

import com.w2a.Testbase.TestBase;
import com.w2a.utilities.TestUtil;

public class AO2Truesight_LoginPage extends TestBase {

	@Test
	public void truesight_LoginPage() throws InterruptedException, IOException {

		log.debug("Truesight_LoginPage Started!!!");
		System.out.println("Login page Start");

		Thread.sleep(1000);
		type("loginuserfld_xpath", OR.getProperty("Username1"));
		type("loginpwdfld_xpath", OR.getProperty("password1"));
		click("loginbtn_xpath");
		Thread.sleep(20000);
		
		// Config page code
		click("headermenutogglebtn_xpath");
		Thread.sleep(3000);
		click("Configurationbtn_xpath");
		Thread.sleep(1000);
		
		// Apply BMC Patrol filter
		System.out.println("Apply BMC Patrol filter Start");
		click("monitoringbtn_xpath");
		Thread.sleep(3000);
		click("monitoring-events_xpath");
		Thread.sleep(15000);
		click("extend-tb-link_xpath");
		Thread.sleep(2000);
		click("change_table_view_id_xpath");
		Thread.sleep(1000);
		click("arrow2btn_xpath");
		Thread.sleep(1000);
		click("radio_basicinfo");
		Thread.sleep(1000);
		click("selectedRemoteCell_xpath");
		Thread.sleep(10000);
		
		click("monitoringbtn_xpath");
		System.out.println("Apply BMC Patrol filter End");

		/*Capture Screenshot
		TestUtil.captureScreenShot();*/

		log.debug("Truesight_LoginPage End!!!");
		System.out.println("Login page done");
	}
	
	
public static WebElement getElement(WebDriver driver, int rownum, int colnum){
		
		Actions action = new Actions(driver);
		
			WebElement ele = driver.findElement(By.xpath("//*[@id=\"row0eventGrid\"]"+rownum));
			action.moveToElement(ele).perform(); 
			
			return ele;
		
	}
	

}

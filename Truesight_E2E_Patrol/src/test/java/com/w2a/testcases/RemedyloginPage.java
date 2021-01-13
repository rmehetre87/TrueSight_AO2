package com.w2a.testcases;


import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.w2a.Testbase.TestBase;
import com.w2a.utilities.TestUtil;


public class RemedyloginPage extends TestBase {
	
	
	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void remedyloginPage(Hashtable<String, String> data) throws InterruptedException, IOException {
		
		
		driver.findElement(By.cssSelector(OR.getProperty("UserName_CSS"))).sendKeys("kinolid");
		driver.findElement(By.cssSelector(OR.getProperty("Pwd_CSS"))).sendKeys("Testing@123");
		driver.findElement(By.name(OR.getProperty("Loginbtn_Name"))).click();
		
		Thread.sleep(8000);
		TestUtil.captureScreenShot();
		/*
		Alert alert= driver.switchTo().alert();
		String Message= driver.switchTo().alert().getText();
		alert.accept();
		Thread.sleep(3000);
		*/
		
		driver.findElement(By.cssSelector(OR.getProperty("Application_CSS"))).click();
		//*[@id="reload-button"]
		//driver.findElement(By.xpath("//*[@id='reload-button']")).click();
		
		
		driver.findElement(By.xpath(OR.getProperty("IncidentManagementbtn_xpath"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("Incidentsearcchbtn_xpath"))).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath(OR.getProperty("Categorization_xpath"))).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(OR.getProperty("IncidentIDfld_CSS"))).sendKeys(data.get("Incident_ID"));  //.sendKeys("INC000000516629");
		//driver.findElement(By.cssSelector(OR.getProperty("IncidentIDfld_CSS"))).sendKeys("INC000000516629");
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("Searchbtn_xpath"))).click();
		Thread.sleep(8000);
		
		
		
	}

}

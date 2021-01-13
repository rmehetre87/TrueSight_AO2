package com.w2a.Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.w2a.utilities.TestUtil;


public class CustomListeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output","false");
		Reporter.log("The test is Passed"+result.getName());
		//Reporter.log("<a href=\"C:\Users\patiln1\Desktop\\DSC.jpg\">screenlink</a>"+result.getName());
		//Reporter.log("<a href=\"C:\\Users\\patiln1\\Desktop\\DSC.jpg\">screenlink</a>");
		
		
		/*try {
			TestUtil.captureScreenShot();
					} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		Reporter.log("<br><br><a href="+TestUtil.screenshotName+">ScreenShot</a><br>");
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		
		System.setProperty("org.uncommons.reportng.escape-output","false");
		Reporter.log("The test is Failed"+result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}

package com.synechron.appium.AppiumTraining.prefflow;

import java.net.MalformedURLException;

import javax.swing.tree.ExpandVetoException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synechron.appium.AppiumTraining.utils.DriverUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.functions.ExpectedCondition;

public class PreferenceUsingFunction {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<AndroidElement> driver =  DriverUtils.getDriverForRealDevice();
		
		driver.findElementByAccessibilityId("Preference").click();
		driver.findElementByAccessibilityId("4. Default values").click();
		
		String checkBoxStatus = driver.findElementById("android:id/checkbox").getAttribute("checked");
		
		if(checkBoxStatus.equals("true"))
		{
			driver.findElementById("android:id/checkbox").click();
		}

//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElementByAndroidUIAutomator("text(\"Edit text preference\")")));

		
		driver.findElementByAndroidUIAutomator("text(\"Edit text preference\")").click();
		Thread.sleep(2000);
		driver.findElementById("android:id/edit").clear();
		driver.findElementById("android:id/edit").sendKeys("Test Sample Input");
		
		driver.findElementByAndroidUIAutomator("text(\"OK\")").click();
		
		driver.findElementByAndroidUIAutomator("text(\"List preference\")").click();
		
		driver.findElementByAndroidUIAutomator("text(\"Charlie Option 03\")").click();
//		driver.findElementByAccessibilityId("text(\"	\r\n" + 
//				"Cancel\")").click();
//		
		
		
		
	}

}

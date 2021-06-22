package com.synechron.appium.AppiumTraining.prefflow;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;

import com.synechron.appium.AppiumTraining.utils.DriverUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BasicOperationsDemo {
	
	
	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<AndroidElement> driver = DriverUtils.getDriverForRealDevice();
		driver.findElementByAccessibilityId("Views").click();
		
		driver.findElementByXPath("//android.widget.TextView[@content-desc='Controls']").click();
		driver.findElementByAccessibilityId("1. Light Theme").click();
		driver.findElementByXPath("//android.widget.EditText").sendKeys("SampleText");
		driver.hideKeyboard();
		Thread.sleep(10000);
		 String checkbox = driver.findElementById("io.appium.android.apis:id/check1").getAttribute("checked");
		
		if(checkbox.equals("false"))
		{
			System.out.println("Checkbox is not selected selecting Checkbox");
			driver.findElementById("io.appium.android.apis:id/check1").click();
			
		}
		
		String radio = driver.findElementById("io.appium.android.apis:id/radio1").getAttribute("checked");;
		
		if(radio.equals("false"))
		{
			System.out.println("Checkbox is not selected selecting Checkbox");
			
			driver.findElementById("io.appium.android.apis:id/radio1").click();
		}
		String textBeforeClick = driver.findElementById("io.appium.android.apis:id/toggle1").getAttribute("text");
		System.out.println("Before Click text value " + textBeforeClick);
		
		driver.findElementById("io.appium.android.apis:id/toggle1").click();
		
		String textAfterClick = driver.findElementById("io.appium.android.apis:id/toggle1").getAttribute("text");
		System.out.println("After Click text value " + textAfterClick);
		
		
		driver.findElementById("io.appium.android.apis:id/spinner1").click();
		
		List<AndroidElement> textViewElements = driver.findElementsByClassName("android.widget.CheckedTextView");
				
		for (AndroidElement ele : textViewElements)
		{
			System.out.println(ele.getText());
		}
		
	}

}

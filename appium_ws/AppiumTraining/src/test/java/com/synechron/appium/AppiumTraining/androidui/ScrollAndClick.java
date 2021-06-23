package com.synechron.appium.AppiumTraining.androidui;

import java.net.MalformedURLException;

import com.synechron.appium.AppiumTraining.utils.DriverUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollAndClick {

	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<AndroidElement> driver  = DriverUtils.getDriverForRealDevice();
		driver.findElementByAccessibilityId("Views").click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Web View\"))").click();
		
	}
}

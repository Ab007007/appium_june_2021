package com.synechron.appium.AppiumTraining.autosuggestions;

import java.net.MalformedURLException;

import com.synechron.appium.AppiumTraining.utils.DriverUtils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

public class AutoSuggestionsDemo {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = DriverUtils.getDriverForRealDevice();

		DriverUtils.click("access-id", "Views");
		DriverUtils.click("access-id", "Auto Complete");
		DriverUtils.click("access-id", "1. Screen Top");
		
		DriverUtils.type("id", "io.appium.android.apis:id/edit", "ind");
		Thread.sleep(2000);
		TouchAction act  =  new TouchAction(driver);
		act.tap(PointOption.point(520, 520)).perform();
		System.out.println("DONE");
		

	}
}

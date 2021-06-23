package com.synechron.appium.AppiumTraining.touchActions;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.Dimension;

import com.synechron.appium.AppiumTraining.utils.DriverUtils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeOnScreen {
	
	static AndroidDriver<AndroidElement> driver =null;
	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		driver =  DriverUtils.getDriverForRealDevice();
		// id, access-id,name,classname,xpath,androidui
		DriverUtils.click("access-id", "Views");
		
		System.out.println("Swiping from bottom to top after 2 sec...");
		Thread.sleep(2000);
		swipeFromBottomToTop();
		System.out.println("Swipe complete");
		System.out.println("Swiping from top to bottom after 2 sec...");
		Thread.sleep(2000);
		swipeFromTopT0Bottom();
		System.out.println("Swipe complete");
	}
	
	
	public static void swipeFromTopT0Bottom()
	{
		Dimension size = driver.manage().window().getSize();
		int startx = size.width /2;
		int starty = (int ) (size.height * 0.3);
		int endy = (int ) (size.height * 0.8);
		
		TouchAction act = new TouchAction(driver);
		
		act.press(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		.moveTo(PointOption.point(startx, endy)).release().perform();
	
	}

	
	public static void swipeFromBottomToTop()
	{
		Dimension size = driver.manage().window().getSize();
		int startx = size.width /2;
		int starty = (int ) (size.height * 0.8);
		int endy = (int ) (size.height * 0.3);
		
		TouchAction act = new TouchAction(driver);
		
		act.press(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		.moveTo(PointOption.point(startx, endy)).release().perform();
	
	}

}

package com.synechron.appium.AppiumTraining.touchActions;

import java.net.MalformedURLException;

import org.openqa.selenium.interactions.touch.TouchActions;

import com.synechron.appium.AppiumTraining.utils.DriverUtils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragAndDropDemo {

	
	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver =  DriverUtils.getDriverForRealDevice();
		// id, access-id,name,classname,xpath,androidui
		DriverUtils.click("access-id", "Views");
		DriverUtils.click("access-id", "Drag and Drop");
		AndroidElement sourceEle = driver.findElementsByXPath("//android.view.View").get(0);
		AndroidElement destEle = driver.findElementsByXPath("//android.view.View").get(1);
		
		TouchAction act = new TouchAction(driver);
		act.longPress(element(sourceEle)).moveTo(element(destEle)).release().perform();
	
	}
}

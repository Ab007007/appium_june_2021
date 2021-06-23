package com.synechron.appium.AppiumTraining.touchActions;

import java.net.MalformedURLException;
import java.time.Duration;

import com.synechron.appium.AppiumTraining.utils.DriverUtils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class SwipeDemo {

	
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver =  DriverUtils.getDriverForRealDevice();
		// id, access-id,name,classname,xpath,androidui
		DriverUtils.click("access-id", "Views");
		DriverUtils.click("access-id", "Date Widgets");
		DriverUtils.click("access-id", "2. Inline");
		DriverUtils.click("xpath", "//*[@content-desc='6']");
		
		AndroidElement sourceEle = DriverUtils.getElement("xpath", "//*[@content-desc='15']");
		AndroidElement destEle = DriverUtils.getElement("xpath", "//*[@content-desc='0']");
		
		TouchAction act = new TouchAction(driver);
		
		act.longPress(longPressOptions()
				.withElement(element(sourceEle))
				.withDuration(Duration.ofSeconds(2))).moveTo(element(destEle)).release().perform();
		
		
	}
}

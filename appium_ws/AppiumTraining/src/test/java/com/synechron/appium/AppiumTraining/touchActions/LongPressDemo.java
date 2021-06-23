package com.synechron.appium.AppiumTraining.touchActions;

import java.net.MalformedURLException;
import java.time.Duration;

import com.synechron.appium.AppiumTraining.utils.DriverUtils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class LongPressDemo {
	
	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver =  DriverUtils.getDriverForRealDevice();
		// id, access-id,name,classname,xpath,androidui
		DriverUtils.click("access-id", "Views");
		DriverUtils.click("access-id", "Expandable Lists");
		DriverUtils.click("access-id", "1. Custom Adapter");
		
		TouchAction act  = new TouchAction(driver);
		AndroidElement peopleEle = DriverUtils.getElement("androidui", "text(\"People Names\")");
		act.longPress(
				LongPressOptions.longPressOptions().
				withElement(ElementOption.element(peopleEle))
				.withDuration(Duration.ofSeconds(2))
				).release().perform();
		
		System.out.println(DriverUtils.getText("id", "android:id/alertTitle"));
		System.out.println(DriverUtils.getText("id", "android:id/title"));
		
		
		
	}

}

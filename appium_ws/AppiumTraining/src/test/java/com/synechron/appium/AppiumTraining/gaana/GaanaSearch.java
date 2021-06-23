package com.synechron.appium.AppiumTraining.gaana;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.synechron.appium.AppiumTraining.utils.DriverUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class GaanaSearch {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5");
		cap.setCapability(MobileCapabilityType.APP, new File("app/Gaana.apk").getAbsolutePath());
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "50000");

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		DriverUtils.driver = driver;

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		DriverUtils.click("id", "com.gaana:id/btn_save");
		Thread.sleep(5000);
		DriverUtils.type("id", "com.gaana:id/search_src_text", "KGF");
		Thread.sleep(5000);
		List<AndroidElement> autoSuggestions = driver.findElementsByXPath("//*[@resource-id='com.gaana:id/tv_search_keyword']");
		
		for (AndroidElement suggestion : autoSuggestions) 
		{
			System.out.println(suggestion.getText());
			
		}
	
		driver.hideKeyboard();
		
		
		DriverUtils.click("androidui", "text(\"Home\")");
		
	
	}

}

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
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class GaanaTest {

	static AndroidDriver<AndroidElement> driver = null;

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5");
		cap.setCapability(MobileCapabilityType.APP, new File("app/Gaana.apk").getAbsolutePath());
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "50000");

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		DriverUtils.driver = driver;

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		DriverUtils.click("id", "com.gaana:id/btn_save");
		DriverUtils.click("androidui", "text(\"Top Hits\")");

		List<AndroidElement> topHits = driver
				.findElementsByXPath("//androidx.recyclerview.widget.RecyclerView//android.widget.TextView");

		for (AndroidElement androidElement : topHits) {
			System.out.println(androidElement.getText());

		}
	}

}

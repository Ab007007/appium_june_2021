package com.synechron.appium.AppiumTraining.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverUtils {
	public static AndroidDriver<AndroidElement> driver = null;

	public static AndroidDriver<AndroidElement> getDevice(String deviceName, String packageName, String activityName,
			String udid) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability("appPackage", packageName);
		cap.setCapability("appActivity", activityName);

		cap.setCapability(MobileCapabilityType.UDID, udid);

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;
	}

	public static AndroidDriver<AndroidElement> getDevice(String deviceName, String app, String udid)
			throws MalformedURLException {

		File f = new File(app);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability("app", f.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.UDID, udid);

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;
	}

	public static AndroidDriver<AndroidElement> getDriverForVirtualDevice() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;
	}

	public static AndroidDriver<AndroidElement> getDriverForRealDevice() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

		cap.setCapability(MobileCapabilityType.UDID, "01abd5130382753e");

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;
	}
/**
 * 
 * @param identifier - id, access-id,name,classname,xpath,androidui
 * @param value
 * @return
 */
	public static AndroidElement getElement(String identifier, String value) {
		AndroidElement ele = null;
		System.out.println("Finding Element using " + identifier + " and " + value);
		switch (identifier) {
		case "id":
			ele  = driver.findElementById(value);
			break;

		case "access-id":
			ele = driver.findElementByAccessibilityId(value);
			break;

		case "name":
			ele = driver.findElementByName(value);
			break;

		case "classname":
			ele = driver.findElementByClassName(value);
			break;

		case "xpath":
			ele = driver.findElementByXPath(value);
			break;
		case "androidui":
			ele = driver.findElementByAndroidUIAutomator(value);
			break;

		default:
			ele = null;
			System.out.println("pkease check the identifer ...");
			break;
		}
		return ele;
	}
	
	/**
	 * 
	 * @param identifier id, access-id,name,classname,xpath,androidui
	 * @param value
	 * @param textToType
	 */
	public static void type(String identifier, String value, String textToType) 
	{
		System.out.println("Performing type using " + identifier + " and " + value + " and " + textToType);
		getElement(identifier, value).sendKeys(textToType);
	}

	/**
	 * @author Aravind
	 * @param identifier id, access-id,name,classname,xpath,androidui
	 * @param value
	 */
	public static void click(String identifier, String value)
	{
		System.out.println("Performing Click using " + identifier + " and " + value);
		getElement(identifier, value).click();
	}

	/**
	 * 
	 * @param identifier- id, access-id,name,classname,xpath,androidui
	 * @param value
	 */
	public static void clearText(String identifier, String value)
	{
		System.out.println("Performing Clear using " + identifier + " and " + value);
		getElement(identifier, value).clear();
	}

	/**
	 * 
	 * @param identifier- id, access-id,name,classname,xpath,androidui
	 * @param value
	 * @param attr
	 * @return
	 */
	public static String getAttributeValue(String identifier, String value, String attr)
	{
		System.out.println("Gettting attribute using " + identifier + " and " + value + " for " + attr);
		String attrvalue = getElement(identifier, value).getAttribute(attr);
		System.out.println("Attribute value found " + attrvalue);
		return attrvalue;

	}

}

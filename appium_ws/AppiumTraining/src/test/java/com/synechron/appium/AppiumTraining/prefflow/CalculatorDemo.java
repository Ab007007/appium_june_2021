package com.synechron.appium.AppiumTraining.prefflow;

import java.net.MalformedURLException;

import com.synechron.appium.AppiumTraining.utils.DriverUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CalculatorDemo {
	
	static AndroidDriver<AndroidElement> driver = null;
	public static void main(String[] args) throws MalformedURLException 
	{
//		AndroidDriver<AndroidElement> driver = DriverUtils.getDevice("Nexus 5", "com.android.calculator2", "com.android.calculator2.Calculator", "01abd5130382753e");
//		AndroidDriver<AndroidElement> driver = DriverUtils.getDevice("Pixel", "app\\Calculator_apkpure.apk", "emulator-5554");
		driver = DriverUtils.getDevice("Pixel", "com.android.calculator2", "com.android.calculator2.Calculator", "emulator-5554");
		//text("value")
		
		add(5,3);
		sub(9,5);
		mul(5,5);
		div(5,2);
		
	}

	public static void add(int a, int b)
	{
		driver.findElementByAndroidUIAutomator("text(\"" + a + "\")").click();
		driver.findElementById("com.android.calculator2:id/op_add").click();
		driver.findElementByAndroidUIAutomator("text(\""+ b +"\")").click();
		
		String result = driver.findElementById("com.android.calculator2:id/result").getText();
		System.out.println(result);
	}
	public static void sub(int a, int b)
	{
		driver.findElementByAndroidUIAutomator("text(\"" + a + "\")").click();
		driver.findElementById("com.android.calculator2:id/op_sub").click();
		driver.findElementByAndroidUIAutomator("text(\""+ b +"\")").click();
		
		String result = driver.findElementById("com.android.calculator2:id/result").getText();
		
		System.out.println(result);
	
	}
	public static void mul(int a, int b)
	{
		driver.findElementByAndroidUIAutomator("text(\"" + a + "\")").click();
		driver.findElementById("com.android.calculator2:id/op_mul").click();
		driver.findElementByAndroidUIAutomator("text(\""+ b +"\")").click();
		
		String result = driver.findElementById("com.android.calculator2:id/result").getText();
		
		System.out.println(result);
	}
	public static void div(int a, int b)
	{
		driver.findElementByAndroidUIAutomator("text(\"" + a + "\")").click();
		driver.findElementById("com.android.calculator2:id/op_div").click();
		driver.findElementByAndroidUIAutomator("text(\""+ b +"\")").click();
				
		String result = driver.findElementById("com.android.calculator2:id/result").getText();
		
	}
	
	
}

package com.synechron.appium.AppiumTraining.prefflow;

import java.net.MalformedURLException;

import javax.swing.tree.ExpandVetoException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synechron.appium.AppiumTraining.utils.DriverUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.functions.ExpectedCondition;

public class PreferenceDependencies {
	//identifier id, access-id,name,classname,xpath,androidui
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<AndroidElement> driver =  DriverUtils.getDriverForRealDevice();
		
		DriverUtils.click("access-id", "Preference");
		DriverUtils.click("access-id", "4. Default values");
		String checkBoxStatus = DriverUtils.getAttributeValue("id", "android:id/checkbox", "checked");
		
		if(checkBoxStatus.equals("true"))
		{
			DriverUtils.click("id", "android:id/checkbox");
		}

		DriverUtils.click("androidui", "text(\"Edit text preference\")");
		DriverUtils.clearText("id", "android:id/edit");
		DriverUtils.type("id", "android:id/edit", "Test Sample Text");
		
		DriverUtils.click("androidui", "text(\"OK\")");
		DriverUtils.click("androidui", "text(\"List preference\")");
		DriverUtils.click("androidui", "text(\"Charlie Option 03\")");
		
		
		
	}

}

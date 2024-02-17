package com.UiKitCatalogTestsOnIOS.Actions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.ios.IOSDriver;

public class CommonActions {
	
	IOSDriver driver;
	
	public CommonActions(IOSDriver dr) {
		driver = dr;
	}
	
	public void iOSLongPressAction(WebElement ele) {
		
		Map<String, Object> paramsMap = new HashMap<>();
		
		paramsMap.put("element", ((RemoteWebElement)ele).getId());
		paramsMap.put("duration", 3);
		
		driver.executeScript("mobile:touchAndHold", paramsMap);
		
	}
	
	public void iOSScrollAction(WebElement ele) 
	{
		Map<String, Object> paramsMap = new HashMap<>();
		
		paramsMap.put("element", ((RemoteWebElement)ele).getId());
		paramsMap.put("direction", "down");
		
		((JavascriptExecutor)driver).executeScript("mobile:scroll", paramsMap);
	}

}

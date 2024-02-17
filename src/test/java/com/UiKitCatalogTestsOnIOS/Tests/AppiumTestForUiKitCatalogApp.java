package com.UiKitCatalogTestsOnIOS.Tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.UiKitCatalogTestsOnIOS.PageObjects.AlertViewsPage;
import com.UiKitCatalogTestsOnIOS.PageObjects.PickerViewPage;
import com.UiKitCatalogTestsOnIOS.PageObjects.SteppersPage;
import com.UiKitCatalogTestsOnIOS.PageObjects.WebViewsPage;

import io.appium.java_client.AppiumBy;


public class AppiumTestForUiKitCatalogApp extends BaseTest{
	
	
	@Test
	public void TestAlertViews() 
	{
		
		AlertViewsPage alertViewPage = homePage.selectAlertView();
		
		alertViewPage.selectTextEntry();
		alertViewPage.setTextEntryField("TestIOS With Page Factory");
		
		alertViewPage.clickOK();
		alertViewPage.clickConfirm();
		
		AssertJUnit.assertEquals(alertViewPage.getMessage(), "A message should be a short, complete sentence.");
		alertViewPage.clickConfirmMessage();
		
		driver.navigate().back();
		
		
	}
	
	@Test
	public void TestIOSLongPress() throws InterruptedException 
	{
		SteppersPage stepPage = homePage.clickStepper();
		
		//get initial value
		String beforeValue = stepPage.getValue0();
		//click +
		stepPage.clickIncrement();
		
		//click after value
		String afterValue = stepPage.getValue1();
		
		AssertJUnit.assertEquals(Integer.parseInt(afterValue), Integer.parseInt(beforeValue)+1);

		//test longPress
		stepPage.iOSLongPressIncrement();
		
		Thread.sleep(3000);
		
		driver.navigate().back();
	}
	
	@Test
	public void TestIOSScroll() throws InterruptedException 
	{
		Thread.sleep(3000);
		//pick the element we need to scroll to
		
		WebViewsPage webViewPage = homePage.selectWebView();
		Assert.assertEquals(webViewPage.getMessage(), "This is HTML content inside a WKWebView .");
		//click back button of app
		driver.navigate().back();
		
		
	}
	
	@Test
	public void TestIOSPicker() throws InterruptedException 
	{
		PickerViewPage pickerPage = homePage.selectPickerView();
		
		pickerPage.selectRedValue("80");
		
		pickerPage.selectGreenValue("100");
		
		pickerPage.selectBlueValue("220");
		
		driver.navigate().back();
		
	}
	
}
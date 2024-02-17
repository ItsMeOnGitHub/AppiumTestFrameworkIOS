package com.UiKitCatalogTestsOnIOS.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.UiKitCatalogTestsOnIOS.Actions.CommonActions;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends CommonActions{
	
	public IOSDriver driver;
	
	@iOSXCUITFindBy(accessibility = "Alert Views")
	private WebElement alertViews;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name == 'Steppers'")
	private WebElement stepper;
	
	@iOSXCUITFindBy(accessibility = "Web View")
	private WebElement webViews;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name == \"Picker View\"")
	private WebElement pickerViews;
	
	public HomePage(IOSDriver driver2) {
		super(driver2);
		this.driver=driver2;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public AlertViewsPage selectAlertView() {
		alertViews.click();
		return new AlertViewsPage(driver);
	}
	
	public SteppersPage clickStepper() {
		stepper.click();
		return new SteppersPage(driver);
	}
	
	public WebViewsPage selectWebView() {
		
		iOSScrollAction(webViews);
		webViews.click();
		return new WebViewsPage(driver);
	}
	
	public PickerViewPage selectPickerView() {
		//iOSScrollAction(webViews);
		pickerViews.click();
		return new PickerViewPage(driver);
	}

}

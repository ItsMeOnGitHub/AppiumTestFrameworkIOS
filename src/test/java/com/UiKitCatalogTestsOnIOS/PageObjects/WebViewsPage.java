package com.UiKitCatalogTestsOnIOS.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.UiKitCatalogTestsOnIOS.Actions.CommonActions;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WebViewsPage extends CommonActions{
	
	public IOSDriver driver;
	
	@iOSXCUITFindBy(accessibility = "This is HTML content inside a WKWebView .")
	private WebElement message;
//	
//	@iOSXCUITFindBy(iOSNsPredicate = "name == 'Steppers'")
//	private WebElement stepper;
//	
//	@iOSXCUITFindBy(accessibility = "Web Views")
//	private WebElement webViews;
	
	public WebViewsPage(IOSDriver driver2) {
		super(driver2);
		this.driver=driver2;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String getMessage() {
		
		return message.getAttribute("name");
	}
//	
//	public SteppersPage clickStepper() {
//		stepper.click();
//		return new SteppersPage(driver);
//	}
//	
//	public WebViewsPage selectWebView() {
//		webViews.click();
//		return new WebViewsPage(driver);
//	}

}
package com.UiKitCatalogTestsOnIOS.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.UiKitCatalogTestsOnIOS.Actions.CommonActions;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PickerViewPage extends CommonActions{
	
	public IOSDriver driver;
	
	@iOSXCUITFindBy(accessibility ="Red color component value")
	private WebElement redValue;
	
	@iOSXCUITFindBy(accessibility ="Green color component value")
	private WebElement greenValue;
	
	@iOSXCUITFindBy(accessibility ="Blue color component value")
	private WebElement blueValue;
	
	
	public PickerViewPage(IOSDriver driver2) {
		super(driver2);
		this.driver=driver2;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void selectRedValue(String str) {
		redValue.sendKeys(str);
	}
	
	public void selectGreenValue(String str) {
		greenValue.sendKeys(str);
	}
	
	public void selectBlueValue(String str) {
		blueValue.sendKeys(str);
	}
	

}
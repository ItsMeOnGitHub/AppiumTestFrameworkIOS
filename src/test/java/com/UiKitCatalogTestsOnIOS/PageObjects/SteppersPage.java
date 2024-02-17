package com.UiKitCatalogTestsOnIOS.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.UiKitCatalogTestsOnIOS.Actions.CommonActions;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SteppersPage extends CommonActions{
	
	public IOSDriver driver;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Increment\"`][3]")
	private WebElement increment;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Decrement\"`][3]")
	private WebElement decrement;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == '0'`][3]")
	private WebElement value0;
	
	@iOSXCUITFindBy(accessibility = "1")
	private WebElement value1;
	
	public SteppersPage(IOSDriver driver2) {
		super(driver2);
		this.driver=driver2;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickDecrement() {
		decrement.click();
	}
	
	public void clickIncrement() {
		increment.click();
	}
	
	public String getValue0() {
		return value0.getText();
	}
	
	public String getValue1() {
		return value1.getText();
	}
	
	public void iOSLongPressIncrement() {
		iOSLongPressAction(increment);
	}

}

package com.UiKitCatalogTestsOnIOS.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.UiKitCatalogTestsOnIOS.Actions.CommonActions;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindByChainSet;
import io.appium.java_client.pagefactory.iOSXCUITFindBys;

public class AlertViewsPage extends CommonActions{
	
	public IOSDriver driver;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Text Entry\"`]")
	private WebElement textEntry;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField")
	private WebElement textEntryField;
	
	@iOSXCUITFindBy(accessibility = "OK")
	private WebElement textEntryOK;
	
	@iOSXCUITFindBy(accessibility = "Confirm / Cancel")
	private WebElement confirm;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH[c] 'A message'")
	private WebElement message;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name == \"Confirm\"")
	private WebElement messageConfirm;
	
	public AlertViewsPage(IOSDriver driver2) {
		super(driver2);
		this.driver=driver2;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void selectTextEntry() {
		textEntry.click();
	}
	
	public void setTextEntryField(String str) {
		textEntryField.sendKeys(str);
	}
	
	public void clickOK() {
		textEntryOK.click();
	}
	
	public void clickConfirm() {
		confirm.click();
	}
	
	public String getMessage() {
		return message.getText();
	}
	
	public void clickConfirmMessage() {
		messageConfirm.click();
	}

}

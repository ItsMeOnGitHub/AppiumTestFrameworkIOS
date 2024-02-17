package com.UiKitCatalogTestsOnIOS.Tests;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.UiKitCatalogTestsOnIOS.PageObjects.HomePage;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest{
	
	public AppiumDriverLocalService server;
	public IOSDriver driver;
	public HomePage homePage;
	
	@BeforeClass
	public void setup() 
	{
		
		//server starting code (it is same for android and ios) 
		 server = new AppiumServiceBuilder()
					.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
					.withIPAddress("127.0.0.1").usingPort(4723).build();
		try 
		{
			server.start();
			// Set capabilities using XCUITestOptions
			XCUITestOptions deviceOptions = new XCUITestOptions();
			deviceOptions.setCapability("deviceName", "iPhone 15");
			deviceOptions.setCapability("app", "//Users//parulbhasin//eclipse-workspace//AppiumTestFrameworkIOS//src//test//java//resources//UiKitCatalog.app");		
//			deviceOptions.setCapability("app", "//Users//parulbhasin//eclipse-workspace//basicAppium//src//test//java//resources//TestApp 3.app");		
			
			deviceOptions.setPlatformVersion("17.2");
			
			//WDA-> webDriver agent. We need to install WDA in the virtual device which helps on iyr automation.
			//We need to set the time out for installing WDA
			deviceOptions.setWdaLaunchTimeout(Duration.ofSeconds(30));
			//Create object of AndroidDriver class
			//AndriodCode -> AppiumServer --> mobile 
			//so while instantiating the driver we need to provide URL of Appium server, and the details of the device.
			URL url = new URL("http://127.0.0.1:4723");
			driver = new IOSDriver(url, deviceOptions);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			homePage = new HomePage(driver);
			
		}catch(Exception e) {
			e.printStackTrace();
			driver.quit();
			server.stop();
		}
	}
	
	
	
	@AfterClass
	public void teardowm() {
		
		driver.quit();
		server.stop();
		
	}
	
	
}
package org.automation.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverFactory {

    public static AppiumDriver getDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("deviceName", "emulator-5554");
        //capabilities.setCapability("app", System.getProperty("user.dir") + "/apps/app.apk");
        capabilities.setCapability("app", "src/test/resources/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        capabilities.setCapability("newCommandTimeout", "1000");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
        capabilities.setCapability("autoGrantPermissions", true);

        return new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }
}

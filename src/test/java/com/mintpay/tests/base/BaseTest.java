package com.mintpay.tests.base;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class BaseTest {
	public AndroidDriver driver;

    @BeforeMethod
    public void setup() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554"); 
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", "C:/Mintpay/lk.mintpay.app.apk"); 
        caps.setCapability("autoGrantPermissions", true);

        // Initialize the driver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
     //   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

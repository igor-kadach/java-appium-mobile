package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.Setting;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class GetDriver {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            synchronized (GetDriver.class) {
                if (driver == null) {
                    driver = createDriver();
                }
            }
        }
        return driver;
    }

    private static AppiumDriver createDriver() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
   //     desiredCapabilities.setCapability("appium:app", "C:\\Users\\Igor\\Downloads\\Telegram Desktop\\250.apk");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:deviceName", "Android Emulator");
        desiredCapabilities.setCapability("appium:noReset", false);
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appPackage", "com.vpn99");
        desiredCapabilities.setCapability("appActivity","com.vpn99.MainActivity");

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub/");
        driver = new AppiumDriver(remoteUrl, desiredCapabilities);
        driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 500);
        return driver;
    }

    public static void teardown(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
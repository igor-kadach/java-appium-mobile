/*
package TestsVPN99;

import PageObjects.*;
import Utils.GetDriver;
import io.appium.java_client.AppiumDriver;
import org.junit.*;
import java.net.MalformedURLException;

public class ConnectionTest {
    private AppiumDriver driver;
    private MainPageObject mainPage;
    private ConnectionPageObject connectionPage;
    private SettingsPageObject settingsPage;

    @Before
    public void setup() throws MalformedURLException {
        driver = GetDriver.getDriver();
        mainPage = new MainPageObject(driver);
        connectionPage = new ConnectionPageObject(driver);
        settingsPage = new SettingsPageObject(driver);
    }

    @After
    public void quit() {
        settingsPage.changeLanguageBack();
        GetDriver.teardown();
    }

    @Test
    public void connectVPN() {
        mainPage.closeMainPage();
        connectionPage.connectionVPN();
        boolean expectedResult = true;
        Assert.assertEquals(expectedResult, connectionPage.isVPNConnected());
    }
}
*/

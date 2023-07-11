package TestsVPN99;

import PageObjects.*;
import Utils.*;
import io.appium.java_client.AppiumDriver;
import org.junit.*;
import java.net.MalformedURLException;

public class LogOutFromSettingsTest {
    private AppiumDriver driver;
    private ConnectionPageObject connectionPage;
    private MenuPageObject menuPage;
    private SettingsPageObject settingsPage;
    private LoginPageObject loginPage;

    @Before
    public void setup() throws MalformedURLException {
        driver = GetDriver.getDriver();
        connectionPage = new ConnectionPageObject(driver);
        menuPage = new MenuPageObject(driver);
        settingsPage = new SettingsPageObject(driver);
        loginPage = new LoginPageObject(driver);
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.login("test21@vpn99.net", "test21_Tdutybq");
    }

    @After
    public void quit() {
        GetDriver.teardown();
    }

    @Test
    public void logOut() throws InterruptedException {
        // Act
        connectionPage.menuButtonClick();
        menuPage.pressButton("Settings");
        settingsPage.logOutClickIcon();
        // Assert
        boolean expectedResult = true;
        Assert.assertEquals(expectedResult, loginPage.isLoginButtonPresent());
    }
}
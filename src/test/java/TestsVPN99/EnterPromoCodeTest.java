package TestsVPN99;

import PageObjects.*;
import Utils.*;
import io.appium.java_client.AppiumDriver;
import org.junit.*;

import java.net.MalformedURLException;

public class EnterPromoCodeTest {
    private AppiumDriver driver;
    private ConnectionPageObject connectionPage;
    private MenuPageObject menuPage;
    private SettingsPageObject settingsPage;

    @Before
    public void setup() throws MalformedURLException {
        driver = GetDriver.getDriver();
        connectionPage = new ConnectionPageObject(driver);
        menuPage = new MenuPageObject(driver);
        settingsPage = new SettingsPageObject(driver);
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.login("test21@vpn99.net", "test21_Tdutybq");
    }

    @After
    public void quit() {
        GetDriver.teardown();
    }

    @Test
    public void enterPromoCode() throws InterruptedException {
        // Act
        connectionPage.menuButtonClick();
        menuPage.pressButton("Settings");
        settingsPage.enterPromoCode();
        // Assert
        boolean expectedResult = true;
        Assert.assertEquals(expectedResult, settingsPage.isErrorPresent());
    }
}
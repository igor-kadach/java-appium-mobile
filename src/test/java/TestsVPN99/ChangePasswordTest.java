package TestsVPN99;

import PageObjects.*;
import Utils.*;
import io.appium.java_client.AppiumDriver;
import org.junit.*;

import java.net.MalformedURLException;

public class ChangePasswordTest {
    private AppiumDriver driver;
    private ConnectionPageObject connectionPage;
    private MenuPageObject menuPage;
    private SettingsPageObject settingsPage;
    private LoginHelper loginHelper;
    private ChangePasswordPageObject changePasswordPage;

    @Before
    public void setup() throws MalformedURLException {
        driver = GetDriver.getDriver();
        connectionPage = new ConnectionPageObject(driver);
        menuPage = new MenuPageObject(driver);
        settingsPage = new SettingsPageObject(driver);
        changePasswordPage = new ChangePasswordPageObject(driver);
        loginHelper = new LoginHelper(driver);
        loginHelper.login("test@testmail.com", "Qwerty123456" );
    }

    @After
    public void quit() throws InterruptedException {
        menuPage.pressButton("Settings");
        settingsPage.changePasswordButtonClock();
        changePasswordPage.changePassword("123456Qwerty", "Qwerty123456", "Qwerty123456" );
        GetDriver.teardown();
    }

    @Test
    public void changePassword() throws InterruptedException {
        // Act
        connectionPage.menuButtonClick();
        menuPage.pressButton("Settings");
        settingsPage.changePasswordButtonClock();
        changePasswordPage.changePassword("Qwerty123456", "123456Qwerty", "123456Qwerty" );
        settingsPage.logOutClickIcon();
        loginHelper.login("test@testmail.com", "123456Qwerty" );
        connectionPage.menuButtonClick();
        // Assert
        boolean expectedResult = true;
        Assert.assertEquals(expectedResult, menuPage.isLogOutButtonDisplayed());
    }
}



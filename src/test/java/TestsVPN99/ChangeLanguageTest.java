package TestsVPN99;

import PageObjects.*;
import Utils.GetDriver;
import io.appium.java_client.AppiumDriver;
import org.junit.*;
import java.net.MalformedURLException;

public class ChangeLanguageTest {
    private AppiumDriver driver;
    private MainPageObject mainPage;
    private ConnectionPageObject connectionPage;
    private MenuPageObject menuPage;
    private SettingsPageObject settingsPage;

    @Before
    public void setup() throws MalformedURLException {
        driver = GetDriver.getDriver();
        mainPage = new MainPageObject(driver);
        connectionPage = new ConnectionPageObject(driver);
        menuPage = new MenuPageObject(driver);
        settingsPage = new SettingsPageObject(driver);
    }

    @After
    public void quit() {
        settingsPage.changeLanguageBack();
        GetDriver.teardown();
    }

    @Test
    public void changeLanguage() throws InterruptedException {
        // Act
        mainPage.closeMainPage();
        connectionPage.menuButtonClick();
        menuPage.pressButton("Settings");
        settingsPage.changeLanguage();
        // Assert
        boolean expectedResult = true;
        Assert.assertEquals(expectedResult, settingsPage.isDeutschLanguageDisplayed());
    }
}
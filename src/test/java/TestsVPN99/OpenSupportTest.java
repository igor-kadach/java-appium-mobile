package TestsVPN99;

import PageObjects.*;
import Utils.GetDriver;
import io.appium.java_client.AppiumDriver;
import org.junit.*;

import java.net.MalformedURLException;

public class OpenSupportTest {
    private AppiumDriver driver;
    private MainPageObject mainPage;
    private ConnectionPageObject connectionPage;
    private MenuPageObject menuPage;
    private SupportPageObject supportPage;

    @Before
    public void setup() throws MalformedURLException {
        driver = GetDriver.getDriver();
        mainPage = new MainPageObject(driver);
        connectionPage = new ConnectionPageObject(driver);
        menuPage = new MenuPageObject(driver);
        supportPage = new SupportPageObject(driver);
    }

    @After
    public void quit() {
        GetDriver.teardown();
    }

    @Test
    public void openSupportPage() throws InterruptedException {
        // Act
        mainPage.closeMainPage();
        connectionPage.menuButtonClick();
        menuPage.pressButton("Support");
        // Assert
        boolean expectedResult = true;
        Assert.assertEquals(expectedResult, supportPage.isMessageSent());
    }
}
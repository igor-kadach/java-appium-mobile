package TestsVPN99;

import PageObjects.*;
import Utils.GetDriver;
import io.appium.java_client.AppiumDriver;
import org.junit.*;

import java.net.MalformedURLException;

public class ConnectButtonTest {
    private AppiumDriver driver;
    private MainPageObject mainPage;
    private ConnectionPageObject connectionPage;
    private MenuPageObject menuPage;

    @Before
    public void setup() throws MalformedURLException {
        driver = GetDriver.getDriver();
        mainPage = new MainPageObject(driver);
        connectionPage = new ConnectionPageObject(driver);
        menuPage = new MenuPageObject(driver);
    }

    @After
    public void quit() {
        GetDriver.teardown();
    }

    @Test
    public void openConnectPage() throws InterruptedException {
        // Act
        mainPage.closeMainPage();
        connectionPage.menuButtonClick();
        menuPage.pressButton("Connect");
        // Assert
        boolean expectedResult = true;
        Assert.assertEquals(expectedResult, connectionPage.isGetProVersionButtonPresent());
    }
}
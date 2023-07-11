package TestsVPN99;

import PageObjects.*;
import io.appium.java_client.AppiumDriver;
import Utils.GetDriver;
import org.junit.*;

import java.net.MalformedURLException;

public class GetProVersionTest {
    private AppiumDriver driver;
    private MainPageObject mainPage;
    private ConnectionPageObject connectionPage;

    @Before
    public void setup() throws MalformedURLException {
        driver = GetDriver.getDriver();
        mainPage = new MainPageObject(driver);
        connectionPage = new ConnectionPageObject(driver);
    }

    @After
    public void quit() {
        GetDriver.teardown();
    }

    @Test
    public void redirectToMainPage() {
        // Act
        mainPage.closeMainPage();
        connectionPage.redirectToMainPage();
        // Assert
        boolean expectedResult = true;
        Assert.assertEquals(expectedResult, mainPage.isBuyYearPresent());
    }
}
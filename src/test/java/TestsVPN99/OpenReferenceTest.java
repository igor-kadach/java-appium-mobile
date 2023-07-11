package TestsVPN99;

import PageObjects.*;
import Utils.GetDriver;
import io.appium.java_client.AppiumDriver;
import org.junit.*;

import java.net.MalformedURLException;

public class OpenReferenceTest {
    private AppiumDriver driver;
    private MainPageObject mainPage;
    private ConnectionPageObject connectionPage;
    private MenuPageObject menuPage;
    private ReferencePageObject referencePage;

    @Before
    public void setup() throws MalformedURLException {
        driver = GetDriver.getDriver();
        mainPage = new MainPageObject(driver);
        connectionPage = new ConnectionPageObject(driver);
        menuPage = new MenuPageObject(driver);
        referencePage = new ReferencePageObject(driver);
    }

    @After
    public void quit() {
        GetDriver.teardown();
    }

    @Test
    public void openReferencePageTest() throws InterruptedException {
        // Act
        mainPage.closeMainPage();
        connectionPage.menuButtonClick();
        menuPage.pressButton("Reference");
        // Assert
        boolean expectedResult = true;
        Assert.assertEquals(expectedResult, referencePage.isReferencePageOpen());
    }
}
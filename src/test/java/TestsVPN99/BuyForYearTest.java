package TestsVPN99;

import PageObjects.MainPageObject;
import Utils.GetDriver;
import io.appium.java_client.AppiumDriver;
import org.junit.*;

import java.net.MalformedURLException;

public class BuyForYearTest {
    private AppiumDriver driver;
    private MainPageObject mainPage;

    @Before
    public void setup() throws MalformedURLException {
        driver = GetDriver.getDriver();
        mainPage = new MainPageObject(driver);
    }

    @After
    public void quit() {
        GetDriver.teardown();
    }

    @Test
    public void buyYear(){
        // Act
        mainPage.pressButton("Year");
        // Assert
        String expectedResult = "Add credit or debit card";
        Assert.assertEquals(expectedResult, mainPage.getCreditCardText());
    }
}
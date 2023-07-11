package TestsVPN99;

import PageObjects.*;
import Utils.*;
import io.appium.java_client.AppiumDriver;
import org.junit.*;

import java.net.MalformedURLException;

public class LoginMainPageTest {
    private AppiumDriver driver;
    private MenuPageObject menuPage;
    private ConnectionPageObject connectionPage;
    private LoginHelper loginHelper;

    @Before
    public void setup() throws MalformedURLException {
        driver = GetDriver.getDriver();
        menuPage = new MenuPageObject(driver);
        connectionPage = new ConnectionPageObject(driver);
        loginHelper = new LoginHelper(driver);
    }

    @After
    public void quit() {
        menuPage.logOut();
        GetDriver.teardown();
    }

    @Test
    public void testLogin() {
        // Act
        loginHelper.login("test21@vpn99.net", "test21_Tdutybq");
        connectionPage.menuButtonClick();
        // Assert
        boolean expectedResult = true;
        Assert.assertEquals(expectedResult, menuPage.isLogOutButtonDisplayed());
    }
}
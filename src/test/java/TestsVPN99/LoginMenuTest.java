package TestsVPN99;

import PageObjects.*;
import Utils.GetDriver;
import Utils.LoginHelper;
import io.appium.java_client.AppiumDriver;
import org.junit.*;

import java.net.MalformedURLException;

public class LoginMenuTest {
    private AppiumDriver driver;
    private MainPageObject mainPage;
    private ConnectionPageObject connectionPage;
    private MenuPageObject menuPage;
    private LoginHelper loginHelper;

    @Before
    public void setup() throws MalformedURLException {
        driver = GetDriver.getDriver();
        mainPage = new MainPageObject(driver);
        connectionPage = new ConnectionPageObject(driver);
        menuPage = new MenuPageObject(driver);
        loginHelper = new LoginHelper(driver);
    }

    @After
    public void quit() {
        menuPage.logOut();
        GetDriver.teardown();
    }

    @Test
    public void loginInMenu() throws InterruptedException {
        // Act
        mainPage.closeMainPage();
        connectionPage.menuButtonClick();
        loginHelper.login("test21@vpn99.net", "test21_Tdutybq");
        connectionPage.menuButtonClick();
        // Assert
        boolean expectedResult = true;
        Assert.assertEquals(expectedResult, menuPage.isLogOutButtonDisplayed());
    }
}
package TestsVPN99;

import PageObjects.*;
import Utils.*;
import io.appium.java_client.AppiumDriver;
import org.junit.*;

import java.net.MalformedURLException;

public class LoginWithWrongPasswordTest {
    private AppiumDriver driver;
    private LoginHelper loginHelper;
    private LoginPageObject loginPage;

    @Before
    public void setup() throws MalformedURLException {
        driver = GetDriver.getDriver();
        loginHelper = new LoginHelper(driver);
        loginPage = new LoginPageObject(driver);
    }

    @After
    public void quit() {
        GetDriver.teardown();
    }

    @Test
    public void testLogin() {
        // Act
        loginHelper.login("test21@vpn99.net", "wrongPass");
        // Assert
        boolean expectedResult = true;
        Assert.assertEquals(expectedResult, loginPage.isWrongPasswordMessageDisplayed());
    }
}
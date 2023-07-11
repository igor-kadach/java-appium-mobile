package TestsVPN99;

import PageObjects.*;
import Utils.*;
import io.appium.java_client.AppiumDriver;
import org.junit.*;

import java.net.MalformedURLException;

public class ChooseServerTest {
    private AppiumDriver driver;
    private ConnectionPageObject connectionPage;
    private ServersPageObject serversPage;

    @Before
    public void setup() throws MalformedURLException {
        driver = GetDriver.getDriver();
        connectionPage = new ConnectionPageObject(driver);
        serversPage = new ServersPageObject(driver);
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.login("test21@vpn99.net", "test21_Tdutybq");
    }

    @After
    public void quit() {
        GetDriver.teardown();
    }

    @Test
    public void chooseServer() {
        // Act
        connectionPage.chooseServerButtonClick();
        serversPage.chooseCountryFromList();
        // Assert
        boolean expectedResult = true;
        Assert.assertEquals(expectedResult, connectionPage.isCanadaPresent());
    }
}
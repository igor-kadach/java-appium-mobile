package TestsVPN99;

import Utils.GetDriver;
import io.appium.java_client.AppiumDriver;
import org.junit.*;

import java.net.MalformedURLException;

public class OpenApplicationTest {
    private AppiumDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        driver = GetDriver.getDriver();
    }

    @After
    public void teardown() {
        GetDriver.teardown();
    }

    @Test
    public void testAppLaunch() {
        // Act
        boolean isAppOpened = driver.getSessionId() != null;
        // Assert
        Assert.assertEquals(isAppOpened, true);
    }
}
package TestsVPN99;

import PageObjects.*;
import Utils.GetDriver;
import io.appium.java_client.AppiumDriver;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SignUpTest {
    private AppiumDriver driver;
    private MainPageObject mainPage;
    private ConnectionPageObject connectionPage;
    private MenuPageObject menuPage;
    private SignUpPageObject signUpPage;
    private final String emailDomain;
    private final String password;
    private final String confirmPassword;
    private final boolean expectedResult;

    public SignUpTest(String emailDomain, String password, String confirmPassword, boolean expectedResult) {
        this.emailDomain = emailDomain;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setup() throws MalformedURLException {
        driver = GetDriver.getDriver();
        mainPage = new MainPageObject(driver);
        connectionPage = new ConnectionPageObject(driver);
        menuPage = new MenuPageObject(driver);
        signUpPage = new SignUpPageObject(driver);
    }

    @After
    public void quit() {
        GetDriver.teardown();
    }

    @Parameterized.Parameters
    public static Collection signUpParameters() {
        return Arrays.asList(new Object[][]{
                        {"@testmail.com", "123456Qwerty", "123456Qwerty", true},
                        {"@testmail.com", "123ty", "123456Qwerty", false},
                }
        );
    }

    @Test
    public void signUp() throws InterruptedException {
        // Act
        mainPage.closeMainPage();
        connectionPage.menuButtonClick();
        menuPage.pressButton("Sign up");
        signUpPage.signUp(emailDomain, password, confirmPassword);
        connectionPage.menuButtonClick();
        // Assert
        boolean actualResult = menuPage.isLogOutButtonDisplayed() == true;
        Assert.assertEquals(expectedResult, actualResult);
    }
}
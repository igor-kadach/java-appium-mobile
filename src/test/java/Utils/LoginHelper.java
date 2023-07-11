package Utils;

import PageObjects.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginHelper extends GetDriver {
    private final MainPageObject mainPage;
    private final LoginPageObject loginPage;

    public LoginHelper(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        loginPage = new LoginPageObject(driver);
        mainPage = new MainPageObject(driver);
    }

    public void login(String email, String password) {
        mainPage.pressButton("Login");
        loginPage.logIn(email, password);
    }
}
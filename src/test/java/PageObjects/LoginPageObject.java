package PageObjects;

import Utils.Waiter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
    private AppiumDriver driver;
    private Waiter wait;

    public LoginPageObject(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.EditText[1]")
    private WebElement emailField;
    @FindBy(xpath = "//android.widget.EditText[2]")
    private WebElement passwordField;
    @FindBy(xpath = "//android.widget.TextView[@text='Login']")
    private WebElement loginButton;
    @FindBy(xpath = "//android.widget.TextView[1]")
    private WebElement backButton;
    @FindBy(xpath = "//android.widget.TextView[@text='Incorrect e-mail or password']")
    private WebElement wrongPasswordMessage;

    public void logIn(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void goToBack() {
        wait.waitForElementToBeVisible(driver, By.xpath("//android.widget.TextView[1]"), 15);
        backButton.click();
    }

    public boolean isLoginButtonPresent() {
        return loginButton.isDisplayed();
    }

    public boolean isWrongPasswordMessageDisplayed() {
        return wrongPasswordMessage.isDisplayed();
    }
}
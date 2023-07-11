package PageObjects;

import Utils.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPageObject extends GetDriver {
    public SignUpPageObject(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.EditText[1]")
    private WebElement emailField;
    @FindBy(xpath = "//android.widget.EditText[2]")
    private WebElement passwordField;
    @FindBy(xpath = "//android.widget.EditText[3]")
    private WebElement confirmPasswordField;
    @FindBy(xpath = "//android.widget.TextView[@text='Sign up']")
    private WebElement signUpButton;

    public void signUp(String emailDomain, String password, String confirmPassword) {
        emailField.sendKeys(RandomHelper.generateRandomString().concat(emailDomain));
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        signUpButton.click();
    }
}
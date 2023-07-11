package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPageObject {
    public ChangePasswordPageObject(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.EditText[1]")
    private WebElement currentPasswordField;
    @FindBy(xpath = "//android.widget.EditText[2]")
    private WebElement passwordField;
    @FindBy(xpath = "//android.widget.EditText[3]")
    private WebElement newPasswordConfirmationField;
    @FindBy(xpath = "//android.widget.TextView[@text='Save']")
    private WebElement saveButton;

    public void changePassword(String password, String newPassword, String ConfirmPassword) {
        currentPasswordField.sendKeys(password);
        passwordField.sendKeys(newPassword);
        newPasswordConfirmationField.sendKeys(ConfirmPassword);
        saveButton.click();
    }
}
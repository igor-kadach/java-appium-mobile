package PageObjects;

import Utils.GetDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupportPageObject extends GetDriver {
    public SupportPageObject(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.EditText[1]")
    private WebElement emailField;
    @FindBy(xpath = "//android.widget.EditText[2]")
    private WebElement messageField;
    @FindBy(xpath = "//android.widget.TextView[@text='Send']")
    private WebElement sendButton;
    @FindBy(xpath = "//android.widget.TextView[@text='E-MAIL']")
    private WebElement emailFieldName;

    public void sendMessage() {
        emailField.sendKeys("testEmail@gmail.com");
        messageField.sendKeys("testMessage");
        sendButton.click();
    }

    public boolean isMessageSent() {
        return emailFieldName.isDisplayed();
    }
}
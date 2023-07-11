package PageObjects;

import Utils.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReferencePageObject extends GetDriver {
    public ReferencePageObject(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='What does VPN mean?']")
    private WebElement titleOfReferencePage;

    public boolean isReferencePageOpen() {
        return titleOfReferencePage.isDisplayed();
    }
}
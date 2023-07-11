package PageObjects;

import Utils.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServersPageObject extends GetDriver {
    private AppiumDriver driver;
    private Waiter wait;

    public ServersPageObject(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.EditText[@text='Country']")
    private WebElement chooseCountryForVPN;
    @FindBy(xpath = "//android.widget.TextView[@text='Canada']")
    private WebElement canada;

    public void chooseCountryFromList() {
        wait.waitForElementToBeVisible(driver, By.xpath("//android.widget.TextView[@text='Canada']"), 10);
        canada.click();
    }
}
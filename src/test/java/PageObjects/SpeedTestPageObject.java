package PageObjects;

import Utils.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpeedTestPageObject extends GetDriver {
    private AppiumDriver driver;
    private Waiter wait;

    public SpeedTestPageObject(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Run']")
    private WebElement runSpeedTest;
    @FindBy(xpath = "//android.widget.TextView[@text='Test has run successfully']")
    private WebElement speedTestFinished;

    public void startSpeedTest() {
        runSpeedTest.click();
        wait.waitForElementToBeVisible(driver, By.xpath("//android.widget.TextView[@text='Test has run successfully']"), 60);
    }

    public boolean isSpeedTestFinished() {
        return speedTestFinished.isDisplayed();
    }
}
package PageObjects;

import Utils.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPageObject extends GetDriver {
    private AppiumDriver driver;
    private Waiter wait;

    public MenuPageObject(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Log out']")
    private WebElement logOutButton;
    @FindBy(xpath = "//android.widget.Button[@text='YES']")
    private WebElement acceptLogOutButton;

    public boolean isLogOutButtonDisplayed() {
        try {
            logOutButton.isDisplayed();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void logOut() {
        wait.waitForElementToBeVisible(driver, By.xpath("//android.widget.TextView[@text='Log out']"), 10);
        logOutButton.click();
        acceptLogOutButton.click();
        wait.waitForElementToBeInvisible(driver, By.xpath("//android.widget.TextView[@text='Log out']"), 10);
    }

    public void pressButton(String buttonName) throws InterruptedException {
        Thread.sleep(1000);
        WebElement button = driver.findElement(By.xpath("//android.widget.TextView[@text='" + buttonName + "']"));
        button.click();
    }
}
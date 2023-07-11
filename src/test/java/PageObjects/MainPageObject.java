package PageObjects;

import Utils.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageObject extends GetDriver {
    private AppiumDriver driver;
    private Waiter wait;

    public MainPageObject(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.TextView[1]")
    private WebElement restorePurchasesButton;
    @FindBy(xpath = "//android.widget.TextView[@text='Year']")
    private WebElement buyYear;
    @FindBy(xpath = "//android.widget.TextView[@text='Add credit or debit card']")
    private WebElement addCard;
    @FindBy(xpath = "//android.widget.TextView")
    private WebElement closeButton;

    public void pressButton(String buttonName) {
        wait.waitForElementToBeVisible(driver, By.xpath("//android.widget.TextView[@text='Login']"), 40);
        WebElement button = driver.findElement(By.xpath("//android.widget.TextView[@text='" + buttonName + "']"));
        button.click();
    }

    public String getCreditCardText() {
        wait.waitForElementToBeVisible(driver, By.xpath("//android.widget.TextView[@text='Add credit or debit card']"), 15);
        return addCard.getText();
    }

    public void closeMainPage() {
        wait.waitForElementToBeVisible(driver, By.xpath("//android.widget.TextView[@text='Year']"), 40);
        closeButton.click();
    }

    public boolean isBuyYearPresent() {
        return buyYear.isDisplayed();
    }
}
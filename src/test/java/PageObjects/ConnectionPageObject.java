package PageObjects;

import Utils.Waiter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConnectionPageObject {
    private AppiumDriver driver;
    private Waiter wait;

    public ConnectionPageObject(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Get PRO version']")
    private WebElement getProVersionButton;
    @FindBy(xpath = "//android.widget.TextView")
    private WebElement menuButton;
    @FindBy(xpath = "//android.view.ViewGroup")
    private WebElement connectionButton;
    @FindBy(xpath = "//android.widget.TextView[@text='is protected']")
    private WebElement connectionIsProtected;
    @FindBy(xpath = "//android.view.ViewGroup[2]/android.widget.ImageView")
    private WebElement serversList;
    @FindBy(xpath = "//android.widget.TextView[@text='Canada']")
    private WebElement canadaServer;

    public void redirectToMainPage() {
        getProVersionButton.click();
    }

    public boolean isGetProVersionButtonPresent() {
        return getProVersionButton.isDisplayed();
    }

    public void menuButtonClick() {
        wait.waitForElementToBeVisible(driver, By.xpath("//android.widget.TextView"), 10);
        menuButton.click();
    }

    public void connectionVPN() {
        connectionButton.click();
    }

    public boolean isVPNConnected() {
        wait.waitForElementToBeVisible(driver, By.xpath("//android.widget.TextView[@text='is protected']"), 30);
        return connectionIsProtected.isDisplayed();
    }

    public void chooseServerButtonClick() {
        serversList.click();
    }

    public boolean isCanadaPresent() {
        wait.waitForElementToBeVisible(driver, By.xpath("//android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView"), 10);
        return canadaServer.isDisplayed();
    }
}
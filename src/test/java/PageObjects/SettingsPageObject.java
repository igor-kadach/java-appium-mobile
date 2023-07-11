package PageObjects;

import Utils.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPageObject extends GetDriver {
    private AppiumDriver driver;
    private Waiter wait;

    public SettingsPageObject(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Language']")
    private WebElement languageDropListName;
    @FindBy(xpath = "//android.widget.TextView[@text='Change language']")
    private WebElement changeLanguageButton;
    @FindBy(xpath = "//android.widget.TextView[@text='Sprache ändern']")
    private WebElement changeLanguageBack;
    @FindBy(xpath = "//android.widget.TextView[@text='Change protocol']")
    private WebElement changeProtocolButton;
    @FindBy(xpath = "//android.widget.TextView[@text='Deutsch']")
    private WebElement deutschLanguage;
    @FindBy(xpath = "//android.widget.TextView[@text='English']")
    private WebElement englishLanguage;
    @FindBy(xpath = "//android.widget.TextView[@text='SPRACHE']")
    private WebElement changeLanguageInDeutsch;
    @FindBy(xpath = "//android.widget.ImageView")
    private WebElement logOutIcon;
    @FindBy(xpath = "//android.widget.TextView[@text='Change password']")
    private WebElement changePassword;
    @FindBy(xpath = "//android.widget.TextView[@text='Subscribe']")
    private WebElement subscribeButton;
    @FindBy(xpath = "//android.widget.TextView[@text='Activate promo code']")
    private WebElement activatePromoCode;
    @FindBy(xpath = "//android.widget.Button[@text='YES']")
    private WebElement acceptLogOutButton;
    @FindBy(xpath = "//android.widget.EditText")
    private WebElement promoCodeField;
    @FindBy(xpath = "//android.widget.TextView[@text='Save']")
    private WebElement savePromoCodeButton;
    @FindBy(xpath = "//android.widget.TextView[@text='Error']")
    private WebElement errorWindow;
    @FindBy(xpath = "//android.widget.TextView[@text='OpenVPN® (port 80, TCP)']")
    private WebElement openVPNProtocol;

    public boolean isSettingOpen() {
        return languageDropListName.isDisplayed();
    }

    public void changeLanguage() {
        changeLanguageButton.click();
        deutschLanguage.click();
        wait.waitForElementToBeVisible(driver, By.xpath("//android.widget.TextView[@text='SPRACHE']"), 10);
    }

    public void changeLanguageBack() {
        changeLanguageBack.click();
        englishLanguage.click();
    }

    public boolean isDeutschLanguageDisplayed() {
        return changeLanguageInDeutsch.isDisplayed();
    }

    public void changePasswordButtonClock() {
        changePassword.click();
    }

    public void logOutClickIcon() {
        wait.waitForElementToBeVisible(driver, By.xpath("//android.widget.ImageView"), 15);
        logOutIcon.click();
        acceptLogOutButton.click();
    }

    public void enterPromoCode() {
        activatePromoCode.click();
        wait.waitForElementToBeVisible(driver, By.xpath("//android.widget.TextView[@text='PROMO CODE']"), 15);
        promoCodeField.sendKeys("promoCode");
        savePromoCodeButton.click();
    }

    public boolean isErrorPresent() {
        wait.waitForElementToBeVisible(driver, By.xpath("//android.widget.TextView[@text='Error']"), 15);
        return errorWindow.isDisplayed();
    }

    public void changeProtocol() {
        changeProtocolButton.click();
        openVPNProtocol.click();
    }

    public boolean isProtocolChanged() {
        wait.waitForElementToBeVisible(driver, By.xpath("//android.widget.TextView[@text='OpenVPN® (port 80, TCP)']"), 15);
        return openVPNProtocol.isDisplayed();
    }
}
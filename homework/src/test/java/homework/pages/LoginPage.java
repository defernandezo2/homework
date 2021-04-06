package homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    WebDriver driver;
    private String loginPath = "/login";
    private By acceptCookies = By.className("consentForm__acceptButton");
    private By absenden = By.id("newsletterFormSubmitBtn");
    private By emailTextField = By.name("email");
    private By confirmationMessage = By.className("footerNewsletter__confirmation");
    private By newsSellerSubscriptionContainer = By.className("footerNewsletter__container");

    public LoginPage(WebDriver driverP) {
        driver = driverP;
    }

    public LoginPage load() {
        driver.get(baseUrl + loginPath);
        return this;
    }

    public void acceptCookies() {
        driver.findElement(acceptCookies).click();
    }

    public void clickAbsendenButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(absenden));
        actions.perform();
        driver.findElement(absenden).click();
    }

    public void enterEmail(String email) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(emailTextField));
        actions.perform();
        driver.findElement(emailTextField).sendKeys(email);
    }

    public void verifyConfirmationEmailMessageIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));
    }

    public void verifyNewsSellerIsPresent() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(newsSellerSubscriptionContainer));
    }


}

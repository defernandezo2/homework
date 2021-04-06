package homework.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    WebDriver driver;

    public HomePage(WebDriver driverP) {
        driver = driverP;
    }

    public HomePage load() {
        driver.get(baseUrl);
        return this;
    }
}

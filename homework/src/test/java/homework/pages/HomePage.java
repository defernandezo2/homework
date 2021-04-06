package homework.pages;

import org.openqa.selenium.WebDriver;

/**
 * Class representing the home and main page
 */
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

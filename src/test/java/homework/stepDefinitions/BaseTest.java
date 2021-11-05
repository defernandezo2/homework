package homework.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class is created to gather all the configuration needed to run the test, like driver and driver properties
 */
public abstract class BaseTest {


    protected WebDriver driver;

    public void setupDriver() {
//        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

}

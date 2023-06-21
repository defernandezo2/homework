package homework.stepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class is created to gather all the configuration needed to run the test, like driver and driver properties
 */
public abstract class BaseTest {


    protected WebDriver driver;

    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(2000, 10)); // To 2nd monitor.
        driver.manage().window().maximize();
    }

}

package homework.stepDefinitions;

import homework.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Random;

/**
 * The login page testing feature
 */
public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private Random rd = new Random();
    private Scenario myScenario;

    @Before()
    public void embedScreenshotStep(Scenario scenario) {

        myScenario = scenario;

    }
    @Given("a Höffner login page")
    public void a_Höffner_login_page() {
        setupDriver();
        loginPage = new LoginPage(driver);
    }

    @When("I open a page")
    public void i_open_a_page() {
        loginPage.load();
        loginPage.acceptCookies();
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        myScenario.attach(screenshot, "image/png","loaded login page");  // Stick it in the report
    }

    @Then("I can see a newsletter subscription input")
    public void I_can_see_a_newsletter_subscription_input() {
        loginPage.verifyNewsSellerIsPresent();
    }

    @When("enter my email in the input field")
    public void enter_my_email_in_the_input_field() {
        loginPage.enterEmail("Email" + rd.nextInt() + "@mail.com");
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        myScenario.attach(screenshot, "image/png","email field");  // Stick it in the report
    }

    @When("I press Absenden button")
    public void i_press_absenden_button() {
        loginPage.clickAbsendenButton();
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        myScenario.attach(screenshot, "image/png","clicked Absenden");  // Stick it in th
    }

    @Then("I can see a confirmation message that my subscription is in progress")
    public void i_can_see_a_confirmation_message_that_my_subscription_is_in_progress() {
        loginPage.verifyConfirmationEmailMessageIsVisible();
    }

    @When("enter a wrong formatted email in the input field")
    public void enter_a_wrong_formatted_email_in_the_input_field() {
        loginPage.enterEmail("Email" + rd.nextInt());
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        myScenario.attach(screenshot, "image/png","other email");  // Stick
    }

    @Then("A Wrong Message Is Displayed")
    public void a_wrong_message_is_displayed() {
        loginPage.verifyEmailErrorMessageIsDisplayed();
    }

    @When("enter a valid {string} in the input field")
    public void enterAValidInTheInputField(String arg0) {
        loginPage.enterEmail(arg0 + rd.nextInt() + "@mail.com");
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        myScenario.attach(screenshot, "image/png","other email");  // Stick
    }

    @After
    public void tearDown(Scenario scenario) {
        driver.close();
    }
}

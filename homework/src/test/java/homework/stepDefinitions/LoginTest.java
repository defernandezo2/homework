package homework.stepDefinitions;

import homework.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Random;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    Random rd = new Random();

    @Given("a Höffner login page")
    public void a_Höffner_login_page() {
        setupDriver();
        loginPage = new LoginPage(driver);
    }

    @When("I open a page")
    public void i_open_a_page() {
        loginPage.load();
        loginPage.acceptCookies();
    }

    @Then("I can see a newsletter subscription input")
    public void I_can_see_a_newsletter_subscription_input() {
        loginPage.verifyNewsSellerIsPresent();
    }

    @When("enter my email in the input field")
    public void enter_my_email_in_the_input_field() {
        loginPage.enterEmail("Email" + rd.nextInt() + "@mail.com");
    }

    @When("I press Absenden button")
    public void i_press_absenden_button() {
        loginPage.clickAbsendenButton();
    }

    @Then("I can see a confirmation message that my subscription is in progress")
    public void i_can_see_a_confirmation_message_that_my_subscription_is_in_progress() {
        loginPage.verifyConfirmationEmailMessageIsVisible();
    }

    @After
    public void tearDown() {
        driver.close();
    }
}

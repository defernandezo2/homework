package homework.pages;

import homework.configurations.Configurations;

/**
 * Class is created to gather all the global configurations for the pages, so far they only have the Base url to use
 */
public abstract class BasePage {
    protected String baseUrl = Configurations.getInstance().getProperty("TEST_TARGET_URL");
}

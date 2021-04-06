package homework.pages;

import homework.configurations.Configurations;

public abstract class BasePage {
    protected String baseUrl = Configurations.getInstance().getProperty("TEST_TARGET_URL");
}

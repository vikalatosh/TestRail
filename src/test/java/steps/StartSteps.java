package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class StartSteps {
    LoginPage loginPage;

    public StartSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    public LoginPage openLoginPage(String baseUrl) {
        return loginPage
                .openLoginPage(baseUrl);
    }

    public LoginPage isPageOpened() {
        boolean isOpened = loginPage
                .isPageOpened();
        assertTrue(isOpened, "Login page was not opened");
        return loginPage;
    }
}

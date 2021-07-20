package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class StartSteps {
    LoginPage loginPage;

    public StartSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    public StartSteps openLoginPage(String baseUrl) {
        loginPage
                .openLoginPage(baseUrl);
        return this;
    }

    public StartSteps isLoginPageOpened() {
        boolean isOpened = loginPage
                .isPageOpened();
        assertTrue(isOpened, "Login page was not opened");
        return this;
    }
}

package steps;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginSteps {
    HomePage homePage;
    LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    public HomePage login(String email, String password) {
        loginPage
                .login(email, password);
        return homePage;
    }

    public HomePage isPageOpened() {
        boolean isOpened = loginPage
                .isPageOpened();
        assertTrue(isOpened, "Home page was not opened");
        return homePage;
    }
}

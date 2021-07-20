package steps;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginSteps {
    HomePage homePage;
    LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    public LoginSteps loginByEmailAndPassword(String email, String password) {
        loginPage
                .login(email, password);
        return this;
    }

    public LoginSteps clickTheButtonLogIn() {
        loginPage
                .clickLogIn();
        return this;
    }

    public void isHomePageOpened() {
        boolean isOpened = homePage
                .isPageOpened();
        assertTrue(isOpened, "Home page was not opened");
    }

    public void validateLoginPageMessage(String errorMessage) {
        String message = loginPage
                .getLoginPageMessage();
        assertEquals(message, errorMessage, "Error message is not correct");
    }
}

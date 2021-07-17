package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(description = "Login should be successful")
    public void login() {
        boolean isOpened = loginPage
                .openLoginPage(baseUrl)
                .isPageOpened();
        assertTrue(isOpened, "Login page was not opened");
        isOpened = loginPage
                .login(email, password)
                .isPageOpened();
        assertTrue(isOpened, "Home page was not opened");
    }
}

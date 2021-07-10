package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        boolean isOpened = loginPage
                .openLoginPage(baseUrl)
                .isPageOpened();
        assertTrue(isOpened, "Login Page was not opened");
        isOpened = loginPage
                .login(email, password)
                .isPageOpened();
        assertTrue(isOpened, "Home Page was not opened");
    }
}

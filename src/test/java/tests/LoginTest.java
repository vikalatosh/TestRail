package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class LoginTest extends BaseTest {

    @Test(description = "Login should be successful")
    public void login() {
        startSteps
                .openLoginPage(baseUrl)
                .isPageOpened();
        loginSteps
                .login(email, password)
                .isPageOpened();
    }
}

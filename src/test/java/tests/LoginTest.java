package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class LoginTest extends BaseTest {

    @Test(description = "Login should be successful")
    public void login() {
        startSteps
                .openLoginPage(baseUrl)
                .isLoginPageOpened();
        loginSteps
                .loginByEmailAndPassword(email, password)
                .clickTheButtonLogIn()
                .isHomePageOpened();
    }

    @DataProvider(name = "Login Data")
    public Object[][] loginData() {
        return new Object[][]{
                {"", password, "Email/Login is required."},
                {email, "", "Password is required."},
        };
    }

    @Test(description = "Negative tests for login", dataProvider = "Login Data")
    public void negativeTestsForLogin(String email, String password, String errorMessage) {
        startSteps
                .openLoginPage(baseUrl)
                .isLoginPageOpened();
        loginSteps
                .loginByEmailAndPassword(email, password)
                .clickTheButtonLogIn()
                .validateLoginPageMessage(errorMessage);
    }
}

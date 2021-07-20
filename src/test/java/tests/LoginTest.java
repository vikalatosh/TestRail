package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class LoginTest extends BaseTest {

    @DataProvider(name = "Login")
    public Object[][] loginData11() {
        return new Object[][]{
                {email, password},
        };
    }

    @Test(description = "Login should be successful", dataProvider = "Login")
    public void login(String email, String password) {
        startSteps
                .openLoginPage(baseUrl)
                .isLoginPageOpened();
        loginSteps
                .loginByEmailAndPassword(email, password)
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

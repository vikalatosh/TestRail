package pages;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {
    public static final By EMAIL_INPUT = By.id("name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("button_primary");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check Login page is opened")
    public boolean isPageOpened() {
        log.info("Check Login page is opened by locator " + LOGIN_BUTTON);
        return isExist(LOGIN_BUTTON);
    }

    @Step("Open Login page")
    public LoginPage openLoginPage(String baseUrl) {
        log.info("Open Login page");
        driver.get(baseUrl + "/index.php?/auth/login");
        return this;
    }

    @Step("Log in by email {email}, password {password}")
    public HomePage login(String email, String password) {
        log.info("Log in by email " + email + ", password " + password);
        new Input(driver, "Name").write(email);
        new Input(driver, "Password").write(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }
}

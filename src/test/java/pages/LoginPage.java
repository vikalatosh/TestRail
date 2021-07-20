package pages;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {
    public static final By LOGIN_PAGE_MESSAGE = By.cssSelector(".loginpage-message");
    public static final By LOGIN_BUTTON = By.id("button_primary");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check Login page is opened")
    public boolean isPageOpened() {
        log.debug("Check Login page is opened by locator: {}", LOGIN_BUTTON);
        return isExist(LOGIN_BUTTON);
    }

    @Step("Open Login page by URL")
    public LoginPage openLoginPage(String baseUrl) {
        log.info("Open Login page by URL: {}/index.php?/auth/login", baseUrl);
        driver.get(baseUrl + "/index.php?/auth/login");
        return this;
    }

    @Step("Log in by email: {email}, password: {password}")
    public LoginPage login(String email, String password) {
        log.info("Log in by email: {}, password: {}", email, password);
        new Input(driver, "Name").write(email);
        new Input(driver, "Password").write(password);
        return this;
    }

    @Step("Click the button Log in")
    public LoginPage clickLogIn() {
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    @Step("Get message on the Login page")
    public String getLoginPageMessage() {
        return driver.findElement(LOGIN_PAGE_MESSAGE).getText();
    }
}

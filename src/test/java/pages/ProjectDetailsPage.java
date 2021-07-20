package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProjectDetailsPage extends BasePage {
    public static final By RETURN_TO_DASHBOARD_BUTTON = By.id("navigation-dashboard-top");
    public static final By ADD_BUTTON = By.id("sidebar-cases-add");


    public ProjectDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check Project details page is opened")
    public boolean isPageOpened() {
        log.debug("Check Login page is opened by locator: {}", RETURN_TO_DASHBOARD_BUTTON);
        return isExist(RETURN_TO_DASHBOARD_BUTTON);
    }

    @Step("Click the button Add")
    public TestCaseModal clickButtonAdd() {
        driver.findElement(ADD_BUTTON).click();
        return new TestCaseModal(driver);
    }
}

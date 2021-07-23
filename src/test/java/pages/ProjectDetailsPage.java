package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProjectDetailsPage extends BasePage {
    public static final By RETURN_TO_DASHBOARD_BUTTON = By.id("navigation-dashboard-top");
    public static final By ADD_CASE_BUTTON = By.id("sidebar-cases-add");
    public static final By ADD_MILESTONE_BUTTON = By.id("sidebar-milestones-add");

    public ProjectDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check Project details page is opened")
    public boolean isPageOpened() {
        log.debug("Check Login page is opened by locator: {}", RETURN_TO_DASHBOARD_BUTTON);
        return isExist(RETURN_TO_DASHBOARD_BUTTON);
    }

    @Step("Click the button 'Add Case'")
    public TestCaseModalPage clickButtonTheAddCaseButton() {
        driver.findElement(ADD_CASE_BUTTON).click();
        return new TestCaseModalPage(driver);
    }

    @Step("Click the button 'Add Milestone'")
    public MilestoneModalPage clickButtonTheAddMilestoneButton() {
        driver.findElement(ADD_MILESTONE_BUTTON).click();
        return new MilestoneModalPage(driver);
    }
}

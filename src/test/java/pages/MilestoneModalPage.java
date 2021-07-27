package pages;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Milestone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class MilestoneModalPage extends BasePage {
    public static final By MILESTONE_MODAL_PAGE_TITLE = By.xpath("//div[contains(text(),'Add Milestone')]");
    public static final By ADD_MILESTONE_BUTTON = By.id("accept");
    public static final By MILESTONE_CHECKBOX = By.id("is_completed");

    public MilestoneModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check Milestone modal page is opened")
    public boolean isPageOpened() {
        log.debug("Check Milestone modal page is opened by locator: {}", MILESTONE_MODAL_PAGE_TITLE);
        return isExist(MILESTONE_MODAL_PAGE_TITLE);
    }

    @Step("Create new milestone")
    public ProjectsPage createMilestone(Milestone milestone) {
        log.info("Create new project {}", milestone.getName());
        new Input(driver, "Name").write(milestone.getName());
        new Input(driver, "Reference").write(milestone.getReferences());
        new Input(driver, "Start_on").write(milestone.getStartDate());
        new Input(driver, "Due_on").write(milestone.getEndDate());
        driver.findElement(MILESTONE_CHECKBOX).click();
        driver.findElement(ADD_MILESTONE_BUTTON).click();
        return new ProjectsPage(driver);
    }
}

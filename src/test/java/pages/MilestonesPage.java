package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Milestone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

@Log4j2
public class MilestonesPage extends BasePage {
    public static final By MILESTONES_PAGE_TITLE = By.xpath("//div[contains(text(),'Milestones')]");
    public static final String MILESTONE_NAME_TEXT = "//*[contains(@id,'milestone')]//*[contains(text(),'%s')]";

    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check Milestones page is opened")
    public boolean isPageOpened() {
        log.debug("Check Projects page is opened by locator: {}", MILESTONES_PAGE_TITLE);
        return isExist(MILESTONES_PAGE_TITLE);
    }

    @Step("Check milestone is exist")
    public void milestoneIsExist(Milestone milestone) {
        boolean isExist = driver.findElement(By.xpath(String.format(MILESTONE_NAME_TEXT, milestone.getName()))).isDisplayed();
        log.info("Check milestone {} is exist", milestone.getName());
        assertTrue(isExist, "Milestone was not created");
    }
}

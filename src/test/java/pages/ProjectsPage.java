package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

@Log4j2
public class ProjectsPage extends BasePage {
    public static final By BANNER_LINK = By.id("bannerLink");
    public static final By DASHBOARD_BUTTON = By.xpath("//*[text()='Dashboard']");
    public static final By MESSAGE = By.cssSelector(".message-success");
    public static final String PROJECT_NAME_TEXT = "//*[contains(text(),'%s')]";


    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check Projects page is opened")
    public boolean isPageOpened() {
        log.debug("Check Projects page is opened by locator: {}", BANNER_LINK);
        return isExist(BANNER_LINK);
    }

    @Step("Get message on the page")
    public String getMessage() {
        log.debug("Get message on the page by locator: {}", MESSAGE);
        return driver.findElement(MESSAGE).getText();
    }

    @Step("Check project {actualName} is exist")
    public void projectIsExist(Project project) {
        String actualName = driver.findElement(By.xpath(String.format(PROJECT_NAME_TEXT, project.getName()))).getText();
        log.info("Check project {} is exist", actualName);
        assertEquals(actualName, project.getName());
    }

    public ProjectDetailsPage openProjectDetails(Project project) {
        driver.findElement(DASHBOARD_BUTTON).click();
        driver.findElement(By.xpath(String.format(PROJECT_NAME_TEXT, project.getName()))).click();
        return new ProjectDetailsPage(driver);
    }
}

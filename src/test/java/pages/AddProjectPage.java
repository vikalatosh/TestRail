package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AddProjectPage extends BasePage {
    public static final By BANNER_LINK = By.xpath("//*[contains(@class,'content-header-title')]");
    public static final By NAME_INPUT = By.id("name");
    public static final By ADD_PROJECT_BUTTON = By.id("accept");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check 'Add Project' page is opened")
    public boolean isPageOpened() {
        log.info("Check 'Add Project' page is opened by locator " + BANNER_LINK);
        return isExist(BANNER_LINK);
    }

    @Step("Create new project")
    public ProjectsPage createProject(Project project) {
        log.info("Create new project " + project.getName());
        driver.findElement(NAME_INPUT).sendKeys(project.getName());
        driver.findElement(ADD_PROJECT_BUTTON).click();
        return new ProjectsPage(driver);
    }
}

package pages;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProjectModalPage extends BasePage {
    public static final By PRODUCT_MODAL_PAGE_TITLE = By.xpath("//div[contains(text(),'Add Project')]");
    public static final By ADD_PROJECT_BUTTON = By.id("accept");

    public ProjectModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check Project modal page is opened")
    public boolean isPageOpened() {
        log.debug("Check Project modal page is opened by locator: {}", PRODUCT_MODAL_PAGE_TITLE);
        return isExist(PRODUCT_MODAL_PAGE_TITLE);
    }

    @Step("Create new project")
    public ProjectsPage createProject(Project project) {
        log.info("Create new project {}", project.getName());
        new Input(driver, "Name").write(project.getName());
        driver.findElement(ADD_PROJECT_BUTTON).click();
        return new ProjectsPage(driver);
    }
}

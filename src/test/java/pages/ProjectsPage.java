package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static pages.HomePage.DASHBOARD_BUTTON;

@Log4j2
public class ProjectsPage extends BasePage {
    public static final By PROJECTS_PAGE_TITLE = By.xpath("//div[contains(text(),'Projects')]");
    public static final By MESSAGE = By.cssSelector(".message-success");
    public static final String PROJECT_NAME_TEXT = "//*[contains(text(),'%s')]";
    public static final String DELETE_ICON = "//*[text()='%s']//ancestor::*[contains(@class,'hoverSensitive')]" +
            "//*[@class='icon-small-delete']";
    public static final String DELETE_CHECKBOX = "//*[contains(text(),'Yes, delete this project')]" +
            "//ancestor::label//*[@name='deleteCheckbox']";
    public static final String OK_BUTTON = "//*[@id='deleteDialog']//*[contains(@class,'dialog-action-default')]";

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check Projects page is opened")
    public boolean isPageOpened() {
        log.debug("Check Projects page is opened by locator: {}", PROJECTS_PAGE_TITLE);
        return isExist(PROJECTS_PAGE_TITLE);
    }

    @Step("Get message on the page")
    public String getMessage() {
        log.debug("Get message on the page by locator: {}", MESSAGE);
        return driver.findElement(MESSAGE).getText();
    }

    @Step("Check project is exist")
    public void projectIsExist(Project project) {
        String actualName = driver.findElement(By.xpath(String.format(PROJECT_NAME_TEXT, project.getName()))).getText();
        log.info("Check project {} is exist", actualName);
        assertEquals(actualName, project.getName());
    }

    @Step("Open Project details page")
    public ProjectDetailsPage openProjectDetails(Project project) {
        driver.findElement(DASHBOARD_BUTTON).click();
        driver.findElement(By.xpath(String.format(PROJECT_NAME_TEXT, project.getName()))).click();
        return new ProjectDetailsPage(driver);
    }

    @Step("Delete created Project")
    public ProjectsPage deleteProject(Project project) {
        driver.findElement(By.xpath(String.format(DELETE_ICON, project.getName()))).click();
        driver.findElement(By.xpath(DELETE_CHECKBOX)).click();
        driver.findElement(By.xpath(OK_BUTTON)).click();
        return this;
    }
}

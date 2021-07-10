package pages;

import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProjectPage extends BasePage {
    public static final By BANNER_LINK = By.xpath("//*[contains(@class,'content-header-title')]");
    public static final By NAME_INPUT = By.id("name");
    public static final By ADD_PROJECT_BUTTON = By.id("accept");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isExist(BANNER_LINK);
    }

    public ProjectsPage createProject(Project project) {
        driver.findElement(NAME_INPUT).sendKeys(project.getName());
        driver.findElement(ADD_PROJECT_BUTTON).click();
        return new ProjectsPage(driver);
    }
}

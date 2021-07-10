package pages;

import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class ProjectsPage extends BasePage {
    public static final By BANNER_LINK = By.id("bannerLink");
    //*[contains(text(),'Successfully added the new project.')]
    public static final By MESSAGE = By.cssSelector(".message-success");
    public static final String PROJECT_NAME_TEXT = "//*[contains(text(),'%s')]";

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isExist(BANNER_LINK);
    }

    public String getMessage() {
        return driver.findElement(MESSAGE).getText();
    }

    public void projectIsExist(Project project) {
        String actualName = driver.findElement(By.xpath(String.format(PROJECT_NAME_TEXT, project.getName()))).getText();
        assertEquals(actualName, project.getName());
    }
}

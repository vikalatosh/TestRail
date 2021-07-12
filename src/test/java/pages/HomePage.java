package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HomePage extends BasePage {
    public static final By BANNER_LINK = By.id("bannerLink");
    public static final By ADD_PROJECT_BUTTON = By.id("sidebar-projects-add");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Check Home page is opened")
    public boolean isPageOpened() {
        log.info("Check Home page is opened by locator " + BANNER_LINK);
        return isExist(BANNER_LINK);
    }

    @Step("Click the button 'Add Project'")
    public HomePage clickButtonAddProject() {
        log.info("Click the button 'Add Project'");
        driver.findElement(ADD_PROJECT_BUTTON).click();
        return this;
    }
}

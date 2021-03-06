package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HomePage extends BasePage {
    public static final By HOME_PAGE_TITLE = By.xpath("//div[contains(text(),'All Projects')]");
    public static final By BANNER_LINK = By.id("bannerLink");
    public static final By ADD_PROJECT_BUTTON = By.id("sidebar-projects-add");
    public static final By DASHBOARD_BUTTON = By.xpath("//*[text()='Dashboard']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Check Home page is opened")
    public boolean isPageOpened() {
        log.debug("Check Home page is opened by locator: {}", HOME_PAGE_TITLE);
        return isExist(HOME_PAGE_TITLE);
    }

    @Step("Click the button 'Add Project'")
    public HomePage clickButtonAddProject() {
        log.debug("Click the button 'Add Project' by locator: {}", BANNER_LINK);
        driver.findElement(ADD_PROJECT_BUTTON).click();
        return this;
    }
}

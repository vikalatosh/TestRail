package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public static final By BANNER_LINK = By.id("bannerLink");
    public static final By ADD_PROJECT_BUTTON = By.id("sidebar-projects-add");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isExist(BANNER_LINK);
    }

    public HomePage clickButtonAddProject() {
        driver.findElement(ADD_PROJECT_BUTTON).click();
        return this;
    }
}

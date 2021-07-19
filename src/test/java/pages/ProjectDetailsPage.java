package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectDetailsPage extends BasePage {
    public static final By RETURN_TO_DASHBOARD_BUTTON = By.id("navigation-dashboard-top");
    //    public static final By TEST_CASES_MENU = By.id("navigation-suites");
    public static final By ADD_BUTTON = By.id("sidebar-cases-add");


    public ProjectDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(RETURN_TO_DASHBOARD_BUTTON);
    }

    public TestCaseModal clickButtonAdd() {
        driver.findElement(ADD_BUTTON).click();
        return new TestCaseModal(driver);
    }
}

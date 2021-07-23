package pages;

import elements.DropDownSearch;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.TestRun;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TestRunModalPage extends BasePage {
    public static final By TEST_RUN_MODAL_PAGE_TITLE = By.xpath("//div[contains(text(),'Add Test Run')]");
    public static final By ADD_TEST_RUN_BUTTON = By.id("accept");

    public TestRunModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check Test run modal page is opened")
    public boolean isPageOpened() {
        log.debug("Check Test Run modal page is opened by locator: {}", TEST_RUN_MODAL_PAGE_TITLE);
        return isExist(TEST_RUN_MODAL_PAGE_TITLE);
    }

    @Step("Create new Test Run")
    public TestRunModalPage createTestRun(TestRun testRun) {
        log.info("Create new Test Run {}", testRun.getName());
        new Input(driver, "Name").write(testRun.getName());
        new Input(driver, "Refs").write(testRun.getReferences());
        new DropDownSearch(driver, "Assign To").select(testRun.getAssignedTo());
        driver.findElement(ADD_TEST_RUN_BUTTON).click();
        return this;
    }
}

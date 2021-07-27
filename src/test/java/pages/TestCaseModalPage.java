package pages;

import elements.DropDownSearch;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TestCaseModalPage extends BasePage {
    public static final By PAGE_TITLE = By.xpath("//div[contains(text(),'Add Test Case')]");
    public static final By ADD_TEST_CASE_BUTTON = By.id("accept");

    public TestCaseModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check Test Case modal page is opened")
    public boolean isPageOpened() {
        log.debug("Check Test Case modal page is opened by locator: {}", PAGE_TITLE);
        return isExist(PAGE_TITLE);
    }

    @Step("Create new Test Case")
    public TestCaseModalPage createTestCase(TestCase testCase) {
        log.info("Create new Test Case {}", testCase.getTitle());
        new Input(driver, "Title").write(testCase.getTitle());
        new DropDownSearch(driver, "Section").select(testCase.getSection());
        new DropDownSearch(driver, "Template").select(testCase.getTemplate());
        new DropDownSearch(driver, "Type").select(testCase.getType());
        new DropDownSearch(driver, "Priority").select(testCase.getPriority());
        new Input(driver, "Estimate").write(testCase.getEstimate());
        new Input(driver, "Refs").write(testCase.getReferences());
        new DropDownSearch(driver, "Automation Type").select(testCase.getAutomationType());
        driver.findElement(ADD_TEST_CASE_BUTTON).click();
        return this;
    }
}

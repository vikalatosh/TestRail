package pages;

import elements.DropDownSearch;
import elements.Input;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCaseModal extends BasePage {
    public static final By PAGE_TITLE = By.xpath("//div[contains(text(),'Add Test Case')]");
    public static final By ADD_TEST_CASE_BUTTON = By.id("accept");

    public TestCaseModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(PAGE_TITLE);
    }

    public TestCaseModal createTestCase(TestCase testCase) {
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

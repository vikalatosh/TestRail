package pages;

import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCaseModal extends BasePage {
    public static final By PAGE_TITLE = By.xpath("//div[contains(text(),'Add Test Case')]");
    public static final By TITLE_INPUT = By.id("title");
    public static final By ESTIMATE_INPUT = By.id("estimate");
    public static final By REFERENCES_INPUT = By.id("refs");
    //li[contains(text(),'Regression')]
    //*[contains(text(),'Type')]//ancestor::td/*[contains(@id,'id_chzn')]

    public static final By ADD_TEST_CASE_BUTTON = By.id("accept");

    public TestCaseModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(PAGE_TITLE);
    }

    public void createTestCase(TestCase testCase) {
        driver.findElement(TITLE_INPUT).sendKeys(testCase.getTitle());
        driver.findElement(ADD_TEST_CASE_BUTTON).click();
    }
}

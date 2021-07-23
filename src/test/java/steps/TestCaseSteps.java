package steps;

import models.TestCase;
import org.openqa.selenium.WebDriver;
import pages.ProjectDetailsPage;
import pages.ProjectsPage;
import pages.TestCaseModalPage;

import static org.testng.Assert.assertTrue;

public class TestCaseSteps {
    ProjectsPage projectsPage;
    ProjectDetailsPage projectDetailsPage;
    TestCaseModalPage testCaseModalPage;

    public TestCaseSteps(WebDriver driver) {
        projectsPage = new ProjectsPage(driver);
        projectDetailsPage = new ProjectDetailsPage(driver);
        testCaseModalPage = new TestCaseModalPage(driver);
    }

    public TestCaseSteps clickTheButtonAdd() {
        projectDetailsPage
                .clickButtonTheAddCaseButton();
        return this;
    }

    public TestCaseSteps isTestCaseModalPageOpened() {
        boolean isOpened = testCaseModalPage
                .isPageOpened();
        assertTrue(isOpened, "Test Case modal page was not opened");
        return this;
    }

    public TestCaseSteps createTestCase(TestCase testCase) {
        testCaseModalPage
                .createTestCase(testCase);
        return this;
    }
}

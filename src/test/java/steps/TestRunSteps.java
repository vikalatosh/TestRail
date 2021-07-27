package steps;

import models.TestRun;
import org.openqa.selenium.WebDriver;
import pages.ProjectDetailsPage;
import pages.TestRunDetailsPage;
import pages.TestRunModalPage;
import pages.TestRunsPage;

import static org.testng.Assert.assertTrue;

public class TestRunSteps {
    ProjectDetailsPage projectDetailsPage;
    TestRunModalPage testRunModalPage;
    TestRunDetailsPage testRunDetailsPage;
    TestRunsPage testRunsPage;

    public TestRunSteps(WebDriver driver) {
        projectDetailsPage = new ProjectDetailsPage(driver);
        testRunModalPage = new TestRunModalPage(driver);
        testRunDetailsPage = new TestRunDetailsPage(driver);
        testRunsPage = new TestRunsPage(driver);
    }

    public TestRunSteps clickTheButtonAdd() {
        projectDetailsPage
                .clickButtonTheAddTestRunButton();
        return this;
    }

    public TestRunSteps isTestRunModalPageOpened() {
        boolean isOpened = testRunModalPage
                .isPageOpened();
        assertTrue(isOpened, "Test Run modal page was not opened");
        return this;
    }

    public TestRunSteps createNewTestRun(TestRun testRun) {
        testRunModalPage
                .createTestRun(testRun);
        return this;
    }

    public TestRunSteps validateMessageAfterAdditionOfTestRun() {
        testRunDetailsPage
                .validateMessageAfterAdditionOfTestRun();
        return this;
    }

    public TestRunSteps openTestRunsPage() {
        testRunDetailsPage
                .openTestRunsPage();
        boolean isOpened = testRunsPage
                .isPageOpened();
        assertTrue(isOpened, "Test Runs page was not opened");
        return this;
    }

    public TestRunSteps newTestRunIsExist(TestRun testRun) {
        testRunsPage
                .testRunIsExist(testRun);
        return this;
    }
}

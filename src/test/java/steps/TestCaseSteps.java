package steps;

import models.Project;
import models.TestCase;
import org.openqa.selenium.WebDriver;
import pages.ProjectDetailsPage;
import pages.ProjectsPage;
import pages.TestCaseModal;

import static org.testng.Assert.assertTrue;

public class TestCaseSteps {
    ProjectsPage projectsPage;
    ProjectDetailsPage projectDetailsPage;
    TestCaseModal testCaseModal;

    public TestCaseSteps(WebDriver driver) {
        projectsPage = new ProjectsPage(driver);
        projectDetailsPage = new ProjectDetailsPage(driver);
        testCaseModal = new TestCaseModal(driver);
    }

    public TestCaseSteps openProjectDetailsPage(Project project) {
        projectsPage
                .openProjectDetails(project);
        return this;
    }

    public TestCaseSteps clickTheButtonAdd() {
        projectDetailsPage
                .clickButtonAdd();
        return this;
    }

    public TestCaseSteps isTestCaseModalPageOpened() {
        boolean isOpened = testCaseModal
                .isPageOpened();
        assertTrue(isOpened, "Projects page was not opened");
        return this;
    }

    public TestCaseSteps createTestCase(TestCase testCase) {
        testCaseModal
                .createTestCase(testCase)
                .isPageOpened();
        return this;
    }
}

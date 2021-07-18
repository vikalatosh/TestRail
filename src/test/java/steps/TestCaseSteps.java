package steps;

import models.Project;
import models.TestCase;
import org.openqa.selenium.WebDriver;
import pages.ProjectDetailsPage;
import pages.ProjectsPage;
import pages.TestCaseModal;

public class TestCaseSteps {
    ProjectsPage projectsPage;
    ProjectDetailsPage projectDetailsPage;
    TestCaseModal testCaseModal;

    public TestCaseSteps(WebDriver driver) {
        projectsPage = new ProjectsPage(driver);
        projectDetailsPage = new ProjectDetailsPage(driver);
        testCaseModal = new TestCaseModal(driver);
    }

    public ProjectDetailsPage openProjectDetails(Project project) {
        return projectsPage
                .openProjectDetails(project);
    }

    public TestCaseModal clickButtonAdd() {
        return projectDetailsPage
                .clickButtonAdd();
    }

    public TestCaseModal createTestCase(TestCase testCase) {
        testCaseModal
                .createTestCase(testCase)
                .isPageOpened();
        return testCaseModal;
    }
}

package tests;

import models.Project;
import models.ProjectFactory;
import models.TestCase;
import models.TestCaseFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class TestCaseTest extends BaseTest {

    @Test(description = "Test case should be created")
    public void testCaseShouldBeCreated() {
        Project project = ProjectFactory.get();
        TestCase testCase = TestCaseFactory.get();
        startSteps
                .openLoginPage(baseUrl)
                .isPageOpened();
        loginSteps
                .login(email, password)
                .isPageOpened();
        projectSteps
                .clickButtonAddProject()
//                .isPageOpened()
                .createProject(project)
                .getMessage()
                .projectIsExist(project);
        testCaseSteps
                .openProjectDetails(project)
//                .isPageOpened()
                .clickButtonAdd()
                .createTestCase(testCase);
    }
}

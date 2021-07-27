package tests;

import models.Project;
import models.ProjectFactory;
import models.TestRun;
import models.TestRunFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class TestRunTest extends BaseTest {

    @Test(description = "Test Run should be created")
    public void testRunShouldBeCreated() {
        Project project = ProjectFactory.get();
        TestRun testRun = TestRunFactory.get();
        startSteps
                .openLoginPage(baseUrl)
                .isLoginPageOpened();
        loginSteps
                .loginByEmailAndPassword(email, password)
                .clickTheButtonLogIn()
                .isHomePageOpened();
        projectSteps
                .clickTheButtonAddProject()
                .isProjectModalPageOpened()
                .createNewProject(project)
                .isProjectsPageOpened()
                .getMessageAfterCreatingNewProject()
                .projectIsExistOnTheProjectsPage(project)
                .openProjectDetailsPage(project);
        testRunSteps
                .clickTheButtonAdd()
                .isTestRunModalPageOpened()
                .createNewTestRun(testRun)
                .validateMessageAfterAdditionOfTestRun()
                .openTestRunsPage()
                .newTestRunIsExist(testRun);
    }
}

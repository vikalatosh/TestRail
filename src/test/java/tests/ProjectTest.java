package tests;

import models.Project;
import models.ProjectFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ProjectTest extends BaseTest {

    @Test(description = "Project should be created")
    public void projectShouldBeCreated() {
        Project project = ProjectFactory.get();
        startSteps
                .openLoginPage(baseUrl)
                .isLoginPageOpened();
        loginSteps
                .loginByEmailAndPassword(email, password)
                .isHomePageOpened();
        projectSteps
                .clickTheButtonAddProject()
                .isProjectModalPageOpened()
                .createNewProject(project)
                .isProjectsPageOpened()
                .getMessageAfterCreatingNewProject()
                .projectIsExistOnTheProjectsPage(project);
    }
}

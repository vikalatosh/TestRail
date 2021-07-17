package tests;

import models.Project;
import models.ProjectFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProjectTest extends BaseTest {

    @Test(description = "Project should be created")
    public void projectShouldBeCreated() {
        boolean isOpened = loginPage
                .openLoginPage(baseUrl)
                .isPageOpened();
        assertTrue(isOpened, "Login page was not opened");
        isOpened = loginPage
                .login(email, password)
                .isPageOpened();
        assertTrue(isOpened, "Home page was not opened");
        homePage
                .clickButtonAddProject();
        isOpened = projectModalPage
                .isPageOpened();
        assertTrue(isOpened, "'Add Project' page was not opened");
        Project project = ProjectFactory.get();
        isOpened = projectModalPage
                .createProject(project)
                .isPageOpened();
        assertTrue(isOpened, "Projects page was not opened");
        String message = projectsPage
                .getMessage();
        assertEquals(message, "Successfully added the new project.", "Project was not created");
        projectsPage.projectIsExist(project);
    }
}

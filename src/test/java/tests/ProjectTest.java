package tests;

import models.Project;
import models.ProjectFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProjectTest extends BaseTest {

    @Test
    public void projectShouldBeCreated() {
        boolean isOpened = loginPage
                .openLoginPage(baseUrl)
                .isPageOpened();
        assertTrue(isOpened, "Login Page was not opened");
        isOpened = loginPage
                .login(email, password)
                .isPageOpened();
        assertTrue(isOpened, "Home Page was not opened");
        homePage
                .clickButtonAddProject();
        isOpened = addProjectPage
                .isPageOpened();
        assertTrue(isOpened, "'Add Project' Page was not opened");
        Project project = ProjectFactory.get();
        isOpened = addProjectPage
                .createProject(project)
                .isPageOpened();
        assertTrue(isOpened, "Projects Page was not opened");
        String message = projectsPage
                .getMessage();
        assertEquals(message, "Successfully added the new project.", "Project was not created");
        projectsPage.projectIsExist(project);
    }
}

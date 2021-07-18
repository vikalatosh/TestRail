package steps;

import models.Project;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ProjectModalPage;
import pages.ProjectsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProjectSteps {
    HomePage homePage;
    ProjectModalPage projectModalPage;
    ProjectsPage projectsPage;

    public ProjectSteps(WebDriver driver) {
        homePage = new HomePage(driver);
        projectModalPage = new ProjectModalPage(driver);
        projectsPage = new ProjectsPage(driver);
    }

    public ProjectModalPage clickButtonAddProject() {
        homePage
                .clickButtonAddProject();
        return projectModalPage;
    }

    public ProjectModalPage isPageOpened() {
        boolean isOpened = projectModalPage
                .isPageOpened();
        assertTrue(isOpened, "'Add Project' page was not opened");
        return projectModalPage;
    }

    public ProjectsPage createProject(Project project) {
        projectModalPage
                .createProject(project);
        return projectsPage;
    }

    public ProjectsPage isProjectsPageOpened() {
        boolean isOpened = projectModalPage
                .isPageOpened();
        assertTrue(isOpened, "Projects page was not opened");
        return projectsPage;
    }

    public ProjectsPage getMessage() {
        String message = String.valueOf(projectsPage
                .getMessage());
        assertEquals(message, "Successfully added the new project.", "Project was not created");
        return projectsPage;
    }

    public ProjectsPage projectIsExist(Project project) {
        projectsPage
                .projectIsExist(project);
        return projectsPage;
    }
}

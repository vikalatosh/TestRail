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

    public ProjectSteps clickTheButtonAddProject() {
        homePage
                .clickButtonAddProject();
        return this;
    }

    public ProjectSteps isProjectModalPageOpened() {
        boolean isOpened = projectModalPage
                .isPageOpened();
        assertTrue(isOpened, "Project modal page was not opened");
        return this;
    }

    public ProjectSteps createNewProject(Project project) {
        projectModalPage
                .createProject(project);
        return this;
    }

    public ProjectSteps isProjectsPageOpened() {
        boolean isOpened = projectsPage
                .isPageOpened();
        assertTrue(isOpened, "Projects page was not opened");
        return this;
    }

    public ProjectSteps getMessageAfterCreatingNewProject() {
        String message = projectsPage
                .getMessage();
        assertEquals(message, "Successfully added the new project.", "Project was not created");
        return this;
    }

    public ProjectSteps projectIsExistOnTheProjectsPage(Project project) {
        projectsPage
                .projectIsExist(project);
        return this;
    }

    public ProjectSteps deleteCreatedProject(Project project) {
        projectsPage
                .deleteProject(project);
        return this;
    }

    public ProjectSteps getMessageAfterDeletingProject() {
        String message = projectsPage
                .getMessage();
        assertEquals(message, "Successfully deleted the project.", "Project was not deleted");
        return this;
    }

    public ProjectSteps openProjectDetailsPage(Project project) {
        projectsPage
                .openProjectDetails(project);
        return this;
    }
}

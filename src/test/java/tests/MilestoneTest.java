package tests;

import models.Milestone;
import models.MilestoneFactory;
import models.Project;
import models.ProjectFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class MilestoneTest extends BaseTest {

    @Test(description = "Milestone should be created")
    public void milestoneShouldBeCreated() {
        Project project = ProjectFactory.get();
        Milestone milestone = MilestoneFactory.get();
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
                .projectIsExistOnTheProjectsPage(project);
        milestoneSteps
                .openProjectDetailsPage(project)
                .clickTheButtonAdd()
                .isMilestoneModalPageOpened()
                .createMilestone(milestone)
                .createdMilestoneIsExistOnThePage(milestone);
    }
}

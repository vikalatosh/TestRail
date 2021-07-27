package steps;

import models.Milestone;
import org.openqa.selenium.WebDriver;
import pages.MilestoneModalPage;
import pages.MilestonesPage;
import pages.ProjectDetailsPage;
import pages.ProjectsPage;

import static org.testng.Assert.assertTrue;

public class MilestoneSteps {
    ProjectsPage projectsPage;
    ProjectDetailsPage projectDetailsPage;
    MilestonesPage milestonesPage;
    MilestoneModalPage milestoneModalPage;

    public MilestoneSteps(WebDriver driver) {
        projectsPage = new ProjectsPage(driver);
        projectDetailsPage = new ProjectDetailsPage(driver);
        milestonesPage = new MilestonesPage(driver);
        milestoneModalPage = new MilestoneModalPage(driver);
    }

    public MilestoneSteps clickTheButtonAdd() {
        projectDetailsPage
                .clickButtonTheAddMilestoneButton();
        return this;
    }

    public MilestoneSteps isMilestoneModalPageOpened() {
        boolean isOpened = milestoneModalPage
                .isPageOpened();
        assertTrue(isOpened, "Milestone modal page was not opened");
        return this;
    }

    public MilestoneSteps createMilestone(Milestone milestone) {
        milestoneModalPage
                .createMilestone(milestone);
        return this;
    }

    public MilestoneSteps createdMilestoneIsExistOnThePage(Milestone milestone) {
        milestonesPage
                .milestoneIsExist(milestone);
        return this;
    }
}

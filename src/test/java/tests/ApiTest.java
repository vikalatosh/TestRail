package tests;

import adapters.ProjectAdapter;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import models.Project;
import models.ResponseStatus;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.testng.Assert.assertEquals;

public class ApiTest {

    @Test(description = "Project should be created by using REST API")
    public void createProjectTestByApi() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        Project project = Project.builder()
                .name(fakeValuesService.regexify("[A-Z]{10}"))
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.getName(), project.getName());
        ResponseStatus actualGet = new ProjectAdapter().getProject(200, actual.getId());
        assertEquals(actualGet.getName(), project.getName());
    }

    @Test(description = "Project should be deleted by using REST API")
    public void deleteProjectTest() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        Project project = Project.builder()
                .name(fakeValuesService.regexify("[A-Z]{10}"))
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.getName(), project.getName());
        ResponseStatus actualGet = new ProjectAdapter().getProject(200, actual.getId());
        assertEquals(actualGet.getName(), project.getName());
        new ProjectAdapter().deleteProject(200, actual.getId());
    }
}

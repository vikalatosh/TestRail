package tests;

import adapters.ProjectAdapter;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import models.Project;
import models.ResponseProject;
import models.ResponseStatus;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.testng.Assert.assertEquals;

public class ApiTest {

    @Test(description = "Project should be created")
    public void projectTest() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        Project project = Project.builder()
                .name(fakeValuesService.regexify("[A-Z]{10}"))
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getName(), project.getName());
    }

    @Test(description = "Get Project data")
    public void get() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        Project project = Project.builder()
                .name(fakeValuesService.regexify("[A-Z]{10}"))
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getName(), project.getName());
        ResponseProject responseProject = new ProjectAdapter().getProject(actual.getResult().getId());
        System.out.println(responseProject);
    }
}

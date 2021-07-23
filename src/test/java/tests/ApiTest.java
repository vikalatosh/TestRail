package tests;

import adapters.ProjectAdapter;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import models.Project;
import models.ResponseProject;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.testng.Assert.assertEquals;

public class ApiTest {

    @Test(description = "Project should be created by using REST API")
    public void projectShouldBeCreatedByApi() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        Project project = Project.builder()
                .name(fakeValuesService.regexify("[A-Z]{10}"))
                .build();
        ResponseProject actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.getName(), project.getName());
        ResponseProject actualGet = new ProjectAdapter().getProject(200, actual.getId());
        assertEquals(actualGet.getName(), project.getName());
    }

    @Test(description = "Project should be deleted by using REST API")
    public void projectShouldBeDeletedByApi() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        Project project = Project.builder()
                .name(fakeValuesService.regexify("[A-Z]{10}"))
                .build();
        ResponseProject actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.getName(), project.getName());
        ResponseProject actualGet = new ProjectAdapter().getProject(200, actual.getId());
        assertEquals(actualGet.getName(), project.getName());
        new ProjectAdapter().deleteProject(200, actual.getId());
    }

//    @Test(description = "Section should be created into project")
//    public void sectionShouldBeCreatedIntoProject() {
//        FakeValuesService fakeValuesService = new FakeValuesService(
//                new Locale("en-GB"), new RandomService());
//        Project project = Project.builder()
//                .name(fakeValuesService.regexify("[A-Z]{10}"))
//                .build();
//        ResponseProject actual = new ProjectAdapter().create(project, 200);
//        assertEquals(actual.getName(), project.getName());
//        ResponseProject actualGet = new ProjectAdapter().getProject(200, actual.getId());
//        assertEquals(actualGet.getName(), project.getName());
//        Section section = Section.builder()
//                .name(fakeValuesService.regexify("[A-Z]{10}"))
//                .build();
//        ResponseSection actualSection = new SectionAdapter().createSection(section, 200, actual.getId());
//        assertEquals(actualSection.getName(), section.getName());
//        ResponseSection getActualSection = new SectionAdapter().getSection(200, actualSection.getId());
//        assertEquals(getActualSection.getName(), section.getName());
//    }

//    @Test(description = "Test Case should be created by using REST API")
//    public void testCaseShouldBeCreatedByApi() {
//        FakeValuesService fakeValuesService = new FakeValuesService(
//                new Locale("en-GB"), new RandomService());
//        Project project = Project.builder()
//                .name(fakeValuesService.regexify("[A-Z]{10}"))
//                .build();
//        TestCase testCase = TestCase.builder()
//                .title(fakeValuesService.regexify("[A-Z]{10}"))
//                .build();
//        ResponseProject actual = new ProjectAdapter().create(project, 200);
//        assertEquals(actual.getName(), project.getName());
//        ResponseTestCase actualCase = new TestCaseAdapter().createTestCase(testCase, 200, actual.getId());
//        assertEquals(actualCase.getTitle(), testCase.getTitle());
//        ResponseTestCase getActualCase = new TestCaseAdapter().getTestCase(200, actual.getId());
//        assertEquals(getActualCase.getTitle(), testCase.getTitle());
//    }
}

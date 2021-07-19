package models;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import lombok.extern.log4j.Log4j2;

import java.util.Locale;

@Log4j2
public class TestCaseFactory {
    public static TestCase get() {
        log.info("Create new TestCase");
        Faker faker = new Faker();
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        return TestCase.builder()
                .title(faker.app().name() + fakeValuesService.regexify("[A-Z]{3}"))
                .section("Test cases")
                .template("Test Case (Text)")
                .type("Regression")
                .priority("Medium")
                .estimate("")
                .references("")
                .automationType("Ranorex")
                .preconditions("")
                .steps("")
                .expectedResult("")
                .build();
    }
}

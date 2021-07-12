package models;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProjectFactory {
    public static Project get() {
        log.info("Create new Project");
        Faker faker = new Faker();
        return Project.builder()
                .name(faker.app().name())
                .build();
    }
}

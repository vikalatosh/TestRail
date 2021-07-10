package models;

import com.github.javafaker.Faker;

public class ProjectFactory {
    public static Project get() {
        Faker faker = new Faker();
        return Project.builder()
                .name(faker.app().name())
                .build();
    }
}

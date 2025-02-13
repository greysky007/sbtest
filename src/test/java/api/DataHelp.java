package api;

import com.codeborne.selenide.ElementsCollection;
import com.github.javafaker.Faker;

import java.util.Random;

public final class DataHelp {
    public static int getRandomNumForCollection(ElementsCollection elements) {
        return new Random().nextInt(elements.size());

    }

    public static String generateValidFirstName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String generateValidLastName() {
        Faker faker = new Faker();
        return faker.name().lastName();
    }

    public static String generateValidUserName() {
        Faker faker = new Faker();

        return faker.name().username();
    }

    public static String generateValidEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String generateValidPass() {
        Faker faker = new Faker();
        return faker.internet().password();
    }

    public static String generateValidPhone() {
        Faker faker = new Faker();
        return faker.phoneNumber().cellPhone();
    }

    public static int generateValidId() {
        Faker faker = new Faker();
        String random = faker.number().digits(5);
        return Integer.parseInt(random);
    }
}

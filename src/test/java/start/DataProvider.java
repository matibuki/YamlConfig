package start;

import com.github.javafaker.Faker;

public class DataProvider {
    Faker faker = new Faker();

    public String setName() {
        return faker.name().fullName();
    }

    public String setEmail() {
        return faker.internet().emailAddress();
    }

    public String setPassword() {
        return faker.internet().password();
    }

}

package utils;

import com.github.javafaker.Faker;

public class TestData {

    private static final Faker faker = new Faker();

    public String searchText = getSearchText(),
                    phone = getRandomPhone(),
                    email = getRandomEmail(),
                    name = getRandomName();

    public String getSearchText() {
        return "кроссовки";
    }

    public String getRandomPhone() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public String getRandomName() {
        return faker.name().firstName();
    }
}

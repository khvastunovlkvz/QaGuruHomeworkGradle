package com.example.qaguruhomeworkgradle.testdata;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class TestData {

    Faker faker = new Faker();
    public final String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            firstAndLastName = firstName + " " + lastName,
            emailAddress = faker.internet().emailAddress(),
            gender = getRandomValueFrom("Male", "Female", "Other") ,
            number = faker.number().digits(10),
            day = dataSplit()[0],
            month = dataSplit()[1],
            year = dataSplit()[2],
            dateOfBirth = day + " " + month + "," + year,
            subject = getRandomValueFrom("English", "Commerce", "Social Studies"),
            hobbies = getRandomValueFrom("Sports", "Reading", "Music"),
            namePicture = "milaya-mordashka-kotika.jpg",
            currentAddress = faker.address().fullAddress(),
            state = getRandomValueFrom("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = getRandomCity(),
            stateAndCity = state + " " + city;

    private String[] dataSplit(){
        return new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH)
                .format(faker.date().birthday(18,70))
                .toString()
                .split(" ");
    }

    private String getRandomValueFrom(String... values){
        return faker.options().option(values);
    }

    private String getRandomCity(){
        String randomCity;
        switch (state){
            case "NCR" -> randomCity = getRandomValueFrom("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> randomCity = getRandomValueFrom("Agra", "Lucknow", "Merrut");
            case "Haryana" -> randomCity = getRandomValueFrom("Karnal", "Panipat");
            case "Rajasthan" -> randomCity = getRandomValueFrom("Jaipur", "Jaiselmer");
            default -> throw new IllegalArgumentException("State:" + state + " not found");
        }
        return randomCity;
    }
}

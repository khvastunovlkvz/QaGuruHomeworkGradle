package com.example.qaguruhomeworkgradle.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class StepAllureFormTest extends BaseTest {
    @Feature("Форма регистрации")
    @Story("Заполнение формы регистрации")
    @Owner("Александр Соловьев")
    @DisplayName("Проверка заполнения формы регистрации")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value ="Form", url = "https://demoqa.com/automation-practice-form")
    @Test
    public void formTest() {

        step("Открываем страницу с регистрацией ", () -> {
            registrationPage.openPage();
        });

        step("Вводим имя: " + testData.firstName, () -> {
            registrationPage.setFirstName(testData.firstName);
        });

        step("Вводим фамилию: " + testData.lastName, () -> {
            registrationPage.setLastName(testData.lastName);
        });

        step("Вводим почту: " + testData.emailAddress, () -> {
            registrationPage.setEmail(testData.emailAddress);
        });

        step("Выбираем пол: " + testData.gender, () -> {
            registrationPage.setGender(testData.gender);
        });

        step("Вводим номер мобильного телефона: " + testData.number, () -> {
            registrationPage.setMobileNumber(testData.number);
        });

        step("Выбираем дату рождения: " + testData.day + "." + testData.month + "." + testData.year + ".", () -> {
            registrationPage.setDateOfBirth(testData.day, testData.month, testData.year);
        });

        step("Выбираем предмет: " + testData.subject, () -> {
            registrationPage.setSubject(testData.subject);
        });

        step("Выбираем хобби: " + testData.hobbies, () -> {
            registrationPage.setHobbies(testData.hobbies);
        });

        step("Выбираем аватарку: " + testData.namePicture, () -> {
            registrationPage.uploadPicture(testData.namePicture);
        });

        step("Указываем адрес проживания: " + testData.currentAddress, () -> {
            registrationPage.setCurrentAddress(testData.currentAddress);
        });

        step("Выбираем штат: " + testData.state, () -> {
            registrationPage.setState(testData.state);
        });

        step("Выбираем город: " + testData.city, () -> {
            registrationPage.setCity(testData.city);
        });
        step("Нажимаем кнопку submit", () -> {
            registrationPage.pressSubmit();
        });

        step("Проверяем что модальное окно с данными появилось", () -> {
            registrationPage.resultsModal
                    .verifyResultsModalAppears();
        });

        step("Проверяем имя студента: " + testData.firstAndLastName, () -> {
            registrationPage.resultsModal
                    .verifyResult("Student Name", testData.firstAndLastName);
        });

        step("Проверяем почту: " + testData.emailAddress, () -> {
            registrationPage.resultsModal
                    .verifyResult("Student Email", testData.emailAddress);
        });

        step("Проверяем пол: " + testData.gender, () -> {
            registrationPage.resultsModal
                    .verifyResult("Gender", testData.gender);
        });

        step("Проверяем номер мобильного телефона: " + testData.number, () -> {
            registrationPage.resultsModal
                    .verifyResult("Mobile", testData.number);
        });

        step("Проверяем дату рождения: " + testData.dateOfBirth, () -> {
            registrationPage.resultsModal
                    .verifyResult("Date of Birth", testData.dateOfBirth);
        });

        step("Проверяем хобби: " + testData.hobbies, () -> {
            registrationPage.resultsModal
                    .verifyResult("Hobbies", testData.hobbies);
        });

        step("Проверяем аватарку: " + testData.namePicture, () -> {
            registrationPage.resultsModal
                    .verifyResult("Picture", testData.namePicture);
        });

        step("Проверяем адрес проживания: " + testData.currentAddress, () -> {
            registrationPage.resultsModal
                    .verifyResult("Address", testData.currentAddress);
        });

        step("Проверяем штат и город: " + testData.stateAndCity, () -> {
            registrationPage.resultsModal
                    .verifyResult("State and City", testData.stateAndCity);
        });
        System.out.println();
    }


}

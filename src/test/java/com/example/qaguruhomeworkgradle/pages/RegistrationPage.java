package com.example.qaguruhomeworkgradle.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.example.qaguruhomeworkgradle.component.CalendarComponent;
import com.example.qaguruhomeworkgradle.component.RegistrationResultsModal;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.id;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final String URL = "/automation-practice-form";

    private final SelenideElement
            footer = $("[src='/images/Toolsqa.jpg']"),
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            email = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            mobile = $("#userNumber"),
            dateOfBirth = $("#dateOfBirthInput"),
            subjects = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            buttonUploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateCityWrapper = $("#stateCity-wrapper"),
            state = $("#state"),
            city = $("#city"),
            submit = $("#submit");

    private CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationResultsModal resultsModal = new RegistrationResultsModal();

    public RegistrationPage openPage() {
        open(URL);
        footer.should(visible, Duration.ofSeconds(10));
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstName.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastName.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        email.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value))
                .parent()
                .click();

        return this;
    }

    public RegistrationPage setMobileNumber(String value) {
        mobile.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirth.click();
        calendarComponent
                .setMonth(month)
                .setYear(year)
                .setDay(day);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjects.setValue(value);
        $(".subjects-auto-complete__menu").$(byText(value)).click();

        return this;
    }

        public RegistrationPage setHobbies(String value){
            hobbiesWrapper.$(byText(value))
                    .parent()
                    .click();

            return this;
        }
/*
    public RegistrationPage setHobbies(String hobbies) {
        $(byText(hobbies)).closest("div").click();

        return this;
    }
*/

    public RegistrationPage uploadPicture(String value) {
        buttonUploadPicture
                .uploadFile(
                        new File("src/test/resources/" + value));

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public void pressSubmit() {
        submit.click();
        ;
    }


}

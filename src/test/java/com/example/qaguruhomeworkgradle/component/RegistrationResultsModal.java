package com.example.qaguruhomeworkgradle.component;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {

    private final String title = "Thanks for submitting the form";

    public RegistrationResultsModal verifyResultsModalAppears(){
        $(".modal-content").should(appear);
        $(".modal-header").shouldHave(text(title));

        return this;
    }

    public RegistrationResultsModal verifyResult(String key, String value){
        $($(".table-responsive"))
                .$(byText(key))
                .parent()
                .shouldHave(text(value));
        return this;
    }
}

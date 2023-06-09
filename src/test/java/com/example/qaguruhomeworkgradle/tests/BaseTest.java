package com.example.qaguruhomeworkgradle.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.example.qaguruhomeworkgradle.pages.RegistrationPage;
import com.example.qaguruhomeworkgradle.testdata.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {

    RegistrationPage registrationPage;
    TestData testData;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 4000;
        Configuration.pageLoadStrategy = "none";
        Configuration.browserPosition = "0x0";
        Configuration.holdBrowserOpen = false;
    }

    @BeforeEach
    public void init() {

        registrationPage = new RegistrationPage();
        testData = new TestData();
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}
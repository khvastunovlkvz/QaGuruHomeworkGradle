package com.example.qaguruhomeworkgradle.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.qaguruhomeworkgradle.helpers.Attachments;
import com.example.qaguruhomeworkgradle.pages.RegistrationPage;
import com.example.qaguruhomeworkgradle.testdata.TestData;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;


public class BaseTest {

    RegistrationPage registrationPage;
    TestData testData;

    private static String browserDefault = "chrome",
                    browserVersionDefault = "113.0",
                    screenResolutionDefault = "1920x1080";

    @BeforeAll
    public static void setUp() {

        Configuration.remote = System.getProperty("selenoidUrl", "http://109.106.139.39:4444") + "/wd/hub";
        Configuration.browser = System.getProperty("browser", browserDefault);
        Configuration.browserVersion = System.getProperty("browserVersion", browserVersionDefault);
        Configuration.browserSize = System.getProperty("screenResolution", screenResolutionDefault);
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "none";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    public void init() {
        registrationPage = new RegistrationPage();
        testData = new TestData();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void attachmentAdd(){String url ="" + Attachments.getVideoUrl();
        Attachments.addVideo();
/*
        Attachments.screenshotAs("Last screenshot");
*/
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }

}
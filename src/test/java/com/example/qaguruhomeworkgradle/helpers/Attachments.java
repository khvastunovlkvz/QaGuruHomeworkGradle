package com.example.qaguruhomeworkgradle.helpers;
import io.qameta.allure.Attachment;
import java.net.MalformedURLException;
import java.net.URL;
import static com.codeborne.selenide.Selenide.*;
public class Attachments {

/*
    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenshotAs(String attachName) {
        return Selenide.screenshot(OutputType.BYTES);
    }
*/

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo() {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + getVideoUrl()
                + "' type='video/mp4'></video></body></html>";
    }

    public static URL getVideoUrl() {
        String videoUrl = System.getProperty("selenoidVideo", "http://109.106.139.39:4444")
                + "/video/"
                + sessionId()
                + ".mp4";

        try {
            return new URL(videoUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }


}

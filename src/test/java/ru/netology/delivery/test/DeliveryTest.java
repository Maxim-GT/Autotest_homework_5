package ru.netology.delivery.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class DeliveryTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void SetUp() {
        open("http://localhost:9999/");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Should successful plan and replan meeting")
    void shouldSuccessfulPlanAndReplanMeeting() throws Exception {
        var validUser = ru.netology.delivery.data.DataGenerator.Registration.generateUser("ru");
        var daysToAddForFirstMeeting = 4;
        var firstMeetingDate = ru.netology.delivery.data.DataGenerator.generateDate(daysToAddForFirstMeeting);
        var daysToAddForSecondMeeting = 7;
        var secondMeetingDate = ru.netology.delivery.data.DataGenerator.generateDate(daysToAddForSecondMeeting);

        $("[placeholder= 'Город']").setValue(validUser.getCity());
        $("[class= 'input__control'][placeholder= 'Дата встречи']").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[class= 'input__control'][placeholder= 'Дата встречи']").setValue(firstMeetingDate);
        $("[class= 'input__control'][name= 'name']").setValue(validUser.getName());
        $("[type= 'tel'][name= 'phone']").setValue(validUser.getPhone());
        $("[class= 'checkbox__box']").click();
        $("[class='button__content']").click();
        $("[data-test-id='success-notification']").shouldHave(text("Встреча успешно запланирована на " + (firstMeetingDate)));
        $("[class= 'input__control'][placeholder= 'Дата встречи']").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[class= 'input__control'][placeholder= 'Дата встречи']").setValue(secondMeetingDate);
        $("[class='button__content']").click();
        $("[data-test-id='replan-notification']").shouldHave(text("У вас уже запланирована встреча на другую дату. Перепланировать? "));
        $("[class='button button_view_extra button_size_s button_theme_alfa-on-white']").click();
        $("[data-test-id='success-notification']").shouldHave(text("Встреча успешно запланирована на " + (secondMeetingDate)));
    }
}




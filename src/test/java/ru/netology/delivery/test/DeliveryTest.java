package ru.netology.delivery.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryTest {

    @BeforeEach
    void SetUp() {
        open("http://localhost:9999/");
    }


    @Test
    @DisplayName("Should successful plan and replan meeting")
    void shouldSuccessfulPlanAndReplanMeeting() {
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




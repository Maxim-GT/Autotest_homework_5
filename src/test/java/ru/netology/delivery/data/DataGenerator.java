package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        // TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
        // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью Faker, либо используя массив валидных городов и класс Random
        String[] cities = {"Белгород",
                "Брянск",
                "Владимир",
                "Воронеж",
                "Иваново",
                "Калуга",
                "Кострома",
                "Курск",
                "Липецк",
                "Москва",
                "Москва",
                "Орел",
                "Рязань",
                "Смоленск",
                "Тамбов",
                "Тверь",
                "Тула",
                "Ярославль",
                "Архангельск",
                "Вологда",
                "Калининград",
                "Петрозаводск",
                "Сыктывкар",
                "Санкт-Петербург",
                "Мурманск",
                "Салехард",
                "Великий Новгород",
                "Псков",
                "Санкт-Петербург",
                "Уфа",
                "Киров",
                "Йошкар-Ола",
                "Саранск",
                "Нижний Новгород",
                "Оренбург",
                "Пенза",
                "Пермь",
                "Самара",
                "Саратов",
                "Казань",
                "Ижевск",
                "Ульяновск",
                "Чебоксары",
                "Курган",
                "Екатеринбург",
                "Тюмень",
                "Ханты-мансийск",
                "Челябиннск",
                "Салехард",
                "Горно-Алтайск",
                "Барнаул",
                "Улан-Удэ",
                "Чита",
                "Иркутск",
                "Кемерово",
                "Красноярск",
                "Новосибирск",
                "Омск",
                "Томск",
                "Кызыл",
                "Абакан",
                "Благовещенск",
                "Биробиджан",
                "Петропавловск-Камчатский",
                "Магадан",
                "Владивосток",
                "Якутск",
                "Южно-Сахалинск",
                "Хабаровск",
                "Анадырь",
                "Майкоп",
                "Астрахань",
                "Волгоград",
                "Элиста",
                "Краснодар",
                "Ростов",
                "Махачкала",
                "Магас",
                "Нальчик",
                "Черкесск",
                "Владивкавказ",
                "Ставрополь",
                "Грозный"};
        int goal = new Random().nextInt(cities.length);
        String city = (cities[goal]);
        return city;
    }


    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().name();
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)
            UserInfo user = new UserInfo("ru", "ru", "ru");
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
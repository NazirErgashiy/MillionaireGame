package database;

import java.util.LinkedList;

/**
 *<h2>База Вопросов с ответами
 */
public class DataBase {
    private static LinkedList<QuestionWithAnswers> easyQuestons = new LinkedList<>();
    //Предполагается что можно добавлять листы с более сложными вопросами

    //Затаривание листа вопросами с помощью Builder
    //Показаны простые примеры вопросов
    static {
        easyQuestons.add(QuestionWithAnswers.builder()
                .question("Что растёт в огороде?")
                .correctAnswer("Лук")
                .wrongAnswer1("Пистолет")
                .wrongAnswer2("Пулемёт")
                .wrongAnswer3("Ракета СС-20")
                .build());

        easyQuestons.add(QuestionWithAnswers.builder()
                .question("Как называют микроавтобусы, совершающие поездки по определённым маршрутам?")
                .correctAnswer("Маршрутка")
                .wrongAnswer1("Путёвка")
                .wrongAnswer2("Курсовка")
                .wrongAnswer3("Рейсовка")
                .build());

        easyQuestons.add(QuestionWithAnswers.builder()
                .question("Сколько падежей в русском языке")
                .correctAnswer("6")
                .wrongAnswer1("2")
                .wrongAnswer2("3")
                .wrongAnswer3("8")
                .build());

        easyQuestons.add(QuestionWithAnswers.builder()
                .question("Как заканчивается русская поговорка: «Раз на раз…»?")
                .correctAnswer("Не приходится")
                .wrongAnswer1("Не перемножается")
                .wrongAnswer2("Не меняется")
                .wrongAnswer3("Не размножается")
                .build());

        easyQuestons.add(QuestionWithAnswers.builder()
                .question("Как по-другому называется обойма для патронов?")
                .correctAnswer("Магазин")
                .wrongAnswer1("Универсам")
                .wrongAnswer2("Патрон")
                .wrongAnswer3("Супермаркет")
                .build());

        easyQuestons.add(QuestionWithAnswers.builder()
                .question("Какое животное царь зверей?")
                .correctAnswer("Лев")
                .wrongAnswer1("Собака")
                .wrongAnswer2("Человек")
                .wrongAnswer3("Леопард")
                .build());

        easyQuestons.add(QuestionWithAnswers.builder()
                .question("Сколько дней в месяце МАЙ?")
                .correctAnswer("31")
                .wrongAnswer1("27")
                .wrongAnswer2("28")
                .wrongAnswer3("30")
                .build());

        easyQuestons.add(QuestionWithAnswers.builder()
                .question("Какая формула у воды?")
                .correctAnswer("H2O")
                .wrongAnswer1("H2SO4")
                .wrongAnswer2("S")
                .wrongAnswer3("Fe")
                .build());

        easyQuestons.add(QuestionWithAnswers.builder()
                .question("Какое животное поёт?")
                .correctAnswer("Птица")
                .wrongAnswer1("Волк")
                .wrongAnswer2("Человек")
                .wrongAnswer3("Заяц")
                .build());

        easyQuestons.add(QuestionWithAnswers.builder()
                .question("Кто изобрел таблицу Менделеева?")
                .correctAnswer("Менделеев")
                .wrongAnswer1("Сталин")
                .wrongAnswer2("Обама")
                .wrongAnswer3("Александр Сергеевич Пушкин")
                .build());

        easyQuestons.add(QuestionWithAnswers.builder()
                .question("Сколько пальцев у человека?")
                .correctAnswer("20")
                .wrongAnswer1("10")
                .wrongAnswer2("5")
                .wrongAnswer3("Нету")
                .build());

        easyQuestons.add(QuestionWithAnswers.builder()
                .question("Назовите столицу Франции")
                .correctAnswer("Париж")
                .wrongAnswer1("Лондон")
                .wrongAnswer2("Канада")
                .wrongAnswer3("США")
                .build());

        easyQuestons.add(QuestionWithAnswers.builder()
                .question("Сколько будет 2+2")
                .correctAnswer("4")
                .wrongAnswer1("2")
                .wrongAnswer2("0")
                .wrongAnswer3("6")
                .build());

        easyQuestons.add(QuestionWithAnswers.builder()
                .question("Как называют руль автомобиля?")
                .correctAnswer("Баранка")
                .wrongAnswer1("Бублик")
                .wrongAnswer2("Шарик")
                .wrongAnswer3("Мяч")
                .build());
    }

    //Получение БД
    public static LinkedList<QuestionWithAnswers> getData() {
        return easyQuestons;
    }
}

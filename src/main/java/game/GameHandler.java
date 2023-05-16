package game;

import database.DataBase;
import database.QuestionWithAnswers;
import sound.Sound;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * <h2>Обработчик игры</h3>
 * <p>Получает вопрос из БД
 * <p>Выводит в консоль вопрос
 * <p>Принимает ВВОД игрока
 * <p>Проверят правильно ответил игрок или нет
 * <p>Задает новый вопрос удалив прежний
 */
public class GameHandler {
    public static int currentCorrectAnswer;//Текущий правильный ответ на вопрос
    public static int userInputAnswer;//Ответ игрока на вопрос
    public static int currentQuestionIndex;//Индекс текущего вопроса из Базы Данных
    public static boolean gameIsGoing = true;//Игра продолжается ли
    public static int gameContinueUserChoice = 1;//Хочет ли игрок продолжить играть не сбрасывая прогресс

    public static void main(String[] args) {
        LinkedList<QuestionWithAnswers> easyDataBase = DataBase.getData();//Получение базы данных и сохранение в копию

        //Звук для игры
        Sound correctSound = new Sound(new File("F:\\JavaProjects\\millionaire\\src\\main\\resources\\Correct.wav"));
        Sound wrongSound = new Sound(new File("F:\\JavaProjects\\millionaire\\src\\main\\resources\\Wrong.wav"));
        Sound introSound = new Sound(new File("F:\\JavaProjects\\millionaire\\src\\main\\resources\\Intro.wav"));
        introSound.play();

        //Цикл в котором игрок если проиграет может продолжить играть
        while (gameContinueUserChoice == 1) {
            //Игрок правильно отвечает на вопрос и цикл задает новый вопрос и тд
            while (gameIsGoing) {
                QuestionWithAnswers current = getRandomQuestion(easyDataBase);//Получение случайного вопроса и регистрирование его как текущего
                gameIsGoing = printGameStatus(current.getQuestion(), current.getCorrectAnswer(), current.getWrongAnswer1(), current.getWrongAnswer2(), current.getWrongAnswer3(), correctSound, wrongSound);//Вывод в консоль вопроса игроку
                easyDataBase.remove(currentQuestionIndex);//Удаление вопроса из Базы Данных во избежание попадание такого же вопроса
            }
            //Хочет ли игрок продолжить играть
            System.out.println("Хотите продолжить?");
            System.out.println("1 -Да 2 -Нет");
            Scanner userChoiceScanner = new Scanner(System.in);
            gameContinueUserChoice = userChoiceScanner.nextInt();
            if (gameContinueUserChoice == 1) gameIsGoing = true;
        }
    }

    /**
     * <h2>Выводит игру в консоль</>
     * @param question Вопрос
     * @param correctAnswer Правильный ответ
     * @param wrongAnswer1 Неправильный ответ
     * @param wrongAnswer2 Неправильный ответ
     * @param wrongAnswer3 Неправильный ответ
     * @param correct Звук который будет воспроизводиться если игрок ответит правильно
     * @param wrong Звук который будет воспроизводиться если игрок ответит неправильно
     * @return Если игрок ответил правильно -> true неправильно -> false
     */
    public static boolean printGameStatus(String question, String correctAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3, Sound correct, Sound wrong) {

        System.out.println("********************");//
        System.out.println(question);

        //Расположение правильного ответа под случайным номером от 1 до 4
        switch (randomInt(1, 4)) {
            case 1:
                currentCorrectAnswer = 1;
                System.out.println("1. " + correctAnswer);
                System.out.println("2. " + wrongAnswer1);
                System.out.println("3. " + wrongAnswer2);
                System.out.println("4. " + wrongAnswer3);
                break;
            case 2:
                currentCorrectAnswer = 2;
                System.out.println("1. " + wrongAnswer2);
                System.out.println("2. " + correctAnswer);
                System.out.println("3. " + wrongAnswer3);
                System.out.println("4. " + wrongAnswer1);
                break;
            case 3:
                currentCorrectAnswer = 3;
                System.out.println("1. " + wrongAnswer3);
                System.out.println("2. " + wrongAnswer1);
                System.out.println("3. " + correctAnswer);
                System.out.println("4. " + wrongAnswer2);
                break;
            case 4:
                currentCorrectAnswer = 4;
                System.out.println("1. " + wrongAnswer3);
                System.out.println("2. " + wrongAnswer2);
                System.out.println("3. " + wrongAnswer1);
                System.out.println("4. " + correctAnswer);
                break;
        }
        System.out.println("********************");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите ответ от 1 до 4");
        userInputAnswer = in.nextInt();

        //Если игрок ответил правильно
        if (userInputAnswer == currentCorrectAnswer) {
            System.out.println("Верно");
            System.out.println("Правильный ответ был под номером " + currentCorrectAnswer + ": " + correctAnswer);
            correct.play(true);
            return true;
        }

        //Если игрок ответил неправильно
        System.out.println("Вы проиграли");
        System.out.println("Правильный ответ был под номером " + currentCorrectAnswer + ": " + correctAnswer);
        wrong.play(true);
        return false;
    }

    /**
     * <h2>Выдаёт случайный вопрос из БД не выходя за его рамки
     * @param questions БД
     * @return Случайный вопрос
     */
    public static QuestionWithAnswers getRandomQuestion(LinkedList<QuestionWithAnswers> questions) {
        currentQuestionIndex = randomInt(0, questions.size() - 1);
        return questions.get(currentQuestionIndex);
    }

    /**
     * <h2>Выдает Случайную цифру
     * @param min минимальный порог
     * @param max максимальный порог
     * @return random int
     */
    public static int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}

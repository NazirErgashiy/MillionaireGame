package database;

import lombok.Builder;
import lombok.Data;

/**
 * <h2> Основной класс который служит как контейнер
 * <p> question - вопрос
 * <p> correctAnswer - правильный ответ на вопрос
 * <p> wrongAnswer 1-3 - неправильные ответы на вопрос
 */
@Data
@Builder
public class QuestionWithAnswers {
    private String question;
    private String correctAnswer;
    private String wrongAnswer1;
    private String wrongAnswer2;
    private String wrongAnswer3;
}

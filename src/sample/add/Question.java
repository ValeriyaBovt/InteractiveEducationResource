package sample.add;

import java.util.Arrays;

public class Question {
    private String question;
    private String[] answer;

    public Question(String question, String[] answer) {
        this.question = question;
        this.answer = answer;
    }
    public String correctAnswer ()
    {
        return this.answer[answer.length-1];
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswer() {
        return answer;
    }

    public void setAnswer(String[] answer) {
        this.answer = answer;
    }
}

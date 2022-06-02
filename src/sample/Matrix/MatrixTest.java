package sample.Matrix;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.add.Question;
import javafx.scene.image.ImageView;
import sample.animations.Shakes;

public class MatrixTest {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup answer;

    @FXML
    private RadioButton answer1;

    @FXML
    private RadioButton answer2;

    @FXML
    private RadioButton answer3;

    @FXML
    private RadioButton answer4;

    @FXML
    private Button answer_button;

    @FXML
    private Button back_button;

    @FXML
    private ImageView img_bad;

    @FXML
    private ImageView img_good;

    @FXML
    private ImageView img_quest;

    @FXML
    private Label question_label;

    @FXML
    private Label finish_label;

    @FXML
    private Button next_button;

    @FXML
    private Button toMenu_button;

    public MatrixTest() throws IOException {
    }

    private  Question[] question;
    public Question[] fullArray () throws IOException {
        File file = new File("./src/sample/Matrix/question_matrix.txt");
        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));
        lineNumberReader.skip(Long.MAX_VALUE);
        int lines = lineNumberReader.getLineNumber();
        lineNumberReader.close();
        int n=lines/5;//кількість питань
        question=new Question[n];
        int i=0;
        Scanner s = new Scanner(new File("./src/sample/Matrix/question_matrix.txt"));
        while (i<n) {

            question[i]=
                    new Question(s.nextLine(), new String[] {
                            s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine()
                    });
            i++;
        }
        return question;
    }

    private int nowQuestion = 0, correctAnswer;
    private String nowCorrectAnswer;
    @FXML
    void initialize() throws IOException {
        img_bad.setVisible(false);
        img_good.setVisible(false);
        finish_label.setVisible(false);

        question=fullArray();
        Collections.shuffle(Arrays.asList(question));
        nowCorrectAnswer = question[nowQuestion].correctAnswer();
        question_label.setText(question[nowQuestion].getQuestion());//для першого питання
        // Получаем массив ответов
        String[] answers1 = question[nowQuestion].getAnswer();
        // Преобразовываем в список (так удобнее сортировать элементы)
        List<String> intList1 = Arrays.asList(answers1);
        // Сортируем в случайном порядке
        Collections.shuffle(intList1);
        // Подставляем ответы в радио кнопки
        answer1.setText(intList1.get(0));
        answer2.setText(intList1.get(1));
        answer3.setText(intList1.get(2));
        answer4.setText(intList1.get(3));


        answer_button.setOnAction(event -> {
            RadioButton selectedRadio = (RadioButton) answer.getSelectedToggle();
            if (selectedRadio!=null) {
                String toggleGroupValue = selectedRadio.getText();

                if (toggleGroupValue.equals(nowCorrectAnswer))
                {
                    img_quest.setVisible(false);
                    img_good.setVisible(true);
                }
                else {
                    System.out.println("no");
                    img_quest.setVisible(false);
                    img_bad.setVisible(true);
                }
                answer_button.setVisible(false);
                answerDisable(true);


            }
            else {
                shakerAnswers();
            }
        });
        next_button.setOnAction(event -> {
            answerDisable(false);
            img_good.setVisible(false);
            img_bad.setVisible(false);
            img_quest.setVisible(true);
            RadioButton selectedRadio = (RadioButton) answer.getSelectedToggle();
            if (selectedRadio!=null) {
                String toggleGroupValue = selectedRadio.getText();

                if (toggleGroupValue.equals(nowCorrectAnswer)) {
                    correctAnswer++;
                }
            }
            if (nowQuestion + 1 == question.length) {

                hideAll();
                finish_label.setVisible(true);
                // Показываем текст в конце
                finish_label.setText("   Ви відповіли правильно на   " + correctAnswer + " з " + question.length + " питань!");
            } else { // Если еще есть вопросы...
                answerDisable(false);
                answer_button.setVisible(true);
                nowQuestion++;// Увеличиваем номер текущего вопроса
                nowCorrectAnswer = question[nowQuestion].correctAnswer();// Указываем новый текст верного ответа
                question_label.setText(question[nowQuestion].getQuestion()); // Меняем текст вопроса в программе
                String[] answers = question[nowQuestion].getAnswer();// Получаем массив ответов
                List<String> intList = Arrays.asList(answers);// Преобразовываем в список (так удобнее сортировать элементы)
                Collections.shuffle(intList);// Сортируем в случайном порядке
                // Подставляем ответы в радио кнопки
                answer1.setText(intList.get(0));
                answer2.setText(intList.get(1));
                answer3.setText(intList.get(2));
                answer4.setText(intList.get(3));
                // Снимаем выделение, что указал пользователь ранее
                if (selectedRadio != null) {
                    selectedRadio.setSelected(false);
                }
            }
        });

        toMenu_button.setOnAction(event -> {
            toMenu_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/Menu.fxml");

        });
        back_button.setOnAction(event -> {
            back_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/matrixMenu.fxml");

        });

    }

    void hideAll()
    {
        answer1.setVisible(false); // Скрываем все поля для выбора
        answer2.setVisible(false);
        answer3.setVisible(false);
        answer4.setVisible(false);
        answer_button.setVisible(false); // Скрываем кнопку ответа
        img_good.setVisible(false);
        img_bad.setVisible(false);
        img_quest.setVisible(false);
        next_button.setVisible(false);
        question_label.setVisible(false);
    }

    void openWindow (String address)
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(address));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("/sample/assets/icon.png"));
        stage.setTitle("Інтерактивний освітній ресурс до розділу алгера та аналітична геометрія");
        stage.show();
    }
    void answerDisable (boolean b)
    {
        answer1.setDisable(b);
        answer2.setDisable(b);
        answer3.setDisable(b);
        answer4.setDisable(b);
    }
    public void shakerAnswers()
    {
        Shakes answ1 = new Shakes(answer1);
        Shakes answ2 = new Shakes(answer2);
        Shakes answ3 = new Shakes(answer3);
        Shakes answ4 = new Shakes(answer4);
        answ2.play();
        answ1.play();
        answ3.play();
        answ4.play();
    }



}




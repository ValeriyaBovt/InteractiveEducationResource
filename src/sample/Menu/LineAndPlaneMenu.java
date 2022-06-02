package sample.Menu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LineAndPlaneMenu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label note;

    @FXML
    private Button practice_button;

    @FXML
    private Button test_button;

    @FXML
    private Button theory_button;

    @FXML
    private Button toMenu_button;

    @FXML
    void handle(ActionEvent event) {

    }

    @FXML
    void initialize() {
        String new_color = "-fx-background-color: #FB6B90; -fx-border-color: #000000  ";
        String back_color ="-fx-background-color: #ffffff; -fx-border-color: #000000 ";
        note.setText("                                                            Оберіть розділ");
        toMenu_button.setOnAction(event -> {
            toMenu_button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Menu/Menu.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        });
        practice_button.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                practice_button.setStyle(new_color);
                note.setText("Тут ви можете знайти приклади розв'язання завдань, калькулятори та задачі");

            }
        });
        practice_button.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                practice_button.setStyle(back_color);
                note.setText("                                                            Оберіть розділ");
            }
        });
        theory_button.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                theory_button.setStyle(new_color);
                note.setText("             Тут ви зможете знайти теоретичну інформацію: конспект та лекції");
            }
        });
        theory_button.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                theory_button.setStyle(back_color);
                note.setText("                                                            Оберіть розділ");

            }
        });
        test_button.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                test_button.setStyle(new_color);
                note.setText("                             Тут ви зможете знайти тести за даною темою" );

            }
        });
        test_button.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                test_button.setStyle(back_color);
                note.setText("                                                            Оберіть розділ");

            }
        });
        theory_button.setOnAction(event -> {
            theory_button.getScene().getWindow().hide();
            openWindow("/sample/LineAndPlane/lineAndPlaneTheory.fxml");
        });
       test_button.setOnAction(event -> {
            test_button.getScene().getWindow().hide();
            openWindow("/sample/LineAndPlane/lineAndPlaneTest.fxml");
        });


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






}


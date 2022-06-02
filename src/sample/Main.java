package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample/Menu/Menu.fxml"));
        primaryStage.setTitle("Інтерактивний освітній ресурс до розділу алгера та аналітична геометрія");
        primaryStage.setScene(new Scene(root, 700, 560));
        primaryStage.getIcons().add(new Image("/sample/assets/icon.png"));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}

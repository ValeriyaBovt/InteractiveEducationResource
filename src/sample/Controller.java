package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.ForDB.DataBaseHandler;
import sample.ForDB.User;
import sample.animations.Shakes;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enter_button;

    @FXML
    private Button goRegistration_button;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    void initialize() {

        enter_button.setOnAction(event -> {
            //String loginText = login_field.getText().trim();
            //String passwordText = password_field.getText().trim();
            String loginText="lerabovt";
            String passwordText="123456";
            if(!loginText.equals("") && !passwordText.equals(""))
                loginUser(loginText,passwordText);
            else System.out.println("empty");
                });
       goRegistration_button.setOnAction(event -> {
           goRegistration_button.getScene().getWindow().hide();
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/sample/registration.fxml"));
           try {
               loader.load();
           } catch (IOException e) {
               e.printStackTrace();
           }
           Parent root = loader.getRoot();
           Stage stage = new Stage();
           stage.setScene(new Scene(root));
           stage.showAndWait();


       });
    }

    private void loginUser(String loginText, String passwordText) {
        DataBaseHandler dbHandler = new DataBaseHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassword(passwordText);
        ResultSet resultSet = dbHandler.getUser(user);

        int counter=0;

        try{
            while (resultSet.next())
                counter++;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }


        if(counter>=1){
            openNewScene("/sample/Menu/Menu.fxml");//другое окно
        }
        else {
            Shakes loginEnterAnim = new Shakes(login_field);
            Shakes passwordEnterAnim = new Shakes(password_field);
            loginEnterAnim.play();
            passwordEnterAnim.play();
        }

    }
    public void openNewScene (String window){
        enter_button.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

}

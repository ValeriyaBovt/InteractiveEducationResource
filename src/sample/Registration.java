package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.ForDB.DataBaseHandler;
import sample.ForDB.User;

public class Registration {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_button;

    @FXML
    private CheckBox check_student;

    @FXML
    private CheckBox check_teacher;

    @FXML
    private TextField reg_email;

    @FXML
    private TextField reg_login;

    @FXML
    private TextField reg_name;

    @FXML
    private PasswordField reg_password;

    @FXML
    private TextField reg_surname;

    @FXML
    private Button registration_now_button;

    @FXML
    void initialize() {
            registration_now_button.setOnAction(event ->{
                registrationNewUser();

                    }
                    );
    }

    private void registrationNewUser() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        String name = reg_name.getText();
        String surname = reg_surname.getText();
        String login = reg_login.getText();
        String password = reg_password.getText();
        String email = reg_email.getText();
        String level;

        if(check_student.isSelected())
            level="Студент";
        else
            level="Викладач";

        User user = new User(name, surname, login, password, email, level);

        dbHandler.registrationUser(user);
    }

}

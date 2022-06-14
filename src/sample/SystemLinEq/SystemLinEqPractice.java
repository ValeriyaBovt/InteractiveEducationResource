package sample.SystemLinEq;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.add.Matrix;

public class SystemLinEqPractice {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button GaussMethod_button;

    @FXML
    private Button KramerMethod_button;

    @FXML
    private TextField a11_text;

    @FXML
    private TextField a12_text;

    @FXML
    private TextField a13_text;

    @FXML
    private TextField a21_text;

    @FXML
    private TextField a22_text;

    @FXML
    private TextField a23_text;

    @FXML
    private TextField a31_text;

    @FXML
    private TextField a32_text;

    @FXML
    private TextField a33_text;

    @FXML
    private Button solve_button;

    @FXML
    private Button back_button;

    @FXML
    private TextField h1_text;

    @FXML
    private TextField h2_text;

    @FXML
    private TextField h3_text;

    @FXML
    private Button matrixMethod_button;

    @FXML
    private Label solution_label;

    @FXML
    private Button toMenu_button;
    private int whatDoing=1;//1 - метод Крамера, 2 - матричний метод
    String startStyleForButton = "-fx-background-color: #ffffff; -fx-border-color:  #FB6B90; -fx-border-radius: 5 ";
    String activeStyleForButton ="-fx-background-color: #ffffff; -fx-border-color: #000000; -fx-border-radius: 5 ";
    @FXML
    void initialize() {
        allTextFieldsOnlyNumber();
        KramerMethod_button.setStyle(activeStyleForButton);


        KramerMethod_button.setOnAction(event -> {
            matrixMethod_button.setStyle(startStyleForButton);
            KramerMethod_button.setStyle(activeStyleForButton);
            whatDoing=1;
        });
        matrixMethod_button.setOnAction(event -> {
            KramerMethod_button.setStyle(startStyleForButton);
            matrixMethod_button.setStyle(activeStyleForButton);
            whatDoing=2;
        });
        solve_button.setOnAction(event -> {
            Matrix matrix = new Matrix(new double[][]{makeNumber(coefEq1()), makeNumber(coefEq2()), makeNumber(coefEq3())});
           if(whatDoing==1){
               Matrix copy =new Matrix(new double[][]{makeNumber(coefEq1()), makeNumber(coefEq2()), makeNumber(coefEq3())});
               solution_label.setText(matrix.KramerMethod(copy));
           }
           if(whatDoing==2){
               solution_label.setText(matrix.matrixMethod());
           }
        });



        back_button.setOnAction(event -> {
            back_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/systemsLinEqMenu.fxml");

        });
        toMenu_button.setOnAction(event -> {
            toMenu_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/Menu.fxml");

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
    void allTextFieldsOnlyNumber(){
        onlyNumber(coefEq1());
        onlyNumber(coefEq2());
        onlyNumber(coefEq3());
    }
    TextField[] coefEq1() {
        TextField [] line = {a11_text,a12_text,a13_text,h1_text};
        return line;
    }

    TextField[] coefEq2() {
        TextField [] line = {a21_text,a22_text,a23_text,h2_text};
        return line;
    }

    TextField[] coefEq3() {
        TextField [] line = {a31_text,a32_text,a33_text,h3_text};
        return line;
    }

    double[] makeNumber(TextField[] coordinatesText)
    {
        String[] coordinatesStr = new String[4];
        double[] coordinates = new double[4];
        for(int i=0;i<4;i++)
        {
            coordinatesStr[i]=coordinatesText[i].getText();
            if(coordinatesStr[i]=="")
                coordinatesStr[i]="0";
            coordinates[i]=Double.valueOf(coordinatesStr[i]);
        }
        return coordinates;
    }



    void onlyNumber(TextField[] coordinates) {
        for(int j=0;j<4;j++) {
            int b=j;
            coordinates[j].textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue,
                                    String newValue) {
                    if (!newValue.matches("-?\\d*|-?\\d*\\.\\d*")) {
                        newValue = newValue.replaceFirst("\\.", "₊");
                        newValue = newValue.replaceFirst("-", "³");
                        newValue = newValue.replaceAll("[^\\d₊³]", "");
                        newValue = newValue.replaceFirst("₊", "\\.");
                        newValue = newValue.replaceFirst("³", "-");

                        coordinates[b].setText(newValue);
                    }
                }
            });
        }
    }


}

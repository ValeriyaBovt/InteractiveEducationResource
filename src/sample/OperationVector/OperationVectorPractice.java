package sample.OperationVector;

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
import sample.add.CustomVector;

public class OperationVectorPractice {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_button;

    @FXML
    private Label ear_a_lbl;

    @FXML
    private Label ear_b_lbl;

    @FXML
    private TextField lambdaText;

    @FXML
    private Label lambda_label;

    @FXML
    private Button multiplyByNumber_button;

    @FXML
    private Label solution_label;

    @FXML
    private Button solve_button;

    @FXML
    private Button subtractionVector_button;

    @FXML
    private Button sumVectors_button;

    @FXML
    private Button toMenu_button;

    @FXML
    private Label vectora_label;

    @FXML
    private Label vectorb_label;

    @FXML
    private TextField xa_text;

    @FXML
    private TextField xb_text;

    @FXML
    private TextField ya_text;

    @FXML
    private TextField yb_text;

    @FXML
    private TextField za_text;

    @FXML
    private TextField zb_text;
    private int whatDoing=1;//1 - додавання векторів, 2 - віднімання векторів, 3 - множення вектора на число

    @FXML
    void initialize() {
        TextField[] coordinatesVector_a=coordinatesVector_a();
        TextField[] coordinatesVector_b=coordinatesVector_b();
        activeSumVectors_button();//початок
        onlyNumber(coordinatesVector_b);
        onlyNumber(coordinatesVector_a);
        inputOnlyNumbers(lambdaText);


        sumVectors_button.setOnAction(event -> {
            activeSumVectors_button();
            visibleTextFields(coordinatesVector_b,true);
        });
        subtractionVector_button.setOnAction(event -> {
            activeSubtractionVector_button();
            visibleTextFields(coordinatesVector_b,true);
        });
        multiplyByNumber_button.setOnAction(event -> {
            activeMultiplyByNumber_button();
            visibleTextFields(coordinatesVector_b,false);
        });
        solve_button.setOnAction(event -> {
            String result = "";
            CustomVector a = new CustomVector(makeCoordinates(coordinatesVector_a));
            if(whatDoing==1)//додавання векторів
            {
                CustomVector b = new CustomVector((makeCoordinates(coordinatesVector_b)));
                result = "a⃑ - b⃑ = (xa + xb ; ya + yb ; za + zb) = \n"+" = "+a.sumVectors(b);
                solution_label.setText(result);
            }
            if(whatDoing==2)//віднімання векторів
            {
                CustomVector b = new CustomVector((makeCoordinates(coordinatesVector_b)));
                result = "a⃑ - b⃑ = (xa - xb ; ya - yb ; za - zb) = \n"+" = "+a.subtractionVectors(b);
                solution_label.setText(result);
            }
            if(whatDoing==3)//множення вектора на число
            {
                double lambda = lambda();
                result="λa⃑ = (λ×xₐ ; λ×yₐ ; λ×zₐ) =\n"+a.multiplyByNumber(lambda);
                solution_label.setText(result);
            }

        });
        back_button.setOnAction(event -> {
            back_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/operationVectorMenu.fxml");
        });
        toMenu_button.setOnAction(event -> {
            toMenu_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/Menu.fxml");

        });
    }

    void activeSubtractionVector_button() {
        visibleVectorB(true);
        lambda_label.setVisible(false);
        lambdaText.setVisible(false);
        whatDoing=2;
        toStartStyle(multiplyByNumber_button);
        toStartStyle(sumVectors_button);
        activeStyle(subtractionVector_button);
        solution_label.setText("");
    }
    void activeSumVectors_button() {
        visibleVectorB(true);
        lambda_label.setVisible(false);
        lambdaText.setVisible(false);
        whatDoing=1;
        activeStyle(sumVectors_button);
        toStartStyle(subtractionVector_button);
        toStartStyle(multiplyByNumber_button);
        solution_label.setText("");

    }
    void activeMultiplyByNumber_button() {
        visibleVectorB(false);
        lambda_label.setVisible(true);
        lambdaText.setVisible(true);
        vectorb_label.setVisible(false);
        whatDoing=3;
        toStartStyle(sumVectors_button);
        toStartStyle(subtractionVector_button);
        activeStyle(multiplyByNumber_button);
        solution_label.setText("");
    }



    double lambda()
    {
        String lambdaStr = lambdaText.getText();
        if(lambdaStr=="")
            lambdaStr="0";
        return Double.valueOf(lambdaStr);
    }

    double[] makeCoordinates(TextField[] coordinatesText)
    {
        String[] coordinatesStr = new String[3];
        double[] coordinates = new double[3];
        for(int i=0;i<3;i++)
        {
            coordinatesStr[i]=coordinatesText[i].getText();
            if(coordinatesStr[i]=="")
                coordinatesStr[i]="0";
            coordinates[i]=Double.valueOf(coordinatesStr[i]);
        }
        return coordinates;
    }
    void activeStyle(Button button)
    {
        String newStyleButton ="-fx-background-color: #ffffff; -fx-border-color: #000000; -fx-border-radius: 5 ";
        button.setStyle(newStyleButton);
    }

    void toStartStyle(Button button)
    {
        String startStyle = "-fx-background-color: #ffffff; -fx-border-color:  #FB6B90; -fx-border-radius: 5 ";
        button.setStyle(startStyle);
    }

    void visibleTextFields(TextField[] text,boolean b)
    {
        for(int i=0;i<3;i++)
            text[i].setVisible(b);
    }
    void visibleVectorB(boolean b)
    {
        visibleTextFields(coordinatesVector_b(),b);
        vectorb_label.setVisible(b);
        ear_b_lbl.setVisible(b);
    }
    TextField[] coordinatesVector_b()
    {
        TextField[] B={xb_text,yb_text,zb_text};
        return B;
    }
    TextField[] coordinatesVector_a()
    {
        TextField[] B={xa_text,ya_text,za_text};
        return B;
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

    void onlyNumber(TextField[] coordinates) {
        for(int j=0;j<3;j++) {
           inputOnlyNumbers(coordinates[j]);
        }
    }
    void inputOnlyNumbers(TextField t){
       t.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("-?\\d*|-?\\d*\\.\\d*")) {
                    newValue = newValue.replaceFirst("\\.", "₊");
                    newValue = newValue.replaceFirst("-", "³");
                    newValue = newValue.replaceAll("[^\\d₊³]", "");
                    newValue = newValue.replaceFirst("₊", "\\.");
                    newValue = newValue.replaceFirst("³", "-");

                    t.setText(newValue);
                }
            }
        });

    }
}

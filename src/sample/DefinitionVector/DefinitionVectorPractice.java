package sample.DefinitionVector;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

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

public class DefinitionVectorPractice {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_button;

    @FXML
    private Button findCoordinates_button;

    @FXML
    private Button findLength_button;

    @FXML
    private Button isCollinear_button;

    @FXML
    private Label earA_lbl;

    @FXML
    private Label earB_lbl;

    @FXML
    private Label ear_a_lbl;

    @FXML
    private Label ear_b_lbl;


    @FXML
    private Label pointA_label;

    @FXML
    private Label pointB_label;

    @FXML
    private Label solution_label;

    @FXML
    private Button solve_button;

    @FXML
    private Button toMenu_button;

    @FXML
    private Label vectora_label;

    @FXML
    private Label vectorb_label;

    @FXML
    private TextField xA_text;

    @FXML
    private TextField xB_text;

    @FXML
    private TextField xa_text;

    @FXML
    private TextField xb_text;

    @FXML
    private TextField yA_text;

    @FXML
    private TextField yB_text;

    @FXML
    private TextField ya_text;

    @FXML
    private TextField yb_text;

    @FXML
    private TextField zA_text;

    @FXML
    private TextField zB_text;

    @FXML
    private TextField za_text;

    @FXML
    private TextField zb_text;
    private int whatDoing=1;//1 - пошук координат вектора,2 - пошук довжини вектора, 3 - перевірка на колінеарність
    @FXML
    void initialize() {
        TextField[] coordinatesPointA=coordinatesPointA();
        TextField[] coordinatesPointB=coordinatesPointB();
        TextField[] coordinatesVector_a=coordinatesVector_a();
        TextField[] coordinatesVector_b=coordinatesVector_b();
        onlyNumber(coordinatesPointA);
        onlyNumber(coordinatesVector_b);
        onlyNumber(coordinatesVector_a());
        onlyNumber(coordinatesPointB);

        activeFindCoordinates_button();//початок
        visibleTextFields(coordinatesPointA, true);
        visibleTextFields(coordinatesPointB,true);

        findCoordinates_button.setOnAction(event -> {
            activeFindCoordinates_button();
            visibleTextFields(coordinatesPointA, true);
            visibleTextFields(coordinatesPointB,true);
        });
        findLength_button.setOnAction(event -> {
            activeFindLength_button();
            visibleTextFields(coordinatesVector_a,true);
        });
        isCollinear_button.setOnAction(event -> {
            activeIsCollinear_button();
            visibleTextFields(coordinatesVector_a,true);
            visibleTextFields(coordinatesVector_b,true);
        });
        solve_button.setOnAction(event->{
            if(whatDoing==1)
            {
                CustomVector A= new CustomVector(makeCoordinates(coordinatesPointA));
                CustomVector B=new CustomVector(makeCoordinates(coordinatesPointB));
                String result="a⃑ = A⃑B⃑ = (xB - xA; yB - yA; zB - zA) =\n"+"= "+B.subtractionVectors(A);
                solution_label.setText(result);

            }

            else {CustomVector a = new CustomVector(makeCoordinates(coordinatesVector_a));
                if(whatDoing==2){
                String result ="|a⃑| = √(xₐ²+yₐ²+zₐ²) =\n"+a.lengthVector();
                solution_label.setText(result);
            }
            else{//whatDoing=3
                CustomVector b = new CustomVector(makeCoordinates(coordinatesVector_b));
                String result = "Перевіримо чи колінеарні вектори:\n"+a.isCollinearVectors(b);
                solution_label.setText(result);
            }
            }
        });
        back_button.setOnAction(event -> {
            back_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/basicDefinitionMenu.fxml");

        });
        toMenu_button.setOnAction(event -> {
            toMenu_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/Menu.fxml");

        });
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
    void activeIsCollinear_button()
    {
        hideAllTextFields();
        hideLabels();
        vectora_label.setVisible(true);
        ear_a_lbl.setVisible(true);
        vectorb_label.setVisible(true);
        ear_b_lbl.setVisible(true);
        activeStyle(isCollinear_button);
        toStartStyle(findCoordinates_button);
        toStartStyle(findLength_button);
        whatDoing=3;
    }
    void activeFindLength_button()
    {
        hideAllTextFields();
        hideLabels();
        vectora_label.setVisible(true);
        ear_a_lbl.setVisible(true);
        activeStyle(findLength_button);
        toStartStyle(findCoordinates_button);
        toStartStyle(isCollinear_button);
        whatDoing=2;
    }
    void activeFindCoordinates_button()
    {
        hideAllTextFields();
        hideLabels();
        pointA_label.setVisible(true);
        earA_lbl.setVisible(true);
        pointB_label.setVisible(true);
        earB_lbl.setVisible(true);
        activeStyle(findCoordinates_button);
        toStartStyle(findLength_button);
        toStartStyle(isCollinear_button);
        whatDoing=1;
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
    void hideLabels()
    {
        pointA_label.setVisible(false);
        pointB_label.setVisible(false);
        earA_lbl.setVisible(false);
        earB_lbl.setVisible(false);
        vectora_label.setVisible(false);
        vectorb_label.setVisible(false);
        ear_a_lbl.setVisible(false);
        ear_b_lbl.setVisible(false);
        solution_label.setText("");
    }
    void visibleTextFields(TextField[] text,boolean b)
    {
        for(int i=0;i<3;i++)
            text[i].setVisible(b);
    }
    void hideAllTextFields()
    {
        visibleTextFields(coordinatesVector_a(),false);
        visibleTextFields(coordinatesPointA(),false);
        visibleTextFields(coordinatesVector_b(),false);
        visibleTextFields(coordinatesPointB(),false);

    }
    TextField[] coordinatesPointA()
    {
        TextField[] A={xA_text,yA_text,zA_text};
        return A;
    }
    TextField[] coordinatesPointB()
    {
        TextField[] B={xB_text,yB_text,zB_text};
        return B;
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

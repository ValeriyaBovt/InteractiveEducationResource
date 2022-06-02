package sample.LineOnPlane;

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
import sample.add.LinesAndPlane;

public class LineOnPlanePractice {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_button;

    @FXML
    private Label eq1_label;

    @FXML
    private Label eq2_label;

    @FXML
    private Button findAngle_button;

    @FXML
    private Button findDistance_button;

    @FXML
    private Button findIntersectionPoint_button;

    @FXML
    private TextField lambdaText;

    @FXML
    private Label lambda_label;

    @FXML
    private Button makeEqByTwoPoints_button;

    @FXML
    private Button makeEqParallel_button;

    @FXML
    private Button makeEqPerpendicular_button;

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
    private TextField xA_text;

    @FXML
    private TextField xB_text;

    @FXML
    private TextField yA_text;

    @FXML
    private TextField yB_text;

    @FXML
    private TextField zA_text;

    @FXML
    private TextField zB_text;

    @FXML
    private TextField сoefA1_text;

    @FXML
    private TextField сoefA2_text;

    @FXML
    private TextField сoefB1_text;

    @FXML
    private TextField сoefB2_text;

    @FXML
    private TextField сoefC1_text;

    @FXML
    private TextField сoefC2_text;
    private int whatDoing = 1; //1 - рівняння прямої за двома точками, 2 - рівняння перпендикулярної прямої,
    // 3 - рівняння паралельної прямої, 4 - пошук точки перетину, 5 - пошук кута між прямими, 6 - відстань між точко. і прямою
    @FXML
    void initialize() {
        startPosition();
        activeStyle(makeEqByTwoPoints_button);//start
        visiblePointA(true);
        visiblePointB(true);
        zA_text.setVisible(false);
        zB_text.setVisible(false);
        onlyNumber(coordinatesPointA());
        onlyNumber(coordinatesPointB());
        onlyNumber(coefficientsLine1());
        onlyNumber(coefficientsLine2());
        makeEqByTwoPoints_button.setOnAction(event -> {
            startPosition();
            activeStyle(makeEqByTwoPoints_button);
            visiblePointA(true);
            visiblePointB(true);
            zA_text.setVisible(false);
            zB_text.setVisible(false);
            whatDoing=1;
        });
        makeEqPerpendicular_button.setOnAction(event -> {
            startPosition();
            activeStyle(makeEqPerpendicular_button);
            visiblePointA(true);
            visibleLine1(true);
            zA_text.setVisible(false);
            whatDoing=2;
        });
        makeEqParallel_button.setOnAction(event -> {
            startPosition();
            activeStyle(makeEqParallel_button);
            visiblePointA(true);
            visibleLine1(true);
            zA_text.setVisible(false);
            whatDoing=3;
        });
        findIntersectionPoint_button.setOnAction(event -> {
            startPosition();
            activeStyle(findIntersectionPoint_button);
            visibleLine1(true);
            visibleLine2(true);
            whatDoing=4;
       });
        findAngle_button.setOnAction(event -> {
            startPosition();
            activeStyle(findAngle_button);
            visibleLine1(true);
            visibleLine2(true);
            whatDoing=5;
        });
        findDistance_button.setOnAction(event -> {
            startPosition();
            activeStyle(findDistance_button);
            visibleLine1(true);
            visiblePointA(true);
            zA_text.setVisible(false);
            whatDoing=6;
        });
        solve_button.setOnAction(event ->
        {       solution_label.setText("");
            if(whatDoing==1) {
                LinesAndPlane points = new LinesAndPlane(makeNumber(coordinatesPointA()),makeNumber(coordinatesPointB()));
                solution_label.setText(points.makeEquationLineByTwoPoints());
            }
            if(whatDoing==2) {
                LinesAndPlane line = new LinesAndPlane(makeNumber(coordinatesPointA()),makeNumber(coefficientsLine1()));
                solution_label.setText(line.makeEquationPerpendicularLine());
            }
            if(whatDoing==3){
                LinesAndPlane line = new LinesAndPlane(makeNumber(coordinatesPointA()),makeNumber(coefficientsLine1()));
                solution_label.setText(line.makeEquationParallelLine());
            }
            if(whatDoing==4){
                LinesAndPlane line = new LinesAndPlane(makeNumber(coefficientsLine1()),makeNumber(coefficientsLine2()));
                solution_label.setText(line.findIntersectionPoint());
            }
            if(whatDoing==5) {
                LinesAndPlane lines = new LinesAndPlane(makeNumber(coefficientsLine1()),makeNumber(coefficientsLine2()));
                solution_label.setText(lines.findAngleBetweenLines());
            }
            if(whatDoing==6) {
                LinesAndPlane line = new LinesAndPlane(makeNumber(coordinatesPointA()),makeNumber(coefficientsLine1()));
                solution_label.setText(line.findDistanceBetweenPointAndLine());
            }

        });

        back_button.setOnAction(event -> {
            back_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/lineOnPlaneMenu.fxml");
        });
        toMenu_button.setOnAction(event -> {
            toMenu_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/Menu.fxml");

        });
    }
    void visiblePointA(boolean b)
    {
        visibleTextFields(coordinatesPointA(),b);
        pointA_label.setVisible(b);
    }
    void visiblePointB(boolean b)
    {
        visibleTextFields(coordinatesPointB(),b);
        pointB_label.setVisible(b);
    }
    void visibleLine1(boolean b)
    {
        visibleTextFields(coefficientsLine1(),b);
        eq1_label.setVisible(b);
    }
    void visibleLine2(boolean b)
    {
        visibleTextFields(coefficientsLine2(),b);
        eq2_label.setVisible(b);
    }
    void startPosition()
    {   //всі кнопки до початкового вигляду
        toStartStyle(makeEqParallel_button);
        toStartStyle(makeEqPerpendicular_button);
        toStartStyle(makeEqByTwoPoints_button);
        toStartStyle(findAngle_button);
        toStartStyle(findDistance_button);
        toStartStyle(findIntersectionPoint_button);
        //приховуємо всі точки/прямі
        visibleLine1(false);
        visibleLine2(false);
        visiblePointA(false);
        visiblePointB(false);
    }
    double[] makeNumber(TextField[] coordinatesText)
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
    TextField[] coordinatesPointA()
    {
        TextField[] pointA = {xA_text,yA_text,zA_text};
        return pointA;
    }
    TextField[] coordinatesPointB()
    {
        TextField[] pointB = {xB_text,yB_text,zB_text};
        return pointB;
    }
    TextField[] coefficientsLine1()
    {
        TextField[] coef1={сoefA1_text,сoefB1_text,сoefC1_text} ;
        return coef1;
    }
    TextField[] coefficientsLine2()
    {
        TextField[] coef2={сoefA2_text,сoefB2_text,сoefC2_text} ;
        return coef2;
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



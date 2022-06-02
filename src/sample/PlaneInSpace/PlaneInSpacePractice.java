package sample.PlaneInSpace;

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

public class PlaneInSpacePractice {

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
    private Button isPerpendicular_button;
    @FXML
    private Button isParallel_button;

    @FXML
    private Button makeEqByPointVector_button;

    @FXML
    private Button makeEqByThreePoints_button;

    @FXML
    private Label pointA_label;

    @FXML
    private Label pointB_label;

    @FXML
    private Label pointC_label;

    @FXML
    private Label solution_label;

    @FXML
    private Button solve_button;

    @FXML
    private Button toMenu_button;

    @FXML
    private Label vector_label;

    @FXML
    private TextField xA_text;

    @FXML
    private TextField xB_text;

    @FXML
    private TextField xC_text;

    @FXML
    private TextField xn_text;

    @FXML
    private TextField yA_text;

    @FXML
    private TextField yB_text;

    @FXML
    private TextField yC_text;

    @FXML
    private TextField yn_text;

    @FXML
    private TextField zA_text;

    @FXML
    private TextField zB_text;

    @FXML
    private TextField zC_text;

    @FXML
    private TextField zn_text;

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

    @FXML
    private TextField сoefD1_text;

    @FXML
    private TextField сoefD2_text;
    private int whatDoing = 1;//1 - скласти рівняння площини, 2 - рівняння площини через три точки, 3 - знайти кут між площинами
    //4 -знайти відстань від точки до площини , 5 - чи є площини перпендикулярними, 6 - чи э площини паралельними
    @FXML
    void initialize() {
        startPosition();
        visiblePointA(true);
        visibleVectorN(true);
        activeStyle(makeEqByPointVector_button);
        onlyNumber(coordinatesPointA(),3);
        onlyNumber(coordinatesPointB(),3);
        onlyNumber(coordinatesPointC(),3);
        onlyNumber(coordinatesVectorN(),3);
        onlyNumber(coefficientsPlane1(),4);
        onlyNumber(coefficientsPlane2(),4);
        makeEqByPointVector_button.setOnAction(event -> {
            startPosition();
            whatDoing=1;
            visiblePointA(true);
            visibleVectorN(true);
            activeStyle(makeEqByPointVector_button);
        });
        makeEqByThreePoints_button.setOnAction(event -> {
            startPosition();
            whatDoing=2;
            visiblePointA(true);
            visiblePointB(true);
            visiblePointC(true);
            activeStyle(makeEqByThreePoints_button);
        });
        findAngle_button.setOnAction(event -> {
            startPosition();
            whatDoing=3;
            visiblePlane1(true);
            visiblePlane2(true);
            activeStyle(findAngle_button);
        });
        findDistance_button.setOnAction(event -> {
            startPosition();
            whatDoing=4;
            visiblePointA(true);
            visiblePlane1(true);
            activeStyle(findDistance_button);
        });
        isPerpendicular_button.setOnAction(event -> {
            startPosition();
            whatDoing=5;
            visiblePlane1(true);
            visiblePlane2(true);
            activeStyle(isPerpendicular_button);
        });
        isParallel_button.setOnAction(event -> {
            startPosition();
            whatDoing=6;
            visiblePlane1(true);
            visiblePlane2(true);
            activeStyle(isParallel_button);
        });
        solve_button.setOnAction(event ->{
            solution_label.setText("");
            if(whatDoing==1)//рівняння за точкою  і заданим нормальним вектором
            {
                LinesAndPlane pointVector = new LinesAndPlane(makeNumber(coordinatesPointA(),3),makeNumber(coordinatesVectorN(),3));
                solution_label.setText(pointVector.makeEquationPlaneByPointAndVector());
            }
            if(whatDoing==2)//рівняння за трьома точками
            {

            }
            if(whatDoing==3)//знайти кут між площинами
            {
                LinesAndPlane twoPlanes = new LinesAndPlane(makeNumber(coefficientsPlane1(),4),makeNumber(coefficientsPlane2(),4));
                solution_label.setText(twoPlanes.findAngleBetweenPlanes());
            }
            if(whatDoing==4)//знайти відстань від точки до площини
            {
                LinesAndPlane pointAndPlane = new LinesAndPlane(makeNumber(coordinatesPointA(),3),makeNumber(coefficientsPlane1(),4));
                solution_label.setText(pointAndPlane.findDistanceBetweenPointAndPlane());
            }
            if(whatDoing==5)//чи є площини перпендикулярними
            { LinesAndPlane twoPlanes = new LinesAndPlane(makeNumber(coefficientsPlane1(),4),makeNumber(coefficientsPlane2(),4));
                solution_label.setText(twoPlanes.isPerpendicularPlanes());
            }
            if(whatDoing==6)//чи є площини паралельними
            { LinesAndPlane twoPlanes = new LinesAndPlane(makeNumber(coefficientsPlane1(),4),makeNumber(coefficientsPlane2(),4));
                solution_label.setText(twoPlanes.isParallelPlanes());
            }

        });
        back_button.setOnAction(event -> {
            back_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/planeInSpaceMenu.fxml");
        });
        toMenu_button.setOnAction(event -> {
            toMenu_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/Menu.fxml");

        });
    }


    void startPosition()
    {
        toStartStyle(findAngle_button);
        toStartStyle(isPerpendicular_button);
        toStartStyle(findDistance_button);
        toStartStyle(makeEqByPointVector_button);
        toStartStyle(makeEqByThreePoints_button);

        visiblePointB(false);
        visiblePointA(false);
        visiblePointC(false);
        visibleVectorN(false);
        visiblePlane1(false);
        visiblePlane2(false);
        solution_label.setText("");
    }
    void visiblePointA(boolean b)
    {
        visibleTextFields(coordinatesPointA(),b, 3);
        pointA_label.setVisible(b);
    }
    void visiblePointB(boolean b)
    {
        visibleTextFields(coordinatesPointB(),b, 3);
        pointB_label.setVisible(b);
    }
    void visiblePointC(boolean b)
    {
        visibleTextFields(coordinatesPointC(),b, 3);
        pointC_label.setVisible(b);
    }
    void visibleVectorN(boolean b)
    {
        visibleTextFields(coordinatesVectorN(),b,3);
        vector_label.setVisible(b);
    }
    void visiblePlane1(boolean b)
    {
        visibleTextFields(coefficientsPlane1(),b,4);
        eq1_label.setVisible(b);
    }
    void visiblePlane2(boolean b)
    {
        visibleTextFields(coefficientsPlane2(),b,4);
        eq2_label.setVisible(b);
    }


    double[] makeNumber(TextField[] coordinatesText, int n)
    {
        String[] coordinatesStr = new String[n];
        double[] coordinates = new double[n];
        for(int i=0;i<n;i++)
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

    void visibleTextFields(TextField[] text,boolean b, int n)
    {
        for(int i=0;i<n;i++)
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
    TextField[] coordinatesPointC()
    {
        TextField[] pointC = {xC_text,yC_text,zC_text};
        return pointC;
    }
    TextField[] coordinatesVectorN()
    {
        TextField[] vector = {xn_text,yn_text,zn_text};
        return vector;
    }
    TextField[] coefficientsPlane1()
    {
        TextField[] coef1={сoefA1_text,сoefB1_text,сoefC1_text, сoefD1_text} ;
        return coef1;
    }
    TextField[] coefficientsPlane2()
    {
        TextField[] coef2={сoefA2_text,сoefB2_text,сoefC2_text, сoefD2_text} ;
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
    void onlyNumber(TextField[] coordinates, int n) {
        for(int j=0;j<n;j++) {
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

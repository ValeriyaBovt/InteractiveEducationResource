package sample.LineInSpace;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LineInSpacePractice {

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
    private Label eq2Line_label;

    @FXML
    private Label eq1Line_label;

    @FXML
    private Button eqLineByIntersectionPlanes_button;

    @FXML
    private Button findAngle_button;

    @FXML
    private Button isParallel_button;

    @FXML
    private Button isPerpendicular_button;

    @FXML
    private Button makeEqByPointVector_button;

    @FXML
    private Button makeEqByTwoPoints_button;

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
    private TextField xn_text;

    @FXML
    private TextField yA_text;

    @FXML
    private TextField yB_text;

    @FXML
    private TextField yn_text;

    @FXML
    private TextField zA_text;

    @FXML
    private TextField zB_text;

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
    private int whatDoing =1;//1 - рівняння прямої через дві точки, 2- рівняння прямої, через напрямний вектор
    //3 - кут між прямими, 4 - пряма - перетин площин, 5- чи є перпендикулярні, 6 - чи паралельні

    @FXML
    void initialize() {
        backUp();
        visiblePointA(true);
        visiblePointB(true);
        activeStyle(makeEqByTwoPoints_button);


        makeEqByTwoPoints_button.setOnAction(event ->{
            backUp();
            visiblePointA(true);
            visiblePointB(true);
            activeStyle(makeEqByTwoPoints_button);
            whatDoing=1;

        } );
        makeEqByPointVector_button.setOnAction(event ->{
            backUp();
            visiblePointA(true);
            visibleVectorS(true);
            activeStyle(makeEqByPointVector_button);
            whatDoing=2;
        } );
        findAngle_button.setOnAction(event ->{
            backUp();
            visibleLine1(true);
            visibleLine2(true);
            activeStyle(findAngle_button);
            whatDoing=3;
        } );
        eqLineByIntersectionPlanes_button.setOnAction(event ->{
            backUp();
            visiblePlane1(true);
            visiblePlane2(true);
            activeStyle(eqLineByIntersectionPlanes_button);
            whatDoing=4;
        } );
        isPerpendicular_button.setOnAction(event ->{
            backUp();
            visibleLine1(true);
            visibleLine2(true);
            activeStyle(isPerpendicular_button);
            whatDoing=5;
        } );
        isParallel_button.setOnAction(event ->{
            backUp();
            visibleLine1(true);
            visibleLine2(true);
            activeStyle(isParallel_button);
            whatDoing=6;
        } );
        solve_button.setOnAction(event ->{
            if(whatDoing==1) {//рівняння прямої через дві точки

            }
            if(whatDoing==2) {//рівняння прямої через точку і вектор

            }
            if(whatDoing==3) {//кут між прямими

            }
            if(whatDoing==4) {//рівняння перетину двох площин

            }
            if(whatDoing==5) {//чи є перпендикулярними

            }
            if(whatDoing==6) {//чи є паралельними

            }
        });






        back_button.setOnAction(event -> {
            back_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/lineInSpaceMenu.fxml");
        });
        toMenu_button.setOnAction(event -> {
            toMenu_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/Menu.fxml");

        });
    }

    void backUp()
    {
        toStartStyle(makeEqByPointVector_button);
        toStartStyle(makeEqByTwoPoints_button);
        toStartStyle(isPerpendicular_button);
        toStartStyle(isParallel_button);
        toStartStyle(eqLineByIntersectionPlanes_button);
        toStartStyle(findAngle_button);

        visiblePlane1(false);
        visiblePlane2(false);
        visibleLine2(false);
        visibleLine1(false);
        visiblePointA(false);
        visiblePointB(false);
        visibleVectorS(false);
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

    void visibleVectorS(boolean b)
    {
        visibleTextFields(coordinatesVectorS(),b,3);
        vector_label.setVisible(b);
    }
    void visiblePlane1(boolean b)
    {
        visibleTextFields(coefficients1(),b,4);
        eq1_label.setVisible(b);
    }
    void visiblePlane2(boolean b)
    {
        visibleTextFields(coefficients2(),b,4);
        eq2_label.setVisible(b);
    }
    void  visibleLine1(boolean b)
    {
        visibleTextFields(coefficients1(),b,4);
        eq1Line_label.setVisible(b);
    }
    void  visibleLine2(boolean b)
    {
        visibleTextFields(coefficients2(),b,4);
        eq2Line_label.setVisible(b);
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
    TextField[] coordinatesVectorS()
    {
        TextField[] vector = {xn_text,yn_text,zn_text};
        return vector;
    }
    TextField[] coefficients1()
    {
        TextField[] coef1={сoefA1_text,сoefB1_text,сoefC1_text, сoefD1_text} ;
        return coef1;
    }
    TextField[] coefficients2()
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

}

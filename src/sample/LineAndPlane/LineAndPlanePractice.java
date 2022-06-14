package sample.LineAndPlane;

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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.add.LinesAndPlane;

public class LineAndPlanePractice {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_button;

    @FXML
    private Label eq1Line_label;

    @FXML
    private Label eq2Line_label;

    @FXML
    private Label eqPlane2_label;

    @FXML
    private ImageView eqLine1Img;

    @FXML
    private ImageView eqLine2Img;

    @FXML
    private Label eqPlane1_label;

    @FXML
    private Button eqPlaneFromPointAndLine_button;

    @FXML
    private Button findInersectionPoint_button;

    @FXML
    private Button intersectionLine_button;

    @FXML
    private TextField lLine1_text;

    @FXML
    private TextField lLine2_text;

    @FXML
    private TextField mLine1_text;

    @FXML
    private TextField mLine2_text;

    @FXML
    private Button makeEqPerpendicularPlane_button;

    @FXML
    private TextField pLine1_text;

    @FXML
    private TextField pLine2_text;

    @FXML
    private Button planeFromTwoParallelLines_button;

    @FXML
    private Label pointA_label;

    @FXML
    private Label re;

    @FXML
    private Label solution_label;

    @FXML
    private Label solution_label1;

    @FXML
    private Button solve_button;

    @FXML
    private Button symmetricallyPoint_button;

    @FXML
    private Button toMenu_button;

    @FXML
    private TextField x0Line1text;

    @FXML
    private TextField x0Line2text;

    @FXML
    private TextField xA_text;

    @FXML
    private TextField y0Line1text;

    @FXML
    private TextField y0Line2text;

    @FXML
    private TextField yA_text;

    @FXML
    private TextField z0Line1text;

    @FXML
    private TextField z0Line2text;

    @FXML
    private TextField zA_text;

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
    private int whatDoing=1;//1 - точка перетину прямої і площини, 2 - рівняння перпендикулярної площини до прямої,
    //3 - площина через дві паралельні прямі, 4 - симетрична точка, 5 - площина через пряму і точку, 5 - пряма як перетин площин
    String startStyleForButton = "-fx-background-color: #ffffff; -fx-border-color:  #FB6B90; -fx-border-radius: 5 ";
    String activeStyleForButton ="-fx-background-color: #ffffff; -fx-border-color: #000000; -fx-border-radius: 5 ";
    @FXML
    void initialize() {
        intersectionLine_button.setVisible(false);
        allOnlyNumber();
        //start
        backUp();
        findInersectionPoint_button.setStyle(activeStyleForButton);
        visiblePlane1(true);
        visibleLine1(true);


        findInersectionPoint_button.setOnAction(event -> {
            backUp();
            whatDoing=1;
            findInersectionPoint_button.setStyle(activeStyleForButton);
            visiblePlane1(true);
            visibleLine1(true);
        });
        makeEqPerpendicularPlane_button.setOnAction(event -> {
            backUp();
            whatDoing=2;
            makeEqPerpendicularPlane_button.setStyle(activeStyleForButton);
            visibleLine1(true);
            visiblePointA(true);
        });
        planeFromTwoParallelLines_button.setOnAction(event -> {
            backUp();
            whatDoing=3;
            planeFromTwoParallelLines_button.setStyle(activeStyleForButton);
            visibleLine1(true);
            visibleLine2(true);

        });
        symmetricallyPoint_button.setOnAction(event -> {
            backUp();
            whatDoing=4;
            symmetricallyPoint_button.setStyle(activeStyleForButton);
            visiblePointA(true);
            visiblePlane1(true);
        });
        eqPlaneFromPointAndLine_button.setOnAction(event -> {
            backUp();
            whatDoing=5;
            eqPlaneFromPointAndLine_button.setStyle(activeStyleForButton);
            visiblePointA(true);
            visibleLine1(true);
        });
        intersectionLine_button.setOnAction(event -> {
            backUp();
            whatDoing=6;
            intersectionLine_button.setStyle(activeStyleForButton);
            visiblePlane1(true);
            visiblePlane2(true);
        });

        solve_button.setOnAction(event->{
            solution_label.setText("");
            if(whatDoing==1) {
                LinesAndPlane planeAndLine = new LinesAndPlane(makeNumber(coefficientsPlane1(),4),makeNumber(coordinatesVectorForLine1(),3));
                solution_label.setText(planeAndLine.findIntersectionPointBetweenPlaneAndLine(makeNumber(coordinatesPointsForLine1(),3)));
            }
            if(whatDoing==2) {
                LinesAndPlane pointAndVectorLine = new LinesAndPlane(makeNumber(coordinatesPointA(),3),makeNumber(coordinatesVectorForLine1(),3));
                solution_label.setText(pointAndVectorLine.eqPerpendicularPlaneToLine());
            }
            if(whatDoing==3) {
                LinesAndPlane line1 = new LinesAndPlane(makeNumber(coordinatesPointsForLine1(),3),makeNumber(coordinatesVectorForLine1(),3));
                LinesAndPlane line2 = new LinesAndPlane(makeNumber(coordinatesPointsForLine2(),3),makeNumber(coordinatesVectorForLine2(),3));
                solution_label.setText(line1.eqPLaneFromTwoParallelLines(line2));
            }
            if(whatDoing==4) {
                LinesAndPlane pointAndPlane = new LinesAndPlane(makeNumber(coordinatesPointA(),3),makeNumber(coefficientsPlane1(),4));
                solution_label.setText(pointAndPlane.symmetricalPointAsForPlane());
            }
            if(whatDoing==5) {
                LinesAndPlane pointAndVectorLine = new LinesAndPlane(makeNumber(coordinatesPointA(),3),makeNumber(coordinatesVectorForLine1(),3));
                solution_label.setText(pointAndVectorLine.eqPlaneByLineAndPoint(makeNumber(coordinatesPointsForLine1(),3)));

            }
            if(whatDoing==6) {

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
        intersectionLine_button.setStyle(startStyleForButton);
        eqPlaneFromPointAndLine_button.setStyle(startStyleForButton);
        planeFromTwoParallelLines_button.setStyle(startStyleForButton);
        findInersectionPoint_button.setStyle(startStyleForButton);
        makeEqPerpendicularPlane_button.setStyle(startStyleForButton);
        symmetricallyPoint_button.setStyle(startStyleForButton);

        visibleLine1(false);
        visibleLine2(false);
        visiblePointA(false);
        visiblePlane1(false);
        visiblePlane2(false);
    }
    void allOnlyNumber() {
        onlyNumber(coordinatesPointA(),3);
        onlyNumber(coordinatesPointsForLine1(),3);
        onlyNumber(coordinatesVectorForLine1(),3);
        onlyNumber(coefficientsPlane1(),4);
        onlyNumber(coordinatesPointsForLine2(),3);
        onlyNumber(coordinatesVectorForLine2(),3);
    }

    TextField[] coordinatesPointA() {
        TextField[] pointA = {xA_text,yA_text,zA_text};
        return pointA;
    }
    TextField[] coordinatesPointsForLine1()
    {
        TextField[] line1 = {x0Line1text,y0Line1text,z0Line1text};
        return line1;
    }
    TextField[] coordinatesPointsForLine2()
    {
        TextField[] line1 = {x0Line2text,y0Line2text,z0Line2text};
        return line1;
    }
    TextField[] coordinatesVectorForLine1()
    {
        TextField[] line1 = {lLine1_text,mLine1_text,pLine1_text};
        return line1;
    }
    TextField[] coordinatesVectorForLine2()
    {
        TextField[] line1 = {lLine2_text,mLine2_text,pLine2_text};
        return line1;
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
    void visiblePlane1(boolean b)
    {
        visibleTextFields(coefficientsPlane1(),4,b);
        eqPlane1_label.setVisible(b);
    }
    void visiblePlane2(boolean b)
    {
        visibleTextFields(coefficientsPlane2(),4,b);
        eqPlane2_label.setVisible(b);
    }

    double[] makeNumber(TextField[] coordinatesText, int n)
    {
        String[] coordinatesStr = new String[n];
        double[] coordinates = new double[n];
        for(int i=0;i<3;i++)
        {
            coordinatesStr[i]=coordinatesText[i].getText();
            if(coordinatesStr[i]=="")
                coordinatesStr[i]="0";
            coordinates[i]=Double.valueOf(coordinatesStr[i]);
        }
        return coordinates;
    }

    void visibleTextFields(TextField[] text,int n, boolean b) {
        for(int i=0;i<n;i++)
            text[i].setVisible(b);
    }
    void visiblePointA(boolean b) {
        visibleTextFields(coordinatesPointA(),3,b);
        pointA_label.setVisible(b);
    }

    void visibleLine1(boolean b) {
        visibleTextFields(coordinatesVectorForLine1(),3,b);
        visibleTextFields(coordinatesPointsForLine1(),3,b);
        eq1Line_label.setVisible(b);
        eqLine1Img.setVisible(b);
    }
    void visibleLine2(boolean b) {
        visibleTextFields(coordinatesVectorForLine2(),3,b);
        visibleTextFields(coordinatesPointsForLine2(),3,b);
        eq2Line_label.setVisible(b);
        eqLine2Img.setVisible(b);
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

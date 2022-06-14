package sample.LineInSpace;

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
import sample.add.Matrix;

public class LineInSpacePractice {

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
    private ImageView eqLine1Img;

    @FXML
    private ImageView eqLine2Img;

    @FXML
    private Button findDistanseBetweenPointAndLine_button;

    @FXML
    private Button findInersectionPoint_button;

    @FXML
    private Button findProjection_button;

    @FXML
    private TextField lLine1_text;

    @FXML
    private TextField lLine2_text;

    @FXML
    private TextField lVectorS_text;

    @FXML
    private TextField mLine1_text;

    @FXML
    private TextField mLine2_text;

    @FXML
    private TextField mVectorS_text;

    @FXML
    private Button makeEqByPointVector_button;

    @FXML
    private Button makeEqByTwoPoints_button;

    @FXML
    private Button makePerpendicularEq_button;

    @FXML
    private TextField pLine1_text;

    @FXML
    private TextField pLine2_text;

    @FXML
    private TextField pVectorS_text;

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
    private Label vector_label;

    @FXML
    private TextField x0Line1text;

    @FXML
    private TextField x0Line2text;

    @FXML
    private TextField xA_text;

    @FXML
    private TextField xB_text;

    @FXML
    private TextField y0Line1text;

    @FXML
    private TextField y0Line2text;

    @FXML
    private TextField yA_text;

    @FXML
    private TextField yB_text;

    @FXML
    private TextField z0Line1text;

    @FXML
    private TextField z0Line2text;

    @FXML
    private TextField zA_text;

    @FXML
    private TextField zB_text;
    private int whatDoing=1;//1 - рівняння через дві точки, 2 - рівняння через точку і напрямний вектор, 3 - проекція точки на пряму,
    //4  - точка перетину.5- точка перетину, відстань між точкою і прямою, 6 - перпендикулярна пряма
    String startStyleForButton = "-fx-background-color: #ffffff; -fx-border-color:  #FB6B90; -fx-border-radius: 5 ";
    String activeStyleForButton ="-fx-background-color: #ffffff; -fx-border-color: #000000; -fx-border-radius: 5 ";
    @FXML
    void initialize() {
        allTextFieldOnlyNumber();//введення коректних значень
        backUp();//приховати все
        //для початку активна перша дія
        visiblePointA(true);
        visiblePointB(true);
        makeEqByTwoPoints_button.setStyle(activeStyleForButton);
       makeEqByTwoPoints_button.setOnAction(event -> {
           backUp();
           makeEqByTwoPoints_button.setStyle(activeStyleForButton);
           whatDoing=1;
           visiblePointA(true);
           visiblePointB(true);
       });
       makeEqByPointVector_button.setOnAction(event -> {
           backUp();
           whatDoing=2;
           makeEqByPointVector_button.setStyle(activeStyleForButton);
           visiblePointA(true);
           visibleVectorS(true);
       });
       findProjection_button.setOnAction(event -> {
           backUp();
           whatDoing=3;
           findProjection_button.setStyle(activeStyleForButton);
           visiblePointA(true);
           visibleLine1(true);
       });
       findInersectionPoint_button.setOnAction(event -> {
           backUp();
           whatDoing=4;
           findInersectionPoint_button.setStyle(activeStyleForButton);
           visibleLine2(true);
           visibleLine1(true);
       });
       findDistanseBetweenPointAndLine_button.setOnAction(event -> {
           backUp();
           whatDoing=5;
           findDistanseBetweenPointAndLine_button.setStyle(activeStyleForButton);
           visiblePointA(true);
           visibleLine1(true);
       });
       makePerpendicularEq_button.setOnAction(event -> {
           backUp();
           whatDoing=6;
           makePerpendicularEq_button.setStyle(activeStyleForButton);
           visiblePointA(true);
           visibleLine1(true);
       });
        solve_button.setOnAction(event ->
        {       solution_label.setText("   ");

            if(whatDoing==1) {
                LinesAndPlane twoPoints = new LinesAndPlane(makeNumber(coordinatesPointA()),makeNumber(coordinatesPointB()));
                solution_label.setText(twoPoints.makeEquationLineInSpaceByTwoPoints());
            }
            if(whatDoing==2) {
                LinesAndPlane pointAndVector = new LinesAndPlane(makeNumber(coordinatesPointA()),makeNumber(coordinatesVectorS()));
                solution_label.setText(pointAndVector.makeEquationLineInSpaceByPointAndVector());
            }
            if(whatDoing==3){
                LinesAndPlane pointAndVectorLine = new LinesAndPlane(makeNumber(coordinatesPointA()),makeNumber(coordinatesVectorForLine1()));
                solution_label.setText(pointAndVectorLine.findProjectionPointOnLine(makeNumber(coordinatesPointsForLine1())));
            }
            if(whatDoing==4){
                LinesAndPlane line1 = new LinesAndPlane(makeNumber(coordinatesPointsForLine1()),makeNumber(coordinatesVectorForLine1()));
                LinesAndPlane line2 = new LinesAndPlane(makeNumber(coordinatesPointsForLine2()),makeNumber(coordinatesVectorForLine2()));
                solution_label.setText(line1.findIntersectionPointBetweenTwoLinesInSpace(line2));
            }
            if(whatDoing==5) {
                LinesAndPlane pointAndVectorLine = new LinesAndPlane(makeNumber(coordinatesPointA()),makeNumber(coordinatesVectorForLine1()));
                solution_label.setText(pointAndVectorLine.findDistanceBetweenPointAndLineInSpace(makeNumber(coordinatesPointsForLine1())));
            }
            if(whatDoing==6) {
                LinesAndPlane pointAndVectorLine = new LinesAndPlane(makeNumber(coordinatesPointA()),makeNumber(coordinatesVectorForLine1()));
                solution_label.setText(pointAndVectorLine.makeEquationPerpendicularLineToLineInSpace(makeNumber(coordinatesPointsForLine1())));
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




    void backUp()//все приховати і кнопки початкового стилю
    {
        visibleLine1(false);
        visibleLine2(false);
        visiblePointA(false);
        visiblePointB(false);
        visibleVectorS(false);

        makeEqByPointVector_button.setStyle(startStyleForButton);
        makeEqByTwoPoints_button.setStyle(startStyleForButton);
        makePerpendicularEq_button.setStyle(startStyleForButton);
        findDistanseBetweenPointAndLine_button.setStyle(startStyleForButton);
        findInersectionPoint_button.setStyle(startStyleForButton);
        findProjection_button.setStyle(startStyleForButton);

    }

    void allTextFieldOnlyNumber() {
        onlyNumber(coordinatesPointA());
        onlyNumber(coordinatesPointB());
        onlyNumber(coordinatesVectorS());
        onlyNumber(coordinatesPointsForLine1());
        onlyNumber(coordinatesPointsForLine2());
        onlyNumber(coordinatesVectorForLine1());
        onlyNumber(coordinatesVectorForLine2());
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

    void visibleTextFields(TextField[] text,boolean b) {
        for(int i=0;i<3;i++)
            text[i].setVisible(b);
    }

    void visibleLine1(boolean b) {
        visibleTextFields(coordinatesVectorForLine1(),b);
        visibleTextFields(coordinatesPointsForLine1(),b);
        eq1Line_label.setVisible(b);
        eqLine1Img.setVisible(b);
    }
    void visibleLine2(boolean b) {
        visibleTextFields(coordinatesVectorForLine2(),b);
        visibleTextFields(coordinatesPointsForLine2(),b);
        eq2Line_label.setVisible(b);
        eqLine2Img.setVisible(b);
    }
    void visibleVectorS(boolean b) {
        vector_label.setVisible(b);
        visibleTextFields(coordinatesVectorS(),b);
    }
    void visiblePointA(boolean b) {
        visibleTextFields(coordinatesPointA(),b);
        pointA_label.setVisible(b);
    }
    void visiblePointB(boolean b){
        visibleTextFields(coordinatesPointB(),b);
        pointB_label.setVisible(b);
    }

    TextField[] coordinatesPointA() {
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
        TextField[] VectorS = {lVectorS_text,mVectorS_text,pVectorS_text};
        return VectorS;
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

package sample.Determinant;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
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

public class DeterminantPractice {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField a11_text;

    @FXML
    private TextField a12_text;

    @FXML
    private TextField a13_text;

    @FXML
    private TextField a14_text;

    @FXML
    private TextField a15_text;

    @FXML
    private TextField a21_text;

    @FXML
    private TextField a22_text;

    @FXML
    private TextField a23_text;

    @FXML
    private TextField a24_text;

    @FXML
    private TextField a25_text;

    @FXML
    private TextField a31_text;

    @FXML
    private TextField a32_text;

    @FXML
    private TextField a33_text;

    @FXML
    private TextField a34_text;

    @FXML
    private TextField a35_text;

    @FXML
    private TextField a41_text;

    @FXML
    private TextField a42_text;

    @FXML
    private TextField a43_text;

    @FXML
    private TextField a44_text;

    @FXML
    private TextField a45_text;

    @FXML
    private TextField a51_text;

    @FXML
    private TextField a52_text;

    @FXML
    private TextField a53_text;

    @FXML
    private TextField a54_text;

    @FXML
    private TextField a55_text;

    @FXML
    private Button answer_button;

    @FXML
    private Button answer_button1;

    @FXML
    private Label answer_label;

    @FXML
    private Button back_button;

    @FXML
    private Button size2_button;

    @FXML
    private Button size3_button;

    @FXML
    private Button size4_button;

    @FXML
    private Button size5_button;
    @FXML
    private Label solution_label;

    @FXML
    private Button toMenu_button;

    @FXML
    void initialize() {
        onlyNumber(matrixA());


            SizeButtonIsActive(size2_button);//на початку відображаємо визначник 2 на 2
        MatrixForSize2();

        size2_button.setOnAction(event -> {
            SizeButtonIsActive(size2_button);
            MatrixForSize2();
        });
        size3_button.setOnAction(event -> {
            SizeButtonIsActive(size3_button);
            MatrixForSize3();
        });
        size4_button.setOnAction(event -> {
           SizeButtonIsActive(size4_button);
           MatrixForSize4();
        });
        size5_button.setOnAction(event -> {
            SizeButtonIsActive(size5_button);
            MatrixForSize5();
        });
        answer_button.setOnAction(event -> {
            if(a55_text.isVisible())
            {

            }
            else {
                if (a44_text.isVisible()) {
                    Matrix matrix = new Matrix(Matrix4size());
                    solution_label.setText(matrix.solveDeterminant4size());
                } else {
                    if (a33_text.isVisible()) {
                        Matrix matrix = new Matrix(Matrix3Size());
                        solution_label.setText(matrix.solveDeterminant3size());
                    } else {
                        Matrix matrix = new Matrix(Matrix2Size());
                        solution_label.setText("             "+matrix.solveDeterminant2size());
                    }
                }
            }
        });



        back_button.setOnAction(event -> {
            back_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/DeterminantMenu.fxml");

        });
        toMenu_button.setOnAction(event -> {
            toMenu_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/Menu.fxml");

        });






    }
    void onlyNumber(TextField[][] matrix)
    {
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                int a=i;
                int b=j;
                matrix[i][j].textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue,
                                        String newValue) {
                        if (!newValue.matches("-?\\d*|-?\\d*\\.\\d*")) {
                            newValue = newValue.replaceFirst("\\.", "₊");
                            newValue = newValue.replaceFirst("-", "³");
                            newValue = newValue.replaceAll("[^\\d₊³]", "");
                            newValue = newValue.replaceFirst("₊", "\\.");
                            newValue = newValue.replaceFirst("³", "-");

                            matrix[a][b].setText(newValue);
                        }
                    }
                });
            }
        }

    }
    TextField[][] matrixA() {
        TextField[][] matrixA ={{a11_text, a12_text,a13_text,a14_text,a15_text},
                {a21_text, a22_text,a23_text,a24_text,a25_text},
                {a31_text, a32_text,a33_text,a34_text,a35_text},
                {a41_text, a42_text,a43_text,a44_text,a45_text},
                {a51_text,a52_text,a53_text,a54_text,a55_text}};
        return matrixA;
    }
    double [][] Matrix4size()
    {
        String a11=a11_text.getText();
        String a12=a12_text.getText();
        String a13=a13_text.getText();
        String a14=a14_text.getText();
        String a21=a21_text.getText();
        String a22=a22_text.getText();
        String a23=a23_text.getText();
        String a24=a24_text.getText();
        String a31=a31_text.getText();
        String a32=a32_text.getText();
        String a33=a33_text.getText();
        String a34=a34_text.getText();
        String a41=a41_text.getText();
        String a42=a42_text.getText();
        String a43=a43_text.getText();
        String a44=a44_text.getText();

        if(a11=="")
            a11="0";
        if(a12=="")
            a12="0";
        if(a13=="")
            a13="0";
        if(a14=="")
            a14="0";
        if(a21=="")
            a21="0";
        if(a22=="")
            a22="0";
        if(a23=="")
            a23="0";
        if(a24=="")
            a24="0";
        if(a31=="")
            a31="0";
        if(a32=="")
            a32="0";
        if(a33=="")
            a33="0";
        if(a34=="")
            a34="0";
        if(a41=="")
            a41="0";
        if(a42=="")
            a42="0";
        if(a43=="")
            a43="0";
        if(a44=="")
            a44="0";
        double a[][]={{Double.valueOf(a11),Double.valueOf(a12), Double.valueOf(a13),Double.valueOf(a14)},
                {Double.valueOf(a21),Double.valueOf(a22),Double.valueOf(a23),Double.valueOf(a24)},
                {Double.valueOf(a31),Double.valueOf(a32),Double.valueOf(a33),Double.valueOf(a34)},
                {Double.valueOf(a41),Double.valueOf(a42),Double.valueOf(a43),Double.valueOf(a44)}};
        return a;
    }
    double[][] Matrix3Size(){
        String a11=a11_text.getText();
        String a12=a12_text.getText();
        String a22=a22_text.getText();
        String a21=a21_text.getText();
        String a13=a13_text.getText();
        String a23=a23_text.getText();
        String a33=a33_text.getText();
        String a31=a31_text.getText();
        String a32=a32_text.getText();
        if(a11=="")
            a11="0";
        if(a12=="")
            a12="0";
        if(a13=="")
            a13="0";
        if(a21=="")
            a21="0";
        if(a22=="")
            a22="0";
        if(a23=="")
            a23="0";
        if(a31=="")
            a31="0";
        if(a32=="")
            a32="0";
        if(a33=="")
            a33="0";
        double a[][]={{Double.valueOf(a11),Double.valueOf(a12), Double.valueOf(a13)},
                        {Double.valueOf(a21),Double.valueOf(a22),Double.valueOf(a23)},
                         {Double.valueOf(a31),Double.valueOf(a32),Double.valueOf(a33)}};
        return a;
    }

    double[][] Matrix2Size()
    {

            String a11=a11_text.getText();
            String a12=a12_text.getText();
            String a22=a22_text.getText();
            String a21=a21_text.getText();
            if(a11=="")
                a11="0";
            if(a12=="")
                a12="0";
            if(a21=="")
                a21="0";
            if(a22=="")
                a22="0";

            double a[][]={{Double.valueOf(a11),Double.valueOf(a12)},{Double.valueOf(a21),Double.valueOf(a22)}};
        return a;
    }


    void SizeButtonIsActive (Button button)
    {
        String newStyleButton ="-fx-background-color: #ffffff; -fx-border-color: #000000; -fx-border-radius: 5 ";
        allButtonToStartStyle();
        button.setStyle(newStyleButton);

    }

    void allButtonToStartStyle()
    {
        String startStyle = "-fx-background-color: #ffffff; -fx-border-color:  #FB6B90; -fx-border-radius: 5 ";
        size2_button.setStyle(startStyle);
        size3_button.setStyle(startStyle);
        size4_button.setStyle(startStyle);
        size5_button.setStyle(startStyle);
    }
    void MatrixForSize5()//всі активні
    {
        a13_text.setVisible(true);
        a14_text.setVisible(true);
        a15_text.setVisible(true);
        a23_text.setVisible(true);
        a24_text.setVisible(true);
        a25_text.setVisible(true);
        a31_text.setVisible(true);
        a32_text.setVisible(true);
        a33_text.setVisible(true);
        a34_text.setVisible(true);
        a35_text.setVisible(true);
        a41_text.setVisible(true);
        a42_text.setVisible(true);
        a43_text.setVisible(true);
        a44_text.setVisible(true);
        a45_text.setVisible(true);
        a51_text.setVisible(true);
        a52_text.setVisible(true);
        a53_text.setVisible(true);
        a54_text.setVisible(true);
        a55_text.setVisible(true);
    }
    void MatrixForSize4()//ховаємо всі текстові поля окрім 3 на 3
    {
        a13_text.setVisible(true);
        a14_text.setVisible(true);
        a15_text.setVisible(false);
        a23_text.setVisible(true);
        a24_text.setVisible(true);
        a25_text.setVisible(false);
        a31_text.setVisible(true);
        a32_text.setVisible(true);
        a33_text.setVisible(true);
        a34_text.setVisible(true);
        a35_text.setVisible(false);
        a41_text.setVisible(true);
        a42_text.setVisible(true);
        a43_text.setVisible(true);
        a44_text.setVisible(true);
        a45_text.setVisible(false);
        a51_text.setVisible(false);
        a52_text.setVisible(false);
        a53_text.setVisible(false);
        a54_text.setVisible(false);
        a55_text.setVisible(false);
    }



    void MatrixForSize3()//ховаємо всі текстові поля окрім 3 на 3
    {
        a13_text.setVisible(true);
        a14_text.setVisible(false);
        a15_text.setVisible(false);
        a23_text.setVisible(true);
        a24_text.setVisible(false);
        a25_text.setVisible(false);
        a31_text.setVisible(true);
        a32_text.setVisible(true);
        a33_text.setVisible(true);
        a34_text.setVisible(false);
        a35_text.setVisible(false);
        a41_text.setVisible(false);
        a42_text.setVisible(false);
        a43_text.setVisible(false);
        a44_text.setVisible(false);
        a45_text.setVisible(false);
        a51_text.setVisible(false);
        a52_text.setVisible(false);
        a53_text.setVisible(false);
        a54_text.setVisible(false);
        a55_text.setVisible(false);
    }

    void  MatrixForSize2()//ховаємо всі текстові поля окрім 2 на 2
    {
        a13_text.setVisible(false);
        a14_text.setVisible(false);
        a15_text.setVisible(false);
        a23_text.setVisible(false);
        a24_text.setVisible(false);
        a25_text.setVisible(false);
        a31_text.setVisible(false);
        a32_text.setVisible(false);
        a33_text.setVisible(false);
        a34_text.setVisible(false);
        a35_text.setVisible(false);
        a41_text.setVisible(false);
        a42_text.setVisible(false);
        a43_text.setVisible(false);
        a44_text.setVisible(false);
        a45_text.setVisible(false);
        a51_text.setVisible(false);
        a52_text.setVisible(false);
        a53_text.setVisible(false);
        a54_text.setVisible(false);
        a55_text.setVisible(false);
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

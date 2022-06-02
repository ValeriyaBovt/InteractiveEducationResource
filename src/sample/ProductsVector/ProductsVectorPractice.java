package sample.ProductsVector;

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
import sample.add.Matrix;

public class ProductsVectorPractice {

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
    private Label ear_с_lbl;

    @FXML
    private Button mixedProduct_button;

    @FXML
    private Button scalarProduct_button;

    @FXML
    private Label solution_label;

    @FXML
    private Button solve_button;

    @FXML
    private Button toMenu_button;

    @FXML
    private Button vectorProduct_button;

    @FXML
    private Label vectora_label;

    @FXML
    private Label vectorb_label;

    @FXML
    private Label vectorс_label;

    @FXML
    private TextField xa_text;

    @FXML
    private TextField xb_text;

    @FXML
    private TextField xс_text;

    @FXML
    private TextField ya_text;

    @FXML
    private TextField yb_text;

    @FXML
    private Button angleBetweenVectors_button;

    @FXML
    private TextField yс_text;

    @FXML
    private TextField za_text;

    @FXML
    private TextField zb_text;

    @FXML
    private TextField zс_text;
    private int whatDoing =1;//1 - scalar product, 2 - vector product, 3 - mixed product, 4 - angel between vectors

    @FXML
    void initialize() {
        TextField[] coordinatesVector_a=coordinatesVector_a();
        TextField[] coordinatesVector_b=coordinatesVector_b();
        TextField[] coordinatesVector_c=coordinatesVector_c();
        activeScalarProduct_button();//start position
        onlyNumberInCoordinates(coordinatesVector_a);
        onlyNumberInCoordinates(coordinatesVector_b);
        onlyNumberInCoordinates(coordinatesVector_c);
        scalarProduct_button.setOnAction(event -> {
            activeScalarProduct_button();
        });
        vectorProduct_button.setOnAction(event -> {
           activeVectorProduct_button();
        });
        mixedProduct_button.setOnAction(event -> {
            activeMixedProduct_button();
        });
        angleBetweenVectors_button.setOnAction(event -> {
            activeAngleBetweenVectors_button();
        });

        solve_button.setOnAction(event ->{
            String result = "";
            CustomVector a = new CustomVector(makeCoordinates(coordinatesVector_a));
            CustomVector b = new CustomVector((makeCoordinates(coordinatesVector_b)));
            if(whatDoing==1)
            {
                result="a⃑∙b⃑ = xa∙xb + ya∙yb + za∙zb =\n"+"= "+a.scalarProduct(b);
                solution_label.setText(result);
            }
            if(whatDoing==2)
            {
                result=a.vectorProduct(b);
                solution_label.setText(result);
            }
            if(whatDoing==3)
            {
                CustomVector c = new CustomVector((makeCoordinates(coordinatesVector_c)));
                String step1=a.mixedProduct(b,c)+" ⇒ ";
                Matrix mixedProductMatrix = new Matrix(a.mixedMatrixProduct(b,c));
                String step2 = "a⃑∙(b⃑×c⃑) = "+mixedProductMatrix.solveDeterminant3size();
                result=step1+step2;
                solution_label.setText(result);
            }
            if(whatDoing==4)
            {
                result="cos(∠a⃑,b⃑) = (a⃑b⃑)/(|a⃑||b⃑|);\n";
                String scalar="a⃑∙b⃑ = xa∙xb + ya∙yb + za∙zb = "+"= "+a.scalarProduct(b)+"\n";
                String modulA="|a⃑| = √(xₐ²+yₐ²+zₐ²) = "+a.lengthOfVector();
                String modulB="   |b⃑| = √(xᵇ²+yᵇ²+zᵇ²) = "+b.lengthOfVector()+"\n";
                String cos= "cos(∠a⃑,b⃑) = "+a.scalarProductDouble(b)+"/("+a.lengthOfVector()+"∙"+b.lengthOfVector()+") = "+
                        (a.scalarProductDouble(b)/(a.lengthOfVector()*b.lengthOfVector()))+"\n";
                String finish = "∠a⃑,b⃑ = " +Math.acos((a.scalarProductDouble(b)/(a.lengthOfVector()*b.lengthOfVector())));
                solution_label.setText(result+scalar+modulA+modulB+cos+finish);

            }

        });

        back_button.setOnAction(event -> {
            back_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/productsVectorsMenu.fxml");
        });
        toMenu_button.setOnAction(event -> {
            toMenu_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/Menu.fxml");

        });
    }
    void activeScalarProduct_button() {
        solution_label.setText("");
        visibleVectorC(false);
        activeStyle(scalarProduct_button);
        toStartStyle(vectorProduct_button);
        toStartStyle(mixedProduct_button);
        toStartStyle(angleBetweenVectors_button);
        whatDoing=1;
    }

    void activeVectorProduct_button() {
        solution_label.setText("");
        visibleVectorC(false);
        activeStyle(vectorProduct_button);
        toStartStyle(scalarProduct_button);
        toStartStyle(mixedProduct_button);
        toStartStyle(angleBetweenVectors_button);
        whatDoing=2;
    }
    void activeMixedProduct_button() {
        solution_label.setText("");
        visibleVectorC(true);
        activeStyle(mixedProduct_button);
        toStartStyle(vectorProduct_button);
        toStartStyle(scalarProduct_button);
        toStartStyle(angleBetweenVectors_button);
        whatDoing=3;
    }
    void  activeAngleBetweenVectors_button() {
        solution_label.setText("");
        visibleVectorC(false);
        activeStyle(angleBetweenVectors_button);
        toStartStyle(vectorProduct_button);
        toStartStyle(scalarProduct_button);
        toStartStyle(mixedProduct_button);
        whatDoing=4;
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
    void visibleVectorC(boolean b)
    {
        visibleTextFields(coordinatesVector_c(),b);
        vectorс_label.setVisible(b);
        ear_с_lbl.setVisible(b);
    }
    TextField[] coordinatesVector_b()
    {
        TextField[] B={xb_text,yb_text,zb_text};
        return B;
    }
    TextField[] coordinatesVector_a()
    {
        TextField[] A={xa_text,ya_text,za_text};
        return A;
    }
    TextField[] coordinatesVector_c()
    {
        TextField[] C={xс_text,yс_text,zс_text};
        return C;
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
    void onlyNumberInCoordinates(TextField[] coordinates) {
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

package sample.Matrix;

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

public class MatrixPractice {

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
    private Button addMatrix_button;

    @FXML
    private Button answer_button;

    @FXML
    private TextField b11_text;

    @FXML
    private TextField b12_text;

    @FXML
    private TextField b13_text;

    @FXML
    private TextField b14_text;

    @FXML
    private TextField b15_text;

    @FXML
    private TextField b21_text;

    @FXML
    private TextField b22_text;

    @FXML
    private TextField b23_text;

    @FXML
    private TextField b24_text;

    @FXML
    private TextField b25_text;

    @FXML
    private TextField b31_text;

    @FXML
    private TextField b32_text;

    @FXML
    private TextField b33_text;

    @FXML
    private TextField b34_text;

    @FXML
    private TextField b35_text;

    @FXML
    private TextField b41_text;

    @FXML
    private TextField b42_text;

    @FXML
    private TextField b43_text;

    @FXML
    private TextField b44_text;

    @FXML
    private TextField b45_text;

    @FXML
    private TextField b51_text;

    @FXML
    private TextField b52_text;

    @FXML
    private TextField b53_text;

    @FXML
    private TextField b54_text;

    @FXML
    private TextField b55_text;

    @FXML
    private Button back_button;

    @FXML
    private Button inverseMatrix_button;

    @FXML
    private Button mSize2_but;

    @FXML
    private Button mSize3_but;

    @FXML
    private Button mSize4_but;

    @FXML
    private Button mSize5_but;

    @FXML
    private Label matrixB_label;

    @FXML
    private Button multiplyByNumber_button;

    @FXML
    private Label multiply_label;

    @FXML
    private Button nSize2_but;

    @FXML
    private Button nSize3_but;

    @FXML
    private Button nSize4_but;

    @FXML
    private Button nSize5_but;

    @FXML
    private TextField number_text;

    @FXML
    private Label plus_label;

    @FXML
    private Button size2Square_button;

    @FXML
    private Button size3Square_button;

    @FXML
    private Button size4Square_button;

    @FXML
    private Button size5Square_button;

    @FXML
    private Label sizeForAdd_label;

    @FXML
    private Label solution_label;
    @FXML
    private Label solutionMult_label;
    @FXML
    private Label solutionInverse_label;
    @FXML
    private Label next_label;
    @FXML
    private Label resultInverse_label;
    @FXML
    private Label InverseSolve_label;

    @FXML
    private Button toMenu_button;
    private int whatDoing=1;//1 - множення матриці на число, 2 - додавання матриць, 3 - обернена матриця
    public int n=2;
    public int m=2;

    @FXML
    void initialize() {
       hideOrViewMatrix(matrixB(),false);
       hideOrViewMatrix(matrixA(),false);
       ActiveMultiplyByNumber_button();//для початку
        activeStyle(nSize2_but);
        activeStyle(mSize2_but);
        for(int c1 =0;c1<m;c1++)
        {
            for(int c2=0;c2<n;c2++)
            {
                TextField [][]matrA=matrixA();
                matrA[c1][c2].setVisible(true);}
        }
        onlyNumber(matrixA());
        onlyNumber(matrixB());
        lambdaNumber();
        sizeButtonSelected(sizeSquareButtons(), true,true);
        sizeButtonSelected(mSizeButtons(), false, false);
        sizeButtonSelected(nSizeButtons(), true, false);
        multiplyByNumber_button.setOnAction(event -> {
            ActiveMultiplyByNumber_button();
        });
        addMatrix_button.setOnAction(event -> {
            ActiveAddMatrix_button();
        });
        inverseMatrix_button.setOnAction(event -> {
            ActiveInverseMatrix_button();
        });

        answer_button.setOnAction(event ->{
            clearSolution();
            Matrix matrix = new Matrix(makeMatrix(matrixA()));
            if(whatDoing==1)//multiply by number
            {
                String lambda_str = number_text.getText();
                if (lambda_str=="") lambda_str="0";
                double lambda = Double.valueOf(lambda_str);
                solutionMult_label.setText("λA = "+ matrix.multiplicationByNumber(n,m,lambda));
            }
            else {
                if (whatDoing == 2) {

                    double[][] matrixB = makeMatrix(matrixB());
                    solution_label.setText(matrix.addMatrix(n,m,matrixB));
                }
                else {//whatDoing==3
                    if(n==2){
                        double determinant = matrix.Determinant2Size();
                        if(determinant==0){
                            solution_label.setText("Δ = 0 ⇒ оберненої матриці не існує");
                        }
                        else {
                            String step1 = matrix.solveDeterminant2size()+" ⇒\n";
                            String step2 = "A⁻¹ = 1/Δ"+"×A = \n";
                            String step3 = matrix.multiplicationByNumber(n,m,1/determinant);
                            solution_label.setText(step1+step2+step3);
                        }
                    }
                    else { if(n==3){
                        double determinant = matrix.Determinant3size();
                        if(determinant==0){
                            solution_label.setText("Δ = 0 ⇒ оберненої матриці не існує");
                        }
                        else {
                            String step1 = matrix.solveDeterminant3size()+" ⇒\n";
                            String step2=matrix.solveInverseMatrix3();
                            String step3=matrix.printInverseMatrixSolve(matrix.buildInverseMatrix3(),n);
                            Matrix matrInverse = new Matrix(matrix.buildInverseMatrix3());
                            String step4=matrInverse.multiplicationByNumber(3,3,1/determinant);
                            solutionMult_label.setText(step1);
                            solutionInverse_label.setText(step2);
                            InverseSolve_label.setText(step3);
                            resultInverse_label.setText(step4);
                            next_label.setVisible(true);
                        }


                    }
                    }
                }}});





        back_button.setOnAction(event -> {
            back_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/matrixMenu.fxml");

        });
        toMenu_button.setOnAction(event -> {
            toMenu_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/Menu.fxml");

        });

    }
    void clearSolution()
    {
        solution_label.setText("");
        solutionInverse_label.setText("");
        solutionMult_label.setText("");
        next_label.setVisible(false);
        InverseSolve_label.setText("");
        resultInverse_label.setText("");
    }

    void sizeButtonSelected(Button[] buttons, boolean is_n, boolean is_square) {
        for(int i=0;i<4;i++) {
            int a=i;
            Button[] sizeButton = buttons;

            sizeButton[i].setOnAction(event -> {

                for(int j=0;j<4;j++){
                    if(is_square) m=0;
                    hideOrViewMatrix(matrixB(),false);
                    toStartStyle(sizeButton[j]);
                }
                activeStyle(sizeButton[a]);
                if (is_n) {
                    n = a+2;
                } else {
                    m = a + 2;
                }
                TextField [][] matrA = matrixA();
                hideOrViewMatrix(matrixA(), false);
                if(m==0) m=n;
                for(int c1 =0;c1<m;c1++)
                {
                    for(int c2=0;c2<n;c2++)
                    {
                        matrA[c1][c2].setVisible(true);
                        if(whatDoing==2) {
                            TextField[][] matrB = matrixB();
                            matrB[c1][c2].setVisible(true);
                        }
                    }
                }
            });
        }
    }


    double[][] makeMatrix(TextField[][] matrixTextField)
    {
        String [][] matrixStr = new String[m][n];
        double [][] matrix = new double[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrixStr[i][j]=matrixTextField[i][j].getText();
                if(matrixStr[i][j].equals(""))
                    matrixStr[i][j]="0";
                matrix[i][j]=Double.parseDouble(matrixStr[i][j]);
            }
        }
        return matrix;
    }



    TextField[][] matrixB()
    {
        TextField[][] matrixB ={{b11_text, b12_text,b13_text,b14_text,b15_text},
                {b21_text, b22_text,b23_text,b24_text,b25_text},
                {b31_text, b32_text,b33_text,b34_text,b35_text},
                {b41_text, b42_text,b43_text,b44_text,b45_text},
                {b51_text,b52_text,b53_text,b54_text,b55_text}};
        return matrixB;
    }
    TextField[][] matrixA() {
        TextField[][] matrixA ={{a11_text, a12_text,a13_text,a14_text,a15_text},
                {a21_text, a22_text,a23_text,a24_text,a25_text},
                {a31_text, a32_text,a33_text,a34_text,a35_text},
                {a41_text, a42_text,a43_text,a44_text,a45_text},
                {a51_text,a52_text,a53_text,a54_text,a55_text}};
        return matrixA;
    }
    void hideOrViewMatrix(TextField[][] matrix,boolean b)
    {
        for(int i=0;i<=4;i++)
        {
            for(int j=0;j<=4;j++)
            {
                matrix[i][j].setVisible(b);
            }
        }
    }
    void ActiveMultiplyByNumber_button()
    {   activeStyle(multiplyByNumber_button);
        toStartStyle(addMatrix_button);
        toStartStyle(inverseMatrix_button);
        number_text.setVisible(true);
        matrixB_label.setVisible(false);
        hideOrViewMatrix(matrixB(),false);
        plus_label.setVisible(false);
        multiply_label.setVisible(true);
        visibleSizeButton(sizeSquareButtons(),false);
        visibleSizeButton(mSizeButtons(),true);
        visibleSizeButton(nSizeButtons(),true);
        sizeForAdd_label.setVisible(true);
        clearSolution();

        whatDoing=1;
    }
    void ActiveAddMatrix_button()
    {
        activeStyle(addMatrix_button);
        toStartStyle(multiplyByNumber_button);
        toStartStyle(inverseMatrix_button);
        matrixB_label.setVisible(true);
        plus_label.setVisible(true);
        multiply_label.setVisible(false);
        hideOrViewMatrix(matrixB(),false);
        number_text.setVisible(false);
        whatDoing=2;
        sizeForAdd_label.setVisible(true);
        visibleSizeButton(sizeSquareButtons(),false);
        visibleSizeButton(mSizeButtons(),true);
        visibleSizeButton(nSizeButtons(),true);
        clearSolution();
        for(int c1 =0;c1<m;c1++)
        {
            for(int c2=0;c2<n;c2++)
            {
                TextField [][]matrB=matrixB();
                matrB[c1][c2].setVisible(true);}
        }
    }
    void ActiveInverseMatrix_button()
    {
        activeStyle(inverseMatrix_button);
        toStartStyle(addMatrix_button);
        toStartStyle(multiplyByNumber_button);
        matrixB_label.setVisible(false);
        number_text.setVisible(false);
        plus_label.setVisible(false);
        multiply_label.setVisible(false);
        hideOrViewMatrix(matrixB(),false);
        visibleSizeButton(sizeSquareButtons(),true);
        visibleSizeButton(mSizeButtons(),false);
        visibleSizeButton(nSizeButtons(),false);
        sizeForAdd_label.setVisible(false);
        activeStyle(size2Square_button);
        clearSolution();

        for(int c1 =0;c1<m;c1++)
        {
            for(int c2=0;c2<n;c2++)
            {
                TextField [][]matrA=matrixA();
                matrA[c1][c2].setVisible(true);}
        }
        whatDoing=3;
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
    void visibleSizeButton(Button[] button,boolean b)
    {
        for (int i=0;i<4;i++)
            button[i].setVisible(b);
    }
    Button[] sizeSquareButtons() {
        Button[] buttons={size2Square_button,size3Square_button,size4Square_button,size5Square_button};
        return buttons;
    }
    Button[] mSizeButtons() {
        Button[] buttons={mSize2_but,mSize3_but,mSize4_but,mSize5_but};
        return buttons;
    }
    Button[] nSizeButtons() {
        Button[] buttons={nSize2_but,nSize3_but,nSize4_but,nSize5_but};
        return buttons;
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
    void lambdaNumber(){
        number_text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("-?\\d*|-?\\d*\\.\\d*")) {
                    newValue = newValue.replaceFirst("\\.", "₊");
                    newValue = newValue.replaceFirst("-", "³");
                    newValue = newValue.replaceAll("[^\\d₊³]", "");
                    newValue = newValue.replaceFirst("₊", "\\.");
                    newValue = newValue.replaceFirst("³", "-");

                    number_text.setText(newValue);
                }
            }
        });
    }
    void onlyNumber(TextField[][] matrix) {
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


}

package sample.Menu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Menu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button curves_button;//криві другого порядку (3)

    @FXML
    private Button definition_button;//основні означення (2)

    @FXML
    private Button determinant_button;//визначники (1)

    @FXML
    private Button line_in_space_button;//прямі у просторі (3)

    @FXML
    private Button line_on_plane_button;//прямі на площині (3)

    @FXML
    private Button linear_button;//системи лінійних рівнянь (1)

    @FXML
    private Button main_menu;

    @FXML
    private Button main_menu1;//1 - елементи лінійної алгебри

    @FXML
    private Button main_menu2;//2 - вектори

    @FXML
    private Button main_menu3;//3 - аналітична геометрія

    @FXML
    private Button matrix_button;//матриці (1)

    @FXML
    private Button operations_button;//операції над векторами (2)

    @FXML
    private Button plane_in_space_button;//площини у просторі (3)

    @FXML
    private Button lineAndPlane_button;//полярні координати (3)

    @FXML
    private Button product_button;//добутки векторів (2)


    @FXML
    void initialize() {
        allHide();

        //Елементи лінійної алгебри
        determinant_button.setOnAction(event -> {
            determinant_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/determinantMenu.fxml");
        });
        matrix_button.setOnAction(event -> {
            matrix_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/matrixMenu.fxml");
        });
        linear_button.setOnAction(event -> {
            linear_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/systemsLinEqMenu.fxml");
        });

        //Векторна алгебра
        definition_button.setOnAction(event -> {
            definition_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/basicDefinitionMenu.fxml");
        });
        operations_button.setOnAction(event -> {
            operations_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/operationVectorMenu.fxml");
        });
        product_button.setOnAction(event -> {
            product_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/productsVectorsMenu.fxml");
        });
        //Аналітична геометрія
        line_on_plane_button.setOnAction(event -> {
            line_on_plane_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/lineOnPlaneMenu.fxml");
        });
        plane_in_space_button.setOnAction(event -> {
            plane_in_space_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/planeInSpaceMenu.fxml");
        });
        line_in_space_button.setOnAction(event -> {
            line_in_space_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/lineInSpaceMenu.fxml");
        });
        curves_button.setOnAction(event -> {
            curves_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/CurvesSecondOrderMenu.fxml");
        });
        lineAndPlane_button.setOnAction(event -> {
            lineAndPlane_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/lineAndPlaneMenu.fxml");
        });

        String style = "-fx-background-color: #000000; -fx-border-color: #FB6B90; -fx-border-radius: 8; -fx-background-radius: 8 ";
        main_menu1.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                reverseColor();
                allHide();
                main_menu1.setStyle(style);
                determinant_button.setVisible(true);
                matrix_button.setVisible(true);
                linear_button.setVisible(true);
            }
        });
        main_menu2.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                allHide();
                reverseColor();
                main_menu2.setStyle(style);
                definition_button.setVisible(true);
                operations_button.setVisible(true);
                product_button.setVisible(true);
            }
        });
        main_menu3.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                allHide();
                reverseColor();
                main_menu3.setStyle(style);
                lineAndPlane_button.setVisible(true);
                curves_button.setVisible(true);
                plane_in_space_button.setVisible(true);
                line_in_space_button.setVisible(true);
                line_on_plane_button.setVisible(true);
            }
        });
    }
    public void allHide()
    {
        determinant_button.setVisible(false);
        matrix_button.setVisible(false);
        linear_button.setVisible(false);
        product_button.setVisible(false);
        definition_button.setVisible(false);
        operations_button.setVisible(false);
        lineAndPlane_button.setVisible(false);
        line_in_space_button.setVisible(false);
        line_on_plane_button.setVisible(false);
        plane_in_space_button.setVisible(false);
        curves_button.setVisible(false);
    }
    public void reverseColor()
    {
        String design = "-fx-background-color: #ffffff; -fx-border-color: #FB6B90; -fx-border-radius: 8; -fx-background-radius: 8 ";
        main_menu1.setStyle(design);
        main_menu2.setStyle(design);
        main_menu3.setStyle(design);
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

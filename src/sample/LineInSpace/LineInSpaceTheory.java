package sample.LineInSpace;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class LineInSpaceTheory {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label backCatLabel;

    @FXML
    private ImageView backPage;

    @FXML
    private ImageView backPageActive;

    @FXML
    private Button back_button;

    @FXML
    private Button downloadFull_button;

    @FXML
    private Button downloadThisOnly_button;

    @FXML
    private Label nextCatLabel;

    @FXML
    private ImageView nextPage;

    @FXML
    private ImageView nextPageActive;

    @FXML
    private Label page1_label;

    @FXML
    private Label page2_label;

    @FXML
    private ImageView page_img;

    @FXML
    private Button toMenu_button;
    private int amountPages = 2;
    private int whatIsPage =0;//numberPage-1
    //for label about pages
    private String startColor = "-fx-background-color: #ffffff";//white
    private String activeColor = "-fx-background-color: #000000";//black
    private String[] namesImg = {"page1.jpg", "page2.jpg"};


    @FXML
    void initialize() throws FileNotFoundException {
        //Start positions
        backPage.setVisible(false);
        backCatLabel.setVisible(false);
        backPageActive.setVisible(false);
        nextPageActive.setVisible(false);
        page1_label.setStyle(activeColor);
        downloadFull_button.setOnAction(event->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save");
            fileChooser.setInitialFileName("Повний конспект");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("pdf", "*.pdf"));
            Stage stage = new Stage();
            File file = new File("src/sample/theory.pdf");
            File dest = fileChooser.showSaveDialog(stage);
            if (dest != null) {
                try {
                    Files.copy(file.toPath(), dest.toPath());
                } catch (IOException ex) {
                    // handle exception...
                }
            }

        });
        downloadThisOnly_button.setOnAction(event->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save");
            fileChooser.setInitialFileName("Пряма у просторі");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("pdf", "*.pdf"));
            Stage stage = new Stage();
            File file = new File("src/sample/LineInSpace/theory_lineInSpace.pdf");
            File dest = fileChooser.showSaveDialog(stage);
            if (dest != null) {
                try {
                    Files.copy(file.toPath(), dest.toPath());
                } catch (IOException ex) {
                    // handle exception...
                }
            }
        });
        Label[] numberOfPagesLabels = numberOfPagesLabels();
        nextOrBackPageSymbols();

        nextCatLabel.setOnMouseClicked(event->{
            visibleBackButton(true);
            allLabelToStartStyle();
            whatIsPage += 1;
            numberOfPagesLabels[whatIsPage].setStyle(activeColor);
            try {
                viewImage(namesImg[whatIsPage]);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            if (whatIsPage == amountPages - 1)
                visibleNextButton(false);
        });

        backCatLabel.setOnMouseClicked(event->{
            visibleNextButton(true);
            allLabelToStartStyle();
            whatIsPage -= 1;
            numberOfPagesLabels[whatIsPage].setStyle(activeColor);
            try {
                viewImage(namesImg[whatIsPage]);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            if (whatIsPage == 0)
                visibleBackButton(false);
        });


        switchPages(numberOfPagesLabels);

        toMenu_button.setOnAction(event -> {
            toMenu_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/Menu.fxml");

        });
        back_button.setOnAction(event -> {
            back_button.getScene().getWindow().hide();
            openWindow("/sample/Menu/lineInSpaceMenu.fxml");

        });
    }
    void allLabelToStartStyle() {
        Label[] pages = numberOfPagesLabels();
        for(int i=0;i<amountPages;i++)
            pages[i].setStyle(startColor);
    }
    Label[] numberOfPagesLabels() {
        return new Label[]{page1_label, page2_label};
    }

    void nextOrBackPageSymbols()
    {
        backCatLabel.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                backPageActive.setVisible(true);
            }
        });
        nextCatLabel.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED, new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                nextPageActive.setVisible(true);
            }
        });
        backCatLabel.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                backPageActive.setVisible(false);
            }
        });
        nextCatLabel.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                nextPageActive.setVisible(false);
            }
        });

    }
    void visibleBackButton (boolean b)
    {
        backPage.setVisible(b);
        backCatLabel.setVisible(b);
    }
    void visibleNextButton(boolean b)
    {
        nextPage.setVisible(b);
        nextCatLabel.setVisible(b);
    }

    void switchPages(Label[] numberPagesLabels) {
        for(int i=0;i<amountPages;i++)
        {
            int finalI = i;
            int finalI1 = i;
            int finalI2 = i;
            numberPagesLabels[i].setOnMouseClicked(event->{
                whatIsPage= finalI2;
                allLabelToStartStyle();
                numberPagesLabels[finalI].setStyle(activeColor);
                try {
                    viewImage(namesImg[finalI1]);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                visibleBackButton(true);
                visibleNextButton(true);
                if(whatIsPage==amountPages-1)
                    visibleNextButton(false);
                if(whatIsPage==0)
                    visibleBackButton(false);
            });
        }
    }



    void viewImage(String nameImg) throws FileNotFoundException//nameImg like "page.jpg"
    {
        FileInputStream inputstream = new FileInputStream("./src/sample/assets/LineInSpace/"+nameImg);
        Image image = new Image(inputstream);
        page_img.setImage(image);
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

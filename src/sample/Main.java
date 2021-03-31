package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
    public PachetDeCarti pachetDeCarti = new PachetDeCarti();
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Black Jack");
        primaryStage.setScene(new Scene(root, 1280, 720));
        root.setId("mainMenu");
        String css = this.getClass().getResource("styles.css").toExternalForm();
        root.getStylesheets().add(css);
        primaryStage.setResizable(false);
        primaryStage.show();

        pachetDeCarti.show();

    }



    public static void main(String[] args) {
        launch(args);

    }
}

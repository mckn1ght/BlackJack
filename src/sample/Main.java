package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    PachetDeCarti pachetDeCarti = new PachetDeCarti();
    static int latimeRezolutie = 1280, inaltimeRezolutie = 720;
    static String culoare = "Rosu", sunet = "Pornit]";

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Black Jack");
        primaryStage.setScene(new Scene(root, latimeRezolutie, inaltimeRezolutie));
        root.setId("mainMenu");
        String css = this.getClass().getResource("styles.css").toExternalForm();
        root.getStylesheets().add(css);
        primaryStage.setResizable(false);
        primaryStage.show();
        ControllerMain.music();
        pachetDeCarti.show();

    }

    public static void main(String[] args) {
        launch(args);
    }


}


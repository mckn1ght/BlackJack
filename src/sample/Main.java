package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Black Jack");
        primaryStage.setScene(new Scene(root, 1280, 720));
        root.setId("mainMenu");
        String css = this.getClass().getResource("styles.css").toExternalForm();
        root.getStylesheets().add(css);
        primaryStage.setResizable(false);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}

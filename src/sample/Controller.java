package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;


public class Controller {

    public void exit(){
        Platform.exit();
    }

    public void jocNou(){

    }
    public void scoruri(){

        BorderPane layoutScoruri = new BorderPane();
        Scene scenaScoruri = new Scene(layoutScoruri, 500, 480);
        Stage scoruri = new Stage();

        scoruri.setTitle("HIGHSCORES");
        scoruri.setScene(scenaScoruri);
        scoruri.setResizable(false);

        layoutScoruri.setId("scoruri");
        String css = this.getClass().getResource("styles.css").toExternalForm();
        layoutScoruri.getStylesheets().add(css);
        

        scoruri.show();
    }




}

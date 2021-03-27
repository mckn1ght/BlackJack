package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;


public class ControllerMain {

    public void exit() {
        Platform.exit();
    }

    public void jocNou() {

    }

    public void handleButtonAction(MouseEvent mouseEvent) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scoruri.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Scene scenaScoruri = new Scene(root1, 500, 480);
            Stage scoruri = new Stage();

            scoruri.setTitle("SCORURI");
            scoruri.setScene(scenaScoruri);
            scoruri.setResizable(false);

            root1.setId("scoruri");
            String css = this.getClass().getResource("styles.css").toExternalForm();
            root1.getStylesheets().add(css);
            scoruri.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

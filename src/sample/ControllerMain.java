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
import javafx.scene.control.Button;
import java.awt.*;
import java.awt.event.ActionEvent;


public class ControllerMain {
    static Stage stageMeniuPrincipal;
    @FXML
    Button butonJocNou;


    public void exit() {
        Platform.exit();
    }

    public void jocNou(MouseEvent mouseEvent) {
       stageMeniuPrincipal = (Stage) butonJocNou.getScene().getWindow();
        stageMeniuPrincipal.hide();
            try {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("jocNou.fxml"));
                Parent root2 = (Parent) fxmlLoader.load();
                Scene scenaScoruri = new Scene(root2, 1280, 720);
                Stage jocNou = new Stage();

                jocNou.setTitle("Blackjack");
                jocNou.setScene(scenaScoruri);
                jocNou.setResizable(false);

                root2.setId("jocNou");
                String css = this.getClass().getResource("styles.css").toExternalForm();
                root2.getStylesheets().add(css);
                jocNou.show();
            } catch (Exception e) {
                e.printStackTrace();
            }



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

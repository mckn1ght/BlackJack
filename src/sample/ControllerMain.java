package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class ControllerMain {
    static Stage stageMeniuPrincipal;

    @FXML
    Button butonJocNou;

    static int latimeRezolutie = 1280, inaltimeRezolutie = 720;

    public void exit() {
        clickButon();
        Platform.exit();
    }

    public void jocNou() {
        clickButon();
       stageMeniuPrincipal = (Stage) butonJocNou.getScene().getWindow();
       stageMeniuPrincipal.hide();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("jocNou.fxml"));
                Parent root2 = (Parent) fxmlLoader.load();
                Scene scenaSetari = new Scene(root2, latimeRezolutie, inaltimeRezolutie);
                Stage jocNou = new Stage();

                jocNou.setTitle("Blackjack");
                jocNou.setScene(scenaSetari);
                jocNou.setResizable(false);

                root2.setId("jocNou");
                String css = this.getClass().getResource("styles.css").toExternalForm();
                root2.getStylesheets().add(css);
                jocNou.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void setari() {
        clickButon();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("setari.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();
            Scene scenaSetari = new Scene(root1, 700, 600);
            Stage setari = new Stage();

            setari.setTitle("SETARI");
            setari.setScene(scenaSetari);
            setari.setResizable(false);

            root1.setId("setari");
            String css = this.getClass().getResource("styles.css").toExternalForm();
            root1.getStylesheets().add(css);

            setari.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void reguli(){

    }


    static public void clickButon() {
        if(Main.sunet.equals("Pornit")) {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File("C:/Users/kodie/Desktop/clickButon.wav")));
                clip.start();
            } catch (Exception exc) {
                exc.printStackTrace(System.out);
            }
        }
    }



}

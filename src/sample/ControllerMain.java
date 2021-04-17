package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ControllerMain {
    static Stage stageMeniuPrincipal;

    @FXML
    Button butonJocNou;

    static int latimeRezolutie = 1280, inaltimeRezolutie = 720;
    static  Clip muzicaMainMenu;

    public void exit() {
        ControllerJocNou.redaSunet("clickButon");
        Platform.exit();
    }

    public void jocNou() {
        ControllerJocNou.redaSunet("clickButon");
        muzicaMainMenu.stop();
        stageMeniuPrincipal = (Stage) butonJocNou.getScene().getWindow();
        stageMeniuPrincipal.hide();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("jocNou.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Scene scenaJocNou = new Scene(root2, latimeRezolutie, inaltimeRezolutie);
            Stage jocNou = new Stage();

            jocNou.setTitle("Blackjack");
            jocNou.setScene(scenaJocNou);
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
        ControllerJocNou.redaSunet("clickButon");
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

        ControllerJocNou.redaSunet("clickButon");
        try {
            Desktop.getDesktop().browse(new URI("https://bicyclecards.com/how-to-play/blackjack/"));
        }catch(IOException e){
            e.printStackTrace();
        }catch (URISyntaxException e){
            e.printStackTrace();
        }
    }

    static public void music() {

        if (Main.sunet.equals("Pornit")) {
            if(muzicaMainMenu == null || !muzicaMainMenu.isRunning() ) {// verifica daca muzica este deja in curs de redare
                try {
                    muzicaMainMenu = AudioSystem.getClip();
                    muzicaMainMenu.open(AudioSystem.getAudioInputStream(new File("./Resurse/sunete/mainMenuMusic.wav")));
                    muzicaMainMenu.start();
                    muzicaMainMenu.loop(Clip.LOOP_CONTINUOUSLY);

                } catch (Exception exc) {
                    exc.printStackTrace(System.out);
                }
            }
        }else if(Main.sunet.equals("Oprit")){
            muzicaMainMenu.stop();
        }
    }

}

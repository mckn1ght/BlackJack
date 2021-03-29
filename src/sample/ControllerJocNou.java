package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ControllerJocNou {
    @FXML
    Button inapoi;

    @FXML
    Button pariaza;

    @FXML
    ImageView hand;

    public void inapoi() {
        Stage stage = (Stage) inapoi.getScene().getWindow();
        stage.close();
        ControllerMain.stageMeniuPrincipal.show();
    }

    public void pariaza() {
        try {
            InputStream stream = new FileInputStream("C:\\Users\\kodie\\Desktop\\cards_jpeg_zip\\JPEG\\2C.jpg");
            Image image = new Image(stream);
            hand.setImage(image);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
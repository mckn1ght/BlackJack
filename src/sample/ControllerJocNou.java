package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControllerJocNou {
    @FXML
    Button inapoi;

    @FXML
    Button pariaza;

    public void inapoi(){
        Stage stage = (Stage) inapoi.getScene().getWindow();
        stage.close();
        ControllerMain.stageMeniuPrincipal.show();
    }

    public void pariaza(){


    }


}

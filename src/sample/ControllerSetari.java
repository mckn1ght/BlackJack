package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerSetari {

    @FXML
    Button inapoiScor;

    public void inapoi(){
        Stage stage = (Stage) inapoiScor.getScene().getWindow();
        stage.close();
    }
}
package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import javax.sound.sampled.FloatControl;

public class ControllerSetari {

    @FXML
    Button inapoiScor;

    @FXML
    ComboBox setareSpateCarte, setareSunet;

    @FXML
    Slider setareNivelVolum;

    public void inapoi(){

        switch (setareSpateCarte.getValue().toString()) {
            case "Albastru":
                System.out.println("Albastru");
                Main.culoare = "Albastru";
                break;
            case "Galben":
                System.out.println("Galben");
                Main.culoare = "Galben";
                break;
            case "Gri":
                System.out.println("Gri");
                Main.culoare = "Gri";
                break;
            case "Mov":
                System.out.println("Mov");
                Main.culoare = "Mov";
                break;
            case "Rosu":
                System.out.println("Rosu");
                Main.culoare = "Rosu";
                break;
            case "Verde":
                System.out.println("Verde");
                Main.culoare = "Verde";
                break;
        }

        switch (setareSunet.getValue().toString()) {
            case "Pornit":
                System.out.println("Pornit");
                Main.sunet = "Pornit";
                break;
            case "Oprit":
                System.out.println("Oprit");
                Main.sunet = "Oprit";
                break;
        }
        Main.nivelVolum = setareNivelVolum.getValue();
        System.out.println(Main.nivelVolum);
        ControllerMain.music();
        PachetDeCarti.schimbaCuloarePachet(Main.culoare);
        ControllerJocNou.redaSunet("clickButon");
        Stage stage = (Stage) inapoiScor.getScene().getWindow();
        stage.close();

    }


    public void seteazaNivelVolum(){
        Main.nivelVolum = setareNivelVolum.getValue();
        FloatControl gainControl = (FloatControl) ControllerMain.muzicaMainMenu.getControl(FloatControl.Type.MASTER_GAIN);
        float dB = (float) (Math.log(setareNivelVolum.getValue()) / Math.log(10.0) * 20.0);
        gainControl.setValue(dB);
    }
}

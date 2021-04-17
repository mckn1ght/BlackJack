package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class ControllerSetari {

    @FXML
    Button inapoiScor;

    @FXML
    ComboBox setareRezolutie, setareSpateCarte, setareSunet;

    public void inapoi(){

        switch (setareRezolutie.getValue().toString()) {
            case "1920 x 1080":
                System.out.println("1920 x 1080");
                Main.latimeRezolutie = 1920;
                Main.inaltimeRezolutie = 1080;
                break;
            case "1600 x 1200":
                System.out.println("1600 x 1200");
                Main.latimeRezolutie = 1600;
                Main.inaltimeRezolutie = 1200;
                break;
            case "1280 x 720":
                System.out.println("1280 x 720");
                Main.latimeRezolutie = 1280;
                Main.inaltimeRezolutie = 720;
                break;
        }

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

        ControllerMain.music();
        PachetDeCarti.schimbaCuloarePachet(Main.culoare);
        ControllerJocNou.redaSunet("clickButon");
        Stage stage = (Stage) inapoiScor.getScene().getWindow();
        stage.close();

    }
}

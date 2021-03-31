package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Optional;

public class ControllerJocNou {

    @FXML
    Button inapoi;

    @FXML
    Button pariaza;

    @FXML
    ImageView cartea1;

    @FXML
    ImageView cartea2;

    @FXML
    ImageView cartea3;

    @FXML
    ImageView cartea4;

    @FXML
    ImageView cartea5;

    @FXML
    ImageView cartea6;

    @FXML
    TextArea Log;

    static int numarCartiMana = 1, suma = 0;

    int c1, c2, c3, c4, c5, c6;

    public void inapoi() {

        Stage stage = (Stage) inapoi.getScene().getWindow();
        stage.close();
        ControllerMain.stageMeniuPrincipal.show();
    }

    public void pariaza() {

        switch (numarCartiMana) {
            case 1:
                try {
                    for (int i = 0; i < 53; i++) {
                        c1 = (int) (52 * Math.random());
                        c2 = (int) (52 * Math.random());
                    }
                    InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[c1].fata);
                    Image image = new Image(stream);
                    cartea1.setImage(image);
                    numarCartiMana++;
                    suma = suma + PachetDeCarti.pachetDeCarti[c1].valoare;
                    InputStream stream2 = new FileInputStream(PachetDeCarti.pachetDeCarti[c2].fata);
                    Image image2 = new Image(stream2);
                    cartea2.setImage(image2);
                    numarCartiMana++;
                    suma = suma + PachetDeCarti.pachetDeCarti[c2].valoare;
                    conditieCastig(suma);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            case 3:
                try {
                    for (int i = 0; i < 53; i++) {
                        c3 = (int) (52 * Math.random());
                    }
                    InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[c3].fata);
                    Image image = new Image(stream);
                    cartea3.setImage(image);
                    numarCartiMana++;
                    suma = suma + PachetDeCarti.pachetDeCarti[c3].valoare;
                    conditieCastig(suma);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            case 4:
                try {
                    for (int i = 0; i < 53; i++) {
                        c4 = (int) (52 * Math.random());
                    }
                    InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[c4].fata);
                    Image image = new Image(stream);
                    cartea4.setImage(image);
                    numarCartiMana++;
                    suma = suma + PachetDeCarti.pachetDeCarti[c4].valoare;
                    conditieCastig(suma);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            case 5:
                try {
                    for (int i = 0; i < 53; i++) {
                        c5 = (int) (52 * Math.random());
                    }
                    InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[c5].fata);
                    Image image = new Image(stream);
                    cartea5.setImage(image);
                    numarCartiMana++;
                    suma = suma + PachetDeCarti.pachetDeCarti[c5].valoare;
                    conditieCastig(suma);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            case 6:
                try {
                    for (int i = 0; i < 53; i++) {
                        c6 = (int) (52 * Math.random());
                    }
                    InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[c6].fata);
                    Image image = new Image(stream);
                    cartea6.setImage(image);
                    numarCartiMana++;
                    suma = suma + PachetDeCarti.pachetDeCarti[c6].valoare;
                    conditieCastig(suma);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }


        }
    }

        public void reset() {
            if(numarCartiMana == 6) {
                suma = 0;
                numarCartiMana = 1;
                cartea1.setImage(null);
                cartea2.setImage(null);
                cartea3.setImage(null);
                cartea4.setImage(null);
                cartea5.setImage(null);
                cartea6.setImage(null);
            }
        }

        public void suma(int suma, int valoare){

        }

        public void conditieCastig(int suma){
        if (suma > 21){
            System.out.println("Ati Pierdut!" + suma + " .");
            Log.setText(Log.getText() + "\nAti Pierdut !" + suma + " puncte.");

            Alert alert = new Alert(Alert.AlertType.NONE, "Ati pierdut cu " + suma + " puncte!", ButtonType.OK);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();
            }
            reset();
            //button reset , toggle on
        }else if(suma <21) {
            System.out.println();
            Log.setText(Log.getText() + "\nAveti " + suma + " puncte.");
        }

        else if(suma == 21) {
            Log.setText(Log.getText() + "\nAti castigat, felicitari!");
             Alert alert = new Alert(Alert.AlertType.NONE, "Ati castigat cu " + suma + " puncte!", ButtonType.OK);
             Optional<ButtonType> result = alert.showAndWait();
             if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();
             }
        }
    }
}


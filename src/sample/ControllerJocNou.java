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
    ImageView cartea1, cartea2, cartea3, cartea4, cartea5, cartea6,
            carteDealer1, carteDealer2, carteDealer3, carteDealer4, carteDealer5, carteDealer6;

    @FXML
    TextArea Log;

    static int numarCartiManaJucator = 1, numarCartiManaDealer = 1, suma = 0, sumaDealer = 0;
    boolean passCalculator = false;// de implementat + RAND
    int c1, c2, c3, c4, c5, c6, cd1, cd2, cd3, cd4, cd5, cd6;

    public void inapoi() {
        reset();
        Stage stage = (Stage) inapoi.getScene().getWindow();
        stage.close();
        ControllerMain.stageMeniuPrincipal.show();
    }

    public void pariaza() {

        switch (numarCartiManaJucator) {
            case 1:
                try {
                    for (int i = 0; i < 53; i++) {
                        c1 = (int) (52 * Math.random());
                        c2 = (int) (52 * Math.random());
                    }
                    InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[c1].fata);
                    Image image = new Image(stream);
                    cartea1.setImage(image);
                    numarCartiManaJucator++;
                    suma = suma + PachetDeCarti.pachetDeCarti[c1].nrPuncte;
                    InputStream stream2 = new FileInputStream(PachetDeCarti.pachetDeCarti[c2].fata);
                    Image image2 = new Image(stream2);
                    cartea2.setImage(image2);
                    numarCartiManaJucator++;
                    suma = suma + PachetDeCarti.pachetDeCarti[c2].nrPuncte;
                    randulCalculatorului();
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
                    numarCartiManaJucator++;
                    suma = suma + PachetDeCarti.pachetDeCarti[c3].nrPuncte;
                    randulCalculatorului();
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
                    numarCartiManaJucator++;
                    suma = suma + PachetDeCarti.pachetDeCarti[c4].nrPuncte;
                    randulCalculatorului();
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
                    numarCartiManaJucator++;
                    suma = suma + PachetDeCarti.pachetDeCarti[c5].nrPuncte;
                    randulCalculatorului();
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
                    numarCartiManaJucator++;
                    suma = suma + PachetDeCarti.pachetDeCarti[c6].nrPuncte;
                    randulCalculatorului();
                    conditieCastig(suma);

                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }

    public void reset() {
            suma = 0;
            sumaDealer = 0;
            numarCartiManaJucator = 1;
            numarCartiManaDealer = 1;

            cartea1.setImage(null);
            cartea2.setImage(null);
            cartea3.setImage(null);
            cartea4.setImage(null);
            cartea5.setImage(null);
            cartea6.setImage(null);

            carteDealer1.setImage(null);
            carteDealer2.setImage(null);
            carteDealer3.setImage(null);
            carteDealer4.setImage(null);
            carteDealer5.setImage(null);
            carteDealer6.setImage(null);
            pariaza.setDisable(false);

    }

    public void conditieCastig(int suma) {
        if (suma > 21) {
            Log.setText(Log.getText() + "\nAti Pierdut cu " + suma + " de puncte.");
            arataCarti();
            Alert alert = new Alert(Alert.AlertType.NONE, "Ati pierdut cu " + suma + " puncte!", ButtonType.OK);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();

            }
        }
        else if (suma < 21) {
            System.out.println();
            Log.setText(Log.getText() + "\nAveti " + suma + " puncte.");
        }
        else {
            Log.setText(Log.getText() + "\nAti castigat, felicitari!");
            arataCarti();
            Alert alert = new Alert(Alert.AlertType.NONE, "Ati castigat cu " + suma + " puncte!", ButtonType.OK);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();
            }
        }
    }

    public void pass() {
        pariaza.setDisable(true);
    }

    public void randulCalculatorului() {
        switch (numarCartiManaDealer) {
            case 1:
                try {
                    for (int i = 0; i < 53; i++) {
                        cd1 = (int) (52 * Math.random());
                        cd2 = (int) (52 * Math.random());
                    }
                    InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cd1].spate);
                    Image image = new Image(stream);
                    carteDealer1.setImage(image);
                    numarCartiManaDealer++;
                    sumaDealer = sumaDealer + PachetDeCarti.pachetDeCarti[cd1].nrPuncte;
                    InputStream stream2 = new FileInputStream(PachetDeCarti.pachetDeCarti[cd2].spate);
                    Image image2 = new Image(stream2);
                    carteDealer2.setImage(image2);
                    numarCartiManaDealer++;
                    sumaDealer = sumaDealer + PachetDeCarti.pachetDeCarti[cd2].nrPuncte;
//                    conditieCastig(sumaDealer);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            case 3:
                try {
                    for (int i = 0; i < 53; i++) {
                        cd3 = (int) (52 * Math.random());
                    }
                    InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cd3].spate);
                    Image image = new Image(stream);
                    carteDealer3.setImage(image);
                    numarCartiManaDealer++;
                    sumaDealer = sumaDealer + PachetDeCarti.pachetDeCarti[cd3].nrPuncte;
//                    conditieCastig(sumaDealer);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            case 4:
                try {
                    for (int i = 0; i < 53; i++) {
                        cd4 = (int) (52 * Math.random());
                    }
                    InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cd4].spate);
                    Image image = new Image(stream);
                    carteDealer4.setImage(image);
                    numarCartiManaDealer++;
                    sumaDealer = sumaDealer + PachetDeCarti.pachetDeCarti[cd4].nrPuncte;
//                    conditieCastig(sumaDealer);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            case 5:
                try {
                    for (int i = 0; i < 53; i++) {
                        cd5 = (int) (52 * Math.random());
                    }
                    InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cd5].spate);
                    Image image = new Image(stream);
                    carteDealer5.setImage(image);
                    numarCartiManaDealer++;
                    sumaDealer = sumaDealer + PachetDeCarti.pachetDeCarti[cd5].nrPuncte;
//                    conditieCastig(sumaDealer);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            case 6:
                try {
                    for (int i = 0; i < 53; i++) {
                        cd6 = (int) (52 * Math.random());
                    }
                    InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cd6].spate);
                    Image image = new Image(stream);
                    carteDealer6.setImage(image);
                    numarCartiManaDealer++;
                    sumaDealer = sumaDealer + PachetDeCarti.pachetDeCarti[cd6].nrPuncte;
//                    conditieCastig(sumaDealer);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }

    public void arataCarti() {

        if(carteDealer1.getImage() != null) {
            try {
                InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cd1].fata);
                Image image = new Image(stream);
                carteDealer1.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
//            if (carteDealer2.getImage() != null) {
                try {
                    InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cd2].fata);
                    Image image = new Image(stream);
                    carteDealer2.setImage(image);
                } catch (Exception e) {
                    e.printStackTrace();
                }
//            }
        }

        if(carteDealer3.getImage() != null){
        try{
            InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cd3].fata);
            Image image = new Image(stream);
            carteDealer3.setImage(image);
        }catch (Exception e) {
            e.printStackTrace();
            }
        }

        if(carteDealer4.getImage() != null) {
            try {
                InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cd4].fata);
                Image image = new Image(stream);
                carteDealer4.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(carteDealer5.getImage() != null) {
            try {
                InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cd5].fata);
                Image image = new Image(stream);
                carteDealer5.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(carteDealer6.getImage() != null) {
            try {
                InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cd6].fata);
                Image image = new Image(stream);
                carteDealer6.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


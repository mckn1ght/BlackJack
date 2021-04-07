package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Optional;

public class ControllerJocNou {

    @FXML
    Button inapoi, pariaza, pass;

    @FXML
    ImageView cartea1, cartea2, cartea3, cartea4, cartea5, cartea6,
            carteDealer1, carteDealer2, carteDealer3, carteDealer4, carteDealer5, carteDealer6;

    @FXML
    TextArea Log;

    static int numarCartiManaJucator = 0, numarCartiManaDealer = 0, suma = 0, sumaDealer = 0;
    static boolean passCalculator = false, passJucator = false;

    int c1, c2, c3, c4, c5, c6, cd1, cd2, cd3, cd4, cd5, cd6, alegere;

    public void inapoi() {
        ControllerMain.clickButon();
        reset();
        Stage stage = (Stage) inapoi.getScene().getWindow();
        stage.close();
        ControllerMain.stageMeniuPrincipal.show();
    }

    public void rundaNoua(){
        randulJucatorului();
        randulCalculatorului();
        conditieCastig();
    }

    public void randulJucatorului() {

        if (!passJucator) {
            ControllerMain.clickButon();
            redaSunet("dealCard");
            switch (numarCartiManaJucator) {
                case 0:
                    try {
                        for (int i = 0; i < 53; i++) {
                            c1 = (int) (52 * Math.random());
                            c2 = (int) (52 * Math.random());
                        }
                        InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[c1].fata);
                        Image image = new Image(stream);
                        cartea1.setImage(image);
                        suma = suma + PachetDeCarti.pachetDeCarti[c1].nrPuncte;
                        numarCartiManaJucator++;
                        InputStream stream2 = new FileInputStream(PachetDeCarti.pachetDeCarti[c2].fata);
                        Image image2 = new Image(stream2);
                        cartea2.setImage(image2);
                        numarCartiManaJucator++;
                        suma = suma + PachetDeCarti.pachetDeCarti[c2].nrPuncte;
                        pass.setDisable(false);
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                case 2:
                    try {
                        for (int i = 0; i < 53; i++) {
                            c3 = (int) (52 * Math.random());
                        }
                        InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[c3].fata);
                        Image image = new Image(stream);
                        cartea3.setImage(image);
                        numarCartiManaJucator++;
                        suma = suma + PachetDeCarti.pachetDeCarti[c3].nrPuncte;
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                case 3:
                    try {
                        for (int i = 0; i < 53; i++) {
                            c4 = (int) (52 * Math.random());
                        }
                        InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[c4].fata);
                        Image image = new Image(stream);
                        cartea4.setImage(image);
                        numarCartiManaJucator++;
                        suma = suma + PachetDeCarti.pachetDeCarti[c4].nrPuncte;
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                case 4:
                    try {
                        for (int i = 0; i < 53; i++) {
                            c5 = (int) (52 * Math.random());
                        }
                        InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[c5].fata);
                        Image image = new Image(stream);
                        cartea5.setImage(image);
                        numarCartiManaJucator++;
                        suma = suma + PachetDeCarti.pachetDeCarti[c5].nrPuncte;
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                case 5:
                    try {
                        for (int i = 0; i < 53; i++) {
                            c6 = (int) (52 * Math.random());
                        }
                        InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[c6].fata);
                        Image image = new Image(stream);
                        cartea6.setImage(image);
                        numarCartiManaJucator++;
                        suma = suma + PachetDeCarti.pachetDeCarti[c6].nrPuncte;
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    public void randulCalculatorului() {
        if (!passCalculator) {
            redaSunet("dealCard");
            switch (numarCartiManaDealer) {
                case 0:
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
//                        if (sumaDealer <= 15) {
//                            alegere = (int) (10 * Math.random());
//                            Log.setText(Log.getText() + "\nCase 1 - Alegere= " + alegere);
//                            if (alegere < 8) {
//                                passCalculator = true;
//                                Log.setText(Log.getText() + "\nOponentul sta.");
//                            }else{
//                                Log.setText(Log.getText() + "\nOponentul pariaza.");
//                                randulCalculatorului();
//                            }
//                        }
                        break;

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                case 2:
                    Log.setText(Log.getText() + "\nOponentul se gandeste.....");
//                    try {
//                        Thread.sleep((int)(5 * Math.random()) * 1000);
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
                    try {
                        for (int i = 0; i < 53; i++) {
                            cd3 = (int) (52 * Math.random());
                        }
                        InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cd3].spate);
                        Image image = new Image(stream);
                        carteDealer3.setImage(image);
                        numarCartiManaDealer++;
                        sumaDealer = sumaDealer + PachetDeCarti.pachetDeCarti[cd3].nrPuncte;
                        if (sumaDealer <= 16) {
                            alegere = (int) (10 * Math.random());
                            Log.setText(Log.getText() + "\nCase 3 - Alegere= " + alegere);
                            if (alegere < 5) {
                                passCalculator = true;
                                Log.setText(Log.getText() + "\nOponentul sta.");
                            }else{
                                Log.setText(Log.getText() + "\nOponentul pariaza.");
                            }
                        }
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                case 3:
                    Log.setText(Log.getText() + "\nOponentul se gandeste.....");
//                    try {
//                        Thread.sleep((int)(5 * Math.random()) * 1000);
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
                    try {
                        for (int i = 0; i < 53; i++) {
                            cd4 = (int) (52 * Math.random());
                        }
                        InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cd4].spate);
                        Image image = new Image(stream);
                        carteDealer4.setImage(image);
                        numarCartiManaDealer++;
                        sumaDealer = sumaDealer + PachetDeCarti.pachetDeCarti[cd4].nrPuncte;
                        if (sumaDealer <= 17) {
                            alegere = (int) (10 * Math.random());
                            Log.setText(Log.getText() + "\nCase 4 - Alegere= " + alegere);
                            if (alegere < 4) {
                                passCalculator = true;
                                Log.setText(Log.getText() + "\nOponentul sta.");
                            }else{
                                Log.setText(Log.getText() + "\nOponentul pariaza.");
                            }
                        }
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                case 4:
                    Log.setText(Log.getText() + "\nOponentul se gandeste.....");
//                    try {
//                        Thread.sleep((int)(5 * Math.random()) * 1000);
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
                    try {
                        for (int i = 0; i < 53; i++) {
                            cd5 = (int) (52 * Math.random());
                        }
                        InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cd5].spate);
                        Image image = new Image(stream);
                        carteDealer5.setImage(image);
                        numarCartiManaDealer++;
                        sumaDealer = sumaDealer + PachetDeCarti.pachetDeCarti[cd5].nrPuncte;
                        if (sumaDealer <= 17) {
                            alegere = (int) (10 * Math.random());
                            Log.setText(Log.getText() + "\nCase 5 - Alegere= " + alegere);
                            if (alegere < 3) {
                                passCalculator = true;
                                Log.setText(Log.getText() + "\nOponentul sta.");
//                                rundaNoua();
                            }else{
                                Log.setText(Log.getText() + "\nOponentul pariaza.");
                            }
                        }
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                case 5:
                    Log.setText(Log.getText() + "\nOponentul se gandeste.....");
//                    try {
//                        Thread.sleep((int)(5 * Math.random()) * 1000);
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
                    try {
                        for (int i = 0; i < 53; i++) {
                            cd6 = (int) (52 * Math.random());
                        }
                        InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cd6].spate);
                        Image image = new Image(stream);
                        carteDealer6.setImage(image);
                        numarCartiManaDealer++;
                        sumaDealer = sumaDealer + PachetDeCarti.pachetDeCarti[cd6].nrPuncte;
                        if (sumaDealer <= 18) {
                            alegere = (int) (10 * Math.random());
                            Log.setText(Log.getText() + "\nCase 6 - Alegere= " + alegere);
                            if (alegere < 2) {
                                passCalculator = true;
                                Log.setText(Log.getText() + "\nOponentul sta.");
                            }else{
                                Log.setText(Log.getText() + "\nOponentul pariaza.");
                            }
                        }
                        conditieCastig();
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                case 6:
                    passCalculator = true;
                    rundaNoua();
            }
        } else System.out.println(Log.getText() + "\nOponentul sta.");

    }

    public void reset() {
            suma = 0;
            sumaDealer = 0;
            numarCartiManaJucator = 0;
            numarCartiManaDealer = 0;

            passCalculator = false;
            passJucator = false;

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
            pass.setDisable(true);

            redaSunet("shuffle");

    }

    public void conditieCastig() {
//player wins
        if(suma == 21 && !(sumaDealer==21) && passCalculator){
            passJucator = true;
            Log.setText(Log.getText() + "\nAti castigat cu " + suma + " puncte!");
            arataCarti();
            redaSunet("victorie");
            Alert alert = new Alert(Alert.AlertType.NONE, "Ati castigat cu " + suma + " puncte! Oponentul a avut " + sumaDealer, ButtonType.OK);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();
            }
        }
//draw
        else if(suma == 21 && sumaDealer==21){
            passCalculator = true;
            passJucator = true;
            Log.setText(Log.getText() + "\nEgalitate! Ati avut "+ suma + ", iar oponentul a avut: " + sumaDealer);
            arataCarti();
            redaSunet("egalitate");
            Alert alert = new Alert(Alert.AlertType.NONE, "\nEgalitate! Ati avut "+ suma + ", iar oponentul a avut: " + sumaDealer, ButtonType.OK);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();

            }
        }
//dealer wins
        else if(sumaDealer == 21 && !(suma==21) && passJucator){
            passCalculator = true;
            Log.setText(Log.getText() + "\nOponentul a castigat cu : " + sumaDealer + " | Ati avut: " + suma);
            arataCarti();
            redaSunet("infrangere");
            Alert alert = new Alert(Alert.AlertType.NONE, "\nOponentul a castigat cu : " + sumaDealer + " Ati avut: " + suma, ButtonType.OK);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();
            }
        }
//dealer wins
        else if(suma > 21 && !(sumaDealer > 21) && passCalculator){
            Log.setText(Log.getText() + "\nOponentul a castigat cu : " + sumaDealer + ". Ati avut: " + suma);
            arataCarti();
            redaSunet("infrangere");
            Alert alert = new Alert(Alert.AlertType.NONE, "\nOponentul a castigat cu : " + sumaDealer + ". Ati avut: " + suma, ButtonType.OK);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();
            }
        }
//player wins
        else if(sumaDealer > 21 && !(suma > 21) && passJucator ){
            Log.setText(Log.getText() + "\nAti castigat cu " + suma + " puncte!");
            arataCarti();
            redaSunet("victorie");
            Alert alert = new Alert(Alert.AlertType.NONE, "Ati castigat cu " + suma + " puncte! Oponentul a avut " + sumaDealer, ButtonType.OK);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();
            }
        }
//draw
        else if(sumaDealer > 21 && suma > 21){

            Log.setText(Log.getText() + "\nEgalitate! Ati avut "+ suma + ", iar oponentul a avut: " + sumaDealer);
            arataCarti();
            redaSunet("egalitate");
            Alert alert = new Alert(Alert.AlertType.NONE, "\nEgalitate! Ati avut "+ suma + ", iar oponentul a avut: " + sumaDealer, ButtonType.OK);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();
            }
        }
//vezi win conditie
        else if(suma < 21 && sumaDealer < 21 && passJucator && passCalculator){

            if(suma > sumaDealer){
                Log.setText(Log.getText() + "\nAti castigat cu " + suma + " puncte!");
                arataCarti();
                redaSunet("victorie");
                Alert alert = new Alert(Alert.AlertType.NONE, "Ati castigat cu " + suma + " puncte! Oponentul a avut " + sumaDealer, ButtonType.OK);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    reset();
                }
            }else if(sumaDealer > suma){
                Log.setText(Log.getText() + "\nOponentul a castigat cu : " + sumaDealer + ". Ati avut: " + suma);
                arataCarti();
                redaSunet("infrangere");
                Alert alert = new Alert(Alert.AlertType.NONE, "\nOponentul a castigat cu : " + sumaDealer + ". Ati avut: " + suma, ButtonType.OK);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    reset();
                }
            }
        }

        else if(suma < 21 && sumaDealer < 21 && passCalculator) {
            rundaNoua();
        }

        else if(suma < 21 && sumaDealer < 21 && passJucator){
            rundaNoua();
        }

        //egalitate
        else if(suma == sumaDealer && passCalculator && passJucator){

            Log.setText(Log.getText() + "\nEgalitate! Ati avut "+ suma + ", iar oponentul a avut: " + sumaDealer);
            arataCarti();
            redaSunet("egalitate");
            Alert alert = new Alert(Alert.AlertType.NONE, "\nEgalitate! Ati avut "+ suma + ", iar oponentul a avut: " + sumaDealer, ButtonType.OK);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();
            }
        }

        //daca se ajunge la nr maxim de carti admis in mana//
        if(numarCartiManaDealer == 6 && numarCartiManaJucator == 6 && suma < 21 && sumaDealer < 21){
            if(suma > sumaDealer){
                Log.setText(Log.getText() + "\nAti castigat cu " + suma + " puncte!");
                arataCarti();
                redaSunet("victorie");
                Alert alert = new Alert(Alert.AlertType.NONE, "Ati castigat cu " + suma + " puncte! Oponentul a avut " + sumaDealer, ButtonType.OK);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    reset();
                }
            }else if(sumaDealer > suma){
                Log.setText(Log.getText() + "\nOponentul a castigat cu : " + sumaDealer + ". Ati avut: " + suma);
                arataCarti();
                redaSunet("infrangere");
                Alert alert = new Alert(Alert.AlertType.NONE, "\nOponentul a castigat cu : " + sumaDealer + ". Ati avut: " + suma, ButtonType.OK);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    reset();
                }
            }
        }
    }

    public void pass() {
        ControllerMain.clickButon();
        passJucator = true;
        pariaza.setDisable(true);
        pass.setDisable(true);
        rundaNoua();
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
            try {
                InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cd2].fata);
                Image image = new Image(stream);
                carteDealer2.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
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

    public void redaSunet(String denumire){
        if(Main.sunet.equals("Pornit")) {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File("C:/Users/kodie/Documents/IntelliJProjects/JocBlackJack/src/sample/Resurse/" + denumire + ".wav")));
                clip.start();
            } catch (Exception exc) {
                exc.printStackTrace(System.out);
            }
        }
    }
}
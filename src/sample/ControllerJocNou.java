package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Optional;

public class ControllerJocNou {

    @FXML
    Button inapoi, hit, pass;

    @FXML
    ImageView cartea1, cartea2, cartea3, cartea4, cartea5, cartea6,
            carteDealer1, carteDealer2, carteDealer3, carteDealer4, carteDealer5, carteDealer6;

    @FXML
    TextField textFieldPariu;

    @FXML
    Slider sliderPariu;

    @FXML
    TextArea Log;

    Jucator jucator = new Jucator();
    Jucator oponent = new Jucator();

    int alegere;
    static ArrayList<Integer> idCartiExtrase = new ArrayList<Integer>();


    public void inapoi() {
        ControllerMain.clickButon();
        reset();
        Stage stage = (Stage) inapoi.getScene().getWindow();
        stage.close();
        ControllerMain.stageMeniuPrincipal.show();
    }

    public void rundaNoua() {

        if(!jucator.pass || !jucator.blackjack || !jucator.bust) {
            jucator.joaca(cartea1, cartea2, cartea3, cartea4, cartea5, cartea6);
            pass.setDisable(false);
            if(oponent.numarCartiMana == 0 ) {
                oponent.joaca(carteDealer1, carteDealer2, carteDealer3, carteDealer4, carteDealer5, carteDealer6);
                // acopera  a doua carte
                try {
                    InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[oponent.cartea2].spate);
                    Image cardBack = new Image(stream);
                    carteDealer2.setImage(cardBack);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

        if(jucator.pass || jucator.blackjack || jucator.bust){

            // afiseaza a doua carte
            try {
                InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[oponent.cartea2].fata);
                Image cardBack = new Image(stream);
                carteDealer2.setImage(cardBack);
            }catch(Exception e){
                e.printStackTrace();
            }

            while(oponent.numarCartiMana < 6 && !oponent.bust && !oponent.pass && !oponent.blackjack){
                oponent.joaca(carteDealer1, carteDealer2, carteDealer3, carteDealer4, carteDealer5, carteDealer6);
            }
            if(oponent.pass){
                System.out.println("Dealerul se opreste.");
                Log.setText(Log.getText() + "\nDealerul se opreste.");
            }
        }
        conditieCastig();
    }

    public void reset() {
        idCartiExtrase.clear();

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

        jucator.reset();
        oponent.reset();

        pass.setDisable(true);
        redaSunet("shuffle");
    }

    public void conditieCastig() {

        if(jucator.blackjack && oponent.blackjack){
            Log.setText(Log.getText() + "\n1Ambii jucatori au avut BLACKJACK !");
            arataCarti();
            redaSunet("egalitate");
            Alert alert = new Alert(Alert.AlertType.NONE, "1Ambii jucatori au avut BLACKJACK !", ButtonType.OK);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();
            }
        }

        else if(jucator.blackjack){
            Log.setText(Log.getText() + "\n2Ati castigat cu " + jucator.puncte + " puncte!");
            arataCarti();
            redaSunet("victorie");
            Alert alert = new Alert(Alert.AlertType.NONE, "2Ati castigat cu " + jucator.puncte + " puncte! Oponentul a avut " + oponent.puncte, ButtonType.OK);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();
            }
        }

        else if(oponent.blackjack){
            Log.setText(Log.getText() + "\n3Oponentul a castigat cu : " + oponent.puncte + " | Ati avut: " + jucator.puncte);
            arataCarti();
            redaSunet("infrangere");
            Alert alert = new Alert(Alert.AlertType.NONE, "\n3Oponentul a castigat cu : " + oponent.puncte + " Ati avut: " + jucator.puncte, ButtonType.OK);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();
            }
        }
        else if(jucator.bust &&  !oponent.pass && !oponent.bust){
            Log.setText(Log.getText() + "\n4Oponentul a castigat cu : " + oponent.puncte + " | Ati avut: " + jucator.puncte);
            arataCarti();
            redaSunet("infrangere");
            Alert alert = new Alert(Alert.AlertType.NONE, "\n4Oponentul a castigat cu : " + oponent.puncte + " Ati avut: " + jucator.puncte, ButtonType.OK);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();
            }
        }

        else if(!jucator.bust && oponent.bust){
            Log.setText(Log.getText() + "\n5Ati castigat cu " + jucator.puncte + " puncte!");
            arataCarti();
            redaSunet("victorie");
            Alert alert = new Alert(Alert.AlertType.NONE, "5Ati castigat cu " + jucator.puncte + " puncte! Oponentul a avut " + oponent.puncte, ButtonType.OK);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();
            }
        }

        else if(oponent.bust && jucator.pass ){
            Log.setText(Log.getText() + "\n6Ati castigat cu " + jucator.puncte + " puncte!");
            arataCarti();
            redaSunet("victorie");
            Alert alert = new Alert(Alert.AlertType.NONE, "6Ati castigat cu " + jucator.puncte + " puncte! Oponentul a avut " + oponent.puncte, ButtonType.OK);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();
            }
        }

        else if(jucator.bust && oponent.bust){
            Log.setText(Log.getText() + "\n7Ambii jucatori au fost eliminati ! Ati avut " + jucator.puncte + " puncte! Oponentul dvs a avut: " + oponent.puncte);
            arataCarti();
            redaSunet("egalitate");
            Alert alert = new Alert(Alert.AlertType.NONE, "7Ambii jucatori au fost eliminati ! Ati avut " + jucator.puncte + " puncte! Oponentul dvs a avut: " + oponent.puncte, ButtonType.OK);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();
            }
        }
    }

    public void pass() {
        ControllerMain.clickButon();
        jucator.pass();
        rundaNoua();
    }

    static public void redaSunet(String denumire) {
        if (Main.sunet.equals("Pornit")) {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File("./Resurse/sunete/" + denumire + ".wav")));
                clip.start();
            } catch (Exception exc) {
                exc.printStackTrace(System.out);
            }
        }
    }

    public void arataCarti(){
        if (carteDealer1.getImage() != null) {
            try {
                InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[oponent.cartea1].fata);
                Image image = new Image(stream);
                carteDealer1.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[oponent.cartea2].fata);
                Image image = new Image(stream);
                carteDealer2.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (carteDealer3.getImage() != null) {
            try {
                InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[oponent.cartea3].fata);
                Image image = new Image(stream);
                carteDealer3.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (carteDealer4.getImage() != null) {
            try {
                InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[oponent.cartea4].fata);
                Image image = new Image(stream);
                carteDealer4.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (carteDealer5.getImage() != null) {
            try {
                InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[oponent.cartea5].fata);
                Image image = new Image(stream);
                carteDealer5.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (carteDealer6.getImage() != null) {
            try {
                InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[oponent.cartea6].fata);
                Image image = new Image(stream);
                carteDealer6.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pariaza(){

        textFieldPariu.setText("0");
        sliderPariu.setMin(1);
        sliderPariu.setMax(100);
        sliderPariu.setVisible(true);
        textFieldPariu.setVisible(true);
    }

    public void actualizeazaPariu(){
        textFieldPariu.setText(String.valueOf((int)sliderPariu.getValue()));
    }

}
package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    Button inapoi, hit, pass, colecteazaPariu, pariaza;

    @FXML
    ImageView cartea1, cartea2, cartea3, cartea4, cartea5, cartea6,
            carteDealer1, carteDealer2, carteDealer3, carteDealer4, carteDealer5, carteDealer6;

    @FXML
    TextField textFieldPariu;

    @FXML
    Slider sliderPariu;

    @FXML
    TextArea Log;

    @FXML
    Label pot, credit, creditOponent;

    Jucator jucator = new Jucator();
    Jucator oponent = new Jucator();

    int alegere;

    static ArrayList<Integer> idCartiExtrase = new ArrayList<>();


    public void inapoi() {
        ControllerJocNou.redaSunet("clickButon");
        reset();
        Stage stage = (Stage) inapoi.getScene().getWindow();
        stage.close();
        ControllerMain.stageMeniuPrincipal.show();
        ControllerMain.music();// Reporneste muzica din meniul principal daca aceasta este de asemenea pornita din setari
    }

    public void rundaNoua() {

        if(!jucator.pass || !jucator.blackjack || !jucator.bust) {
            pariaza.setDisable(false);
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
            hit.setDisable(true);
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

        pot.setVisible(false);
        pot.setText("          ");
        pass.setDisable(true);
        hit.setDisable(true);
        redaSunet("shuffle");

        verificaCreditContinuare();
    }

    public void conditieCastig() {

        if(jucator.blackjack && oponent.blackjack){
            Log.setText(Log.getText() + "\n1Ambii jucatori au avut BLACKJACK !");
            arataCarti();
            redaSunet("egalitate");
            Alert alert = new Alert(Alert.AlertType.NONE, "1Ambii jucatori au avut BLACKJACK !", ButtonType.OK);
            jucator.adaugaCredit(Double.parseDouble(pot.getText()) / 2);
            credit.setText("Creditul Dumneavoastra: " + jucator.credit);
            oponent.adaugaCredit(Double.parseDouble(pot.getText()) / 2);
            creditOponent.setText("Credit Oponent: " + oponent.credit);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();
            }
        }

        else if(jucator.blackjack){
            Log.setText(Log.getText() + "\n2Ati castigat cu " + jucator.puncte + " puncte!");
            arataCarti();
            redaSunet("victorie");
            jucator.adaugaCredit(Double.parseDouble(pot.getText()));
            credit.setText("Creditul Dumneavoastra: " + jucator.credit);
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
            oponent.adaugaCredit(Double.parseDouble(pot.getText()));
            creditOponent.setText("Credit Oponent: " + oponent.credit);
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
            oponent.adaugaCredit(Double.parseDouble(pot.getText()));
            creditOponent.setText("Credit Oponent: " + oponent.credit);
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
            jucator.adaugaCredit(Double.parseDouble(pot.getText()));
            credit.setText("Creditul Dumneavoastra: " + jucator.credit);
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
            jucator.adaugaCredit(Double.parseDouble(pot.getText()));
            credit.setText("Creditul Dumneavoastra: " + jucator.credit);
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
            jucator.adaugaCredit(Double.parseDouble(pot.getText()) / 2);
            credit.setText("Creditul Dumneavoastra: " + jucator.credit);
            oponent.adaugaCredit(Double.parseDouble(pot.getText()) / 2);
            creditOponent.setText("Credit Oponent: " + oponent.credit);
            Alert alert = new Alert(Alert.AlertType.NONE, "7Ambii jucatori au fost eliminati ! Ati avut " + jucator.puncte + " puncte! Oponentul dvs a avut: " + oponent.puncte, ButtonType.OK);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();
            }
        }
    }

    public void pass() {
        ControllerJocNou.redaSunet("clickButon");
        jucator.pass();
        rundaNoua();
        pass.setDisable(true);
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
        ControllerJocNou.redaSunet("clickButon");
        textFieldPariu.setText("1");
        sliderPariu.setMin(1);
        if(jucator.credit > oponent.credit) {
            sliderPariu.setMax(oponent.credit);
        }
        else sliderPariu.setMax(jucator.credit);

        sliderPariu.setVisible(true);
        textFieldPariu.setVisible(true);
        colecteazaPariu.setVisible(true);
    }

    public void actualizeazaPariu(){
        textFieldPariu.setText(String.valueOf((int)sliderPariu.getValue()));
    }

    public void colecteazaPariu(){
        ControllerJocNou.redaSunet("clickButon");
        sliderPariu.setVisible(false);
        sliderPariu.setValue(sliderPariu.getMin());// dupa fiecare pariu, reseteaza sliderul in pozitia cea mai din stanga(1);
        textFieldPariu.setVisible(false);
        colecteazaPariu.setVisible(false);
        pot.setVisible(true);
        if(pot.getText().trim().isEmpty()){
            pot.setText("          " + 2 * Double.parseDouble(textFieldPariu.getText()));
        }else pot.setText("          " +  (Double.valueOf(pot.getText()) + 2 * Double.parseDouble(textFieldPariu.getText())));
        hit.setDisable(false);
        pariaza.setDisable(true);
        oponent.eliminaCredit(Double.parseDouble(textFieldPariu.getText()));
        jucator.eliminaCredit(Double.parseDouble(textFieldPariu.getText()));
        credit.setText("Creditul Dumneavoastra: " + jucator.credit);
        creditOponent.setText("Credit Oponent: " + oponent.credit);
    }

    public void verificaCreditContinuare() {
        if (jucator.credit <= 0) {
            redaSunet("infrangere");
            Alert alert = new Alert(Alert.AlertType.NONE, "Ati ramas fara bani. Jocul s-a terminat, iar oponentul a castigat!", ButtonType.OK);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Stage stage = (Stage) pariaza.getScene().getWindow();
                stage.close();
            }
        } else if (oponent.credit <= 0) {
            redaSunet("victorie");
            Alert alert = new Alert(Alert.AlertType.NONE, "Oponentul a ramas fara bani. Jocul s-a terminat, iar Dumneavoastra ati castigat! FELICITARI!", ButtonType.OK);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Stage stage = (Stage) pariaza.getScene().getWindow();
                stage.close();
            }
        }
    }

}

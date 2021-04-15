package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.InputStream;

public class Jucator {
    int numarCartiMana, puncte, nrAsiInMana, cartea1, cartea2, cartea3, cartea4, cartea5, cartea6;
    boolean pass, bust, blackjack;
    double credit;

    public Jucator() {
        this.numarCartiMana = 0;
        this.puncte = 0;
        this.nrAsiInMana = 0;
        this.cartea1 = -1;
        this.cartea2 = -1;
        this.cartea3 = -1;
        this.cartea4 = -1;
        this.cartea5 = -1;
        this.cartea6 = -1;
        this.pass = false;
        this.bust = false;
        this.blackjack = false;


    }

    public void joaca(ImageView image1, ImageView image2, ImageView image3, ImageView image4, ImageView image5, ImageView image6) {
        if (!this.pass && this.puncte < 21 && !this.blackjack) {
            ControllerMain.clickButon();
            ControllerJocNou.redaSunet("dealCard");
            switch (this.numarCartiMana) {
                case 0:
                    try {
                        //cartea1
                        do {
                            cartea1 = (int) (52 * Math.random());
                        }
                        while (verificaDuplicat(cartea1));
                        ControllerJocNou.idCartiExtrase.add(cartea1);
                        contorAsi(PachetDeCarti.pachetDeCarti[cartea1].id);
                        //cartea 2
                        do {
                            cartea2 = (int) (52 * Math.random());
                        }
                        while (verificaDuplicat(cartea2));

                        ControllerJocNou.idCartiExtrase.add(cartea2);
                        contorAsi(PachetDeCarti.pachetDeCarti[cartea2].id);

                        InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cartea1].fata);
                        Image img1 = new Image(stream);
                        image1.setImage(img1);

                        this.puncte = this.puncte + PachetDeCarti.pachetDeCarti[cartea1].nrPuncte;
                        this.numarCartiMana++;

                        InputStream stream2 = new FileInputStream(PachetDeCarti.pachetDeCarti[cartea2].fata);
                        Image img2 = new Image(stream2);
                        image2.setImage(img2);

                        this.numarCartiMana++;
                        this.puncte = this.puncte + PachetDeCarti.pachetDeCarti[cartea2].nrPuncte;
                        verificaEligibilitateContinuare();
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                case 2:
                    try {
                        //cartea 3
                        do {
                            cartea3 = (int) (52 * Math.random());
                        }
                        while (verificaDuplicat(cartea3));
                        ControllerJocNou.idCartiExtrase.add(cartea3);

                        contorAsi(PachetDeCarti.pachetDeCarti[cartea3].id);
                        InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cartea3].fata);
                        Image img3 = new Image(stream);
                        image3.setImage(img3);
                        this.numarCartiMana++;
                        this.puncte = this.puncte + PachetDeCarti.pachetDeCarti[cartea3].nrPuncte;
                        verificaEligibilitateContinuare();
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                case 3:
                    try {
                        //cartea 4
                        do {
                            cartea4 = (int) (52 * Math.random());
                        }
                        while (verificaDuplicat(cartea4));
                        ControllerJocNou.idCartiExtrase.add(cartea4);

                        contorAsi(PachetDeCarti.pachetDeCarti[cartea4].id);
                        InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cartea4].fata);
                        Image img4 = new Image(stream);
                        image4.setImage(img4);
                        this.numarCartiMana++;
                        this.puncte = this.puncte + PachetDeCarti.pachetDeCarti[cartea4].nrPuncte;
                        verificaEligibilitateContinuare();
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                case 4:
                    try {
                        //cartea 5
                        do {
                            cartea5 = (int) (52 * Math.random());
                        }
                        while (verificaDuplicat(cartea5));
                        ControllerJocNou.idCartiExtrase.add(cartea5);

                        contorAsi(PachetDeCarti.pachetDeCarti[cartea5].id);
                        InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cartea5].fata);
                        Image img5 = new Image(stream);
                        image5.setImage(img5);
                        this.numarCartiMana++;
                        this.puncte = this.puncte + PachetDeCarti.pachetDeCarti[cartea5].nrPuncte;
                        verificaEligibilitateContinuare();
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                case 5:
                    try {
                        //cartea 6
                        do {
                            cartea6 = (int) (52 * Math.random());
                        }
                        while (verificaDuplicat(cartea6));
                        ControllerJocNou.idCartiExtrase.add(cartea6);

                        contorAsi(PachetDeCarti.pachetDeCarti[cartea6].id);
                        InputStream stream = new FileInputStream(PachetDeCarti.pachetDeCarti[cartea6].fata);
                        Image img6 = new Image(stream);
                        image6.setImage(img6);
                        this.numarCartiMana++;
                        this.puncte = this.puncte + PachetDeCarti.pachetDeCarti[cartea6].nrPuncte;
                        verificaEligibilitateContinuare();
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }
        System.out.println("Nr carti mana:" + numarCartiMana);
    }

    public void reset() {
        this.numarCartiMana = 0;
        this.puncte = 0;
        this.nrAsiInMana = 0;
        this.cartea1 = 0;
        this.cartea2 = 0;
        this.cartea3 = 0;
        this.cartea4 = 0;
        this.cartea5 = 0;
        this.cartea6 = 0;
        this.pass = false;
        this.bust = false;
        this.blackjack = false;
    }

    public void verificaEligibilitateContinuare() {
        verificaAsi();
        if (this.puncte == 21) {
            blackjack();
        } else if (this.puncte > 21) {
            bust();
        }
    }

    public void pass() {
        this.pass = true;
    }

    public void bust() {
        this.bust = true;
    }

    public void blackjack() {
        this.blackjack = true;
    }

    public void verificaAsi() {
        while (this.puncte > 21 && this.nrAsiInMana > 0) {
            this.puncte = this.puncte - 10;
            this.nrAsiInMana--;
        }
    }

    public void contorAsi(int idCarte) {
        if (idCarte == 1 || idCarte == 14 || idCarte == 27 || idCarte == 40) {
            this.nrAsiInMana++;
            System.out.println("Found Player ace on number " + idCarte + " nrAsi = " + this.nrAsiInMana);
        }
    }

    public boolean verificaDuplicat(int k) {
        if(ControllerJocNou.idCartiExtrase.contains(k)){
            return true;
        }
        return false;
    }
}
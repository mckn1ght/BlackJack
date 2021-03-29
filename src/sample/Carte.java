package sample;

import javax.smartcardio.Card;

public class Carte
{
    public static final int numarCarti = 52;
    String[] simbolInitializare = new String[4];
    private Carte[] pachetDeCarti;
    int id = 1;
    String simbol;
    int valoare;

    public Carte( ) {
        simbolInitializare[0] = "Trefla";
        simbolInitializare[1] = "Inima Neagra";
        simbolInitializare[2] = "Inima Rosie";
        simbolInitializare[3] = "Caro";

        pachetDeCarti = new Carte[numarCarti];
        int i = 0;
        for (int k = 0; k < 4; k++) {
            for (int valoare = 1; valoare <= 13; valoare++) {
                pachetDeCarti[i++] = new Carte(id, simbolInitializare[k], valoare);
                id++;
            }
        }
    }

    public Carte(int id, String simbol, int valoare){
        this.id = id;
        this.simbol = simbol;
        this.valoare = valoare;
    }

    public void show(){
        for(int i = 0; i< pachetDeCarti.length;i++) {
            System.out.println(this.pachetDeCarti[i].id + " " + this.pachetDeCarti[i].valoare + " " + " " + this.pachetDeCarti[i].simbol);
        }
    }


}
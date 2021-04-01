package sample;

public class PachetDeCarti
{
    public static final int numarCarti = 52;
    String[] simbolInitializare = new String[4];
    public static PachetDeCarti[] pachetDeCarti;
    int id = 1, valoare; // nr afisat pe carte;
    int nrPuncte;
    String simbol, fata, spate;


    public PachetDeCarti( ) {
        simbolInitializare[0] = "Trefla";
        simbolInitializare[1] = "Caro";
        simbolInitializare[2] = "Inima Rosie";
        simbolInitializare[3] = "Inima Neagra";

        pachetDeCarti = new PachetDeCarti[numarCarti];
        int i = 0;
        for (int k = 0; k < 4; k++) {
            for (int valoare = 1; valoare <= 13; valoare++) {
                fata = "src/sample/PachetCarti/" + id + ".jpg";
                spate = "src/sample/PachetCarti/Red_back.jpg";
                pachetDeCarti[i++] = new PachetDeCarti(id, simbolInitializare[k], valoare, fata, spate);
                id++;
            }
        }
    }

    public PachetDeCarti(int id, String simbol, int valoare, String fata, String spate){
        this.id = id;
        this.simbol = simbol;
        this.valoare = valoare;
        this.fata = fata;
        this.spate = spate;
        nrPuncte = valoare;
        if(nrPuncte > 10)
            nrPuncte = 10;
        this.nrPuncte = nrPuncte;
    }

    public void show(){
        for(int i = 0; i< pachetDeCarti.length;i++) {
            System.out.println(pachetDeCarti[i].id + " " + pachetDeCarti[i].valoare + " " + pachetDeCarti[i].simbol + " " + " " + pachetDeCarti[i].nrPuncte + " " + pachetDeCarti[i].fata +  " " + pachetDeCarti[i].spate);

        }
    }

}
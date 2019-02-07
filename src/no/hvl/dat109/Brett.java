package no.hvl.dat109;

/*
    @author Herborg Irgens Sjo
 */
public class Brett {

    private char[][] brett;
    private char spelarBrikke;

    public Brett() {
        brett = new char[3][3];
        spelarBrikke = 'x';
        lagBrett();
    }

    /*
        Denne metoden lagar brettet.
        Startar på blankt brett kvar gong metoden blir kalla på.
     */
    public void lagBrett() {

        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                brett[i][j] = '-';
            }
        }
    }


    /*
        Denne metoden skriv ut brettet.
     */
    public void skrivutBrett() {
        System.out.println("--------------");

        for(int i = 0; i < 3; i++) {
            System.out.print("| ");
            for(int j = 0; j < 3; j++) {
                System.out.print(brett[i][j] + " | ");
            }
            System.out.println();
            System.out.println("--------------");
        }
    }

    /*
        Denne metoden skal sjekke om brettet er fullt.
     */
    public boolean erBrettetFullt() {
        boolean erFullt = true;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(brett[i][j] == '-') {
                    erFullt = false;
                }
            }
        }

        return erFullt;

    }

    public boolean sjekkSiger() {
        return (sjekkRadForSiger() || sjekkKolonneForSiger() || sjekkDiagonalForSiger());
    }

    private boolean sjekkRadForSiger() {
        for(int i = 0; i < 3; i++) {
            if(sjekkRadKolonne(brett[i][0], brett[1][i], brett[2][i]) == true) {
                return true;
            }
        }
        return false;
    }


    private boolean sjekkKolonneForSiger() {
        for(int i = 0; i < 3; i++) {
            if(sjekkRadKolonne(brett[0][i], brett[1][i], brett[2][i]) == true) {
                return true;
            }
        }
        return false;
    }

    private boolean sjekkDiagonalForSiger() {
        return (((sjekkRadKolonne(brett[0][0], brett[1][1], brett[2][2]) == true)
                || sjekkRadKolonne(brett[0][2], brett[1][1], brett[2][0]) == true));
    }

    private boolean sjekkRadKolonne(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }

    public void endreSpelar() {
        if(spelarBrikke == 'x') {
            spelarBrikke = 'o';
        } else {
            spelarBrikke = 'x';
        }
    }

    public boolean plasserBrikke(int rad, int kolonne) {
        if((rad >= 0) && (rad < 3)) {
            if((kolonne >= 0) && (kolonne < 3)) {
                if(brett[rad][kolonne] == '-') {
                    brett[rad][kolonne] = spelarBrikke;
                    return true;
                }
            }
        }

        return false;
    }

    public void nesteRunde() {
        System.out.println("//////////////");
    }
}

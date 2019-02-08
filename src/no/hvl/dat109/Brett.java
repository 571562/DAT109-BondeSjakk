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
            for (int j = 0; j < 3; j++) {
                brett[i][j] = '-';
            }
        }
    }


    /*
        Denne metoden skriv ut brettet.
     */
    public void skrivutBrett() {
        System.out.println("--------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
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

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (brett[i][j] == '-') {
                    erFullt = false;
                }
            }
        }

        return erFullt;

    }

    public boolean sjekkSiger() {

        return sjekkRader() || sjekkKolonner() || sjekkDiagonal();
    }

    private boolean sjekkRader() {

        for (int i = 0; i < 3; i++) {
            if (brett[i][0] == 'x' && brett[i][1] == 'x' && brett[i][2] == 'x') return true;
            else if (brett[i][0] == 'o' && brett[i][1] == 'o' && brett[i][2] == 'o') return true;
        }

        return false;
    }

    private boolean sjekkKolonner() {
        for (int i = 0; i < 3; i++) {
            if (brett[0][i] == 'x' && brett[1][i] == 'x' && brett[2][i] == 'x') return true;
            else if (brett[0][i] == 'o' && brett[1][i] == 'o' && brett[2][i] == 'o') return true;
        }

        return false;
    }

    private boolean sjekkDiagonal() {

        if (brett[0][0] == 'x' && brett[1][1]== 'x' && brett[2][2] == 'x') return true;
        else if (brett[0][0] == 'o' && brett[1][1]== 'o' && brett[2][2] == 'o') return true;
        else if (brett[2][0] == 'x' && brett[1][1]== 'x' && brett[0][2] == 'x') return true;
        else return brett[2][0] == 'o' && brett[1][1] == 'o' && brett[0][2] == 'o';

    }


    public void endreSpelar() {
        if (spelarBrikke == 'x') {
            spelarBrikke = 'o';
        } else {
            spelarBrikke = 'x';
        }
    }

    public boolean plasserBrikke(int rad, int kolonne) {
        if ((rad >= 0) && (rad < 3)) {
            if ((kolonne >= 0) && (kolonne < 3)) {
                if (brett[rad][kolonne] == '-') {
                    brett[rad][kolonne] = spelarBrikke;
                    return true;
                }
            }
        }

        return false;
    }


    public char[][] getBrett() {
        return brett;
    }

    public void setBrett(char[][] brett) {
        this.brett = brett;
    }

    public char getSpelarBrikke() {
        return spelarBrikke;
    }

    public void setSpelarBrikke(char spelarBrikke) {
        this.spelarBrikke = spelarBrikke;
    }
}

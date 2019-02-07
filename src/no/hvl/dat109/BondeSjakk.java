package no.hvl.dat109;/*
    @author Herborg Irgens Sjo
 */

import no.hvl.dat109.Brett;

import java.util.Scanner;

public class BondeSjakk {

    static Scanner scan;
    public static Brett brett;


    public static void main(String[] args) {
        String vinnar = null;
        scan = new Scanner(System.in);

        Brett brett = new Brett();
        System.out.println("Velkommen til Bondesjakk: ");
        System.out.println("--------------------------");
        brett.skrivutBrett();
        System.out.println("x er fyrste spelar, skriv inn rad(1-3) og kolonne(1-3) for å plassera brikka.");

        while(vinnar == null) {
            int rad;
            int kolonne;
            try {
                rad = scan.nextInt() - 1;
                kolonne = scan.nextInt() - 1;
                brett.plasserBrikke(rad,kolonne);
                brett.skrivutBrett();
                System.out.println("Neste runde! o sin tur.");
                brett.endreSpelar();
                rad = scan.nextInt() - 1;
                kolonne = scan.nextInt() - 1;
                brett.plasserBrikke(rad, kolonne);
                brett.skrivutBrett();
            } catch (NullPointerException e) {
                System.out.println("Det skjedde ein feil.");
            }
        }


    }
}

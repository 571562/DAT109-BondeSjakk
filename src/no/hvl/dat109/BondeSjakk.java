package no.hvl.dat109;/*
    @author Herborg Irgens Sjo
 */

import no.hvl.dat109.Brett;

import java.util.Scanner;

public class BondeSjakk {

    static Scanner scan;
    public static Brett brett;


    public static void main(String[] args) {
        scan = new Scanner(System.in);

        Brett brett = new Brett();
        System.out.println("Velkommen til Bondesjakk: ");
        System.out.println("--------------------------");
        brett.skrivutBrett();
        System.out.println("x er fyrste spelar, skriv inn rad(1-3) og kolonne(1-3) for å plassera brikka.");

        while (!brett.erBrettetFullt()) {
            int rad;
            int kolonne;
            try {
                rad = scan.nextInt() - 1;
                kolonne = scan.nextInt() - 1;
                brett.plasserBrikke(rad, kolonne);
                brett.skrivutBrett();
                if (brett.sjekkSiger()) break;
                System.out.println("Neste spelar sin tur!");
                brett.endreSpelar();

            } catch (NullPointerException e) {
                System.out.println("Det skjedde ein feil.");
            }
        }

        System.out.println("Gratulerar spelar " + brett.getSpelarBrikke() + " du er ein vinnar!");


    }
}

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main{
    //TODO eventuell _idx bei jedem Programmneustart löschen, weil sonst wird immer nur angehängt...
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        //Passiert bei jedem Programmstart
        DatenVerwaltung.initFiles();
        DatenVerwaltung.initIndexPaare();
        int auswahl = -1;
        while(auswahl != 5){
            System.out.println(
                    "1) Erfassen eines neuen Datensatzes.\n" +
                            "2) Alle Datensatze aus artikel.dat anzeigen.\n" +
                            "3) ISAM-Indexliste anzeigen und Datensatz anhand der Artikel-Nummer suchen.\n" +
                            "4) ISAM-Indexliste anhand Artikelnummer durchsuchen.\n"+
                            "5) ISAM-Indexliste persistieren und das Program beenden.\n");
            try{
                auswahl = Integer.parseInt(sc.nextLine());
                if(auswahl < 1 || auswahl > 5) throw new NumberFormatException();
            }catch(NumberFormatException e){
                System.out.println("Bitte eine Nummer zwischen 1 und 5 eingeben.");
            }

            //noch ein case zum Suchen der artnr
            switch(auswahl){
                case 1: DatenVerwaltung.datensatzErfassen();
                    break;
                case 2: DatenVerwaltung.showDatensaetze();
                    break;
                case 3: Indexpaar.showIndexPaare(DatenVerwaltung.alleIndexPaare);
                    break;
                case 4: Indexpaar.searchIndexPaare(DatenVerwaltung.alleIndexPaare, DatenVerwaltung.alleArtikel, sc);
                    break;
                case 5: Indexpaar.writeMultiple(DatenVerwaltung.alleIndexPaare);
                    break;
            }
        }
    }
}
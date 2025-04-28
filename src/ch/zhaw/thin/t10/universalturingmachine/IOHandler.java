package ch.zhaw.thin.t10.universalturingmachine;

import java.util.Scanner;

/**
 * Hilfsklasse für die Ein-/Ausgabe
 */
public class IOHandler {
    private final Scanner scanner;

    /**
     * Konstruktor
     */
    public IOHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Liest einen String von der Konsole ein
     */
    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    /**
     * Liest eine Ja/Nein-Antwort ein
     */
    public boolean readBoolean(String prompt) {
        while (true) {
            System.out.print(prompt + " (j/n): ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("j") || input.equals("ja")) return true;
            if (input.equals("n") || input.equals("nein")) return false;
            System.out.println("Fehler: Bitte antworten Sie mit j/n.");
        }
    }

    /**
     * Gibt eine Nachricht mit Zeilenumbruch aus
     */
    public void println(String message) {
        System.out.println(message);
    }

    /**
     * Wartet auf die Enter-Taste
     */
    public void waitForEnter(String prompt) {
        System.out.print(prompt);
        scanner.nextLine();
    }
}
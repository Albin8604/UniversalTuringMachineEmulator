package ch.zhaw.thin.t10.universalturingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hauptklasse für die Turingmaschine
 */
public class Main {
    private static final IOHandler IO_HANDLER = new IOHandler(new Scanner(System.in));

    /**
     * Hauptmethode
     *
     * @param args Argumente der Kommandozeile
     */
    public static void main(String[] args) {
        new Main().run();
    }

    /**
     * Führt die Turingmaschine aus
     */
    private void run() {
        String tmCoding = IO_HANDLER.readString("Bitte gebe deine TM Codierung ein (Binaer): ");
        List<Transition> transitions = parseTmCoding(tmCoding);

        IO_HANDLER.println("Übersetzte TM-Codierung:");
        for (Transition transition : transitions) {
            IO_HANDLER.println(transition.toString());
        }

        String input = IO_HANDLER.readString("Bitte gebe die Eingabe für die TM ein: ");

        boolean stepMode = IO_HANDLER.readBoolean("Möchten Sie im Step-Modus ausführen?");

        TuringMachine turingMachine = new TuringMachine(transitions, input);

        if (stepMode) {
            do {
                displayMachineState(turingMachine);
                if (turingMachine.isHalted()) {
                    IO_HANDLER.println("Die Turingmaschine hat angehalten.");
                    break;
                }
                IO_HANDLER.waitForEnter("Drücken Sie Enter für den nächsten Schritt...");
            } while (turingMachine.step());

            if (turingMachine.isHalted()) {
                displayMachineState(turingMachine);
            }
        } else {
            turingMachine.run();
            IO_HANDLER.println("Berechnung abgeschlossen.");
            displayMachineState(turingMachine);
        }
    }

    /**
     * Zeigt den aktuellen Zustand der Turingmaschine an
     *
     * @param turingMachine die Turingmaschine
     */
    private void displayMachineState(TuringMachine turingMachine) {
        String separator = "----------------------------------------";
        IO_HANDLER.println(separator);

        IO_HANDLER.println("Aktueller Zustand: q" + turingMachine.getCurrentState());

        IO_HANDLER.println("Berechnungsschritte: " + turingMachine.getSteps());

        String tapeState = turingMachine.getTapeState();
        IO_HANDLER.println("\nBand:");

        StringBuilder pointerBuilder = new StringBuilder();
        for (int i = 0; i < tapeState.length(); i++) {
            if (i == turingMachine.getRelativeHeadPosition()) {
                pointerBuilder.append("▲");
            } else {
                pointerBuilder.append(" ");
            }
        }

        IO_HANDLER.println(tapeState);
        IO_HANDLER.println(pointerBuilder.toString());

        if (turingMachine.isHalted()) {
            IO_HANDLER.println("\n" + separator);
            IO_HANDLER.println("STATUS: TM ANGEHALTEN");
            IO_HANDLER.println("ERGEBNIS: " + turingMachine.getResult());
            IO_HANDLER.println(separator);
        }
    }

    /**
     * Parst die TM-Codierung und gibt eine Liste von Transitionen zurück
     *
     * @param tmCoding die TM-Codierung
     * @return Liste von Transitionen
     */
    private List<Transition> parseTmCoding(String tmCoding) {
        final List<Transition> transitions = new ArrayList<>();
        if (tmCoding.startsWith("1")) {
            tmCoding = tmCoding.replaceFirst("1", "");
        }

        tmCoding = tmCoding.replace("11", "1");

        final String[] split = tmCoding.split("1");

        for (int i = 0; i < split.length; i += 5) {
            Transition transition = new Transition();
            transition.setState(split[i].length());
            transition.setRead(readWriteParser(split[i + 1].length()));
            transition.setNextState(split[i + 2].length());
            transition.setWrite(readWriteParser(split[i + 3].length()));
            transition.setMove(moveParser(split[i + 4].length()));
            transitions.add(transition);
        }

        return transitions;
    }

    /**
     * Parser für die Lese-/Schreiboperationen
     *
     * @param zeroCount Anzahl der Nullen
     * @return Zeichen für die Lese-/Schreiboperation
     */
    private char readWriteParser(int zeroCount) {
        return switch (zeroCount) {
            case 1 -> '0';
            case 2 -> '1';
            case 3 -> '_';
            default -> (char) (93 + zeroCount);
        };
    }

    /**
     * Parser für die Bewegungsoperationen
     *
     * @param zeroCount Anzahl der Nullen
     * @return Zeichen für die Bewegungsoperation
     */
    private char moveParser(int zeroCount) {
        if (zeroCount == 1) {
            return 'L';
        }
        return 'R';
    }
}

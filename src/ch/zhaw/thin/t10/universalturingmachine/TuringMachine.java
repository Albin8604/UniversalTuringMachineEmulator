package ch.zhaw.thin.t10.universalturingmachine;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse für die Turingmaschine
 */
public class TuringMachine {
    private final List<Transition> transitions;
    private final List<Character> tape;
    private int headPosition;
    private int currentState;
    private int steps;
    private boolean halted;
    private static final char BLANK = '_';

    /**
     * Konstruktor
     *
     * @param transitions Liste der Transitionen
     * @param input       Eingabe für die Turingmaschine
     */
    public TuringMachine(List<Transition> transitions, String input) {
        this.transitions = transitions;
        this.tape = new ArrayList<>();

        if (input.isEmpty()) {
            tape.add(BLANK);
        } else {
            for (char c : input.toCharArray()) {
                tape.add(c);
            }
        }

        this.headPosition = 0;
        this.currentState = 1;
        this.steps = 0;
        this.halted = false;
    }

    /**
     * Führt einen Schritt der Turingmaschine aus
     *
     * @return true, wenn die Turingmaschine weiterläuft, false, wenn sie angehalten hat
     */
    public boolean step() {
        if (halted) return false;

        char currentSymbol = tape.get(headPosition);

        Transition matchingTransition = null;
        for (Transition t : transitions) {
            if (t.getState() == currentState && t.getRead() == currentSymbol) {
                matchingTransition = t;
                break;
            }
        }

        if (matchingTransition == null) {
            halted = true;
            return false;
        }

        tape.set(headPosition, matchingTransition.getWrite());

        if (matchingTransition.getMove() == 'L') {
            headPosition--;
            if (headPosition < 0) {
                tape.addFirst(BLANK);
                headPosition = 0;
            }
        } else {
            headPosition++;
            if (headPosition >= tape.size()) {
                tape.add(BLANK);
            }
        }

        currentState = matchingTransition.getNextState();
        steps++;

        return true;
    }

    /**
     * Führt die Turingmaschine bis zum Halt aus
     */
    public void run() {
        while (step()) {}
    }

    /**
     * Gibt den aktuellen Zustand des Bandes zurück
     *
     * @return String mit dem aktuellen Zustand des Bandes
     */
    public String getTapeState() {
        StringBuilder result = new StringBuilder();

        for (int i = headPosition - 15; i <= headPosition + 15; i++) {
            if (i < 0 || i >= tape.size()) {
                result.append(BLANK);
            } else {
                result.append(tape.get(i));
            }
        }

        return result.toString();
    }

    public int getRelativeHeadPosition() {
        return 15;
    }

    public int getCurrentState() {
        return currentState;
    }

    public int getSteps() {
        return steps;
    }

    public boolean isHalted() {
        return halted;
    }

    public String getResult() {
        StringBuilder result = new StringBuilder();
        for (char c : tape) {
            if (c != BLANK) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
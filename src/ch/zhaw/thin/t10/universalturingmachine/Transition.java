package ch.zhaw.thin.t10.universalturingmachine;

/**
 * Klasse für die Transition einer Turingmaschine
 */
public class Transition {
    private int state;
    private char read;
    private int nextState;
    private char write;
    private char move;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public char getRead() {
        return read;
    }

    public void setRead(char read) {
        this.read = read;
    }

    public int getNextState() {
        return nextState;
    }

    public void setNextState(int nextState) {
        this.nextState = nextState;
    }

    public char getWrite() {
        return write;
    }

    public void setWrite(char write) {
        this.write = write;
    }

    public char getMove() {
        return move;
    }

    public void setMove(char move) {
        this.move = move;
    }

    @Override
    public String toString() {
        return String.format("(%-10s, %c) = (%-10s, %c, %c)",
                buildStateString(state),
                read,
                buildStateString(nextState),
                write,
                move);
    }

    /**
     * Hilfsmethode um den Zustand in einen String zu konvertieren
     *
     * @param state der Zustand
     * @return der Zustand als String
     */
    private String buildStateString(int state) {
        String stateStr = "q" + state;
        if (state == 1) {
            stateStr += " Start";
        } else if (state == 2) {
            stateStr += " Ende";
        }
        return stateStr;
    }
}


public class Puzzle {
    private final int ID;
    private final String DESCRIPTION;
    private final String SOLUTION;
    private final int ATTEMPTS;

    private final String HINT;
    public boolean isSolved;

    public Puzzle(int ID, String description, String solution, int attempts, String hint) {
        this.ID = ID;
        this.DESCRIPTION = description;
        this.SOLUTION = solution;
        this.ATTEMPTS = attempts;
        this.HINT = hint;
        this.isSolved = false;
    }

    public int getATTEMPTS() {
        return this.ATTEMPTS;
    }

    public boolean getIsSolved() {
        return this.isSolved;
    }

    public void setIsSolved(boolean isSolved) {
        this.isSolved = isSolved;
    }

    public String toString() {
        return "[" + this.ID + " " +
                this.DESCRIPTION + " " +
                this.SOLUTION + " " +
                this.ATTEMPTS + " " +
                this.HINT;
    }
}

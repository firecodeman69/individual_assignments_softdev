import java.util.Scanner;

public class Puzzle {
    public final int ID;
    public final String DESCRIPTION;
    public final String SOLUTION;
    public int attempts;

    public final String HINT;
    public boolean isSolved;

    public Puzzle(int ID, String description, String solution, int attempts, String hint) {
        this.ID = ID;
        this.DESCRIPTION = description;
        this.SOLUTION = solution;
        this.attempts = attempts;
        this.HINT = hint;
        this.isSolved = false;
    }

    public int getATTEMPTS() {
        return this.attempts;
    }

    public boolean getIsSolved() {
        return this.isSolved;
    }

    public void setIsSolved(boolean isSolved) {
        this.isSolved = isSolved;
    }

    public boolean solvePuzzle(String input){
        if (this.SOLUTION.equalsIgnoreCase(input)) {return true;}
        else {return false;}
    }

    public String toString() {
        return "[" + this.ID + " " +
                this.DESCRIPTION + " " +
                this.SOLUTION + " " +
                this.attempts + " " +
                this.HINT;
    }
}

import java.util.Scanner;

public class Puzzle {
    public final int ID; //The puzzle Id - doesn't really have implementation, but thinking data-wise, it needs to be here.
    public final String DESCRIPTION; //The puzzle itself. In this assignment, they are fill in the blank questions.
    public final String SOLUTION; //The answer or solution to the puzzle
    public int attempts; //Number of attempts that a puzzle allows before failing
    public final String HINT; //Represents a hint from the puzzle
    public boolean isSolved; //Used to control the puzzle game loop

    public Puzzle(int ID, String description, String solution, int attempts, String hint) { //Basic constructor to set Puzzle objects
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

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }


    /**************************Commented out because unimplemented at the moment****************************
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

     ****************************************************************************************/

    public String toString() {
        return "[" + this.ID + " " +
                this.DESCRIPTION + " " +
                this.SOLUTION + " " +
                this.attempts + " " +
                this.HINT;
    }
}

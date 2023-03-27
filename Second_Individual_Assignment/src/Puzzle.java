import java.util.Scanner;

public class Puzzle {
    public final int ID; //Puzzle Id
    public final String DESCRIPTION; //Question or riddle for puzzle. Could be a general description
    public final String SOLUTION; //Solution to the puzzle
    public int attempts; //Number of attempts allowed for a puzzle

    public final String HINT; //Hint for the puzzle
    public boolean isSolved; //Has the puzzle been solved

    public Puzzle(int ID, String description, String solution, int attempts, String hint) { //Create puzzle objects
        this.ID = ID;
        this.DESCRIPTION = description;
        this.SOLUTION = solution;
        this.attempts = attempts;
        this.HINT = hint;
        this.isSolved = false;
    }

    public int getATTEMPTS() { //Get number of attempts
        return this.attempts;
    }

    public boolean getIsSolved() { //Check if the puzzle has been solved
        return this.isSolved;
    }

    public void setIsSolved(boolean isSolved) { //Set the solved status of the puzzle
        this.isSolved = isSolved;
    }

    public void setAttempts(int attempts) { //Set the number of attempts allowed for a puzzle
        this.attempts = attempts;
    }

    public String toString() {
        return "[" + this.ID + " " +
                this.DESCRIPTION + " " +
                this.SOLUTION + " " +
                this.attempts + " " +
                this.HINT;
    }


    /***********************************************Method Dump*****************************************************/

//    public boolean solvePuzzle(String input) {
//        if (this.SOLUTION.equalsIgnoreCase(input)) {
//            return true;
//        } else {
//            return false;
//        }
//    }


}

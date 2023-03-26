import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Map {
    ArrayList<Room> gameRooms;
    ArrayList<Item> allItems;
    ArrayList<Puzzle> allPuzzles;

    public void newRoom() {
        Room room;
        Scanner sc;
        ArrayList<Room> roomAL = new ArrayList<>();
        try {
            sc = new Scanner(new File("map.txt"));
            while (sc.hasNextLine()) {
                for (int i = 0; i < 7; i++) {
                    room = new Room(sc.nextInt() //RoomID
                            , sc.next() //Room Name/Desc
                            , sc.nextBoolean() //Has been visited
                            , sc.nextBoolean() //Can have Item
                            , sc.nextBoolean() //Can have Puzzle
                            , sc.nextInt() //North RoomId
                            , sc.nextInt() //East RoomId
                            , sc.nextInt() //South RoomId
                            , sc.nextInt()); //West RoomId
                    roomAL.add(room);
                }
            }//end while
            sc.close();
        }//end try
        catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("IOException!" +
                    "No file exists! " +
                    "Please make sure that the file exists and try again.");
        } catch (NoSuchElementException ignored) {
        }
        this.gameRooms = roomAL;
    }

    public void newItem() {
        Item item;
        Scanner sc;
        ArrayList<Item> allItems = new ArrayList<>();
        try {
            sc = new Scanner(new File("item.txt"));
            for (int i = 0; i < 4; i++) {
                {
                    item = new Item(sc.nextLine() //Item name
                            , sc.nextLine()); //Item description

                    allItems.add(item);
                }
            }//end while
            sc.close();
        }//end try
        catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("IOException!" +
                    "No file exists! " +
                    "Please make sure that the file exists and try again.");
        } catch (NoSuchElementException ignored) {
        }
        this.allItems = allItems;
    }

    public void newPuzzle() {
        Puzzle puzzle;
        Scanner sc;
        ArrayList<Puzzle> puzzleAL = new ArrayList<>();
        try {
            sc = new Scanner(new File("puzzle.txt"));

            while (sc.hasNextLine()) {
                for (int i = 0; i < 2; i++) {
                    puzzle = new Puzzle(Integer.parseInt(sc.nextLine()) //PuzzleId
                            , sc.nextLine() //Description
                            , sc.nextLine() //Solution
                            , Integer.parseInt(sc.nextLine()) //Attempts Allowed
                            , sc.nextLine()); //Hints
                    puzzleAL.add(puzzle);
                }
            }//end while
            sc.close();
        }//end try
        catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("IOException!" +
                    "No file exists! " +
                    "Please make sure that the file exists and try again.");
        } catch (NoSuchElementException ignored) {
        }
        this.allPuzzles = puzzleAL;
    }

    public Puzzle getPuzzle (int num) {
        return this.allPuzzles.get(num);
    }

    public void removePossiblePuzzle (int num) {
        this.allPuzzles.remove(num);
    }
}

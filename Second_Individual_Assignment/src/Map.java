import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Map {
    ArrayList<Room> gameRooms;
    ArrayList<Item> allItems;

    public void newRoom() {
        Room room;
        Scanner sc;
        ArrayList<Room> roomAL = new ArrayList<>();
        try {
            sc = new Scanner(new File("map.txt"));
            //System.out.println("Loading in your map. Please standby.");

            while (sc.hasNextLine()) {
                for (int i = 0; i < 7; i++) {
                    room = new Room(sc.nextInt()
                            , sc.next()
                            , sc.nextBoolean()
                            , sc.nextBoolean()
                            , sc.nextInt()
                            , sc.nextInt()
                            , sc.nextInt()
                            , sc.nextInt());
                    roomAL.add(room);
                    //System.out.println(room);
                }
                //game.printRooms(roomAL);
            }//end while
            sc.close();
        }//end try
        catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("IOException!" +
                    "No file exists! " +
                    "Please make sure that the file exists and try again.");
        } catch (NoSuchElementException nsee) {
            //nsee.printStackTrace();
            //System.out.println("No Such Element!");
        } finally {
            //System.out.println("The map loading has been completed.\n");
        }
        this.gameRooms = roomAL;
    }

    public void newItem() {
        Item item;
        Scanner sc;
        ArrayList<Item> allItems = new ArrayList<>();
        try {
            sc = new Scanner(new File("item.txt"));
            //System.out.println("Reading in items.");
            for (int i = 0; i < 3; i++) {
                {
                    item = new Item(sc.nextLine()
                            , sc.nextLine());

                    allItems.add(item);
                    //System.out.println(item);
                }
                //game.printRooms(allItems);
            }//end while
            sc.close();
        }//end try
        catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("IOException!" +
                    "No file exists! " +
                    "Please make sure that the file exists and try again.");
        } catch (NoSuchElementException nsee) {
            //nsee.printStackTrace();
            //System.out.println("No Such Element!");
        } finally {
            //System.out.println("The item reading has been completed.\n");
//            for (Item i: allItems) {
//                System.out.println(i);
//            }
        }
        this.allItems = allItems;
    }
}

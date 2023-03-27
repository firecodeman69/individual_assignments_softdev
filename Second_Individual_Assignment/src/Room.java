import java.util.ArrayList;

public class Room {
    public final int ROOMNUMBER; //Id number for the room
    private final String ROOMDESCRIPTION; //The description of the room
    public boolean alreadyVisited; //Keep track of whether the room has been visited in the game or not
    public int northRoom; //Room Id to the north
    public int eastRoom; //Room Id to the east
    public int southRoom; //Room Id to the south
    public int westRoom; //Room Id to the west
    public ArrayList<Item> roomItems = new ArrayList<>(); //A list of all the items in a room
    public Puzzle roomPuzzle; //The puzzle in the room
    private boolean canHaveItem; //Does the room allow items
    private boolean canHavePuzzle; //Does the room allow puzzles
    //public Item roomItem;

    public Room(int roomNumber, String roomDescription, boolean alreadyVisited, boolean canHaveItem, boolean canHavePuzzle
            , int northRoom, int eastRoom, int southRoom, int westRoom) { //Constructor to create the rooms in the game
        this.ROOMNUMBER = roomNumber;
        this.ROOMDESCRIPTION = roomDescription;
        this.alreadyVisited = alreadyVisited;
        this.canHaveItem = canHaveItem;
        this.canHavePuzzle = canHavePuzzle;
        this.northRoom = northRoom;
        this.eastRoom = eastRoom;
        this.southRoom = southRoom;
        this.westRoom = westRoom;
        this.roomPuzzle = null;
    }

    public boolean hasItem(String name) { //Check to see if an item is in the room by item name
        for (Item i : this.roomItems) {
            if (i.getName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    public boolean hasItems() { //Check to see if an item is in the room by item name
        return this.roomItems != null;
    }

    public boolean hasPuzzle() { //Check to see if the room has a puzzle
        return this.roomPuzzle != null;
    }
    public boolean getCanHavePuzzle() { //Check if the room can have a puzzle
        return this.canHavePuzzle;
    }
    public void setRoomPuzzle(Puzzle puzzle) { //Set the room puzzle
        this.roomPuzzle = puzzle;
    }
    public Puzzle getRoomPuzzle() { //Get the room puzzle
        return this.roomPuzzle;
    }
    public void setAlreadyVisited(boolean alreadyVisited) { //Set the room to visited or not
        this.alreadyVisited = alreadyVisited;
    }

    public boolean getAlreadyVisited() { //Check whether the room has been visited or not
        return this.alreadyVisited;
    }

    public boolean getCanHaveItem() { //Check if the room can have an item
        return this.canHaveItem;
    }

    public String getRoomItems() { //Return a list of items in a room
        return this.roomItems.toString();
    }
    public void removeItem(String name) { //Remove an item from the room
        for (Item i : roomItems) {
            if (i.getName().equalsIgnoreCase(name)) {
                roomItems.remove(i);
                break;
            }
        }
    }

    public String toString() {
        return "[" + this.ROOMNUMBER + " " + this.ROOMDESCRIPTION
                + " | " + this.northRoom + " is to the north | "
                + " " + this.eastRoom + " is to the east | "
                + " " + this.southRoom + " is to the south |"
                + " " + this.westRoom + " is to the west ]\n";
    }

/********************************************Method dump****************************************************

//    public void addRandomItemToRoom(Room room) {
//        Map map = new Map();
//        if (room.getCanHaveItem()) {
//            int randNum = (int) (Math.random() * map.allItems.size());
//            roomItems.add(map.allItems.get(randNum));
//            map.allItems.remove(randNum);
//        }
//    }


//    public Rooms getCurrentRoom(ArrayList<Rooms> currentRoom, int index) {
//        index = index -1;
//        return (currentRoom.get(index));
//    }

    public String toString() { //toString for room objects
        return ("[" + this.ROOMNUMBER + " "
                + this.ROOMDESCRIPTION + ": "
                + this.northRoom + " is to the North, "
                + this.eastRoom + " is to the East, "
                + this.southRoom + " is to the South, "
                + this.westRoom + " is to the West.]"
        );
    }

 public int getRoomNumber() {
 return this.ROOMNUMBER;
 }

 public String getRoomDescription() {
 return this.ROOMDESCRIPTION;
 }

 //    public void startPuzzle() {
 //        while (!this.roomPuzzle.isSolved) {
 //            for (int i = 0; i < this.roomPuzzle.ATTEMPTS; i++) {
 //                System.out.println(this.roomPuzzle.DESCRIPTION);
 //            }
 //        }
 //    }

 public void setRoomItems(Item roomItem) {
 Map map = new Map();
 this.roomItems = map.allItems;
 }

 public Puzzle getRoomPuzzle() {
 return this.roomPuzzle;
 }

 public Item getItem(String name) {
 for (Item i : this.roomItems) {
 if (i.getName().equalsIgnoreCase(name)) return i;
 }
 return null;
 }
 ***********************************************************************************************************/

}

import java.util.ArrayList;

public class Room {
    public final int ROOMNUMBER;
    private final String ROOMDESCRIPTION;
    public boolean alreadyVisited;
    public int northRoom;
    public int eastRoom;
    public int southRoom;
    public int westRoom;
    public ArrayList<Item> roomItems = new ArrayList<>();
    public Puzzle roomPuzzle;
    private boolean canHaveItem;
    private boolean canHavePuzzle;
    //public Item roomItem;

    public Room(int roomNumber, String roomDescription, boolean alreadyVisited, boolean canHaveItem, boolean canHavePuzzle, int northRoom, int eastRoom, int southRoom, int westRoom) {
        this.ROOMNUMBER = roomNumber;
        this.ROOMDESCRIPTION = roomDescription;
        this.alreadyVisited = alreadyVisited;
        this.canHaveItem = canHaveItem;
        this.canHavePuzzle = canHavePuzzle;
        this.northRoom = northRoom;
        this.eastRoom = eastRoom;
        this.southRoom = southRoom;
        this.westRoom = westRoom;
    }

    public int getRoomNumber() {
        return this.ROOMNUMBER;
    }

//    public void setRoomNumber(int roomNumber) {
//        this.roomNumber = roomNumber;
//    }

    public String getRoomDescription() {
        return this.ROOMDESCRIPTION;
    }

//    public void setRoomDescription(String roomDescription) {
//        this.roomDescription = roomDescription;
//    }

    public boolean hasItem(String name) {
        for(Item i: this.roomItems) {
            if(i.getName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    public Item getItem(String name) {
        for(Item i: this.roomItems) {
            if(i.getName().equalsIgnoreCase(name)) return i;
        }
        return null;
    }

//    public String printRoomAssociations() {
//        for (Rooms r: roomsAL) {
//            r.getRoomAssociations();
//        }
//    }

//    public void setRoomAssociations(int roomAssociations) {
//        this.roomAssociations = roomAssociations;
//    }//end setRoomAssociations

//    public boolean getAlreadyVisited() {
//        return this.alreadyVisited;
//    }

    public boolean getCanHavePuzzle() {
        if (this.canHavePuzzle) return true;
        else return false;
    }

    public boolean hasPuzzle() {
            return this.roomPuzzle != null;
    }

//    public void startPuzzle() {
//        while (!this.roomPuzzle.isSolved) {
//            for (int i = 0; i < this.roomPuzzle.ATTEMPTS; i++) {
//                System.out.println(this.roomPuzzle.DESCRIPTION);
//            }
//        }
//    }

    public void setAlreadyVisited(boolean alreadyVisited) {
        this.alreadyVisited = alreadyVisited;
    }

    public boolean getAlreadyVisited() {
        return this.alreadyVisited;
    }

    public boolean getCanHaveItem() {
        return this.canHaveItem;
    }

    public String getRoomItems() {
        for (Item i: this.roomItems) {
            return i.toString();
        }
        return null;
    }

    public void setRoomItems(Item roomItem) {
        Map map = new Map();
        this.roomItems = map.allItems;
    }

    public void removeItem(String name) {
        for (Item i: roomItems) {
            if (i.getName().equalsIgnoreCase(name)) {
                roomItems.remove(i);
                break;
            }
        }
    }


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

    public String toString() {
            return ("[" + this.ROOMNUMBER + " "
                + this.ROOMDESCRIPTION + ": "
                + this.northRoom + " is to the North, "
                + this.eastRoom + " is to the East, "
                + this.southRoom + " is to the South, "
                + this.westRoom + " is to the West.]"
        );
    }

}

import java.util.ArrayList;

public class Player {
    //public int playerHealth;
    public String playerName;
    public boolean keepPlaying;
    //public String movement;
    public Room currentRoom;
    public Room previousRoom;

    public Map map;

    public ArrayList<Item> inventory;


    public Player() {
        this.keepPlaying = true;
        this.map = new Map();
        map.newItem();
        map.newPuzzle();
        map.newRoom();
        this.currentRoom = map.gameRooms.get(0);
        addRandomItemToRoom();
        addRandomPuzzleToRoom();
        this.inventory = new ArrayList<>();
        System.out.println("New player template created.\n");
    }

//    public void loadPlayer(String playerName, Room currentRoom, Map map, ArrayList<Item> inventory) {
//        this.keepPlaying = true;
//        this.playerName = playerName;
//        this.currentRoom = currentRoom;
//        this.map = map;
//        this.inventory = inventory;
//        System.out.println("Player loaded successfully.");
//    }


//    public int getPlayerHealth() {
//        return this.playerHealth;
//    }
//
//    public void setPlayerHealth(int playerHealth) {
//        this.playerHealth = playerHealth;
//    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public boolean getKeepPlaying() {
        return this.keepPlaying;
    }

    public boolean currentRoomHasPuzzle() {
        if (this.currentRoom.roomPuzzle != null) return true;
        else {
            return false;
        }
    }

    public boolean currentRoomPuzzleSolved() {
        if (this.currentRoom.roomPuzzle.isSolved) return true;
        else {
            return false;
        }
    }

    public void setKeepPlaying(boolean keepPlaying) {
        this.keepPlaying = keepPlaying;
        if (!keepPlaying) System.out.println("Thank you for playing! See you later.");
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public Room getPreviousRoom() {
        return this.previousRoom;
    }

    public void setPreviousRoom(Room room) {
        this.previousRoom = room;
    }

    public boolean hasItem(String name) {
        for (Item i : this.inventory) {
            if (i.getName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    public String inspectItem(String name) {
        for (Item i : inventory) {
            if (i.getName().equalsIgnoreCase(name)) {
                return i.getDescription();
            }
        }
        return null;
    }

    public void setCurrentRoom(ArrayList<Room> roomAL, int roomDirection) {
        this.currentRoom = roomAL.get(roomDirection - 1);
    }

    public void addRandomItemToRoom() {
        for (Room r : map.gameRooms) {
            if (r.getCanHaveItem() && map.allItems.size() > 0) {
                int randNum = (int) (Math.random() * map.allItems.size());
                r.roomItems.add(map.allItems.get(randNum));
                map.allItems.remove(randNum);
            }
        }
    }

    public void addRandomPuzzleToRoom() {
        for (Room r : map.gameRooms) {
            if (r.getCanHavePuzzle() && map.allPuzzles.size() > 0) {
                int randNum = (int) (Math.random() * map.allPuzzles.size());
                r.setRoomPuzzle(map.getPuzzle(randNum));
                map.removePossiblePuzzle(randNum);
            }
        }
    }

    public String showInventory() {
        if (this.inventory != null) {
            ArrayList<Item> itemAL = new ArrayList<>();
            for (Item item : this.inventory) {
                itemAL.add(item);
            }
            return itemAL.toString();
        } else {
            return ("You don't have any items in your inventory.");
        }
    }

    public Item getRoomItem(String name) {
        for (Item i : this.currentRoom.roomItems) {
            if (i.getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return null;
    }

    public void addToInventory(Item item) {
        this.inventory.add(item);
        System.out.println(item.getName() + " was added to your inventory. Use command Inventory to see it now.");
    }

    public void dropItem(String name) {
        for (Item i : this.inventory) {
            if (i.getName().equalsIgnoreCase(name)) {
                this.currentRoom.roomItems.add(i);
                this.inventory.remove(i);
                break;
            }
        }
        //System.err.println("You do not have that item in your inventory.");
    }

    public void setVisited() {
        this.currentRoom.setAlreadyVisited(true);
    }

    public int getNorthRoom() {
        return this.currentRoom.northRoom;
    }

    public int getEastRoom() {
        return this.currentRoom.eastRoom;
    }

    public int getSouthRoom() {
        return this.currentRoom.southRoom;
    }

    public int getWestRoom() {
        return this.currentRoom.northRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }
}
import java.util.ArrayList;
public class Player {
    //public int playerHealth;
    public String playerName;
    public boolean keepPlaying;
    //public String movement;
    public Room currentRoom;

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

    public void setKeepPlaying(boolean keepPlaying) {
        this.keepPlaying = keepPlaying;
        if (!keepPlaying) System.out.println("Thank you for playing! See you later.");
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public boolean hasItem(String name) {
        for(Item i: this.inventory) {
            if(i.getName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    public String inspectItem (String name) {
            for (Item i: inventory) {
                if (i.getName().equalsIgnoreCase(name)) {
                    return i.getDescription();
                }
            }
            return null;
    }

    public Room setCurrentRoom(ArrayList<Room> roomAL, int roomDirection) {
        return roomAL.get(roomDirection - 1);
    }

    public void addRandomItemToRoom() {
        for (Room r: map.gameRooms) {
            if (r.getCanHaveItem() && map.allItems.size() > 0) {
                int randNum = (int) (Math.random() * map.allItems.size());
                r.roomItems.add(map.allItems.get(randNum));
                map.allItems.remove(randNum);
            }
        }
    }

    public void addRandomPuzzleToRoom() {
        for (Room r: map.gameRooms) {
            if (r.getCanHavePuzzle() && map.allPuzzles.size() > 0) {
                int randNum = (int) (Math.random() * map.allPuzzles.size());
                r.roomPuzzle = map.allPuzzles.get(randNum);
                map.allPuzzles.remove(randNum);
            }
        }
    }

    public void dropItem(String name) {
        for(Item i: this.inventory) {
            if (i.getName().equalsIgnoreCase(name)) {
                this.currentRoom.roomItems.add(i);
                this.inventory.remove(i);
                break;
            }
        }
        System.err.println("You do not have that item in your inventory.");
    }
}
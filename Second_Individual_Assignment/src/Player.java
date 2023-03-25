import java.util.ArrayList;
public class Player {
    //public int playerHealth;
    public String playerName;
    public boolean keepPlaying;
    //public String movement;
    public Room currentRoom;

    public Map map;

    public ArrayList<Item> inventory = new ArrayList<>();



    public Player() {
        this.keepPlaying = true;
        this.map = new Map();
        map.newItem();
        map.newRoom();
        this.currentRoom = map.gameRooms.get(0);
        System.out.println("Randomly adding items to rooms.");
        addRandomItemToRoom();
        System.out.println("Adding items to rooms completed.");
//        if (currentRoom.roomItems.size() > 0) {
//            System.out.println(currentRoom);
//        }
            System.out.println("New player template created.\n");
    }

    public void loadPlayer(String playerName, Room currentRoom, Map map, ArrayList<Item> inventory) {
        this.keepPlaying = true;
        this.playerName = playerName;
        this.currentRoom = currentRoom;
        this.map = map;
        this.inventory = inventory;
        System.out.println("Player loaded successfully.");
    }


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

    public void setCurrentRoom(Room newRoom) {
        this.currentRoom = newRoom;
    }

    public void addItem(Item item) {
        this.inventory.add(item);
    }

    public void showInventory() {
        System.out.println(inventory.size());
        if (inventory.size() > 0) {
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println(inventory.get(i).toString());
            }
        }
        else {
            System.out.println("You don't have any items in your inventory.");
        }
    }

//    public  void getCurrentRoom(Room currentRoom) {
//        System.out.println("Your are currently in room number " + currentRoom);
//    }

    public void addRandomItemToRoom() {
        for (Room r: map.gameRooms) {
            if (r.getCanHaveItem() && map.allItems.size() > 0) {
                int randNum = (int) (Math.random() * map.allItems.size());
                r.roomItems.add(map.allItems.get(randNum));
                map.allItems.remove(randNum);
            }
        }
    }

    public void addItemToInventory(Item item) {
        this.inventory.add(item);
    }
}
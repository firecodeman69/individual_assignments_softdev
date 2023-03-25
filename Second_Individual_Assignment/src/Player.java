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
        //System.out.println("Randomly adding items to rooms.");
        addRandomItemToRoom();
        addRandomPuzzleToRoom();
        //System.out.println("Adding items to rooms completed.");
//        if (currentRoom.roomItems.size() > 0) {
//            System.out.println(currentRoom);
//        }
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
//    public void setCurrentRoom(Room newRoom) {
//        this.currentRoom = newRoom;
//    }

//    public void addItem(Item item) {
//        this.inventory.add(item);
//    }

//    public void showInventory(ArrayList<Item> itemsArrayList) {
//        //print out item AL to the console
//        if (itemsArrayList.size() > 0) {
//            for (int i = 0; i < itemsArrayList.size(); i++) {
//                return
//            }
//        }
//        else {
//            System.out.println("You don't have any items in your inventory.");
//        }
//    }

//    public  void getCurrentRoom(Room currentRoom) {
//        System.out.println("Your are currently in room number " + currentRoom);
//    }

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
            if (r.getCanHavePuzzle() && map.allItems.size() > 0) {
                int randNum = (int) (Math.random() * map.allItems.size());
                r.roomItems.add(map.allItems.get(randNum));
                map.allItems.remove(randNum);
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
            else {
                System.err.println("You do not have that item in your inventory.");
            }
        }
    }

//    public String helpMenu() {
//        return  ("N: Allows the player to move north (if there is a room available).\n" +
//                "E: Allows the player to move east (if there is a room available).\n" +
//                "S: Allows the player to move south (if there is a room available).\n" +
//                "W: Allows the player to move west (if there is a room available).\n" +
//                "Explore: Check a room for items.\n" +
//                "Pickup{itemname}: Pick up an item from a room, and add it to your inventory.\n" +
//                "Inventory: List all of the current items in your inventory.\n" +
//                "CurrentRoom: List the current room and the exits for that room.\n" +
//                "Quit: I hope you never want to, but this is your way out of the game if you wish.\n");

//        """
//                N: Allows the player to move north (if there is a room available).
//                E: Allows the player to move east (if there is a room available).
//                S: Allows the player to move south (if there is a room available).
//                W: Allows the player to move west (if there is a room available).
//                Explore: Check a room for items.
//                Pickup{itemname}: Pick up an item from a room, and add it to your inventory.
//                Inventory: List all of the current items in your inventory.
//                CurrentRoom: List the current room and the exits for that room.
//                Quit: I hope you never want to, but this is your way out of the game if you wish.
//                """;
    //}

//    public void addItemToInventory(Item item) {
//        this.inventory.add(item);
//    }
}
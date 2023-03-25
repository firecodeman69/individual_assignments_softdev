import java.util.*;

public class Game {


    public static void main(String[] args) {
        Game game = new Game();
        Player player1 = game.player1;
        Map map = new Map();



        System.out.println("Welcome! What would you like to do?\nEnter: NewGame or LoadGame\n");
        if (game.playerInput.next().equalsIgnoreCase("newgame")) {
            game.newGame();
            player1 = game.player1;
            map = player1.map;
            //player1.currentRoom.addRandomItemToRoom();
        }
        else if (game.playerInput.next().equalsIgnoreCase("loadgame")) {
            System.out.println("Please enter the name of your save file:\n");
        }
        else {
            System.out.println("Invalid input. Please enter one of the valid commands.\nEnter: NewGame or LoadGame\n");
        }



        //System.out.println(room.westRoom + " " + room.eastRoom);

        while (player1.getKeepPlaying()) {
            String command; //Direction chosen by the player
            //System.out.println(); // List new room description
            //String roomItemName = player1.currentRoom.roomItems.get(0).getName();
            //System.out.println(roomItemName);
            if (player1.getCurrentRoom().getAlreadyVisited()) System.out.print("Hmmm this room looks familiar.\n");
            String navigationPrompt = player1.getCurrentRoom().toString() +
                    "\n[Please pick a direction to go travel or Explore the room. (N, E, S, W)]";
            System.out.println(navigationPrompt);// Prompt user for direction of travel
            //System.out.println(player1.currentRoom.roomItems.get(0).getName());
            command = game.playerInput.next();
            if (command.equalsIgnoreCase("N")) {
                if (player1.currentRoom.northRoom == 0) System.out.println("You cannot go that way. Please pick another direction.\n");
                else {
                    player1.currentRoom.setAlreadyVisited(true);
                    //player1.currentRoom.hasItem();
                    player1.currentRoom = player1.currentRoom.setCurrentRoom(map.gameRooms, player1.currentRoom.northRoom);
                    System.out.println(player1.currentRoom.toString() + "\n");
                }
            }
            else if (command.equalsIgnoreCase("E")) {
                if (player1.currentRoom.eastRoom == 0) System.out.println("You cannot go that way. Please pick another direction.");
                else {
                    player1.currentRoom.setAlreadyVisited(true);
                    player1.currentRoom = player1.currentRoom.setCurrentRoom(map.gameRooms, player1.currentRoom.eastRoom);
                    System.out.println(player1.currentRoom.getRoomDescription() + "\n");
                }
            }
            else if (command.equalsIgnoreCase("S")) {
                if (player1.currentRoom.southRoom == 0) System.out.println("You cannot go that way. Please pick another direction.");
                else {
                    player1.currentRoom.setAlreadyVisited(true);
                    player1.currentRoom = player1.currentRoom.setCurrentRoom(map.gameRooms, player1.currentRoom.southRoom);
                    System.out.println(player1.currentRoom.getRoomDescription() + "\n");
                }
            }
            else if (command.equalsIgnoreCase("W")) {
                if (player1.currentRoom.westRoom == 0) System.out.println("You cannot go that way. Please pick another direction.");
                else {
                    player1.currentRoom.setAlreadyVisited(true);
                    player1.currentRoom = player1.currentRoom.setCurrentRoom(map.gameRooms, player1.currentRoom.westRoom);
                    System.out.println(player1.currentRoom.getRoomDescription() + "\n");
                }
            }
            else if (command.equalsIgnoreCase("Explore")) {
                if (player1.currentRoom.roomItems.size() > 0) System.out.println(player1.currentRoom.roomItems.get(0).toString());
                else System.out.println("You don't see any items in the room with you.");
                    //player1.currentRoom.getRoomItems();
            }
            else if (player1.currentRoom.canHaveItem) {
                if (command.equalsIgnoreCase(("pickup" + player1.currentRoom.roomItems.get(0).getName()))) {
                    player1.inventory.add(player1.currentRoom.roomItems.get(0));
                    player1.currentRoom.roomItems.remove(0);
                    //System.out.println("pickup");
//                for (Item i: player1.inventory) {
//                    System.out.println(i);
//                }
                }
            }
            else if (command.equalsIgnoreCase("Inventory")) {
                if (player1.inventory.size() > 0) {
//                    for (Item item : player1.inventory) {
//                        System.out.println(item.getName());
//                    }
                    System.out.println(player1.inventory.size());
                    //player1.showInventory();
                }
                else {
                    System.out.println("You have no items in your inventory.");
                }
            }
            else if (command.equalsIgnoreCase("QUIT")) {
                player1.setKeepPlaying(false);
            }  else {
                System.out.println("Please enter a valid direction. N, E, S, or W.");
            }
            //System.out.println("\n----------------------\nNow entering room " + room + "\n");
        }

    }

    //Game newGame = new Game(); //To be used in later game iterations
    //Game loadGame = new Game(Enter save file); To be used in later game iterations

    Player player1;
    public Scanner playerInput;

    public Game() {
        player1 = new Player();
        this.playerInput = new Scanner(System.in);
    }

    public void newGame() {
        System.out.println("\n\nWelcome home! I suffer from memory loss a bit... could you please remind me your first name?");
        player1.setPlayerName(playerInput.next());
        //player1.setCurrentRoom(player1.gameRooms.get(0));
        //System.out.println(player1.getCurrentRoom());
        System.out.printf("\nAh yes! %s, I think I remember now - that is right. " +
                "\nFeel free to venture around! I can't remember anything, but I am sure you can." +
                "\nYou can enter QUIT at anytime to quit the game.\nType helpmenu for a list of commands.\n\n" +
                "                                              END                                              \n" +
                "_______________________________________________________________________________________________\n", player1.getPlayerName());
    }

//    public void loadGame() {
//        this.player1 = new Player();
//        this.map = new Map();
//        this.map.newRoom();
//        map.newItem();
//
//        System.out.println("\n\nWelcome home! I suffer from memory loss a bit... could you please remind me your first name?");
//        player1.setPlayerName(playerInput.next());
//        player1.setCurrentRoom(map.gameRooms.get(0));
//        System.out.printf("\nAh yes! %s, I think I remember now - that is right. " +
//                "\nFeel free to venture around! I can't remember anything, but I am sure you can." +
//                "\n\n", player1.getPlayerName());
//    }

    public Player getPlayer1() {
        return this.player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

//    public Map getMap () {
//        return this.map;
//    }
//
//    public void setMap (Map map) {
//        this.map = map;
//    }
}

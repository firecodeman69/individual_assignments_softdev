import java.util.*;

public class Game {


    public static void main(String[] args) {
        Game game = new Game();
        Player player1 = game.player1;
        Map map = player1.map;
        String navigationPrompt = "[Please pick a direction to go travel or Explore the room. (N, E, S, W)]";
        //String roomInfo = player1.getCurrentRoom().toString();


        while (game.menuOpen) {
            System.out.println("Welcome! What would you like to do?\nEnter: NewGame or LoadGame");
            if (game.playerInput.next().equalsIgnoreCase("newgame")) {
                game.newGame();
                player1 = game.player1;
                map = player1.map;
                game.menuOpen = false;
            } else if (game.playerInput.next().equalsIgnoreCase("loadgame")) {
                System.out.println("Please enter the name of your save file:\n");
                //game.loadGame(game.playerInput.next())
                //System.out.println("Loading in your game...");
                game.menuOpen = false;
            } else {
                System.out.println("Invalid input. Please enter one of the valid commands.\nEnter: NewGame or LoadGame\n");
            }
        }



        //System.out.println(room.westRoom + " " + room.eastRoom);

        while (player1.getKeepPlaying()) {
            Room previousRoom;
            System.out.println(navigationPrompt);// Prompt user for direction of travel
            String command = game.playerInput.nextLine().toLowerCase(); //Direction chosen by the player
            String[] spCommand = command.split(" ");
//            for (int i = 0; i < spCommand.length; i++) {
//                System.out.println(spCommand[i]);
//            }
            //int roomId = currentRoom.getRoomNumber();

            if (spCommand[0].equalsIgnoreCase("N")) {
                if (player1.currentRoom.northRoom == 0) { System.out.println("You cannot go that way. Please pick another direction.\n");}
                if (player1.currentRoom.northRoom != 0) {
                    if (player1.currentRoom.hasPuzzle()) {
                        while (!player1.currentRoom.roomPuzzle.isSolved) {
                            for (int i = player1.currentRoom.roomPuzzle.ATTEMPTS; i > 0; i--) {
                                System.out.println(player1.currentRoom.roomPuzzle.DESCRIPTION + "\n"
                                + "Enter your answer:");
                                if (game.playerInput.next().equalsIgnoreCase(spCommand[0])) {
                                    player1.currentRoom.roomPuzzle.isSolved = true;
                                }
                                else {
                                    System.out.println("Incorrect, please try again - " + i + " attempts remaining.");
                                }
                            }
                        }
                    }
                    previousRoom = player1.currentRoom;
                    System.out.println(player1.currentRoom);
                    player1.currentRoom = player1.setCurrentRoom(map.gameRooms, player1.currentRoom.northRoom);
                    //roomId = currentRoom.getRoomNumber();
                    System.out.println(player1.currentRoom.toString() + "\n");
                    if (player1.getCurrentRoom().getAlreadyVisited()) System.out.print("Hmmm this room looks familiar.\n");
                    player1.currentRoom.setAlreadyVisited(true);
                }
            }
            else if (spCommand[0].equalsIgnoreCase("E")) {
                if (player1.currentRoom.eastRoom == 0) System.out.println("You cannot go that way. Please pick another direction.");
                else {
                    previousRoom = player1.currentRoom;
                    player1.currentRoom = player1.setCurrentRoom(map.gameRooms, player1.currentRoom.eastRoom);
                    //roomId = currentRoom.getRoomNumber();
                    System.out.println(player1.currentRoom.toString() + "\n");
                    if (player1.getCurrentRoom().getAlreadyVisited()) System.out.print("Hmmm this room looks familiar.\n");
                    player1.currentRoom.setAlreadyVisited(true);
                }
            }
            else if (spCommand[0].equalsIgnoreCase("S")) {
                if (player1.currentRoom.southRoom == 0) System.out.println("You cannot go that way. Please pick another direction.");
                else {
                    previousRoom = player1.currentRoom;
                    player1.currentRoom = player1.setCurrentRoom(map.gameRooms, player1.currentRoom.southRoom);
                    //roomId = currentRoom.getRoomNumber();
                    System.out.println(player1.currentRoom.toString() + "\n");
                    if (player1.getCurrentRoom().getAlreadyVisited()) System.out.print("Hmmm this room looks familiar.\n");
                    player1.currentRoom.setAlreadyVisited(true);
                }
            }
            else if (spCommand[0].equalsIgnoreCase("W")) {
                if (player1.currentRoom.westRoom == 0) System.out.println("You cannot go that way. Please pick another direction.");
                else {
                    previousRoom = player1.currentRoom;
                    player1.currentRoom = player1.setCurrentRoom(map.gameRooms, player1.currentRoom.westRoom);
                    //roomId = currentRoom.getRoomNumber();
                    System.out.println(player1.currentRoom.toString() + "\n");
                    if (player1.getCurrentRoom().getAlreadyVisited()) System.out.print("Hmmm this room looks familiar.\n");
                    player1.currentRoom.setAlreadyVisited(true);
                }
            }
            else if (spCommand[0].equalsIgnoreCase("Explore")) {
                if (player1.currentRoom.roomItems.size() > 0) {System.out.println(player1.currentRoom.getRoomItems());}
                else { System.out.println("You don't see any items in the room with you.");}
                //currentRoom.getRoomItems();
            }
            else if (spCommand[0].equalsIgnoreCase("pickup") && player1.currentRoom.hasItem(spCommand[1])) {
                if (player1.currentRoom.hasItem(spCommand[1])) {
                    player1.inventory.add(player1.currentRoom.getItem(spCommand[1]));
                    //System.out.println(currentRoom.roomItems.get(0).getName() + " has been picked up from the room and successfully added to the player inventory.");
                    player1.currentRoom.removeItem(spCommand[1]);
//                }
                }
            }
            else if (spCommand[0].equalsIgnoreCase("Inventory")) {
                if (player1.inventory.size() >= 1) {
                    //player1.showInventory(player1.inventory);
                    for (Item item : player1.inventory) {
                        System.out.println(item.getName());
                    }
                }
                else {
                    System.out.println("You don't have any items in your inventory.");
                }
            }
            else if (spCommand[0].equalsIgnoreCase("CurrentRoom")) {
                System.out.println(player1.currentRoom);
            }
            else if (spCommand[0].equalsIgnoreCase("drop") && player1.hasItem(spCommand[1])) {
                player1.dropItem(spCommand[1]);
                System.out.println("Item dropped.");
            }
            else if (spCommand[0].equalsIgnoreCase("inspect") && player1.hasItem(spCommand[1])) {
                System.out.println("Inspecting");
                System.out.println(player1.inspectItem(spCommand[1]));
            }
            else if (command.equalsIgnoreCase("helpmenu")) {
                System.out.println(game.helpMenu());
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
    private boolean menuOpen = true;
    Player player1;
    public static final Scanner playerInput = new Scanner(System.in);

    public Game() {
        player1 = new Player();
        //this.playerInput = new Scanner(System.in);//.useDelimiter("\\s+");
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

        System.out.println(player1.getCurrentRoom().toString());
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

//    public Player getPlayer1() {
//        return this.player1;
//    }

//    public void setPlayer1(Player player1) {
//        this.player1 = player1;
//    }

//    public Map getMap () {
//        return this.map;
//    }
//
//    public void setMap (Map map) {
//        this.map = map;
//    }

        public String helpMenu() {
        return """
                N: Allows the player to move north (if there is a room available).
                E: Allows the player to move east (if there is a room available).
                S: Allows the player to move south (if there is a room available).
                W: Allows the player to move west (if there is a room available).
                Explore: Check a room for items.
                Pickup{itemname}: Pick up an item from a room, and add it to your inventory.
                Inventory: List all of the current items in your inventory.
                CurrentRoom: List the current room and the exits for that room.
                Quit: I hope you never want to, but this is your way out of the game if you wish.
                """;
    }
}

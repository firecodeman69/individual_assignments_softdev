import java.util.*;

public class Game {


    public static void main(String[] args) {
        Game game = new Game(); //Initialize a game instance, mostly like a template.
        Player player1 = game.player1;
        Map map = player1.map; //
        String navigationPrompt = "[Please pick a direction to go travel or Explore the room. (N, E, S, W)]";
        //String roomInfo = player1.getCurrentRoom().toString();

/******************************************************Main Menu********************************************************/

        while (game.menuOpen) {
            //System.out.println("Welcome! What would you like to do?\nEnter: NewGame or LoadGame");
            System.out.println("Welcome! What would you like to do?\nEnter: NewGame");
            if (game.playerInput.next().equalsIgnoreCase("newgame")) { //Functional. will create a newGame by calling the newgame method in Game class.
                game.newGame(); //Start a new game
                //player1 = game.player1; //Set the local variable to the instance of player in the game
                //map = player1.map; //Set the local variable to the instance of the map in the game.
                game.menuOpen = false; //Exit the menu loop
            } else if (game.playerInput.next().equalsIgnoreCase("loadgame")) { //Not currently functional
                System.out.println("Please enter the name of your save file:\n");
                //game.loadGame(game.playerInput.next())
                //System.out.println("Loading in your game...");
                game.menuOpen = false;
            } else {
                System.out.println("Invalid input. Please enter one of the valid commands.\nEnter: NewGame or LoadGame\n");
            }
        }

/****************************************************Main game Loop****************************************************/

        while (player1.getKeepPlaying()) {
            /**************************************Test for Puzzle*********************************/
            if (player1.currentRoomHasPuzzle()) { //If a room has a puzzle, run the puzzle game loop
                game.solvingPuzzle(player1.getCurrentRoom());
                //player1.setPreviousRoom(player1.currentRoom);
                System.out.println(navigationPrompt);
            } //else {System.out.println(navigationPrompt);}

            /***************************Get the player input - do the thing****************************/
            String command = game.playerInput.nextLine(); //Direction chosen by the player
            String[] spCommand = command.split(" "); //Parse out the user input
            if (spCommand[0].equalsIgnoreCase("N")) {
                if (player1.getNorthRoom() == 0) { //If no room in that direction, don't allow player to travel
                    System.out.println("You cannot go that way. Please pick another direction.\n");
                } else {
                    player1.setCurrentRoom(map.gameRooms, player1.currentRoom.northRoom); //Set the current room for player
                    System.out.println(player1.getCurrentRoom() + "\n"); //Tell user what room they are going into
                    if (player1.getCurrentRoom().getAlreadyVisited()) //Let the user know if the room has been visited
                        System.out.print("Hmmm this room looks familiar.\n");
                    player1.setVisited();  //SetVisited variable to true
                    System.out.println(navigationPrompt);
                }
            } else if (spCommand[0].equalsIgnoreCase("E")) {
                if (player1.getEastRoom() == 0) //If no room in that direction, don't allow player to travel
                    System.out.println("You cannot go that way. Please pick another direction.");
                else {
                    //player1.setPreviousRoom(player1.currentRoom);
                    player1.setCurrentRoom(map.gameRooms, player1.getEastRoom()); //Set the current room for player
                    System.out.println(player1.getCurrentRoom() + "\n"); //Tell user what room they are going into
                    if (player1.getCurrentRoom().getAlreadyVisited()) //Let the user know if the room has been visited
                        System.out.print("Hmmm this room looks familiar.\n");
                    player1.setVisited(); //SetVisited variable to true
                    System.out.println(navigationPrompt);
                }
            } else if (spCommand[0].equalsIgnoreCase("S")) {
                if (player1.getSouthRoom() == 0) //If no room in that direction, don't allow player to travel
                    System.out.println("You cannot go that way. Please pick another direction.");
                else {
                    //player1.setPreviousRoom(player1.currentRoom);
                    player1.setCurrentRoom(map.gameRooms, player1.getCurrentRoom().southRoom); //Set the current room for player
                    System.out.println(player1.getCurrentRoom() + "\n"); //Tell user what room they are going into
                    if (player1.getCurrentRoom().getAlreadyVisited()) //Let the user know if the room has been visited
                        System.out.print("Hmmm this room looks familiar.\n");
                    player1.setVisited(); //SetVisited variable to true
                    System.out.println(navigationPrompt);
                }
            } else if (spCommand[0].equalsIgnoreCase("W")) {
                if (player1.getWestRoom() == 0) //If no room in that direction, don't allow player to travel
                    System.out.println("You cannot go that way. Please pick another direction.");
                else {
                    //player1.setPreviousRoom(player1.currentRoom);
                    player1.setCurrentRoom(map.gameRooms, player1.getCurrentRoom().westRoom); //Set the current room for player
                    System.out.println(player1.getCurrentRoom() + "\n"); //Tell user what room they are going into
                    if (player1.getCurrentRoom().getAlreadyVisited()) //Let the user know if the room has been visited
                        System.out.print("Hmmm this room looks familiar.\n");
                    player1.setVisited(); //SetVisited variable to true
                    System.out.println(navigationPrompt);
                }
            } else if (spCommand[0].equalsIgnoreCase("Explore")) { //Return all items in the current Room
                if (player1.getCurrentRoom().hasItems()) { //If there are items in the room
                    System.out.println(player1.getCurrentRoom().getRoomItems());
                } else { //If there are not items in the room
                    System.out.println("You don't see any items in the room with you.");
                }
            } else if (spCommand[0].equalsIgnoreCase("pickup") && player1.getCurrentRoom().hasItem(spCommand[1])) { //Pickup item and add to inventory
                if (player1.getCurrentRoom().hasItem(spCommand[1])) { //If the room has the specified item
                    player1.addToInventory(player1.getRoomItem(spCommand[1])); //Add the item to player's inventory
                    player1.getCurrentRoom().removeItem(spCommand[1]); //Remove the item from room
                }
                else { //If the room does not have the specified item
                    System.out.println("That item is not in this room");
                }
            } else if (spCommand[0].equalsIgnoreCase("Inventory")) { //List all the items in the player's inventory
                System.out.println(player1.showInventory());
            } else if (spCommand[0].equalsIgnoreCase("CurrentRoom")) { //List the player's current room
                System.out.println(player1.currentRoom);
            } else if (spCommand[0].equalsIgnoreCase("drop")) { //Remove item from player's inventory and add it to the room.
                if (player1.hasItem(spCommand[1])) { //If the item is in player's inventory
                    player1.dropItem(spCommand[1]);
                    System.out.println("Item removed from player's inventory and added to the room. Use explore to find it again.");
                } else { //If the item is not in player's inventory
                    System.out.println("You do not have that item in your inventory.");
                }
            } else if (spCommand[0].equalsIgnoreCase("inspect")) { //Inspect an item in player's inventory
                if (player1.hasItem(spCommand[1])) { //If the player has the item
                    System.out.println("Inspecting");
                    System.out.println(player1.inspectItem(spCommand[1]));
                }
                else { //If the player does not have the item
                    System.out.println("You do not have that item in your inventory.");
                }
            } else if (command.equalsIgnoreCase("helpmenu")) { //Print out the helpmenu
                System.out.println(player1.helpMenu());
            } else if (command.equalsIgnoreCase("QUIT")) { //Allow user to exit the game
                player1.setKeepPlaying(false);
            } else {
                System.out.println("Please enter a valid command. Type helpmenu for a list of commands");
            }
        }

    }

    //Game loadGame = new Game(Enter save file); To be used in later game iterations
    private boolean menuOpen = true; //Keep track of if the menu is open or not
    Player player1; //New player of the game
    public static final Scanner playerInput = new Scanner(System.in); //Player input for the game
    public Game() {
        player1 = new Player(); //Add a new player to the game
    }

    public void newGame() { //Create a new game and prompt only shown in the new game
        System.out.println("\n\nWelcome home! I suffer from memory loss a bit... could you please remind me your first name?");
        player1.setPlayerName(playerInput.next());
        System.out.printf("\nAh yes! %s, I think I remember now - that is right. " +
                "\nFeel free to venture around! I can't remember anything, but I am sure you can." +
                "\nYou can enter QUIT at anytime to quit the game.\nType helpmenu for a list of commands.\n\n" +
                "                                              END                                              \n" +
                "_______________________________________________________________________________________________\n", player1.getPlayerName());

        System.out.println(player1.getCurrentRoom().toString());
    }

    /***************************************************Puzzle game loop**********************************************/
    public void solvingPuzzle(Room puzzleRoom) { //Puzzle inner game loop
        int tries = puzzleRoom.roomPuzzle.attempts;
        Scanner scan = new Scanner(System.in);
        if (puzzleRoom.hasPuzzle() && !player1.currentRoomPuzzleSolved()) { //If the room has a puzzle and it's not solved, enter puzzle loop
            while (tries > 0) {
                tries--; //Decrease the initial amount of attempts since puzzle starts immediately
                System.out.println(puzzleRoom.roomPuzzle.DESCRIPTION + "\n"
                        + "Enter your answer:\n");
                String answer = scan.nextLine().toLowerCase();
                String[] spAnswer = answer.split(" ");
                if (puzzleRoom.roomPuzzle.SOLUTION.equalsIgnoreCase(spAnswer[0])) { //If the answer is right
                    System.out.println("Congratulations! That was the correct answer.\n");
                    puzzleRoom.roomPuzzle.setIsSolved(true);
                    break;
                } else if (spAnswer[0].equalsIgnoreCase("hint")) { //Give puzzle hint
                    System.out.println(puzzleRoom.roomPuzzle.HINT);
                } else { //If the answer is wrong
                    System.out.println("Incorrect, please try again - " + tries + " attempts remaining.");
                    //tries++;
                }
            }
            if (player1.currentRoomPuzzleSolved()) { //Outcome if the puzzle was solved
                System.out.println(player1.getCurrentRoom());
                //player1.setCurrentRoom(player1.map.gameRooms, player1.currentRoom.northRoom);
            } else { //Outcome if the puzzle was failed to be solved
                System.out.println("Puzzle failed, resetting attempts. Come back and try again!");
                //player1.getCurrentRoom().roomPuzzle.setAttempts(tries);
                //System.out.println(player1.getPreviousRoom());
                //player1.currentRoom = player1.previousRoom;
            }
        }
    }

    /******************************************************Method Dump************************************************

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
     ****************************************************************************************************************/
}

Hello! I hope that you are doing well so far today. This is my collectable adventure game.

In this program, you will create your own text game. The program reads in a "map.txt" and constructs a map, "item.txt" and constructs
items, and "puzzle.txt" and constructs puzzles.

----------------------------------------------------ROOMS (MAP)---------------------------------------------------

Open the source file map.txt to view the data contained in the file.

The data is split into 7 different parts! 

There is the number of the room, a description of the room, and the room associations.

You will notice that the data is separated by #.

<roomNumber>
This field is the primary key for the rooms

<roomDescription>
This field is a description of the room

<alreadyVisited>
This field is a boolean to keep up with whether or not a room has been visited.

<canHaveItem>
This is a boolean field that is used to keep track of the rooms that can possibly have items.
This helps with room-item assignment.

<canHavePuzzle>
This is a boolean field that is used to keep track of the rooms that are able to have puzzles.
This helps with room-puzzle assignment.

<northRoom>
<eastRoom>
<southRoom>
<westRoom>
The order of the associations are rooms to the North, East, South, and West.

This is the default map that is created. Please use this for your reference when navigating through the rooms:

-------------- 
|  1   |  2  | 
-------------- 
|  3   |  4  | 
-------------- 
|  5   |  6  | 
--------------

----------------------------------------------------ITEMS---------------------------------------------------------

Open item.txt, and you will find a list of items with their corresponding descriptions. The following is the order:

Item Name
Item Description

----------------------------------------------------PUZZLES-------------------------------------------------------

Open puzzle.txt, and you will find a list of puzzles each with a puzzleId, isSolved boolean value, the puzzle description,
the puzzle solution, and the max number of attempts.

PuzzleId
Description
Solution
NumOfAttempts
Hints

------------------------------------------------GENERAL CONTROLS--------------------------------------------------
For the controls of the game, you will be prompted to enter your player name.
It must be all one word with no spaces - anything after a space will not make it into your name!

|---------------------------------------|
|            Table of Commands          |
|---------------------------------------|
|--------------Navigation---------------|
|            N: Move North              |
|            E: Move North              |
|            S: Move North              |
|            W: Move North              |
|                                       |
|-------------Within Rooms--------------|
|       Explore: List Room Items        |
|CurrentRoom: Lists current room details|
|  Pickup {ItemName}: add to inventory  |
| Drop {ItemName}: Remove from inventory|
|                                       |
|------------Item Interaction-----------|
| Inspect {ItemName}: Return item desc. |
| Inventory: List all items collected   |
|                                       |
|------------------Help-----------------|
|HelpMenu: List all available commands  |
|                                       |
|------------Menu Options---------------|
|NewGame: Start a brand new adventure!  |
|LoadGame {SaveFileName}: Load adventure|
|Quit: Leave the game - why though?     |
|---------------------------------------|

Upon beginning the game, you will find yourself greeted and starting off in the EntryWay. Use N, E, S, and W commands to navigate through your home.

If you would like to quit, you can enter "Quit" at any time during your navigation.
This only works after you have entered your name and created your player.

You can enter "HelpMenu" at any time to display a list of all commands that you are able to make as a player.

I hope that you enjoy playing this game! More development to come, but this is a good start.
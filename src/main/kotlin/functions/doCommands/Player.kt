package functions.doCommands

import classes.MenuType
import classes.Player
import classes.Room
import functions.format.formatItemList
import functions.format.formatPOIList
import kotlin.system.exitProcess

/**
 * Does a command based on the input [input]
 */
public fun doPlayerCommand(input: String, plr: Player){
    val arguments: List<String> = input.split(" ");

    when(arguments[0].toLowerCase()){ //switch case
        "help" -> {
            commandHelp(arguments, plr)
        }

        //Exit aliases
        "exit" -> {
            commandExit(arguments, plr)
        }
        "leave" -> {
            commandExit(arguments, plr)
        }

        //Inventory aliases
        "inventory" -> {
            commandInventory(arguments, plr)
        }
        "inv" -> {
            commandInventory(arguments, plr)
        }
        "items" -> {
            commandInventory(arguments, plr)
        }

        //Classes.Room aliases
        "room" -> {
            commandRoom(arguments, plr)
        }
        "look" -> {
            commandRoom(arguments, plr)
        }


        else -> {
            println("⚠️'${arguments[0]}' is not a known command")
        }
    }
}

//commands
private fun commandHelp(args: List<String>, plr: Player){
    val padding: Int = 35; //using padEnd to add spaces to set a length, that way all the text lines up nicely
    println("Commands:")
    println("* help".padEnd(padding)                   +"Shows all commands you can do.")
    println("* exit, leave".padEnd(padding)            +"Closes the game.")
    println("* inventory, inv, items".padEnd(padding)  +"Shows your inventory.")
    println("* room, look".padEnd(padding)             +"Inspect/look around the current room.")
}
private fun commandExit(args: List<String>, plr: Player){
    //TODO add: are you sure? and bye bye

    exitProcess(0)
}
private fun commandInventory(args: List<String>, plr: Player){
    println(formatItemList(plr.inventory, "Inventory"));

    if (plr.inventory.isNotEmpty()){ //if stuff in inventory change currentMenu

        println("What item would you like to interact with? ")

        var chosen = false;
        while (!chosen) {
            print("- ") //line in front of where you type your choice
            val read = readLine().toString()
            when(read.toLowerCase()){

                //exit out of loop
                "leave" ->{ chosen = true; }
                "back" ->{  chosen = true; }
                "exit" ->{ chosen = true; }
                "return" ->{ chosen = true; }

                "help" ->{
                    val padding: Int = 35; //using padEnd to add spaces to set a length, that way all the text lines up nicely
                    println("Options:")
                    println("- help".padEnd(padding)                            +"Shows all commands you can do.")
                    println("- leave, back, exit, return".padEnd(padding)       +"Stop interacting with your inventory.")
                    println("- inventory, inv, items".padEnd(padding)           +"Shows your inventory.")
                    println("- { number }".padEnd(padding)                      +"Start interacting with said item.")
                }

                "inventory" ->{
                    println(formatItemList(plr.inventory, "Inventory"));
                }
                "inv" ->{
                    println(formatItemList(plr.inventory, "Inventory"));
                }
                "items" ->{
                    println(formatItemList(plr.inventory, "Inventory"));
                }

                else ->{
                    val input: Int? = read.toIntOrNull() //convert input to int (or null if not int)
                    if (input != null){ //is number
                        if (input <= plr.inventory.size && input >= 0){ //chose number in inventory
                            chosen = true;
                            plr.currentMenu = MenuType.INVENTORY
                            plr.currentMenuIndex = input

                        }else{
                            println("You did not pick a valid index inside of your inventory.")
                        }

                    }else{ //is not a number
                        println("You did not pick a valid number nor a valid command (type help for help)")
                    }
                }
            }


        }
    } //else inventory is empty so don't do anything
}
private fun commandRoom(args: List<String>, plr: Player){
    val room = GlobalGameMap.gameMap[plr.currentLevel][plr.currentRoom];
    println(room.name);
    println(room.description);

    println(formatPOIList(room.poiList, "Objects inside ${room.name}"));
}
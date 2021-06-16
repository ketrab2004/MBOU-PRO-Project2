package functions.doCommands

import classes.MenuType
import classes.Player
import classes.Room
import classes.item.Item
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
            commandExit(arguments)
        }
        "leave" -> {
            commandExit(arguments)
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

        //equipment aliases
        "equipment" ->{
            commandEquipment(arguments, plr);
        }
        "equip" ->{
            commandEquipment(arguments, plr);
        }
        "armor" ->{
            commandEquipment(arguments, plr);
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
    println("* equipment, equip, armor".padEnd(padding)+"Shows your equipped items.")
    println("* room, look".padEnd(padding)             +"Inspect/look around the current room.")
}
private fun commandExit(args: List<String>){
    println("Are you sure you want to exit the game?\nY or N");

    val input = readLine()!!.toLowerCase();

    if (input == "y" || input == "yes"){
        println("bye bye :'(")
        exitProcess(0)
    }else{
        println("You typed '${input.toUpperCase()}' which wasn't Y,\nso not closing the game...")
    }
}
private fun commandInventory(args: List<String>, plr: Player){
    println(formatItemList(plr.inventory, "Inventory"));

    if (plr.inventory.isNotEmpty()){ //if stuff in inventory change currentMenu

        println("What item would you like to interact with?")

        plr.currentMenu = MenuType.INVENTORY;
    } //else inventory is empty so don't do anything
}
private fun commandEquipment(args: List<String>, plr: Player){
    println(formatItemList(plr.equipped.toList(), "Equipment"))

    if (plr.equipped.isNotEmpty()){ //if has equipment
        println("What equipped item would you like to interact with?")

        plr.currentMenu = MenuType.EQUIPMENT;
    }
}

private fun commandRoom(args: List<String>, plr: Player){
    val room = GlobalGameMap.gameMap[plr.currentLevel][plr.currentRoom];
    println(room.name);
    println(room.description);

    println(formatPOIList(room.poiList, ""));

    if (room.poiList.isNotEmpty()) { //if stuff in room change currentMenu

        println("What item would you like to interact with? ")

        plr.currentMenu = MenuType.ROOM;
    }
}
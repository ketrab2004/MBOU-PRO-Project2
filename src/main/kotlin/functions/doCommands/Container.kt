package functions.doCommands

import classes.MenuType
import classes.Player
import classes.Room
import classes.item.Item
import classes.poi.POI
import functions.format.formatItemList
import functions.format.formatPOIList

/**
 * Does a command based on the input
 */
public fun doCommandContainer(input: String, plr: Player){
    val arguments: List<String> = input.split(" ");

    val room = GlobalGameMap.gameMap[plr.currentLevel][plr.currentRoom]
    val poi = room.poiList[plr.currentMenuIndex]
    var inventory = poi.properties["Content"] as MutableList<Item>;

    when(arguments[0].toLowerCase()){ //switch case
        "help" -> {
            commandHelp(arguments, poi);
        }
        //Go back
        "leave" -> {
            commandBack(plr, poi); }
        "back" -> {
            commandBack(plr, poi); }
        "return" -> {
            commandBack(plr, poi); }

        //content aliases
        "content" -> {
            commandContent(poi, inventory);
        }
        "items" -> {
            commandContent(poi, inventory);
        }


        else -> {
            val number: Int? = arguments[0].toIntOrNull() //convert input to int (or null if not int)
            if (number != null) { //is number
                if (number <= inventory.size && number >= 0) { //chose number in inventory

                    plr.currentMenu = MenuType.IN_CONTAINER;
                    plr.currentMenuIndex1 = number
                    //currentMenuIndex doesn't change because you're interacting with the same object

                } else {
                    println("You did not pick a valid index inside of ${poi.name}.")
                }

            } else { //is not a number
                println("You did not pick a valid number nor a valid command (type help for help)")
            }
        }
    }
}

private fun commandContent(poi: POI, content: MutableList<Item>){
    println(formatItemList(content, poi.name));
}

private fun commandHelp(arguments: List<String>, poi: POI){
    val padding: Int = 35; //using padEnd to add spaces to set a length, that way all the text lines up nicely
    println("Options:")
    println("- help".padEnd(padding)                    + "Shows all commands you can do.")
    println("- leave, back, return".padEnd(padding)     + "Stop interacting with ${poi.name}.")
    println("- content, items".padEnd(padding)          + "Shows your inventory.")
    println("- { number }".padEnd(padding)              + "Start interacting with the chosen object.")
}

private fun commandBack(plr: Player, poi: POI){
    println("You are now looking at ${poi.name} itself instead of it's content.")
    plr.currentMenu = MenuType.IN_ROOM;
}
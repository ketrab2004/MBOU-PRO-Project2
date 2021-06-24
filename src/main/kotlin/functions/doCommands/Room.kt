package functions.doCommands

import classes.MenuType
import classes.Player
import classes.Room
import functions.format.formatPOIList

/**
 * Does a command based on the input
 */
public fun doCommandRoom(input: String, plr: Player){
    val arguments: List<String> = input.split(" ");

    var room = GlobalGameMap.gameMap[plr.currentLevel][plr.currentRoom]

    when(arguments[0].toLowerCase()){ //switch case
        "help" -> {
            commandHelp(arguments, room);
        }
        //Go back
        "leave" -> {
            commandBack(plr); }
        "back" -> {
            commandBack(plr); }
        "return" -> {
            commandBack(plr); }

        //room aliases
        "room" -> {
            commandRoom(room);
        }
        "look" -> {
            commandRoom(room);
        }


        else -> {
            val number: Int? = arguments[0].toIntOrNull() //convert input to int (or null if not int)
            if (number != null) { //is number
                if (number < room.poiList.size && number >= 0) { //chose number in inventory

                    plr.currentMenu = MenuType.IN_ROOM;
                    plr.currentMenuIndex = number

                } else {
                    println("You did not pick a valid index inside of ${room.name}.")
                }

            } else { //is not a number
                println("You did not pick a valid number nor a valid command (type help for help)")
            }
        }
    }
}

private fun commandRoom(room: Room){
    println(formatPOIList(room.poiList, room.name));
}

private fun commandHelp(arguments: List<String>, room: Room){
    val padding: Int = 35; //using padEnd to add spaces to set a length, that way all the text lines up nicely
    println("Options:")
    println("- help".padEnd(padding)                + "Shows all commands you can do.")
    println("- leave, back, return".padEnd(padding) + "Stop interacting with ${room.name}.")
    println("- room, look".padEnd(padding)          + "Shows your inventory.")
    println("- { number }".padEnd(padding)          + "Start interacting with the chosen object.")
}

private fun commandBack(plr: Player){
    plr.currentMenu = MenuType.NONE;
}
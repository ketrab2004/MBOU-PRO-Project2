package functions.doCommands

import classes.MenuType
import classes.Player
import functions.format.formatItemList

/**
 * Does a command based on the input
 */
public fun doCommandInventory(input: String, plr: Player){
    val arguments: List<String> = input.split(" ");



    when(arguments[0].toLowerCase()){ //switch case
        "help" -> {
            commandHelp(arguments);
        }
        //Go back
        "leave" -> {
            commandBack(plr); }
        "back" -> {
            commandBack(plr); }
        "return" -> {
            commandBack(plr); }

        //inventory aliases
        "inventory" -> {
            commandInventory(plr);
        }
        "inv" -> {
            commandInventory(plr);
        }
        "items" -> {
            commandInventory(plr);
        }


        else -> {
            val number: Int? = arguments[0].toIntOrNull() //convert input to int (or null if not int)
            if (number != null) { //is number
                if (number < plr.inventory.size && number >= 0) { //chose number in inventory

                    plr.currentMenu = MenuType.IN_INVENTORY;
                    plr.currentMenuIndex = number

                } else {
                    println("You did not pick a valid index inside of your inventory.")
                }

            } else { //is not a number
                println("You did not pick a valid number nor a valid command (type help for help)")
            }
        }
    }
}

private fun commandInventory(plr: Player){
    println(formatItemList(plr.inventory, "Inventory"));
}

private fun commandHelp(arguments: List<String>){
    val padding: Int = 35; //using padEnd to add spaces to set a length, that way all the text lines up nicely
    println("Options:")
    println("- help".padEnd(padding)                    + "Shows all commands you can do.")
    println("- leave, back, return".padEnd(padding)     + "Stop interacting with your inventory.")
    println("- inventory, inv, items".padEnd(padding)   + "Shows your inventory.")
    println("- { number }".padEnd(padding)              + "Start interacting with said item.")
}

private fun commandBack(plr: Player){
    plr.currentMenu = MenuType.NONE;
}
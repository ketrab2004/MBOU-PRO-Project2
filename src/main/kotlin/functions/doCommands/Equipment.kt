package functions.doCommands

import classes.MenuType
import classes.Player
import functions.format.formatItemList

/**
 * Does a command based on the input
 */
public fun doCommandEquipment(input: String, plr: Player){
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

        //equipment aliases
        "equipment" -> {
            commandEquipment(plr);
        }
        "equip" -> {
            commandEquipment(plr);
        }
        "armor" -> {
            commandEquipment(plr);
        }


        else -> {
            val number: Int? = arguments[0].toIntOrNull() //convert input to int (or null if not int)
            if (number != null) { //is number
                if (number <= plr.equipped.size && number >= 0) { //chose number in equipment

                    if (plr.equipped[number] != null) {
                        plr.currentMenu = MenuType.IN_EQUIPMENT; //go into interacting with equipped item
                        plr.currentMenuIndex = number;
                    }else{

                        println("There is no item in slot '$number' to interact with.")
                    }

                } else {
                    println("You did not pick a valid index inside of your inventory.")
                }

            } else { //is not a number
                println("You did not pick a valid number nor a valid command (type help for help)")
            }
        }
    }
}

private fun commandEquipment(plr: Player){
    println(formatItemList(plr.equipped.toList(), "Equipment"));
}

private fun commandHelp(arguments: List<String>){
    val padding: Int = 35; //using padEnd to add spaces to set a length, that way all the text lines up nicely
    println("Options:")
    println("- help".padEnd(padding)                    + "Shows all commands you can do.")
    println("- leave, back, return".padEnd(padding)     + "Stop interacting with your equipment.")
    println("- equipment, equip, armor".padEnd(padding) + "Shows your equipped item.")
    println("- { number }".padEnd(padding)              + "Start interacting with said item.")
}

private fun commandBack(plr: Player){
    plr.currentMenu = MenuType.NONE;
}
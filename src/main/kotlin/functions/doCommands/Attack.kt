package functions.doCommands

import classes.MenuType
import classes.Player
import classes.Room
import classes.item.Item
import functions.format.formatEnemyList
import functions.format.formatItemList
import functions.getWeapons

/**
 * Does a command based on the input
 */
public fun doCommandAttack(input: String, plr: Player){
    val arguments: List<String> = input.split(" ");

    val room = GlobalGameMap.gameMap[plr.currentLevel][plr.currentRoom]
    val (weapons, weaponIndices) = getWeapons(plr.inventory);

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

        //enemies aliases
        "enemy" -> {
            commandEnemies(room);
        }
        "enemies" -> {
            commandEnemies(room);
        }
        "opponents" -> {
            commandEnemies(room);
        }

        //weapon aliases
        "weapons" -> {
            commandWeapons(weapons);
        }
        "armaments" -> {
            commandWeapons(weapons);
        }


        else -> {
            val number: Int? = arguments[0].toIntOrNull() //convert input to int (or null if not int)
            if (number != null) { //is number
                if (number <= weapons.size && number >= -1) { //chose number in inventory

                    plr.currentMenu = MenuType.IN_ATTACK;

                    if (number >= 0) {
                        plr.currentMenuIndex = weaponIndices[number]
                    }else{
                        plr.currentMenuIndex = -1; //picked to use fists
                    }

                } else {
                    println("You did not pick a valid index of a weapon.")
                }

            } else { //is not a number
                println("You did not pick a valid number nor a valid command (type help for help)")
            }
        }
    }
}

private fun commandEnemies(room: Room){
    println(formatEnemyList(room.enemyList, room.name));
}
private fun commandWeapons(itemList: List<Item>){
    println(formatItemList(itemList, "Weapons"))
    println("-1 is your fists.")
}

private fun commandHelp(arguments: List<String>){
    val padding: Int = 35; //using padEnd to add spaces to set a length, that way all the text lines up nicely
    println("Options:")
    println("- help".padEnd(padding)                        + "Shows all commands you can do.")
    println("- leave, back, return".padEnd(padding)         + "Stop interacting with your enemies.")
    println("- enemy, enemies, opponents".padEnd(padding)   + "Shows enemies in this room.")
    println("- weapons, armaments".padEnd(padding)          + "Shows the weapons you can use.")
    println("- { number }".padEnd(padding)                  + "Start interacting with your chosen weapon (-1 for no weapon).")
}

private fun commandBack(plr: Player){
    plr.currentMenu = MenuType.NONE;
}
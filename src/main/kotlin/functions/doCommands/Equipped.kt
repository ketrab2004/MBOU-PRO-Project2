package functions.doCommands

import classes.*
import classes.item.*
import functions.format.formatItemList
import kotlin.math.round

/**
 * Does a command based on the input
 */
public fun doCommandIn_Equipment(input: String, plr: Player) {
    val arguments: List<String> = input.split(" ");

    val item = plr.equipped[plr.currentMenuIndex];

    if (item != null) { //selected item isn't null
        when (arguments[0].toLowerCase()) { //switch case
            "help" -> {
                commandHelp(arguments, item)
            }
            //Go back
            "back" -> {
                commandBack(arguments, plr)
            }

            //Inspect aliases
            "inspect" -> {
                commandInspect(arguments, item)
            }
            "info" -> {
                commandInspect(arguments, item)
            }


            //unequip aliases
            "unequip" -> {
                commandUnequip(arguments, plr, item)
            }
            "remove" -> {
                commandUnequip(arguments, plr, item)
            }


            else -> {
                println("⚠️'${arguments[0]}' is not a known command.")
            }
        }
    }else{ //selected item doesn't exist
        plr.currentMenu = MenuType.EQUIPMENT; //go back to equipment to pick a new item
    }
}

private fun commandHelp(args: List<String>, item: Item){
    val padding: Int = 35; //using padEnd to add spaces to set a length, that way all the text lines up nicely
    println("Commands:")
    println("* help".padEnd(padding)                   +"Shows all commands you can do.")
    println("* inspect, info".padEnd(padding)          +"Inspect the item to see it's description.")
    println("* unequip, remove".padEnd(padding)        +"Unequip this item and put it into your inventory.")
    println("* back".padEnd(padding)                   +"Return to the previous menu.")
}
private fun commandInspect(args: List<String>, item: Item){
    println("You inspect ${item.name}.")
    println(item.description)
}
private fun commandUnequip(args: List<String>, plr: Player, item: Item){
    plr.inventory.add(item); //add item to inventory

    var itemIndex = -1;
    for (index in 0..plr.equipped.size -1){ //look through equipped items to find item player is trying to unequip
        if (plr.equipped[index] == item) {
            itemIndex = index; //found item
            break; //break out of loop
        }
    }

    println("You unequipped '${item.name}' and put it into your inventory.")

    plr.equipped[itemIndex] = null; //remove item from equipped

    plr.currentMenu = MenuType.EQUIPMENT;
}
private fun commandBack(args: List<String>, plr: Player){
    println("You are back in your equipment.");
    plr.currentMenu = MenuType.EQUIPMENT;
}
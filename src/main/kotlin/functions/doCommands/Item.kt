package functions.doCommands

import classes.ItemCommands
import classes.Item
import classes.MenuType
import classes.Player

/**
 * Does a command based on the input
 */
public fun doCommand(input: String, item: Item, plr: Player){
    val arguments: List<String> = input.split(" ");



    when(arguments[0].toLowerCase()){ //switch case
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

        //Consume aliases
        "consume" -> {
            commandConsume(arguments, item)
        }
        "eat" -> {
            commandConsume(arguments, item)
        }
        "drink" -> {
            commandConsume(arguments, item)
        }

        //Equip aliases
        "equip" -> {
            commandEquip(arguments, item)
        }
        "wear" -> {
            commandEquip(arguments, item)
        }


        else -> {
            println("⚠️'${arguments[0]}' is not a known command.")
        }
    }
}

private fun commandHelp(args: List<String>, item: Item){
    val padding: Int = 35; //using padEnd to add spaces to set a length, that way all the text lines up nicely
    println("Commands:")
    println("* help".padEnd(padding)                   +"Shows all commands you can do.")
    println("* inspect, info".padEnd(padding)          +"Inspect the item to see it's description.")
    println("* consume, eat, drink".padEnd(padding)    +"Consume the item.")
    println("* equip, wear".padEnd(padding)            +"Equip the item in the first open slot.")
    println("* back".padEnd(padding)                   +"Return to the previous menu.")
}
private fun commandInspect(args: List<String>, item: Item){
    println("You inspect ${item.name}.")
    println(item.description)
}
private fun commandConsume(args: List<String>, item: Item){
    if(item.usableCommands.contains(ItemCommands.CONSUME)) { //consume is a usable command

    }else {
        println("You cannot consume '${item.name}'.")
    }
}
private fun commandEquip(args: List<String>, item: Item){
    if(item.usableCommands.contains(ItemCommands.EQUIP)) { //equip is a usable command

    }else {
        println("You cannot equip '${item.name}'.")
    }
}
private fun commandBack(args: List<String>, plr: Player){
    plr.currentMenu = MenuType.NONE;
}
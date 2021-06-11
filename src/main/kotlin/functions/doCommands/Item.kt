package functions.doCommands

import classes.*
import classes.item.*
import functions.format.formatItemList
import kotlin.math.round

/**
 * Does a command based on the input
 */
public fun doCommandItem(input: String, item: Item, plr: Player){
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
            commandConsume(arguments, item, plr)
        }
        "eat" -> {
            commandConsume(arguments, item, plr)
        }
        "drink" -> {
            commandConsume(arguments, item, plr)
        }

        //Equip aliases
        "equip" -> {
            commandEquip(arguments, plr, item)
        }
        "wear" -> {
            commandEquip(arguments, plr, item)
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
private fun commandConsume(args: List<String>, item: Item, plr: Player){
    if(item.usableCommands.contains(ItemCommands.CONSUME)) { //consume is a usable command
        val consumePoints = item.properties["EatPoints"];
        if (consumePoints is Float){

            if (plr.health < plr.maxHealth) { //can heal
                val gainedHealth = plr.addHealth(consumePoints);

                println("You consumed '${item.name}' and gained ${round(gainedHealth * 10) * .1} health.")
                if (plr.health == plr.maxHealth){
                    println("You are now at full health.")
                }

                plr.inventory.remove(item); //remove item from inventory

                plr.currentMenu = MenuType.INVENTORY; //selected item no longer exist so inventory
            }else{
                println("You cannot eat when you are at full health.")
            }
        }else{ //consume is in usable commands but no EatPoints given
            println("You cannot consume '${item.name}'.")
        }
    }else {
        println("You cannot consume '${item.name}'.")
    }
}
private fun commandEquip(args: List<String>, plr: Player, item: Item){
    if(item.usableCommands.contains(ItemCommands.EQUIP)) { //equip is a usable command
        val itemArmor = item.properties["ArmorSlot"]; //get item's ArmorSlot property
        if (itemArmor is ItemArmorSlot) {
            val equippedItem = plr.equipped[itemArmor.index]
            if (equippedItem == null){ //player is not yet wearing armor in that slot
                plr.equipped[itemArmor.index] = item; //equip in slot

                println("You equipped '${item.name}'.")
                plr.inventory.remove(item); //remove from inventory

                plr.currentMenu = MenuType.INVENTORY; //selected item no longer exist so inventory
            }else{ //player is already wearing something
                plr.inventory.add( equippedItem ) //add into inventory
                println("You unequipped '${equippedItem.name}' and equipped '${item.name}'.")
                
                plr.equipped[itemArmor.index] = item; //overwrite previously equipped item
                plr.inventory.remove(item); //remove from inventory
                plr.currentMenu = MenuType.INVENTORY; //selected item no longer exist so inventory
            }
        }else{ //equip is in usable commands, but no armorSlot is given
            println("You cannot equip '${item.name}'.")
        }
    }else {
        println("You cannot equip '${item.name}'.")
    }
}
private fun commandBack(args: List<String>, plr: Player){
    println("You are back in your inventory.");
    plr.currentMenu = MenuType.INVENTORY;
}
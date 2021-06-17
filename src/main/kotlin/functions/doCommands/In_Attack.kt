package functions.doCommands

import classes.*
import classes.item.*
import functions.doEnemyAttacks
import functions.format.formatEnemyList
import functions.format.formatItemList
import kotlin.math.round

/**
 * Does a command based on the input
 */
public fun doCommandIn_Attack(input: String, plr: Player, room: Room, weapon: Item?){
    val arguments: List<String> = input.split(" ");

    when(arguments[0].toLowerCase()){ //switch case
        "help" -> {
            commandHelp(arguments)
        }
        //Go back
        "back" -> {
            commandBack(arguments, plr)
        }

        //Inspect aliases
        "inspect" -> {
            commandInspect(arguments, weapon)
        }
        "info" -> {
            commandInspect(arguments, weapon)
        }

        //attack aliases
        "attack" -> {
            commandAttack(arguments, room, weapon, plr)
        }

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

        else -> {
            println("⚠️'${arguments[0]}' is not a known command.")
        }
    }
}

private fun commandHelp(args: List<String>){
    val padding: Int = 35; //using padEnd to add spaces to set a length, that way all the text lines up nicely
    println("Commands:")
    println("* help".padEnd(padding)                            +"Shows all commands you can do.")
    println("* inspect, info".padEnd(padding)                   +"Inspect the item to see it's description.")
    println("* attack { index of an enemy }".padEnd(padding)    +"Use this weapon to attack enemy {___}.")
    println("* enemy, enemies, opponents".padEnd(padding)       +"See enemies to know which to attack.")
    println("* back".padEnd(padding)                            +"Return to the previous menu.")
}
private fun commandAttack(args: List<String>, room: Room, weapon: Item?, plr: Player){
    var number: Int? = args[1].toIntOrNull() //convert input to int (or null if not int)

    if (room.enemyList.size <= 1){ //if not given number and there is only 1 enemy attack that enemy
        number = 0; }

    if (number != null) { //is number
        if (number <= room.enemyList.size && number >= 0) { //chose number in inventory

            val enemy = room.enemyList[number];
            val (damage, killed) = enemy.takeDamage(weapon)

            if (killed){
                println("You killed ${enemy.name} after doing $damage damage!")

                if (enemy.inventory.size == 1){ //gained 1 item
                    println("You gained ${enemy.inventory[0]}.");
                }else{
                    println("You gained ${enemy.inventory.size} items.")
                }
                plr.inventory.addAll(enemy.inventory); //add loot

                room.enemyList.remove(enemy); //destroy enemy

                if (room.enemyList.size <= 0){ //all enemies defeated
                    plr.battleMode = false;
                    plr.currentMenu = MenuType.NONE;

                    println("You defeated all the enemies inside of ${room.name}.")
                }
            }else{
                println("You did $damage to ${enemy.name}.")
            }

            doEnemyAttacks(plr, room); //enemies' turn to attack

        } else {
            println("You did not pick a valid index of a enemy.")
        }

    } else { //is not a number
        println("You did not pick a index of an enemy to attack.")
    }
}
private fun commandEnemies(room: Room){
    println(formatEnemyList(room.enemyList, room.name));
}
private fun commandInspect(args: List<String>, item: Item?){
    if (item != null) {
        println("You inspect ${item.name}.")
        println(item.description)
    }else{ //when chosen to use no item to attack with
        println("You inspect your fists.")
        println("They're actually your hands.")
    }
}
private fun commandBack(args: List<String>, plr: Player){
    println("You are back in your inventory.");
    plr.currentMenu = MenuType.INVENTORY;
}
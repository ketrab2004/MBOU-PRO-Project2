package functions.doCommands

import GlobalGameMap
import classes.MenuType
import classes.Player
import classes.Room
import classes.item.Item
import functions.format.formatEnemyList
import functions.format.formatItemList
import functions.format.formatPOIList
import functions.getFloor
import functions.getWeapons
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

        //Stats aliases
        "stats" -> {
            commandStats(arguments, plr);
        }
        "info" -> {
            commandStats(arguments, plr);
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

        //Say aliases
        "say" ->{
            commandSay(arguments);
        }

        //Room aliases
        "room" -> {
            commandRoom(arguments, plr)
        }
        "look" -> {
            commandRoom(arguments, plr)
        }

        //attack aliases
        "attack" -> {
            commandAttack(arguments, plr);
        }
        "fight" -> {
            commandAttack(arguments, plr);
        }

        //enemy aliases
        "enemy" -> {
            commandEnemies(arguments, plr);
        }
        "enemies" -> {
            commandEnemies(arguments, plr);
        }
        "opponents" -> {
            commandEnemies(arguments, plr);
        }


        else -> {
            println("! '${arguments[0]}' is not a known command")
        }
    }
}

//commands
private fun commandHelp(args: List<String>, plr: Player){
    val padding: Int = 35; //using padEnd to add spaces to set a length, that way all the text lines up nicely
    println("Commands:")
    println("* help".padEnd(padding)                            +"Shows all commands you can do.")
    println("* exit, leave".padEnd(padding)                     +"Closes the game.")
    println("* stats, info".padEnd(padding)                     +"Shows info about you (for example health).")
    println("* inventory, inv, items".padEnd(padding)           +"Shows your inventory.")
    println("* equipment, equip, armor".padEnd(padding)         +"Shows your equipped items.")
    if (plr.battleMode){ //only show while in battle mode
        println("* enemy, enemies, opponents".padEnd(padding)   +"Shows enemies so you can inspect them.")
        println("* attack, fight".padEnd(padding)               +"Shows your weapons and lets you use them.")
    }else{ //only show when not in battle mode
        println("* room, look".padEnd(padding)                  +"Inspect/look around the current room.")
    }
    println("* say { what you want to say }".padEnd(padding)    +"Say something")
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
    if (!plr.battleMode) {
        val room = GlobalGameMap.gameMap[plr.currentLevel][plr.currentRoom];
        println(room.name);
        println(room.description);

        println(formatPOIList(room.poiList, ""));

        if (room.poiList.isNotEmpty()) { //if stuff in room change currentMenu

            println("What item would you like to interact with? ")

            plr.currentMenu = MenuType.ROOM;
        }
    }else{
        println("You cannot interact with the room while you are fighting enemies.")
    }
}

private fun commandStats(args: List<String>, plr: Player){

    var floor = getFloor(plr);
    val cLevel = plr.currentLevel

    //You are on the ground floor, in the main hallway.
    println("You are on the $floor, in ${GlobalGameMap.gameMap[cLevel][plr.currentRoom].name}.")

    //health: ❤❤❤❤❤❤💔💔💔💔
    val heartCount: Int = Math.round(plr.maxHealth); //amount of hearts to show (maxHealth so it lines up nicely)
    val health: Int = Math.round( (plr.health / plr.maxHealth)* heartCount );
    println("Health: " + "❤".repeat(health) + "\uD83D\uDC94".repeat(heartCount - health) ) //repeat instead of padEnd because the emoijs are too long (bytes)

    //Armor: 12%
    val armor = Math.round(plr.calcArmorPerc() * 100); //*100 to go from 0-1 to 0-100
    println("Armor:  $armor%")

    println("You have ${plr.inventory.size} items in your inventory.")
}

private fun commandSay(args: List<String>){
    if (args.size > 1) {
        var whatYouSaid = args[1] //skip 0 because it

        if (args.size > 2) { //if you say more than 1 word loop through them
            for (i in 2..args.size -1) { //skip command and first word
                whatYouSaid += " ${args[i]}"
            }
        }

        if (whatYouSaid.isBlank()){ //if you say a bunch of spaces
            println("You say nothing.")
        }else{ //you did say something
            println("You say '$whatYouSaid'.");
        }
    }else{
        println("You say nothing.")
    }
}
//region battle mode commands
private fun commandAttack(args: List<String>, plr: Player){
    if (!plr.battleMode){
        println("There are no enemies to attack.")
    }else{
        val (weapons, _) = getWeapons(plr.inventory);
        println(formatItemList(weapons, "Weapons"))
        if (weapons.size > 0) {
            println("Pick your weapon.")

            plr.currentMenu = MenuType.ATTACK;
        }else{
            println("You have no weapons so you use your fists.")

            plr.currentMenuIndex = -1;
            plr.currentMenu = MenuType.IN_ATTACK;
        }
    }
}
private fun commandEnemies(args: List<String>, plr: Player){
    if (plr.battleMode){
        val room = GlobalGameMap.gameMap[plr.currentLevel][plr.currentRoom]

        var number: Int? = null;
        if (args.size >= 2){
            number = args[1].toIntOrNull();
        }

        if (number == null){
            println(formatEnemyList(room.enemyList, room.name))
            println("""
            You can inspect an enemy by giving the index of the enemy after enemy.
            For example:
            * enemy 0
            will return the description of ${room.enemyList[0].name}""".trimIndent())
        }else if (number < room.enemyList.size && number >= 0) {//gave a number of enemy to inspect
            val enemy = room.enemyList[number]
            println("You inspect ${enemy.name}.")
            println(enemy.description);

            val armor: Int = Math.round(plr.calcArmorPerc() * 1000) /10;
            //*100 to go from 0-1 to 0-1000 then divide so it is 0-100 but 13% will be rounded to 10%
            println("Armor:  $armor%")
        }else{
            println("$number is not an index of an enemy you can inspect.")
        }
    }else{
        println("There are no enemies to inspect.")
    }
}
//endregion
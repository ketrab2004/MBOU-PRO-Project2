package functions.doCommands

import classes.MenuType
import classes.Player
import classes.Room
import classes.item.Item
import classes.poi.POI

/**
 * Does a command based on the input
 */
public fun doCommandIn_Container(input: String, plr: Player, inventory: MutableList<Item>, poi: POI){
    val arguments: List<String> = input.split(" ");

    //val poi = room.poiList[plr.currentMenuIndex]
    //var inventory = poi.properties["Content"] as MutableList<Item>;
    var item = inventory[plr.currentMenuIndex1];

    when(arguments[0].toLowerCase()){ //switch case
        "help" -> {
            commandHelp(arguments, item);
        }
        //Go back
        "leave" -> {
            commandBack(plr, poi); }
        "back" -> {
            commandBack(plr, poi); }
        "return" -> {
            commandBack(plr, poi); }

        //inspect aliases
        "inspect" ->{
            commandInspect(item); }
        "info" ->{
            commandInspect(item); }

        //take aliases
        "take" ->{
            commandTake(plr, inventory, item); }
        "pickup" ->{
            commandTake(plr, inventory, item); }

        else -> {
            println("! '${arguments[0]}' is not a known command.")
        }
    }
}

private fun commandHelp(arguments: List<String>, item: Item){
    val padding: Int = 30; //using padEnd to add spaces to set a length, that way all the text lines up nicely
    println("Options:")
    println("- help".padEnd(padding)                   + "Shows all commands you can do.")
    println("- leave, back, return".padEnd(padding)    + "Stop interacting with ${item.name}.")
    println("- inspect, info".padEnd(padding)          + "Show info off ${item.name}.")
    println("- take, pickup".padEnd(padding)           + "Take ${item.name} and put it into your inventory.")
}

private fun commandBack(plr: Player, poi: POI){
    println("You are looking at the content of ${poi.name} again.")
    plr.currentMenu = MenuType.CONTAINER;
}

private fun commandInspect(item: Item){
    println(item.name);
    println(item.description);
}

private fun commandTake(plr: Player, inventory: MutableList<Item>, item: Item){
    println("You take ${item.name}.")

    plr.inventory.add(item);

    //_TODO_ check if this works
    //update: it does work :)
    inventory.remove(item);

    plr.currentMenu = MenuType.CONTAINER;
}
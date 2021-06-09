package functions.doCommands

import classes.Player
import classes.Room
import classes.item.Item
import classes.poi.*

public fun doCommandPOI(input: String, POI: POI, plr: Player){
    val arguments: List<String> = input.split(" ");

    when(arguments[0].toLowerCase()){ //switch case
        "help" -> {
            commandHelp(arguments)
        }
        //Go back
        "back" -> {
            commandBack(arguments)
        }

        //Inspect aliases
        "inspect" ->{
            commandInspect(arguments, POI)
        }
        "info" ->{
            commandInspect(arguments, POI)
        }

        //Enter aliases
        "enter" -> {
            commandEnter(arguments, POI, plr)
        }


        //Open aliases
        "open" -> {
            commandOpen(arguments, POI)
        }
        "search" -> {
            commandOpen(arguments, POI)
        }

        //Pickup aliases
        "pickup" -> {
            commandPickup(arguments, POI, plr)
        }
        "grab" -> {
            commandPickup(arguments, POI, plr)
        }

        //Destroy aliases
        "destroy" ->{
            commandDestroy(arguments, POI, plr)
        }
        "break" ->{
            commandDestroy(arguments, POI, plr)
        }


        else -> {
            println("⚠ '${arguments[0]}' is not a known command.")
        }
    }
}

private fun commandHelp(args: List<String>){
    // TODO only show relevant commands
    val padding: Int = 35; //using padEnd to add spaces to set a length, that way all the text lines up nicely
    println("Commands:")
    println("* help".padEnd(padding)                    +"Shows all commands you can do.")
    println("* inspect, info".padEnd(padding)           +"Inspect the object to see it's description.")
    println("* enter".padEnd(padding)                   +"Enter the door/staircase.")
    println("* open, search".padEnd(padding)            +"Open the object to see it's content.")
    println("* destroy, break".padEnd(padding)            +"Destroy the object.")
    println("* back".padEnd(padding)                    +"Return to the previous menu.")
}
private fun commandInspect(args: List<String> , POIClass: POI){
    println("You inspect ${POIClass.name}.")
    println(POIClass.description)
}
private fun commandEnter(args: List<String>, POI: POI, plr: Player){
    if(POI.usableCommands.contains(PossiblePOICommands.ENTER)) { //consume is a usable command
        val isLocked = POI.properties["IsLocked"]
        if (isLocked is Boolean){
            if (isLocked){
                println("This '${POI.name}' is locked and needs to be unlocked before it can be entered.");
                //TODO loop through items to find the key

            }else{ //door is not locked
                //TODO use staircase/door
            }
        }else{ //door is not locked
            //TODO use staircase/door
        }
    }else {
        println("You cannot enter '${POI.name}'.")
    }
}
private fun commandOpen(args: List<String>, POI: POI){
    if(POI.usableCommands.contains(PossiblePOICommands.OPEN)) { //open is a usable command
        val isLocked = POI.properties["IsLocked"]
        if (isLocked is Boolean){
            if (isLocked){
                println("This '${POI.name}' is locked and needs to be unlocked before it can be opened.");
                //TODO loop through items to find the key

            }else{ //container is not locked
                //TODO open container
            }
        }else{ //container does not have a isLocked var
            //TODO open container
        }
    }else {
        println("You cannot open '${POI.name}'.")
    }
}
private fun commandPickup(args: List<String>, POI: POI, plr: Player){
    if(POI.usableCommands.contains(PossiblePOICommands.PICKUP)) { //pickup is a usable command
        val pickup = POI.properties["Pickup"];
        if (pickup is Item){
            plr.inventory.add(pickup)

            println("You acquired '${pickup.name}'.")

            GlobalGameMap.gameMap[plr.currentLevel][plr.currentRoom].poiList.remove(POI)
        }else{ //poi has pickup as possible command but doesn't contain an item to pickup
            println("You cannot pick up '${POI.name}'.")
        }
    }else {
        println("You cannot pick up '${POI.name}'.")
    }
}
private fun commandDestroy(args: List<String>, POI: POI, plr: Player){
    if(POI.usableCommands.contains(PossiblePOICommands.DESTROY)) { //equip is a usable command
        println("You destroyed '${POI.name}'.")
        GlobalGameMap.gameMap[plr.currentLevel][plr.currentRoom].poiList.remove(POI)
    }else {
        println("You cannot destroy '${POI.name}'.")
    }
}
private fun commandUse(args: List<String>, POI: POI){
    if(POI.usableCommands.contains(PossiblePOICommands.USE)) { //equip is a usable command

    }else {
        println("There is no way to use '${POI.name}'.")
    }
}
private fun commandBack(args: List<String>){
    //TODO go back
}
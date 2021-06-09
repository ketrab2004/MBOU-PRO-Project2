package functions.doCommands

import classes.POI
import classes.PossiblePOICommands
import classes.POIType

public fun doCommandPOI(input: String, POI: POI){
    val arguments: List<String> = input.split(" ");

    when(arguments[0].toLowerCase()){ //switch case
        "help" -> {
            commandHelp(arguments)
        }
        //Go back
        "back" -> {
            commandBack(arguments)
        }

        //Enter aliases
        "enter" -> {
            commandEnter(arguments, POI)
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
            commandPickup(arguments, POI)
        }
        "pickup" -> {
            commandPickup(arguments, POI)
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
    println("* help".padEnd(padding)                   +"Shows all commands you can do.")
    println("* inspect, info".padEnd(padding)          +"Inspect the item to see it's description.")
    println("* consume, eat, drink".padEnd(padding)    +"Consume the item.")
    println("* equip, wear".padEnd(padding)            +"Equip the item in the first open slot.")
    println("* back".padEnd(padding)                   +"Return to the previous menu.")
}
private fun commandInspect(args: List<String> , POIClass: POI){
    println("You inspect ${POIClass.name}.")
    println(POIClass.description)
}
private fun commandEnter(args: List<String>, POIClass: POI){
    if(POIClass.usableCommands.contains(PossiblePOICommands.ENTER)) { //consume is a usable command
        if (POIClass.isLocked)
        {
            //TODO Check player inventory for the right item to unlock POI
            println("You do not have the right item to unlock this '${POIClass.name}'")
        }
        else
        {
            println("You open the '${POIClass.name}' and enter it.")
            //TODO Send player to new room
        }
    }else {
        println("You cannot enter '${POIClass.name}'.")
    }
}
private fun commandOpen(args: List<String>, POIClass: POI){
    if(POIClass.usableCommands.contains(PossiblePOICommands.OPEN)) { //open is a usable command
        // TODO open inventory of Classes.POI
    }else {
        println("You cannot open '${POIClass.name}'.")
    }
}
private fun commandPickup(args: List<String>, POIClass: POI){
    if(POIClass.usableCommands.contains(PossiblePOICommands.PICKUP)) { //pickup is a usable command
        // TODO add item to inventory
    }else {
        println("You cannot pick up '${POIClass.name}'.")
    }
}
private fun commandDestroy(args: List<String>, POIClass: POI){
    if(POIClass.usableCommands.contains(PossiblePOICommands.DESTROY)) { //equip is a usable command
        // TODO destroy the object from the room
    }else {
        println("You cannot destroy '${POIClass.name}'.")
    }
}
private fun commandUse(args: List<String>, POIClass: POI){
    if(POIClass.usableCommands.contains(PossiblePOICommands.USE)) { //equip is a usable command

    }else {
        println("There is no way to use '${POIClass.name}'.")
    }
}
private fun commandBack(args: List<String>){
    //TODO go back
}
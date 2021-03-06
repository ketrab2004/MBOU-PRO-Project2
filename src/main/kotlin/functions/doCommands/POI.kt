package functions.doCommands

import classes.MenuType
import classes.Player
import classes.item.Item
import classes.poi.*
import functions.checkForEnemies
import functions.checkForKey
import functions.format.formatItemList
import functions.getFloor

public fun doCommandPOI(input: String, POI: POI, plr: Player){
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
            commandOpen(arguments, POI, plr)
        }
        "search" -> {
            commandOpen(arguments, POI, plr)
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
            println("! '${arguments[0]}' is not a known command.")
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
    println("* pickup, grab".padEnd(padding)            +"Pickup the item.")
    println("* destroy, break".padEnd(padding)          +"Destroy the object.")
    println("* back".padEnd(padding)                    +"Return to the previous menu.")
}
private fun commandInspect(args: List<String> , POIClass: POI){
    println("You inspect ${POIClass.name}.")
    println(POIClass.description)
}
private fun commandEnter(args: List<String>, POI: POI, plr: Player){
    if(POI.usableCommands.contains(PossiblePOICommands.ENTER)) { //enter is a usable command
        val targetRoom = POI.properties["TargetRoom"]
        val targetLevel = POI.properties["TargetFloor"]

        //if targetroom and floor are set
        //or
        //if targetRoom is set and poi is a door
        if (targetRoom is Int && targetLevel is Int || targetRoom is Int && POI.type == POIType.DOOR){
            val isLocked = POI.properties["IsLocked"]
            val key = POI.properties["Key"]
            if (isLocked is Boolean && key is String) { //isLocked doesn't matter if no key given
                if (isLocked){
                    println("This '${POI.name}' is locked and needs to be unlocked before it can be entered.");

                    val (hasKey, key) = checkForKey(plr, key);
                    if (hasKey){
                        if (key != null){
                            println("You unlocked '${POI.name}' using '${key.name}' and enter.")

                            print("You are now ")
                            if (targetLevel is Int){ //only if poi is not a door, thus a staircase
                                plr.currentLevel = targetLevel;

                                print("on the ${getFloor(plr)} ") //add extra on floor inbetween if changed floors
                            }
                            print("in ${GlobalGameMap.gameMap[plr.currentLevel][targetRoom].name}.\n")

                            plr.currentRoom = targetRoom;
                            plr.currentMenu = MenuType.ROOM; //go back to room after entering

                            val enemiesFound = checkForEnemies(plr) //check for enemies, go into battle mode if there are enemies

                            if (enemiesFound){ //in battle mode you cannot interact with the room, so change menuType
                                plr.currentMenu = MenuType.NONE;
                            }
                        }else{
                            println("You unlocked '${POI.name}' and enter.") //unlocked but key is null somehow

                            print("You are now ")
                            if (targetLevel is Int){ //only if poi is not a door, thus a staircase
                                plr.currentLevel = targetLevel;

                                print("on the ${getFloor(plr)} ") //add extra on floor inbetween if changed floors
                            }
                            print("in ${GlobalGameMap.gameMap[plr.currentLevel][targetRoom].name}.\n")

                            plr.currentRoom = targetRoom;
                            plr.currentMenu = MenuType.ROOM; //go back to room after entering

                            val enemiesFound = checkForEnemies(plr) //check for enemies, go into battle mode if there are enemies

                            if (enemiesFound){ //in battle mode you cannot interact with the room, so change menuType
                                plr.currentMenu = MenuType.NONE;
                            }
                        }
                    } //you don't have a key so don't do anything
                    //(already showed text saying that it's locked)

                }else{ //door is not locked
                    print("You are now ")
                    if (targetLevel is Int){ //only if poi is not a door, thus a staircase
                        plr.currentLevel = targetLevel;

                        print("on the ${getFloor(plr)} ") //add extra on floor inbetween if changed floors
                    }
                    print("in ${GlobalGameMap.gameMap[plr.currentLevel][targetRoom].name}.\n")

                    plr.currentRoom = targetRoom;
                    plr.currentMenu = MenuType.ROOM; //go back to room after entering

                    val enemiesFound = checkForEnemies(plr) //check for enemies, go into battle mode if there are enemies

                    if (enemiesFound){ //in battle mode you cannot interact with the room, so change menuType
                        plr.currentMenu = MenuType.NONE;
                    }
                }
            }else{ //door is not locked (no key set/ islocked not set)
                print("You are now ")
                if (targetLevel is Int){ //only if poi is not a door, thus a staircase
                    plr.currentLevel = targetLevel;

                    print("on the ${getFloor(plr)} ") //add extra on floor inbetween if changed floors
                }
                print("in ${GlobalGameMap.gameMap[plr.currentLevel][targetRoom].name}.\n")

                plr.currentRoom = targetRoom;
                plr.currentMenu = MenuType.ROOM; //go back to room after entering

                val enemiesFound = checkForEnemies(plr) //check for enemies, go into battle mode if there are enemies

                if (enemiesFound){ //in battle mode you cannot interact with the room, so change menuType
                    plr.currentMenu = MenuType.NONE;
                }
            }
        } else
        {
            println("You cannot enter '${POI.name}'. [ERROR: Room or level not set]")
        }

    }else {
        println("You cannot enter '${POI.name}'.")
    }
}
private fun commandOpen(args: List<String>, POI: POI, plr: Player){
    if(POI.usableCommands.contains(PossiblePOICommands.OPEN)) { //open is a usable command
        var content = POI.properties["Content"];
        if (content is MutableList<*>) {
            val isLocked = POI.properties["IsLocked"]
            val key = POI.properties["Key"]
            if (isLocked is Boolean && key is String) { //isLocked doesn't matter if no key given
                if (isLocked) {
                    println("This '${POI.name}' is locked and needs to be unlocked before it can be opened.");

                    val (hasKey, key) = checkForKey(plr, key);
                    if (hasKey){
                        if (key != null){
                            println("You unlocked '${POI.name}' using '${key.name}'.")

                            if (content.size > 0) {
                                plr.currentMenu = MenuType.CONTAINER;
                                //currentMenuIndex doesn't change
                            }

                            @Suppress("UNCHECKED_CAST") //intelij :)
                            println(formatItemList(content as List<Item>, POI.name));
                        }else{
                            println("You unlocked '${POI.name}'.") //unlocked but key is null somehow

                            if (content.size > 0) {
                                plr.currentMenu = MenuType.CONTAINER;
                                //currentMenuIndex doesn't change
                            }

                            @Suppress("UNCHECKED_CAST") //intelij :)
                            println(formatItemList(content as List<Item>, POI.name));
                        }
                    } //you don't have a key so don't do anything

                } else { //container is not locked
                    if (content.size > 0) {
                        plr.currentMenu = MenuType.CONTAINER;
                        //currentMenuIndex doesn't change
                    }

                    @Suppress("UNCHECKED_CAST") //intelij :)
                    println(formatItemList(content as List<Item>, POI.name));
                }
            } else { //container does not have a isLocked var
                if (content.size > 0) {
                    plr.currentMenu = MenuType.CONTAINER;
                    //currentMenuIndex doesn't change
                }

                @Suppress("UNCHECKED_CAST") //intelij :)
                println(formatItemList(content as List<Item>, POI.name));
            }
        }else{ //poi has open as possible command but doesn't have content
            println("You cannot open '${POI.name}'.")
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
            plr.currentMenu = MenuType.ROOM; //chosen poi doesn't exist anymore so go back to pick a new one
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
        plr.currentMenu = MenuType.ROOM; //chosen poi doesn't exist anymore so go back to pick a new one
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
private fun commandBack(args: List<String>, plr: Player){
    println("You are looking around the room again.");
    plr.currentMenu = MenuType.ROOM; //don't go back all the way
}
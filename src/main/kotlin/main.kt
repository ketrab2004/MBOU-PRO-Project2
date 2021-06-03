import classes.* //import all classes
import functions.doCommands.* //import all doCommands

fun main(args: Array<String>) {

    var gameMap: Array<List<Room>> = getGameMap(); //get gameMap from gameMap.kt

    println("Welcome to Dracula's castle...")

    print("Choose your name: ")
    var player: Player = Player(readLine().toString(), "The player", 10f)

    // region TEMP
    player.inventory += Item("Item 1", "woop", 1)
    player.inventory += Item("Item 5", "woop", 1)
    player.inventory += Item("Item 7", "woop", 1)
    player.inventory += Item("Item 13", "woop", 1)
    player.inventory += Item("Item 4", "woop", 1)
    // endregion

    println("You, ${player.name}, enter Dracula's castle.")

    /*TODO
     * start loop
     * maybe show the description of first room etc
     * also set player.Room or something
     */

    print("What will you do?\n* ")
    doPlayerCommand(readLine().toString(), player)

    while (true){ //game loop
        when(player.currentMenu){
            MenuType.NONE ->{
                print("* ") //print * to type command after
                doPlayerCommand(readLine().toString(), player)
            }
            MenuType.INVENTORY ->{
                val item = player.inventory[player.currentMenuIndex]
                print("${item.name} - ") //print item name - to type command after
                doCommand(readLine().toString(), item, player)
            }
            MenuType.ROOM ->{
                val room = gameMap[player.currentLevel][player.currentRoom]
                print("${room.name} * ") //print room name * to type command after
                readLine().toString() //TODO surround with Room do Command
            }
            MenuType.POI ->{
                val poi = gameMap[player.currentLevel][player.currentRoom].poiList[player.currentMenuIndex]
                print("${poi.name} - ") //print poi name - to type command after
                readLine().toString() //TODO surround with POI do Command
            }
        }
    }

}
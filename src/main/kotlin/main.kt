import classes.* //import all classes
import classes.item.* //import all item classes ( .*.* doesn't work :( )
import classes.POI.* //import all POI classes ( .*.* doesn't work :( )
import functions.doCommands.* //import all doCommands

fun main(args: Array<String>) {

    var gameMap: Array<List<Room>> = getGameMap(); //get gameMap from gameMap.kt

    println("Welcome to Dracula's castle...")

    print("Choose your name: ")
    var player: Player = Player(readLine().toString(), "The player", 10f)

    println("You, ${player.name}, enter Dracula's castle.")



}
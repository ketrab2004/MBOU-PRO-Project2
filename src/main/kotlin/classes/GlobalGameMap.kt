import classes.Room

/**
 * array with lists of rooms
 *
 * each list in the array is an level/floor
 *
 * each room in each list is a room
 *
 * 8 levels/floors
 */
public var gameMap: Array<List<Room>> =
    arrayOf(listOf(), listOf(), listOf(), listOf(), listOf(), listOf(), listOf(), listOf())

var room = Room("Main hallway", "A big hallway leading through the entire bottom floor of the castle", listOf())
//TODO add POIs
var level0: List<Room> = listOf(room)
gameMap[0] = level0

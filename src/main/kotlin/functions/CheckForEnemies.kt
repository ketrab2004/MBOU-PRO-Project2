package functions

import classes.Player
import functions.format.formatEnemyList

/**
 * Checks if the current room of the given player has enemies, if there are enemies it returns true and puts the given player into battle mode
 *
 * @param[plr] player whose inventory to search
 * @return true if there are enemies
 */
public fun checkForEnemies(plr: Player): Boolean{
    val room = GlobalGameMap.gameMap[plr.currentLevel][plr.currentRoom];
    if(room.enemyList.size > 0){ //there are enemies

        plr.battleMode = true;

        println(formatEnemyList(room.enemyList, room.name)); //show enemies

        if (room.enemyList.size > 1){ //check if plural
            println("There are ${room.enemyList.size} enemies, what will you do?")
        }else{
            println("There is a enemy, what will you do?")
        }
        return true
    }
    return false;
}
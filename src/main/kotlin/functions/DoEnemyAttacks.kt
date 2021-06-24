package functions

import classes.Player
import classes.Room
import classes.item.Item
import kotlin.system.exitProcess

public fun doEnemyAttacks(plr: Player, room: Room){

    if(room.enemyList.size > 0){ //print empty line before enemy attacks if there are enemies
        println("");
    }

    room.enemyList.forEach{
        val (weapons, _) = getWeapons(it.inventory)
        var weapon: Item? = null;

        if (weapons.size > 0){
            weapon = weapons[0] //use first weapon in inventory as weapon
        }

        val (damage, _) = plr.takeDamage(weapon);
        println("${it.name} did ${Math.round(damage*10) /10f} to you.")
    }

    if (plr.health <= 0){ //TODO make this better ;)
        println("You have died.")
        println("Any last words?")
        readLine()
        exitProcess(0) //close game after player typed
    }

}
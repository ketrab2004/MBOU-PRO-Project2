package functions

import classes.Player
import classes.item.Item
import classes.item.ItemType

/**
 * Checks if a player has a key in their inventory matching the given key
 *
 * @param[plr] player whose inventory to search
 * @param[key] keyCode to look for
 *
 * @return true if a key has been found, false if not
 * also returns item key
 */
public fun checkForKey(plr: Player, key: String): Pair<Boolean, Item?>{
    plr.inventory.forEach {
        if (it.type == ItemType.KEY){ //item is a key
            val itKey = it.properties["Key"]
            if (itKey is String){ //key property has been set
                if (itKey == key){ //key matches
                    return Pair(true, it); //found so return true with key
                }
            }
        }
    }
    return Pair(false, null); //return false because nothing was found
}
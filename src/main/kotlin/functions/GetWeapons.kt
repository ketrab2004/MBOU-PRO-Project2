package functions

import classes.item.Item
import classes.item.ItemType

/**
 * Give a list of items and get a list of the weapons in that list
 * @return a pair with 2 lists, first is weapns, second is indices inside of given itemList
 */
public fun getWeapons(itemList: List<Item>): Pair<MutableList<Item>, MutableList<Int>>{
    var weapons = Pair(mutableListOf<Item>(), mutableListOf<Int>());

    itemList.forEachIndexed { index, element ->
        if (element.type == ItemType.WEAPON){
            weapons.first.add(element);
            weapons.second.add(index)
        }
    }

    return weapons
}
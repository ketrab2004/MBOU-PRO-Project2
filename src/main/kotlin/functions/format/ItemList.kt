package functions.format

import classes.item.*

/**
 * Formats an [itemList] into a grid to display its contents.
 *
 * @param itemList A list of items to display.
 * @param title Title to show at the top of the item grid, use "" if you don't want a title.
 * @return A string with line breaks, use println() to print it.
 * (only use print() if you know that the current line is empty)
 */
public fun formatItemList(itemList: List<Any>, title: String) : String{
    var toReturn: String = "";

    var longestItemName: Int = 0;

    var nameArray = arrayOfNulls<String>(itemList.size);
    itemList.forEachIndexed { index, item ->
        when (item){ //do .name for each class type
            is Item -> {
                nameArray[index] = item.name;
            }
            is Weapon -> {
                nameArray[index] = item.name;
            }
            is Armor -> {
                nameArray[index] = item.name;
            }
            is Consumable -> {
                nameArray[index] = item.name;
            }
            else -> { //not an item so do error
                nameArray[index] = "Null";
                println("⚠ $item is not an Item class and can't be shown in $title ⚠")
            }
        }
    }

    nameArray.forEach(){ //find how long longest item name is in itemList
        //instead of
        //it ? it.length : 0
        var length = 0;
        if (it != null){
            length = it.length
        }

        if(length > longestItemName){
            longestItemName = length;
        }
    }

    //hardcoded because there is no other way
    val numberLength = 5;
    val extraLength = numberLength + 4; //can't be lower than numberLength
    val screenWidth: Int = Math.max(128,    longestItemName + extraLength);
    // If longestItemName is larger than width, use it as width
    // (10, 12) = 12; (100, 12) = 100


    val itemsPerRow: Int = Math.min(
        Math.floor( screenWidth.toDouble() / (longestItemName + extraLength)).toInt(),
        itemList.size);
    // If there are less items in the itemList than can fit on a row,
    // make the row less long so the inventory top and bottom lines are shorter
    // (10, 3) = 3; (10, 24) = 10

    toReturn+= title.padEnd((longestItemName + extraLength) * itemsPerRow -1, '-') +"\n"; //top line with title
    //subtract 1 because each item ends on " | " which has an extra space at the end which doesn't need a - above it

    nameArray.forEachIndexed { index, element ->
        toReturn+= ("$index. " //number of item
            .padEnd(numberLength) //add spaces to make it numberlength long
                +element) //add name of item
            .padEnd(longestItemName + extraLength - 3) +" | "
        //add spaces so that combined text is longestItemName + extraLength (which is number + numberLength)
        //subtract 3 because " | " is 3 long

        if ((index+1) % itemsPerRow == 0 && index != itemList.size-1) { //if index is last of row, but not last index
            toReturn+= "\n"; //new line
        }
    }

    toReturn+= "\n".padEnd((longestItemName + extraLength) * itemsPerRow, '-'); //bottom line
    //dont need to subtract 1 because "\n" is 1 character, so 1 is already subtracted (because it has no width)

    return toReturn;
}
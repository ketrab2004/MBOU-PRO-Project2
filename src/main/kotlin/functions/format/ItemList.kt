package functions.format

import classes.item.Item

/**
 * Formats an [itemList] into a grid to display its contents.
 *
 * @param itemList A list of items to display.
 * @param title Title to show at the top of the item grid, use "" if you don't want a title.
 * @return A string with line breaks, use println() to print it.
 * (only use print() if you know that the current line is empty)
 */
public fun formatItemList(itemList: List<Item>, title: String) : String{
    if (itemList.isEmpty()){ //when empty avoid all normal steps
        val content = " * empty * "
        val length = Math.max(title.length +2, content.length) //length is either content or title+2 (so title has a couple stripes)
        var toReturn = title.padEnd(length, '-') + "\n" //top line with title
        toReturn+= "$content\n" //content
        toReturn+= "".padEnd(length, '-') //bottom line

        return toReturn
    }

    var toReturn: String = "";

    var longestItemName: Int = 0;

    itemList.forEach(){ //find how long longest item name is in itemList
        if(it.name.length > longestItemName){
            longestItemName = it.name.length;
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

    itemList.forEachIndexed { index, element ->
        toReturn+= ("$index. " //number of item
            .padEnd(numberLength) //add spaces to make it numberlength long
                +element.name) //add name of item
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
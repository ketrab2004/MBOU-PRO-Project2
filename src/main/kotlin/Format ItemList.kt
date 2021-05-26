/**
 * Formats an [itemList] into a grid to display its contents.
 *
 * @param itemList A list of items to display.
 * @param title Title to show at the top of the item grid, use "" if you don't want a title.
 * @return A string with line breaks, use println() to print it.
 * (only use print() if you know that the current line is empty)
 */
fun formatItemList(itemList: List<Item>, title: String) : String{
    var toReturn: String = "";

    var longestItemName: Int = 0;

    itemList.forEach(){ //find how long longest item name is in itemList
        if(it.name.length > longestItemName){
            longestItemName = it.name.length
        }
    }

    //hardcoded because there is no other way
    val numberLength = 5;
    val extraLength = numberLength + 4; //can't be lower than numberLength
    val screenWidth: Int = Math.max(128,    longestItemName + extraLength);
    // If longestItemName is larger than width, use it as width
    // (10, 12) = 12; (100, 12) = 100


    val itemsPerRow: Int = Math.floor( screenWidth.toDouble() / (longestItemName + extraLength)).toInt()

    toReturn+= title.padEnd((longestItemName + extraLength) * itemsPerRow -1, '-') +"\n"; //top line with title

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

    return toReturn;
}
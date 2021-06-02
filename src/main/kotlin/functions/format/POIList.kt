package functions.format

import classes.POI.*

/**
 * Formats an [POIList] into a grid to display its contents.
 * Copy of [formatItemList]
 *
 * @param POIList A list of POIs to display.
 * @param title Title to show at the top of the Classes.POI grid, use "" if you don't want a title.
 * @return A string with line breaks, use println() to print it.
 * (only use print() if you know that the current line is empty)
 */
public fun formatPOIList(POIList: List<POI>, title: String) : String{
    var toReturn: String = "";

    var longestPOIName: Int = 0;

    POIList.forEach(){ //find how long longest poi name is in POIList
        if(it.name.length > longestPOIName){
            longestPOIName = it.name.length
        }
    }

    //hardcoded because there is no other way
    val numberLength = 5;
    val extraLength = numberLength + 4; //can't be lower than numberLength
    val screenWidth: Int = Math.max(128,    longestPOIName + extraLength);
    // If longestPOIName is larger than width, use it as width
    // (10, 12) = 12; (100, 12) = 100


    val POIsPerRow: Int = Math.min(
        Math.floor( screenWidth.toDouble() / (longestPOIName + extraLength)).toInt(),
        POIList.size);
    // If there are less POIs in the POIList than can fit on a row,
    // make the row less long so the inventory top and bottom lines are shorter
    // (10, 3) = 3; (10, 24) = 10

    toReturn+= title.padEnd((longestPOIName + extraLength) * POIsPerRow -1, '-') +"\n"; //top line with title
    //subtract 1 because each item ends on " | " which has an extra space at the end which doesn't need a - above it

    POIList.forEachIndexed { index, element ->
        toReturn+= ("$index. " //number of Classes.POI
            .padEnd(numberLength) //add spaces to make it numberlength long
                +element.name) //add name of Classes.POI
            .padEnd(longestPOIName + extraLength - 3) +" | "
        //add spaces so that combined text is longestPOIName + extraLength (which is number + numberLength)
        //subtract 3 because " | " is 3 long

        if ((index+1) % POIsPerRow == 0 && index != POIList.size-1) { //if index is last of row, but not last index
            toReturn+= "\n"; //new line
        }
    }

    toReturn+= "\n".padEnd((longestPOIName + extraLength) * POIsPerRow, '-'); //bottom line
    //dont need to subtract 1 because "\n" is 1 character, so 1 is already subtracted (because it has no width)

    return toReturn;
}
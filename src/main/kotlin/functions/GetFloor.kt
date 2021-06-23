package functions

import classes.Player

public fun getFloor(plr: Player): String{
    var floor = "ground floor"
    val cLevel = plr.currentLevel
    if (cLevel != 0){
        when(cLevel){ //switch case for floor name
            // 0 is ground floor
            1 -> {  floor = "1st floor" }
            2 -> {  floor = "2nd floor" }
            3 -> {  floor = "3rd floor" }
            else ->{floor = "${cLevel}th floor"} //above 3rd is 4th, 5th, 6th, 7th etc.
        }
    }

    return floor;
}
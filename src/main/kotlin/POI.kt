enum class POICommands {
    ENTER,
    OPEN,
    PICKUP,
    DESTROY,
}

//TODO make inventory a Item class list
open class POI (name: String, description: String){
    var inventory: List<Int> = listOf();

    var possibleCommands : List<POICommands> = listOf();
}

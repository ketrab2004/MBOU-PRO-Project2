package classes.POI

class Container (name: String,
                 description: String,
                 usableCommands : List<PossiblePOICommands> = listOf())
            : POI(name, description, usableCommands){ //Extends POI
    var isLocked: Boolean = false;
    var inventory: List<classes.item.Item> = listOf()
}
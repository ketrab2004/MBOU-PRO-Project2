package classes.poi

class Container (name: String, description: String)
            : POI(name, description){ //Extends POI
    var isLocked: Boolean = false;
    var inventory: List<classes.item.Item> = listOf()
}
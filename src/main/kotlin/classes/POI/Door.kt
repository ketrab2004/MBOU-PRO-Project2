package classes.POI

class Door (name: String,
            description: String,
            usableCommands : List<PossiblePOICommands> = listOf())
            : POI(name, description, usableCommands){ //Extends POI
    var isLocked: Boolean = false;
    //TODO room variable to send upon entering door
    val destinationRoom: classes.Room = classes.Room("none","none", emptyList());
}
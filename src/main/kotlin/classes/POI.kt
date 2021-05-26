package classes

enum class PossiblePOICommands {
    ENTER,
    OPEN,
    PICKUP,
    DESTROY,
    USE,
}

//TODO make inventory a Classes.Item class list
open class POI (val name: String,
                val description: String,
                val usableCommands : List<PossiblePOICommands> = listOf()){
    var inventory: List<Int> = listOf()
}
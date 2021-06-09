package classes.POI

enum class PossiblePOICommands {
    ENTER,
    OPEN,
    PICKUP,
    DESTROY,
    USE,
}


open class POI (val name: String,
                val description: String,
                val usableCommands : List<PossiblePOICommands> = listOf()){

}
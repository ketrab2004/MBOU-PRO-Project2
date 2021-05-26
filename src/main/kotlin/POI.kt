enum class POICommands {
    ENTER,
    OPEN,
    PICKUP,
    DESTROY,
    USE,
}

//TODO make inventory a Item class list
open class POI (val name: String, val description: String){
    var inventory: List<Int> = listOf();

    var usableCommands : List<POICommands> = listOf();

    /**
     * Does a command based on the input
     */
    public fun doCommand(input: String){
        val arguments: List<String> = input.split(" ");

        when(arguments[0].toLowerCase()){ //switch case
            "help" -> {
                commandHelp(arguments)
            }
            //Go back
            "back" -> {
                commandBack(arguments)
            }

            //Enter aliases
            "enter" -> {
                commandEnter(arguments)
            }


            //Open aliases
            "open" -> {
                commandOpen(arguments)
            }
            "search" -> {
                commandOpen(arguments)
            }

            //Pickup aliases
            "pickup" -> {
                commandPickup(arguments)
            }
            "pickup" -> {
                commandPickup(arguments)
            }





            else -> {
                println("⚠ '${arguments[0]}' is not a known command.")
            }
        }
    }

    private fun commandHelp(args: List<String>){
        // TODO only show relevant commands
        val padding: Int = 35; //using padEnd to add spaces to set a length, that way all the text lines up nicely
        println("Commands:")
        println("* help".padEnd(padding)                   +"Shows all commands you can do.")
        println("* inspect, info".padEnd(padding)          +"Inspect the item to see it's description.")
        println("* consume, eat, drink".padEnd(padding)    +"Consume the item.")
        println("* equip, wear".padEnd(padding)            +"Equip the item in the first open slot.")
        println("* back".padEnd(padding)                   +"Return to the previous menu.")
    }
    private fun commandInspect(args: List<String>){
        println("You inspect $name.")
        println(description)
    }
    private fun commandEnter(args: List<String>){
        if(usableCommands.contains(POICommands.ENTER)) { //consume is a usable command
            // TODO enter a new room
        }else {
            println("You cannot enter '$name'.")
        }
    }
    private fun commandOpen(args: List<String>){
        if(usableCommands.contains(POICommands.OPEN)) { //open is a usable command
            // TODO open inventory of POI
        }else {
            println("You cannot open '$name'.")
        }
    }
    private fun commandPickup(args: List<String>){
        if(usableCommands.contains(POICommands.PICKUP)) { //pickup is a usable command
            // TODO add item to inventory
        }else {
            println("You cannot pick up '$name'.")
        }
    }
    private fun commandDestroy(args: List<String>){
        if(usableCommands.contains(POICommands.DESTROY)) { //equip is a usable command
            // TODO destroy the object from the room
        }else {
            println("You cannot destroy '$name'.")
        }
    }
    private fun commandUse(args: List<String>){
        if(usableCommands.contains(POICommands.USE)) { //equip is a usable command

        }else {
            println("There is no way to use '$name'.")
        }
    }
    private fun commandBack(args: List<String>){
        //TODO go back
    }
}
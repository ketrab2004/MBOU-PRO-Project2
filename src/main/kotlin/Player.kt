class Player(name: String, description: String, maxHealth: Float)
    : Enemy(name, description, maxHealth) { //extends Enemy

    var currentRoom: Int = 2; //TODO change Int to room and etc

    /**
     * Does a command based on the input [input]
     */
    public fun doCommand(input: String){
        val arguments: List<String> = input.split(" ");

        when(arguments[0].toLowerCase()){ //switch case
            "help" -> {
                commandHelp(arguments)
            }

            //Exit aliases
            "exit" -> {
                commandExit(arguments)
            }
            "leave" -> {
                commandExit(arguments)
            }

            //Inventory aliases
            "inventory" -> {
                commandInventory(arguments)
            }
            "inv" -> {
                commandInventory(arguments)
            }
            "items" -> {
                commandInventory(arguments)
            }

            //Room aliases
            "room" -> {
                commandRoom(arguments)
            }
            "look" -> {
                commandRoom(arguments)
            }


            else -> {
                println("⚠ '${arguments[0]}' is not a known command")
            }
        }
    }

    private fun commandHelp(args: List<String>){
        val padding: Int = 35; //using padEnd to add spaces to set a length, that way all the text lines up nicely
        println("Commands:")
        println("* help".padEnd(padding)                   +"Shows all commands you can do.")
        println("* exit, leave".padEnd(padding)            +"Closes the game.")
        println("* inventory, inv, items".padEnd(padding)  +"Shows your inventory.")
        println("* room, look".padEnd(padding)             +"Inspect/look around the current room.")
    }
    private fun commandExit(args: List<String>){
        //TODO exit game
    }
    private fun commandInventory(args: List<String>){
    }
    private fun commandRoom(args: List<String>){
    }


}
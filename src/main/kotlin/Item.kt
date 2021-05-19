enum class ItemCommands{
    CONSUME,
    EQUIP

}
enum class ItemType{
    WEAPON,
    WEARABLE,
    EDIBLE
}

class Item(val name: String,
           val description: String,
           val type: ItemType,
           val maxStackSize: Int) {

    var usableCommands: List<ItemCommands> = listOf(); //list of usable commands

    var amount: Int = 1;

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

            //Inspect aliases
            "inspect" -> {
                commandInspect(arguments)
            }
            "info" -> {
                commandInspect(arguments)
            }

            //Consume aliases
            "consume" -> {
                commandConsume(arguments)
            }
            "eat" -> {
                commandConsume(arguments)
            }
            "drink" -> {
                commandConsume(arguments)
            }

            //Equip aliases
            "equip" -> {
                commandEquip(arguments)
            }
            "wear" -> {
                commandEquip(arguments)
            }


            else -> {
                println("⚠ '${arguments[0]}' is not a known command.")
            }
        }
    }

    private fun commandHelp(args: List<String>){
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
    private fun commandConsume(args: List<String>){
        if(usableCommands.contains(ItemCommands.CONSUME)) { //consume is a usable command

        }else {
            println("You cannot consume '$name'.")
        }
    }
    private fun commandEquip(args: List<String>){
        if(usableCommands.contains(ItemCommands.EQUIP)) { //equip is a usable command

        }else {
            println("You cannot equip '$name'.")
        }
    }
    private fun commandBack(args: List<String>){
        //TODO go back
    }
}
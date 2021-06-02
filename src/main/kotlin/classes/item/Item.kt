package classes.item

enum class ItemCommands{
    CONSUME,
    EQUIP

}
enum class ItemType{
    WEAPON,
    WEARABLE,
    EDIBLE,
    MISC
}

open class Item(val name: String,
           val description: String,
           val maxStackSize: Int) {

    open var type: ItemType = ItemType.MISC;

    open var usableCommands: List<ItemCommands> = listOf(); //list of usable commands

    var amount: Int = 1;

    //static function
    companion object {
        /**
         * Checks if given Any is a descendant class of item (or an item)
         * @return true if it is an item, false if not
         */
        fun checkIfItem(input: Any) : Boolean{
            when (input){
                is Item -> {
                    return true
                }
                is Weapon -> {
                    return true
                }
                is Armor -> {
                    return true
                }
                is Consumable -> {
                    return true
                }
                else -> {
                    return false
                }
            }
        }

        /**
         * Checks if given Any is a descendant class of item (or an item) and returns it's name
         * @return the name of the item, NULL if not an item
         */
        fun getName(item: Any) : String{
            when (item){
                is Item -> {
                    return item.name
                }
                is Weapon -> {
                    return item.name
                }
                is Armor -> {
                    return item.name
                }
                is Consumable -> {
                    return item.name
                }
                else -> {
                    println("⚠ $item is not an item. ⚠")
                    return "null"
                }
            }
        }
    }

    /* region item Do Command */
    /**
     * Does a command based on the input
     */
    public fun doCommandItem(input: String){
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
                commandConsume(arguments,)
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
    /* endregion */
}
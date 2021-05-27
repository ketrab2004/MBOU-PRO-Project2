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
    }
}
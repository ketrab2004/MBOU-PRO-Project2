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
}
package classes

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

enum class ItemArmorSlot(val index: Int){
    HEAD(0),
    TORSO(1),
    LEGS(2),
    FEET(3),
    OFFHAND(4)
}

class Item(val name: String, val description: String, val maxStackSize: Int) {

    var type: ItemType = ItemType.MISC;

    var usableCommands: List<ItemCommands> = listOf(); //list of usable commands

    /**
     * ## List of known properties:
     * - "EatPoints" [Float]; How much health you gain when consuming it
     * - "ArmorSlot" [ItemArmorSlot]; In what slot this item can be equipped
     * - "Key" [String]; Key what gets used to unlock a door
     */
    var properties: Map<String, Any> = mapOf(); //like NBT tags in Minecraft

    var amount: Int = 1;

    //static stuff goes in here
    companion object {}
}
package classes.item

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
package classes.item

enum class ArmorSlot{
    HEAD,
    TORSO,
    LEGS,
    FEET,
    OFFHAND //shield or something
}

class Armor(name: String, description: String, maxStackSize: Int = 1) //armor usually isn't stackable
    : Item(name, description, maxStackSize){ //extends classes.item.Item

    override var type: ItemType = ItemType.WEARABLE;

    override var usableCommands: List<ItemCommands> = listOf(ItemCommands.EQUIP); //all wearables can be equipped

    /**
     * amount of damage that should be removed (percentage 0 - 1)
     */
    var damageReduction: Float = .1f;

    var slot: ArmorSlot = ArmorSlot.HEAD;
}
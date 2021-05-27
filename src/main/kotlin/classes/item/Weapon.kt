package classes.item

class Weapon(name: String, description: String, maxStackSize: Int = 1) //weapons aren't usually stackable
    : Item(name, description, maxStackSize){ //extends classes.item.Item

    override var type: ItemType = ItemType.WEAPON;

    override var usableCommands: List<ItemCommands> = listOf(); //default weapon commands

    var damage: Float = 1.5f;

    /**
     * percentage (0 - 1) of how much damage doesn't get blocked by armor
     */
    var armorPenetration: Float = .1f;
}
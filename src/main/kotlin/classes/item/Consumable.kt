package classes.item

class Consumable(name: String, description: String, maxStackSize: Int)
    : Item(name, description, maxStackSize){ //extends classes.item.Item

    override var type: ItemType = ItemType.EDIBLE;

    override var usableCommands: List<ItemCommands> = listOf(ItemCommands.CONSUME); //all wearables can be equipped

    /**
     * amount of health you gain when consuming
     */
    var healingPoints: Float = 2.5f;
}
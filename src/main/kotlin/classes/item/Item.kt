package classes.item

class Item(val name: String, val description: String, val maxStackSize: Int) {

    var type: ItemType = ItemType.MISC;

    var usableCommands: List<ItemCommands> = listOf(); //list of usable commands

    /**
     * ## List of known properties:
     * - "EatPoints" [Float]; How much health you gain when consuming it
     * - "ArmorSlot" [ItemArmorSlot]; In what slot this item can be equipped
     * - "ArmorPerc" [Float]; Percentage of damage to ignore (0-1)
     * - "Key" [String]; Key what gets used to unlock a door
     * - "Damage" [Float]; Amount of damage this weapon does when used
     */
    var properties: MutableMap<String, Any> = mutableMapOf(); //like NBT tags in Minecraft

    var amount: Int = 1;

    //static stuff goes in here
    companion object {
        /**
         * Creates a consumable item and returns it
         * @param[eatPoints] amount of health to add when consumed
         */
        public fun createEdible(name: String, description: String, maxStackSize: Int, eatPoints: Float): Item{
            var item = Item(name, description, maxStackSize);

            item.properties["EatPoints"] = eatPoints;
            item.type = ItemType.EDIBLE;

            item.usableCommands+= ItemCommands.CONSUME;

            return item;
        }

        /**
         * Creates a wearable item and returns it
         * @param[armorSlot] in what slot this can be equipped
         * @param[armorPerc] percentage of damage to ignore (0-1)
         */
        public fun createWearable(name: String, description: String, armorSlot: ItemArmorSlot, armorPerc: Float): Item{
            var item = Item(name, description, 1);

            item.properties["ArmorSlot"] = armorSlot;
            item.properties["ArmorPerc"] = armorPerc;

            item.type = ItemType.WEARABLE;
            item.usableCommands+= ItemCommands.EQUIP;

            return item;
        }

        /**
         * Creates a key and returns it
         * @param[key] string which is the key
         */
        public fun createKey(name: String, description: String, key: String): Item{
            var item = Item(name, description, 1);

            item.properties["Key"] = key;
            item.type = ItemType.KEY;

            return item;
        }

        /**
         * Creates a weapon and returns it
         * @param[damage] amount of damage this weapon does when used
         */
        public fun createWeapon(name: String, description: String, damage: Float): Item{
            var item = Item(name, description, 1);

            item.properties["Damage"] = damage;
            item.type = ItemType.WEAPON;
            item.usableCommands+= ItemCommands.EQUIPWEAPON;

            return item;
        }
    }
}
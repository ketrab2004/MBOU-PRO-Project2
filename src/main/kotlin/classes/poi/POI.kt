package classes.poi

import classes.item.Item;

open class POI (val name: String, val description: String){

    var type: POIType = POIType.MISC;

    var usableCommands: List<PossiblePOICommands> = listOf()

    /**
     * ## List of known properties:
     * - "TargetRoom" [Int]; Index of room behind this door
     * - "TargetFloor" [Int]; Index of floor/level up/down these stairs
     * - "IsLocked" [Boolean]; Whether this door/staircase is locked
     * - "Key" [String]; Code that a key needs to have to be able to unlock this (also works on containers)
     * - "Content" [MutableList]<[Item]>; List of items inside of this POI
     * - "Pickup" [Item]; Used when POI is just a single item on the ground
     */
    var properties: MutableMap<String, Any> = mutableMapOf(); //like NBT tags in Minecraft

    //static stuff goes in here
    companion object {
        /**
         * Creates a door poi and returns it
         * @param[targetRoom] index of room behind door
         * @param[key] keycode required to unlock this door (null if not locked)
         */
        public fun createDoor(name: String, description: String, targetRoom: Int, key: String?): POI {
            var poi = POI(name, description);

            poi.properties["TargetRoom"] = targetRoom;
            if (key != null){ //if key is given
                poi.properties["Key"] = key;
                poi.properties["IsLocked"] = true;
            }

            poi.type = POIType.DOOR;

            return poi;
        }

        /**
         * Creates a staircase poi and returns it
         * @param[targetFloor] index of room behind door
         * @param[key] keycode required to unlock this door (null if not locked)
         */
        public fun createStaircase(name: String, description: String, targetFloor: Int, key: String?): POI {
            var poi = POI(name, description);

            poi.properties["TargetFloor"] = targetFloor;
            if (key != null){ //if key is given
                poi.properties["Key"] = key;
                poi.properties["IsLocked"] = true;
            }

            poi.type = POIType.STAIRCASE;

            return poi;
        }

        /**
         * Creates a container poi and returns it
         * @param[content] mutableList (so items can be removed from it) of Items
         */
        public fun createContainer(name: String, description: String, content: MutableList<Item>): POI {
            var poi = POI(name, description);

            poi.properties["Content"] = content;
            poi.type = POIType.CONTAINER;

            return poi;
        }

        /**
         * Creates a pickup poi and returns it
         * @param[pickup] item that will be picked up
         */
        public fun createPickup(name: String, description: String, pickup: Item): POI {
            var poi = POI(name, description);

            poi.properties["Content"] = pickup;
            poi.type = POIType.ITEM;

            return poi;
        }
    }
}
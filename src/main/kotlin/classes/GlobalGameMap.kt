import classes.Room
import classes.item.Item
import classes.item.ItemArmorSlot
import classes.poi.POI

class GlobalGameMap {
    //static
    companion object {
        /**
         * array with lists of rooms
         *
         * each list in the array is an level/floor
         *
         * each room in each list is a room
         *
         * 8 levels/floors
         */
        public var gameMap: Array<List<Room>> =
            arrayOf(listOf(), listOf(), listOf(), listOf(), listOf(), listOf(), listOf(), listOf())

        public fun setupGameMap() { //call only once at the beginning (or again for resetting)
            //region level 0
            //region main room
            var mainRoom =
                Room("Main hallway", "A big hallway leading through the entire bottom floor of the castle.")

            mainRoom.poiList +=
                POI.createContainer("Hat Stand", "A stand for putting hats on.",
                    mutableListOf(
                        Item.createWearable(
                            "Fancy hat",
                            "A shiny black hat for suits. Doesn't offer any protection.",
                            ItemArmorSlot.HEAD,
                            0f),
                        Item.createWearable(
                            "Baseball cap",
                            "A white baseball cap with a blue rim. Doesn't offer any protection.",
                            ItemArmorSlot.HEAD,
                            0f)
                    )
                )

            mainRoom.poiList +=
                POI.createPickup("Boots", "A pair of boots on the ground",
                    Item.createWearable(
                        "Dracula's boots",
                        "Who knew Dracula had boots? Offers very little protection.",
                        ItemArmorSlot.FEET,
                        0.001f))
            //TODO more POIs
            //endregion main room

            //region room2
            //TODO make room 2 here
            //Maybe change region name too ;)
            //endregion room2

            var level0: List<Room> = listOf(mainRoom) //add rooms to level0, !order matters for doors!

            gameMap[0] = level0 //set ground floor to level0
            //endregion level 0

            //TODO make first floor here
        }
    }
}
import classes.Enemy
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

        /* template

            //region room
            var f =
                Room("", ".")

            f.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("", ".", 0, null),

                    POI("Chandelier", "A large chandelier hanging from the ceiling."),
                )
            )
            //endregion room

            //region level 1

            var level1: List<Room> = listOf() //add rooms level1, !order matters for doors!

            gameMap[1] = level1 //set 1st floor to level1
            //endregion level 1
         */

        public fun setupGameMap() { //call only once at the beginning (or again for resetting)
            //region level 0
            //region room0 main room
            var f0mainRoom =
                Room("Main hallway", "The first room.")

            f0mainRoom.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createContainer("Hat stand", "A stand for putting hats on.",
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
                        ), null
                    ),POI.createPickup("Boots", "A pair of boots on the ground",
                        Item.createWearable(
                            "Dracula's boots",
                            "Who knew Dracula had boots? Offers very little protection.",
                            ItemArmorSlot.FEET,
                            0.001f)
                    ),POI.createContainer("Large Painting", "A large portrait of the great Dracula himself.",
                        mutableListOf(
                            Item.createWeapon(
                                "Wooden stake",
                                "A wooden stake used for killing vampires.",
                                50f,
                            ),
                            Item.createWearable(
                                "Garlic necklace",
                                "A necklace of garlic.",
                                ItemArmorSlot.TORSO,
                                .5f
                            ),
                        ), "Secret Painting 1234"
                    ), POI("Chandelier", "A large chandelier hanging from the ceiling."),
                    POI.createDoor("Living room door", "A door that leads to the living room.", 1, null),
                    POI.createDoor("Bathroom door", "It has a sign stating '\uD835\uDCAA\uD835\uDCCA\uD835\uDCC9 \uD835\uDC5C\uD835\uDCBB \uD835\uDCC8\uD835\uDC52\uD835\uDCC7\uD835\uDCCB\uD835\uDCBE\uD835\uDCB8\uD835\uDC52'.",
                        0, "!unlockable"),
                    POI.createDoor("Staircase closet", "A closet under the staircase.", 2, null),
                    POI.createStaircase("Staircase", "A staircase leading to the first floor.", 0, 1, null)
                )
            )
            //endregion room0 main room

            //region room1 living room
            var f0livingRoom =
                Room("Living room", "A large living room with fancy curtains blocking the windows.")

            f0livingRoom.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("Main hallway door", "A door leading back into the main hallway.", 0, null),
                    POI("Large couch", "A couch large enough to seat 8 guests."),
                    POI("Chandelier", "A large chandelier hanging from the ceiling."),
                    POI.createContainer("TV stand", "A stand that holds the tv.",
                        mutableListOf(
                            Item("TV remote", "The remote for the giant tv.", 1),
                            Item("Xbox controller", "A xbox controller but it's missing a xbox.", 1),
                            Item.createWeapon("Wii controller", "A wii controller but it's missing a wii, does little damage.", 2f)
                        ), null),
                    POI("Giant TV", "A gigantic flatscreen tv opposite of the couch.")
                )
            )
            //endregion room1 living room

            //region room2 staircase closet
            var f0staircaseCloset =
                Room("Living room", "A large living room with fancy curtains blocking the windows.")

            f0staircaseCloset.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("Main hallway door", "A door leading back into the main hallway.", 0, null),
                    POI("Toilet paper tower", "A tower of toiler paper rolls."),
                    POI.createPickup("Plunger", "A plunged plunger on the ground.",
                        Item.createWeapon("Old plunger", "A plunger from centuries ago", 1.5f)),
                    POI("Mini chandelier", "A super small chandelier.")
                )
            )
            //endregion room2 staircase closet

            var level0: List<Room> = listOf(f0mainRoom, f0livingRoom, f0staircaseCloset) //add rooms to level0, !order matters for doors!

            gameMap[0] = level0 //set ground floor to level0
            //endregion level 0

            //region level 1
            //region room0 hallway
            var f1hallway =
                Room("Hallway", "Another hallway this time going through the 1st floor.")

            f1hallway.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createStaircase("Downwards staircase", "A staircase going back to the ground floor.", 0, 0, null),
                    POI.createDoor("Dining room door", "A door leading to the dining room.", 1, null),
                    POI.createDoor("Kitchen door", "A door leading to the kitchen.", 2, null),
                    POI.createDoor("Bathroom door", "It has a sign stating '\uD835\uDCAA\uD835\uDCCA\uD835\uDCC9 \uD835\uDC5C\uD835\uDCBB \uD835\uDCC8\uD835\uDC52\uD835\uDCC7\uD835\uDCCB\uD835\uDCBE\uD835\uDCB8\uD835\uDC52'.",
                        0, "!unlockable"),
                    POI.createDoor("Bat room door", "A door that has a sign above it that says: 'Bat Room'.", 3, null),
                    POI("Chandelier", "A large chandelier hanging from the ceiling."),
                )
            )
            //endregion room0 hallway

            //region room1 dining room
            var f1diningRoom =
                Room("Dining room", "The room where Dracula consumes consumables.")

            f1diningRoom.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("Hallway door", "A door leading back to the hallway.", 0, null),
                    POI("Dining table", "A table to dine upon."),
                    POI("Dining chairs", "Chairs surrounding the dining table."),
                    POI("Chandelier", "A large chandelier hanging from the ceiling above the dining table."),
                    POI.createContainer("Candle chest", "A chest that holds candles",
                        mutableListOf(
                            Item.createConsumable("Pack of candles", "A pack of 10 candles, seems edible...", 10, .01f),
                            Item.createConsumable("Pack of candles", "A pack of 10 candles, seems edible...", 10, .01f),
                            Item.createConsumable("Pack of candles", "A pack of 10 candles, seems edible...", 10, .01f),
                            Item.createWeapon("Lighter", "Used to light candles", 1.75f),
                            Item.createConsumable("Pack of candles", "A pack of 10 candles, seems edible...", 10, .01f),
                            Item.createConsumable("Pack of candles", "A pack of 10 candles, seems edible...", 10, .01f),
                            Item.createConsumable("Pack of fancy candles", "A pack of 10 fancy candles, seems extra edible...", 10, .025f)
                        ), null)
                )
            )
            //endregion room1 dining room

            //region room2 kitchen
            var f1kitchen =
                Room("Kitchen", "The place where food is prepared.")

            f1kitchen.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("Hallway door", "A door leading back to the hallway.", 0, null),
                    POI("Stove", "A stove used to cook things"),
                    POI.createContainer("Rice cooker", "Used to cook rice, duh.",
                        mutableListOf(), null), //empty :)
                    POI.createContainer("Toaster", "Used to toast things, usually bread.",
                        mutableListOf(
                            Item.createConsumable("Toasted breads", "Bread that has been toasted using a toaster.", 2, 1f)
                        ), null),
                    POI.createPickup("Knife", "A knife used for chopping.",
                        Item.createWeapon("Dull knife", "A knife that isn't sharp anymore.", 2f)),
                    POI.createPickup("Mixer", "Used for mixing stuff to prepare foods.",
                        Item.createWeapon("Mixer", "A mixer used for mixing stuff to prepare foods.", 2f)),
                    POI("Chandelier", "A large chandelier hanging from the ceiling."),
                )
            )
            //endregion room2 kitchen

            //region room3 bat room
            var f1batRoom =
                Room("", ".")

            f1batRoom.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("Hallway door", "A door leading back into the hallway.", 0, null),
                    POI.createStaircase("Upwards staircase", "A staircase leading the the 2nd floor", 1, 0, null),
                    POI("Broken chandelier", "A large chandelier hanging from the ceiling, but it's broken because bats live in darkness."),
                )
            )

            f1batRoom.enemyList.addAll(
                listOf(Enemy("Bat", "A bat that lives in the bat room.", 1f))
            )
            //endregion room3 bat room


            val level1: List<Room> = listOf(f1hallway,f1diningRoom,f1kitchen,f1batRoom) //add rooms level1, !order matters for doors!

            gameMap[1] = level1 //set 1st floor to level1
            //endregion level 1

            //region level 2
            //region room0 staircase room
            var f2staircase =
                Room("Staircase room", "A small room barely big enough for the huge staircase leading to this floor.")

            f2staircase.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("Wine cellar door", "A door leading to the wine cellar.", 1, null),
                    POI("Chandelier", "A large chandelier hanging from the ceiling."),
                    POI.createDoor("Hallway door", "A door leading to the hallway.", 2, "f2r2")
                )
            )
            //endregion room0 staircase room

            //region room1 wine cellar
            var f2wine =
                Room("Wine cellar", "A wine cellar but it's not a cellar, it's also out of wine.")

            f2wine.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("Staircase room door", "A door leading back into the cramped staircase room.", 0, null),

                    POI.createPickup("Tilted empty bottle",
                        "A wine bottle but it seems to be tilted. Maybe there is something underneath it?",
                        Item.createKey("Hallway key", "A key to unlock the hallway on the 2nd floor", "f2r2")),

                    POI.createContainer("Wine rack", "A rack for wine bottles.",
                        mutableListOf(
                            Item("Empty wine bottle", "An empty bottle of wine.", 1),
                            Item("Empty wine bottle", "An empty bottle of wine.", 1),
                            Item("Empty wine bottle", "An empty bottle of wine.", 1),
                            Item.createWeapon("Broken wine bottle", "A broken wine bottle with sharp edges.", 2.5f),
                            Item("Empty wine bottle", "An empty bottle of wine.", 1),
                            Item("Empty wine bottle", "An empty bottle of wine.", 1),
                            Item("Empty wine bottle", "An empty bottle of wine.", 1),
                            Item("Empty wine bottle", "An empty bottle of wine.", 1),
                        ), null),
                    POI.createContainer("Wine rack", "Another rack for wine bottles.",
                        mutableListOf(
                            Item("Empty wine bottle", "An empty bottle of wine.", 1),
                            Item("Empty wine bottle", "An empty bottle of wine.", 1),
                            Item("Empty wine bottle", "An empty bottle of wine.", 1),
                            Item("Empty wine bottle", "An empty bottle of wine.", 1),
                            Item("Empty wine bottle", "An empty bottle of wine.", 1),
                        ), null),
                    POI.createContainer("Wine rack", "Another rack for wine bottles, but it's empty.",
                        mutableListOf(), null),

                    POI("Chandelier", "A large chandelier hanging from the ceiling."),
                )
            )
            //endregion room1 wine cellar

            //region room2 hallway
            var f2hallway =
                Room("", ".")

            f2hallway.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("Staircase room door", "A door leading back into the small staircase room.", 0, null),

                    POI("Fancy rug", "A fancy rug underneath your feet."),

                    POI.createDoor("Bat room door 2", "Another door that leads to another bat room.", 3,null),

                    POI("Chandelier", "A large chandelier hanging from the ceiling."),
                    POI.createDoor("Bathroom door", "It has a sign stating '\uD835\uDCAA\uD835\uDCCA\uD835\uDCC9 \uD835\uDC5C\uD835\uDCBB \uD835\uDCC8\uD835\uDC52\uD835\uDCC7\uD835\uDCCB\uD835\uDCBE\uD835\uDCB8\uD835\uDC52'.",
                        0, "!unlockable"),
                )
            )
            //endregion room2

            //region room3 batroom (2)
            var f2batroom =
                Room("Bat room 2", "A bigger and evolved bat room.")

            f2batroom.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("Hallway door", "A door leading back to the hallway.", 2, null),

                    POI.createContainer("Bat chest", "Chest containing bat stuff.",
                        mutableListOf(
                            Item("Bobman mug", "A black mug with the yellow bobman logo on it.", 1),
                            Item("Bat cape", "A cape for bats with the bobman logo on it.", 1)
                        ), "bat"),

                    POI.createStaircase("Upwards staircase", "A staircase leading to the 3rd floor.",
                        3, 0, "bat"),

                    POI("Shattered chandelier", "A shattered chandelier that fell to the ground, bats suck."),
                )
            )

            val f2bigBat = Enemy("Alpha bat", "A bigger bat carrying a key", 2f);
            f2bigBat.inventory.add(
                Item.createKey("Bat key", "A key used for bat stuff", "bat")
            )
            f2batroom.enemyList.addAll(
                listOf(
                    f1batRoom.enemyList[0], //duplicate from first bat room
                    f2bigBat)
            )
            //endregion room3 batroom (2)

            var level2: List<Room> = listOf(f2staircase,f2wine,f2hallway,f2batroom) //add rooms level1, !order matters for doors!

            gameMap[2] = level2 //set 1st floor to level1
            //endregion level 2

            //region final level (8)
            //region

            //endregion

            var level8: List<Room> = listOf() //add rooms to level0, !order matters for doors!

            gameMap[7] = level0 //set ground floor to level0
            //endregion final level (8)
        }
    }
}
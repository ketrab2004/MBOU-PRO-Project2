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
                                10f,
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

            val f2bigBat = Enemy("Alpha bat", "A bigger bat carrying a key", 5f);
            f2bigBat.inventory.add(
                Item.createKey("Bat key", "A key used for bat stuff", "bat")
            )
            f2batroom.enemyList.addAll(
                listOf(
                    f1batRoom.enemyList[0], //duplicate from first bat room
                    f2bigBat)
            )
            //endregion room3 batroom (2)

            var level2: List<Room> = listOf(f2staircase,f2wine,f2hallway,f2batroom) //add rooms level2, !order matters for doors!

            gameMap[2] = level2 //set 2nd floor to level2
            //endregion level 2

            //region level 3
            //region room0 hallway
            var f3hallway =
                Room("Hallway", "The hallway on the 3rd floor.")

            f3hallway.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createStaircase("Downwards staircase", "Staircase to the 2nd floor.", 2,3, null),

                    POI.createDoor("Study room door", "Door leading to the study room", 1, null),
                    POI.createDoor("Playroom door", "Door leading to the children's playplace.", 2, "baby"),
                    POI("Chandelier", "A large chandelier hanging from the ceiling."),
                    POI.createDoor("Utility room door", "Door leading to the utility room", 3, null),

                    POI.createStaircase("Upwards staircase", "Staircase leading to the 4th floor.", 4, 0, "naptime"),
                )
            )
            //endregion room0 hallway

            //region room1 study room
            var f3study =
                Room("Study room", "Room to study in, filled with books.")

            f3study.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("Hallway door", "The door leading back to the hallway.", 0, null),

                    POI.createContainer("Giant bookcase", "A bookcase that covers the entire wall.",
                        mutableListOf(
                            Item("Empty book", "An empty book with no title and no content.", 1),
                            Item("Sharp teeth and you", "Chapter 2, a new hunger:\nAfter your new sharp teeth start to come out you will experience a hunger that\nfood cannot fulfill.", 1),
                            Item("Dracula's diary", "It's locked...", 1),
                            Item.createWeapon("Phone book", "A heavy phone book, could do some damage...", 3.5f),
                        ), null),

                    POI("Bookcase ladder", "One of those ladders that slide across a bookcase so you can reach all the books."),
                    POI("Reading chair", "A chair on top of a large rug in the middle of the room"),
                    POI("Table", "A table next to the reading chair, it has stuff on it."),
                    POI.createPickup("Reading glasses", "Glasses so you can read easier,\nlie upon the table next to the reading chair.",
                        Item.createWearable("Dracula's reading glasses", "Glasses dracula uses to read.",
                            ItemArmorSlot.HEAD,
                            .05f)),
                    POI("Night light", "A light used when you want to read in the dark,\nstands upon the table next to the reading chair."),

                    POI("Dimmed chandelier", "A large chandelier hanging from the ceiling, but it is not beaming light at it's full capacity."),
                )
            )
            //endregion room1 study room

            //region room2 playroom
            var f3play =
                Room("Playroom", "A big room.")

            f3play.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("Hallway door", "The door leading back to the hallway.", 0, null),

                    POI("Chandelier", "A large chandelier hanging from the ceiling."),
                    POI.createContainer("Toybox", "A box containing toys",
                        mutableListOf(
                            Item("GHIJKL letter cube", "A cube with the letters GHIJKL on it.", 1),
                            Item("ABCDEF letter cube", "A cube with the letters ABCDEF on it.", 1),
                            Item("STUVWX letter cube", "A cube with the letters STUVWX on it.", 1),
                            Item("Toy car", "A shiny brand new toy warmwheels© car.", 1),
                            Item("AEOUYZ letter cube", "A cube with the letters AEOUYZ on it.", 1),
                            Item("MNOPQR letter cube", "A cube with the letters MNOPQR on it.", 1),
                        ), "naptime"),

                    POI("Playplace", "A giant playplace with pipes, windows and anything you can imagine."),
                    POI.createContainer("Ballpit", "A big pit with tons of balls in it",
                        mutableListOf(
                            Item("Green ball", "A green plastic ball", 1),
                            Item("Blue ball", "A green plastic ball", 1),
                            Item("Yellow ball", "A green plastic ball", 1),
                            Item("Red ball", "A green plastic ball", 1),
                            Item("Green ball", "A green plastic ball", 1),
                            Item("Blue ball", "A green plastic ball", 1),
                            Item("Yellow ball", "A green plastic ball", 1),
                            Item("Red ball", "A green plastic ball", 1),
                            Item("Green ball", "A green plastic ball", 1),
                            Item("Blue ball", "A green plastic ball", 1),
                            Item("Yellow ball", "A green plastic ball", 1),
                            Item("Red ball", "A green plastic ball", 1),
                            Item("Green ball", "A green plastic ball", 1),
                            Item("Blue ball", "A green plastic ball", 1),
                            Item("Yellow ball", "A green plastic ball", 1),
                            Item("Red ball", "A green plastic ball", 1),
                            Item("Green ball", "A green plastic ball", 1),
                            Item("Blue ball", "A green plastic ball", 1),
                            Item("Yellow ball", "A green plastic ball", 1),
                            Item("Red ball", "A green plastic ball", 1),
                            Item("Green ball", "A green plastic ball", 1),
                            Item("Blue ball", "A green plastic ball", 1),
                            Item("Yellow ball", "A green plastic ball", 1),
                            Item.createConsumable("Hamburger", "Who knows how long this hamburger has lost for...", 1, 5f),
                            Item("Red ball", "A green plastic ball", 1),
                            Item("Green ball", "A green plastic ball", 1),
                            Item("Blue ball", "A green plastic ball", 1),
                            Item("Yellow ball", "A green plastic ball", 1),
                            Item("Red ball", "A green plastic ball", 1),
                            Item("Green ball", "A green plastic ball", 1),
                            Item("Blue ball", "A green plastic ball", 1),
                            Item("Yellow ball", "A green plastic ball", 1),
                            Item("Red ball", "A green plastic ball", 1),
                            Item.createConsumable("Fries", "Who knows how long these fries have been lost...", 25, .25f),
                            Item("Green ball", "A green plastic ball", 1),
                            Item("Blue ball", "A green plastic ball", 1),
                            Item("Yellow ball", "A green plastic ball", 1),
                            Item("Red ball", "A green plastic ball", 1),
                            Item("Green ball", "A green plastic ball", 1),
                            Item("Blue ball", "A green plastic ball", 1),
                            Item("Yellow ball", "A green plastic ball", 1),
                            Item("Red ball", "A green plastic ball", 1),
                        ),null)
                )
            )
            val f3enemy = Enemy("Dracula's baby", "The child of dracula", 15f)
            f3enemy.inventory.add(
                Item.createWearable("Diaper", "Luckily it's clean",
                    ItemArmorSlot.LEGS, .1f)
            )
            f3enemy.inventory.add(
                Item.createKey("Baby's key","The key used by dracula's child to open her toybox.","naptime")
            )
            f3enemy.equipped[2] = f3enemy.inventory[0]; //add armor, because equipped items don't get dropped

            f3play.enemyList.add( f3enemy )
            //endregion room2 playroom

            //region room3 Utility room
            var f3utility =
                Room("Utility room", "The room where you wash your clothes and use other utilities.")

            f3utility.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("Hallway door", "The door leading back to the hallway.", 0, null),

                    POI("Washing machine", "A machine that guess what..., washes clothes!"),
                    POI("Dryer", "A machine that guess what..., dries clothes!"),
                    POI.createPickup("Pile of thingamajigs", "Stuff that was found in pants before being put into the washing machine.",
                        Item.createKey("Playroom key", "Key used to get into the playroom", "baby")),

                    POI.createContainer("Clothes basket", "A basket that holds that need to be washed",
                        mutableListOf(
                            Item.createWearable("Dracula's underwear", "Underwear that dracula wears, what is he wearing now?", ItemArmorSlot.LEGS, .095f),
                            Item.createWearable("Dracula's socks", "Socks with a yellow bobman symbol repeating on it.", ItemArmorSlot.FEET, .05f),
                            Item("Mushy cash", "Money that was accidently put into the washing machine.", 1),
                            Item.createWearable("Dracula's tank top", "A tank top dracula wears as his pyjamas.", ItemArmorSlot.TORSO, .1f),
                        ), null),

                    POI("Chandelier", "A large chandelier hanging from the ceiling."),
                )
            )
            //endregion room3 utility room

            var level3: List<Room> = listOf(f3hallway) //add rooms level3, !order matters for doors!

            gameMap[3] = level3 //set 3rd floor to level3
            //endregion level 3

            //region level 4
            //region room0 hallway
            var f4hallway =
                Room("", ".")

            f4hallway.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createStaircase("Downwards staircase", "Staircase leading to the 3rd floor.", 3, 0, null),

                    POI.createDoor("Empty guest room", "A door leading to an unoccupied guest room.", 1, null),
                    POI.createDoor("Bat guest room", "A door leading to the guest room for bats.", 2,null),
                    POI.createDoor("Chef guest room", "A door leading to where Dracula's chef stays when he's not preparing food.", 3,null),
                    POI.createDoor("Knight guest room", "A door leading to the guest room of a knight.", 4, null),

                    POI.createDoor("Bathroom door", "It has a sign stating '\uD835\uDCAA\uD835\uDCCA\uD835\uDCC9 \uD835\uDC5C\uD835\uDCBB \uD835\uDCC8\uD835\uDC52\uD835\uDCC7\uD835\uDCCB\uD835\uDCBE\uD835\uDCB8\uD835\uDC52'.",
                        0, "!unlockable"),
                    POI("Chandelier", "A large chandelier hanging from the ceiling."),

                    POI.createDoor("Balcony door", "Door leading to the balcony", 5, null),

                    POI.createStaircase("Upwards staircase", "Staircase leading to the 5th floor.", 5, 0, "5th"),
                )
            )
            //endregion room0 hallway

            val f4key = Item.createKey("5th floor key", "A key that opens the staircase leading to the 5th floor.", "5th");

            //region room1 empty guest room
            var f4empty =
                Room("Empty guest room", "A guest room with no guest.")

            f4empty.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("Hallway door", "A door leading to the hallway.", 0, null),

                    POI("Red bed", "A king-sized double bed with a red bedsheet."),
                    POI.createContainer("Nightstand", "A night stand next to the red bed",
                        mutableListOf(
                            f4key
                        ), null),

                    POI("Chandelier", "A large chandelier hanging from the ceiling."),
                )
            )
            //endregion room1 empty guest room

            //region room2 bat guest room
            var f4bat =
                Room("Bat guest room", "The guest room where king bat stayed.")

            f4bat.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("Hallway door", "The door leading to the hallway.", 0, null),

                    POI("Black bed", "The king-sized double bed with a black sheet that has the yellow bobman logo on it"),
                    POI.createContainer("Nightstand", "The night stand next to the black bobman bed",
                        mutableListOf(), null),

                    POI("Chandelier", "The large chandelier hanging from the ceiling."),
                )
            )

            val f4enemyBat = Enemy("King bat", "The one and only king bat", 20f)
            f4enemyBat.inventory.addAll(
                listOf(
                    f4key, //key to 5th floor
                    Item.createWeapon("Bat dagger", "A small dagger for bats.", 2.5f)
                )
            )
            f4bat.enemyList.add(f4enemyBat)
            //endregion room2 bat guest room

            //region room3 chef guest room
            var f4chef =
                Room("Chef guest room", "Guest room where dracula's chef stayed.")

            f4chef.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("Hallway door", "A door leading to the hallway.", 0, null),

                    POI("White bed", "A king-sized double bed with a white bedsheet."),
                    POI.createContainer("Nightstand", "A night stand next to the white bed",
                        mutableListOf(), null),

                    POI("Chandelier", "A large chandelier hanging from the ceiling."),
                )
            )

            val f4enemyChef = Enemy("Dracula's chef", "The chef that cooks for Dracula.", 15f)
            val f4chefHat = Item.createWearable("Chef's hat", "The hat of Dracula's chef.", ItemArmorSlot.HEAD, .1f)
            f4enemyChef.equipped[0] = f4chefHat
            f4enemyChef.equipped[4] = Item.createWearable("","",ItemArmorSlot.OFFHAND, .15f) //secret armor you cannot obtain
            f4enemyChef.inventory.addAll(
                listOf(f4key, f4chefHat)
            )

            f4chef.enemyList.add(f4enemyChef)
            //endregion room3 chef guest room

            //region room4 knight guest room
            var f4knight =
                Room("Knight guest room", "Guest room where dracula's best friend, the knight, stayed.")

            f4knight.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("Hallway door", "A door leading to the hallway.", 0, null),

                    POI("Gray bed", "A king-sized double bed with a gray bedsheet."),
                    POI.createContainer("Nightstand", "A night stand next to the gray bed",
                        mutableListOf(), null),

                    POI("Chandelier", "A large chandelier hanging from the ceiling."),
                )
            )

            val f4enemyKnight = Enemy("The knight", "Dracula's best friend.", 20f)
            val f4shield = Item.createWearable("The knight's shield", "The shield of Dracula's best friend.", ItemArmorSlot.OFFHAND, .15f)
            f4enemyKnight.equipped[4] = f4shield
            f4enemyKnight.equipped[3] = Item.createWearable("","",ItemArmorSlot.FEET, .1f) //secret armor you cannot obtain
            f4enemyKnight.equipped[2] = Item.createWearable("","",ItemArmorSlot.LEGS, .1f)
            f4enemyKnight.equipped[1] = Item.createWearable("","",ItemArmorSlot.TORSO, .1f)
            f4enemyKnight.equipped[0] = Item.createWearable("","",ItemArmorSlot.HEAD, .1f)

            f4enemyKnight.inventory.addAll(
                listOf(
                    f4shield,
                    f4key, //key to the 5th floor
                    Item.createWeapon("The knight's blade", "The blade of Dracula's best friend.", 4.5f)
                )
            )
            f4knight.enemyList.add(f4enemyKnight)
            //endregion room4 knight guest room

            //region room5 balcony
            var f4balcony =
                Room("Balcony", "You cannot see very far, as it is very fogy.")

            f4balcony.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("Hallway", "Door leading to the hallway.", 0, null),

                    POI("Flower pot", "The flower is miraculously alive.")
                )
            )
            //endregion room5 balcony

            var level4: List<Room> = listOf(f4hallway, f4empty, f4bat, f4chef, f4knight, f4balcony) //add rooms level4, !order matters for doors!

            gameMap[4] = level4 //set 4th floor to level4
            //endregion level 4

            //region level 5
            //region room0 bathhouse
            var f5bathhouse =
                Room("Bathhouse", "A giant room filled with baths and showers to clean yourself.")

            f5bathhouse.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createStaircase("Downwards staircase", "Staircase leading to the 4th floor.", 4,0, null),

                    POI.createDoor("Bathroom door", "The only not out of service bathroom.",
                        1, null),

                    POI("Bath", "A giant bath to the left of the upwards staircase"),
                    POI("Chandelier", "A large chandelier hanging from the ceiling."),
                    POI("Showers", "A bunch of showers to the right of the upwards staircase"),

                    POI.createStaircase("Upwards staircase", "Staircase leading to the 6th floor.", 6,0, "f5toilet"),
                )
            )
            //endregion room0 bathhouse

            //region room1 bathroom
            var f5bathroom =
                Room("Bathroom", "The only functioning bathroom in castle Dracula.")

            val f5toiler = POI("Occupied toilet", "This toilet stall is in use.")

            f5bathroom.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("Bathhouse door", "A door leading back to the bathhouse.", 0, null),

                    POI("Chandelier", "A large chandelier hanging from the ceiling."),

                    f5toiler,
                    f5toiler,
                    f5toiler,
                    POI.createContainer("Open toilet", "This toilet stall is open.",
                        mutableListOf(
                            Item.createKey("Toilet key", "A key from a toilet bowl.", "f5toilet")
                        ), null),
                    f5toiler,
                    f5toiler,
                    f5toiler,
                    f5toiler,
                    f5toiler,
                )
            )
            //endregion room1 bathroom

            var level5: List<Room> = listOf(f5bathhouse, f5bathroom) //add rooms level5, !order matters for doors!

            gameMap[5] = level5 //set 5th floor to level1
            //endregion level 5

            //region level 6
            //region room0 hallway
            var f6hallway =
                Room("Hallway", "The place to watch your favourite films.")

            f6hallway.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createStaircase("Downwards staircase", "Staircase leading to the 5th floor.", 5, 0, null),
                    POI.createDoor("Cinema door", "Door leading to the blacked out cinema.", 1, null),

                    POI.createContainer("Movies shelve", "A shelve that contains movies to be watched in the cinema.",
                        mutableListOf(
                            Item("Dracula: Dead and Loving It", "Horror/comedy with Leslie Nielson.", 1),
                            Item("Hotel Transylvania","Haha Jonathan you are ...", 1),
                            Item("Dracula", "American horrorfilm from 1931.", 1),
                            Item("Bram Stoker's Dracula","American horrorfilm from 1992.", 1),
                        ), null),

                    POI("Chandelier", "A large chandelier hanging from the ceiling."),
                    POI.createStaircase("Upwards staircase", "Staircase leading to the 7th and final floor.", 7, 0,null)
                )
            )
            //endregion room0 hallway

            //region room1 cinema
            var f6cinema =
                Room("Cinema", "The place to watch your favourite films.")

            f6cinema.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("Hallway door", "Door leading to the hallway.", 0, null),

                    POI("Movie screen", "Screen where movies are projected onto."),
                    POI("Projector", "Used to project films onto the big screen."),

                    POI.createContainer("Movie seats", "Seats for watching movies, people always lose stuff in the cracks...",
                        mutableListOf(
                            Item.createKey("Painting key", "Has a tag that says 'Dracula's portrait'.", "Secret Painting 1234"),
                            Item.createConsumable("Popcorn", "Loose pieces of popcorn.", 25, .5f),
                            Item.createKey("Dracula's key", "The key that opens Dracula's room.", "dracula")
                        ), null),

                    POI("Chandelier", "A large chandelier hanging from the ceiling, but it isn't plugged in."),
                )
            )
            //endregion room1 cinema

            var level6: List<Room> = listOf(f6hallway, f6cinema) //add rooms level6, !order matters for doors!

            gameMap[6] = level6 //set 6th floor to level6
            //endregion level 6

            //region level 7

            //region room0 hallway
            var f7hallway =
                Room("Dracula's hallway", "The hallway in front of Dracula's room.")

            f7hallway.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createStaircase("Downwards staircase", "Staircase leading to the 6th floor.", 6, 0, null),

                    POI("Chandelier", "A chandelier larger than any you have ever seen before hanging from the ceiling."),

                    POI.createDoor("Dracula's door", "A gigantic double door that leads to Dracula's room.", 0, "dracula"),

                    POI.createDoor("Bathroom door", "It has a sign stating '\uD835\uDCAA\uD835\uDCCA\uD835\uDCC9 \uD835\uDC5C\uD835\uDCBB \uD835\uDCC8\uD835\uDC52\uD835\uDCC7\uD835\uDCCB\uD835\uDCBE\uD835\uDCB8\uD835\uDC52' bummer.",
                        0, "!unlockable"),
                )
            )
            //endregion room0 hallway

            //region room1 dracula's room
            var f7dracula =
                Room("Dracula's room", "The room where you will fulfill your destiny.")

            f7dracula.poiList.addAll(
                listOf( //listOf only for the addAll function
                    POI.createDoor("Hallway door", "A door that goes back to the hallway.", 0, null),

                    POI("Chandelier", "A large chandelier hanging from the ceiling."),
                    POI("Dracula's bed", "A gigantic Dracula-sized bed with it's own curtains."),
                )
            )
            val f7enemyDracula = Enemy("Dracula", "The one you have been looking for.", 25f)
            f7enemyDracula.equipped[1] = Item.createWearable("","",ItemArmorSlot.TORSO, .25f) //secret unobtainable armor

            f7enemyDracula.inventory.add(
                Item("Dracula's canines", "What you have been looking for.", 2)
            )

            f7dracula.enemyList.add(f7enemyDracula)
            //endregion room1 dracula's room

            var level7: List<Room> = listOf(f7hallway, f7dracula) //add rooms level1, !order matters for doors!

            gameMap[7] = level7 //set 1st floor to level1
            //endregion level 7
        }
    }
}
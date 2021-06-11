import classes.* //import all classes
import classes.item.*
import functions.doCommands.* //import all doCommands

fun main(args: Array<String>) {

    GlobalGameMap.setupGameMap() //setup game

    println("Welcome to Dracula's castle...")

    print("Choose your name: ")
    var player: Player = Player(readLine().toString(), "The player", 10f)

    // region TEMP
    player.inventory.add(Item.createConsumable("Food", "Tasty", 1, 1f))
    player.inventory.add(Item.createWearable("Helmet", "for your head", ItemArmorSlot.HEAD, .1f))
    player.inventory.add(Item.createKey("Golden key", "Made of gold", "abcdefghijklmnop"))
    player.inventory.add(Item("Item 13", "foo", 1))
    player.inventory.add(Item("Item 4", "bar", 1))
    // endregion

    println("You, ${player.name}, enter Dracula's castle.")

    /*TODO
     * start loop
     * maybe show the description of first room etc
     * also set player.Room or something
     */

    println("What will you do? (type help for help)")

    while (true){ //game loop
        when(player.currentMenu){
            MenuType.NONE ->{
                print("* ") //print * to type command after
                doPlayerCommand(readLine().toString(), player)
            }

            MenuType.INVENTORY ->{ //look through your inventory to pick an item
                print("- ") // - to type command after
                doCommandInventory(readLine().toString(), player)
            }
            MenuType.IN_INVENTORY ->{ //When you have selected an item inside of your inventory
                val item = player.inventory[player.currentMenuIndex]
                print("${item.name} - ") //print item name - to type command after
                doCommandItem(readLine().toString(), item, player)
            }

            MenuType.ROOM ->{ //look through current room to pick a poi
                print("- ") // - to type command after
                doCommandRoom(readLine().toString(), player)
            }
            MenuType.IN_ROOM ->{
                val poi = GlobalGameMap.gameMap[player.currentLevel][player.currentRoom].poiList[player.currentMenuIndex]
                print("${poi.name} - ") //print poi name - to type command after
                doCommandPOI(readLine().toString(), poi, player);
            }

            MenuType.CONTAINER ->{
                val poi = GlobalGameMap.gameMap[player.currentLevel][player.currentRoom].poiList[player.currentMenuIndex]
                print("${poi.name}>- ") //print poi name >- to type command after
                doCommandContainer(readLine().toString(), player);
            }
            MenuType.IN_CONTAINER ->{
                val poi = GlobalGameMap.gameMap[player.currentLevel][player.currentRoom].poiList[player.currentMenuIndex]
                val inventory = poi.properties["Content"] as MutableList<Item>;
                print("${poi.name}> ${inventory[player.currentMenuIndex1].name} - ") //print poi name >- to type command after
                doCommandIn_Container(readLine().toString(), player, inventory, poi);
            }

            MenuType.BATTLE ->{
                print("\${enemy.name} * ") //print enemy name * to type command after
                readLine().toString() //TODO surround with BATTLE do Command
            }
        }
    }

}
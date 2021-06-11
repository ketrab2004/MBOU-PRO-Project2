package classes

class Player(name: String, description: String, maxHealth: Float)
    : Enemy(name, description, maxHealth) { //extends Classes.Enemy

    var currentLevel: Int = 0; //index of level in gameMap array
    var currentRoom: Int = 0; //index of room in gameMap array > list

    var currentMenu: MenuType = MenuType.NONE
    var currentMenuIndex: Int = 0; //if in a inventory menu this index points to which item
    var currentMenuIndex1: Int = 0; //if in a container this index points to which item inside of it

}
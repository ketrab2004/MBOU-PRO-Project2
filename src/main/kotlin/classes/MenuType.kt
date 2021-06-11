package classes

enum class MenuType() {
    /**
     * Highest "level" of menuType
     * (like in a folder structure)
     */
    NONE,

    /**
     * Looking through your inventory
     */
    INVENTORY,

    /**
     * After having chosen an item from your inventory
     */
    IN_INVENTORY,

    /**
     * Looking through the room
     */
    ROOM,

    /**
     * After having chosen an poi from the current room
     */
    IN_ROOM,


    BATTLE
}
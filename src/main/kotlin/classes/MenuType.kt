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

    /**
     * Looking through the items inside of a container
     */
    CONTAINER,

    /**
     * After having chosen an item from a container
     */
    IN_CONTAINER,

    /**
     * Looking through your equipment
     */
    EQUIPMENT,

    /**
     * After having chosen an item from your equipment
     */
    IN_EQUIPMENT,


    BATTLE
}
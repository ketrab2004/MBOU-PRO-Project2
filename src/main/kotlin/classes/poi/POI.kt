package classes.poi

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
     * ```
     */
    var properties: Map<String, Any> = mapOf(); //like NBT tags in Minecraft
}
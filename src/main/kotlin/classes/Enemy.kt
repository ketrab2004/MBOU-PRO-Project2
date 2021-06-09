package classes

import classes.item.Item
import classes.item.ItemArmorSlot;
import kotlin.math.min

open class Enemy(
    val name: String,
    val description: String,
    val maxHealth: Float) {

    public var health: Float = maxHealth;

    public var inventory: MutableList<Item> = mutableListOf<Item>(); //mutable list can be edited

    public var equipped: Array<Item?> = arrayOfNulls<Item?>(ItemArmorSlot.values().size); //size of amount of armor slots

    /**
     * Add health
     * @return amount of health gained
     */
    public fun addHealth(eatPoints: Float): Float{
        val toReturn = min(health + eatPoints, maxHealth) - health;

        health += toReturn;

        return toReturn;
    }
}
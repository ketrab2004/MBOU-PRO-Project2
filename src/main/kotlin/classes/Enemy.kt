package classes

import classes.item.Item
import classes.item.ItemArmorSlot;
import classes.item.ItemType
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

    /**
     * Calculates how much damage gets protected with the currently equipped armor and returns it
     */
    public fun calcArmorPerc(): Float{
        var damage = 1f;

        this.equipped.forEachIndexed(){ index, item ->
            if (item != null){ //because item is item?
                val armorPerc = item.properties["ArmorPerc"];
                if (armorPerc is Float) {
                    damage -= damage * armorPerc; //remove armorPerc of damage from damage
                }
            }
        }

        return 1-damage; //amount of damage not taken
    }

    /**
     * Take damage based on the enemies armor and used weapon
     * @return a pair which contains 2 values
     * * damage done [Float] (pair.a)
     * * whether the enemy survived [Boolean] (pair.b)
     */
    public fun takeDamage(weapon: Item?): Pair<Float, Boolean>{
        var damage = 1f;
        if (weapon != null) { //if a weapon was used
            if (weapon.type == ItemType.WEAPON) { //weapon is actually a weapon
                val weaponDamage = weapon.properties["Damage"]
                if (weaponDamage is Float){ //weapon damage is set and is a float
                    damage = weaponDamage; //damage is weapon damage
                }
            }
        }

        damage *= 1-calcArmorPerc(); //multiply with armorPerc
        //1-armor because if armor is .1 the damage should be .9 and 1- 0.1 = 0.9

        health -= damage; //do damage

        //return damage and
        //whether enemy is alive (health > 0)
        return Pair(damage, health > 0);
    }
}
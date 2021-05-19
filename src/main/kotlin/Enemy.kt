open class Enemy(
    val name: String,
    val description: String,
    val maxHealth: Float) {

    public val health: Float = maxHealth;

    public var inventory: List<Item> = listOf();

    public var equipped: List<Item> = listOf();

}
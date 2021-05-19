open class Enemy(
    val name: String,
    val description: String,
    val maxHealth: Float) {

    public val health: Float = maxHealth;

    public var inventory: List<Int> = listOf(); //TODO change List<Int> to List<Item>

    public var equipped: List<Int> = listOf(); //TODO change List<Int> to List<Item>

}
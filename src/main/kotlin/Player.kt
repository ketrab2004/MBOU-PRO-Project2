class Player(name: String, description: String, maxHealth: Float)
    : Enemy(name, description, maxHealth) { //extends Enemy

    lateinit var currentRoom: Room; //lateinit because it's null




}
package classes

class Player(name: String, description: String, maxHealth: Float)
    : Enemy(name, description, maxHealth) { //extends Classes.Enemy

    lateinit var currentRoom: Room; //lateinit because it's null




}
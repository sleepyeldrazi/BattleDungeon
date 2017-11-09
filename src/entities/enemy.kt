package entities

class Enemy(val name: String, var level: Int, var strength: Int, var constitution: Int, var intelligence: Int) {
    var health = 10 + constitution
    var dmg = 5+strength
    var currentHealth = health
}
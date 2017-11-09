import entities.Enemy
import entities.Player;
import scripts.battle
import scripts.firstRun
import java.util.Random

val random = Random()

fun rand(from: Int, to: Int) : Int {
    return random.nextInt(to - from) + from
}

fun main(args: Array<String>) {
    val player = firstRun()

    println("Wanna fight?")
    if(readLine().toString().toLowerCase() == "y") battle(player, Enemy("Goblin", player.level, rand(1, 3), rand(1, 3), rand(1, 3)))
}
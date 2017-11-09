package scripts
import entities.Player
import rand

fun firstRun(): Player {
    var pl: Player
    println("Welcome to the Battle Dungeon!")
    println("What's your name?")
    val name = readLine().toString();
    println("Do you want ot play as a mage or warrior?")
    var choice = readLine().toString().toLowerCase()
    var reroll: String = "y"
    when (choice) {
        "mage" -> pl = Player(name, choice,1, rand(1, 3), rand(2, 4), rand(3, 5))
        "warrior" -> pl = Player(name, choice, 1, rand(3, 5), rand(2, 4), rand(1, 3))
        else -> {
            println("Invalid class, restarting")
            pl = firstRun()
        }
    }
    pl.showStats()
    println("Reroll? (y/n)")
    reroll = readLine().toString()
    loop@ while(reroll.toLowerCase() != "n") {
        println("Do you want ot play as a mage or warrior?")
        choice = readLine().toString().toLowerCase()
        when (choice) {
            "mage" -> pl = Player(name, choice, 1, rand(1, 3), rand(2, 4), rand(3, 5))
            "warrior" -> pl = Player(name, choice, 1, rand(3, 5), rand(2, 4), rand(1, 3))
            else -> {
                println("Invalid class, restarting")
                continue@loop
            }
        }
        pl.showStats()
        println("Reroll? (y/n)")
        reroll = readLine().toString()
    }

    return pl
}
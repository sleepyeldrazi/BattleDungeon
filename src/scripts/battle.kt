package scripts

import entities.Enemy
import entities.Player

fun showBattleStats(pl: Player, en: Enemy){
    println("You have: ${pl.currentHealth}hp")
    println("Your enemy has : ${en.currentHealth}hp")
}

fun battle(pl: Player, en: Enemy){
    showBattleStats(pl, en)
    while(pl.currentHealth>0 && en.currentHealth >0 ){
        pl.attack(en)
        showBattleStats(pl, en)
    }
}